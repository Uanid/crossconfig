package com.uanid.crossconfig.common;

import com.uanid.crossconfig.exception.DuplicatedKeyException;
import com.uanid.crossconfig.util.MatchType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author uanid
 * @since 2019-08-12
 */
public final class CachedRepository<Item> {
    private List<Item> itemContainer;
    private MatchFunction<Item> matchFunction;
    private Map<String, Item> cachedItemContainer;

    public CachedRepository(MatchFunction<Item> matchFunction) {
        this(new ArrayList<>(), matchFunction);
    }

    /**
     * @param defaultList
     * @param matchFunction 원하는 아이템을 비교하기 위한 함수 <searchKeyword, Item, resultMatchType>으로 이루어짐
     */
    public CachedRepository(List<Item> defaultList, MatchFunction<Item> matchFunction) {
        this.itemContainer = defaultList;
        this.matchFunction = matchFunction;
        this.cachedItemContainer = new HashMap<>();
    }

    public synchronized void registerItem(Item item) {
        if (itemContainer.contains(item)) {
            throw new DuplicatedKeyException();
        }
        cachedItemContainer.clear();
        itemContainer.add(item);
    }

    public synchronized Item searchItem(String keyword, MatchType atLeastMatchType) {
        Item item = cachedItemContainer.get(keyword);
        if (item != null) {
            return item;
        }

        item = lookup(keyword, atLeastMatchType);
        if (item != null) {
            cachedItemContainer.put(keyword, item);
        }
        return item;
    }

    private Item lookup(String keyword, MatchType atLeastMatchType) {
        Item maxItem = null;
        MatchType maxStrictType = MatchType.NONE;
        for (Item item : itemContainer) {
            MatchType matchResult = matchFunction.apply(keyword, item);
            if (matchResult.isStrictThanAndEqual(atLeastMatchType) && matchResult.isStrictThanAndEqual(maxStrictType)) {
                maxItem = item;
                maxStrictType = matchResult;
            }
        }
        return maxItem;
    }

    public static class MatchFunction<T> implements BiFunction<String, T, MatchType> {

        private BiFunction<String, T, MatchType> function;

        public MatchFunction(BiFunction<String, T, MatchType> function) {
            this.function = function;
        }

        @Override
        public MatchType apply(String searchKeyword, T object) {
            return function.apply(searchKeyword, object);
        }
    }
}
