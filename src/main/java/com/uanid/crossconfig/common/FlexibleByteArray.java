package com.uanid.crossconfig.common;

import com.uanid.crossconfig.util.Validate;

import java.util.Arrays;

/**
 * @author uanid
 * @since 2019-06-15
 */
public class FlexibleByteArray {
    private static final int DEFAULT_GROW_SIZE = 1024;
    private static final int DEFAULT_LIMIT_SIZE = 1024;

    public static int getDefaultGrowSize() {
        return DEFAULT_GROW_SIZE;
    }

    public static int getDefaultLimitSize() {
        return DEFAULT_LIMIT_SIZE;
    }

    private byte[] buffer;
    private int limitSize;
    private int growSize;
    private int appendOffset;

    public FlexibleByteArray() {
        this(DEFAULT_LIMIT_SIZE, DEFAULT_GROW_SIZE);
    }

    public FlexibleByteArray(int limitSize, int growSize) {
        this.buffer = new byte[limitSize];
        this.limitSize = limitSize;
        this.growSize = growSize;
        this.appendOffset = 0;
    }

    public void grow() {
        grow(growSize);
    }

    public void grow(int passiveGrowSize) {
        Validate.positiveNumber(passiveGrowSize);

        int newLimitSize = limitSize + passiveGrowSize;
        buffer = Arrays.copyOf(buffer, newLimitSize);
        limitSize = newLimitSize;
    }

    public void append(byte[] sourceBuffer) {
        append(sourceBuffer, 0, sourceBuffer.length);
    }

    public void append(byte[] sourceBuffer, int bufferOffset, int copyLength) {
        int targetBufferSize = appendOffset + copyLength;
        int targetLimitSize = limitSize;
        int targetGrowSize = 0;
        while (targetLimitSize < targetBufferSize) {
            targetGrowSize += growSize;
            targetLimitSize = limitSize + targetGrowSize;
        }

        grow(targetGrowSize);
        for (int i = 0; i < copyLength; i++) {
            buffer[appendOffset] = sourceBuffer[bufferOffset + i];
            appendOffset++;
        }
    }

    public void shrinkTo(int newLimitSize) {
        Validate.lessThan(newLimitSize, limitSize);
        setLimitSize(newLimitSize);
    }

    public void growTo(int newLimitSize) {
        Validate.greaterThan(limitSize, newLimitSize);
        setLimitSize(newLimitSize);
    }

    public void setLimitSize(int newLimitSize) {
        Validate.positiveNumber(newLimitSize);

        buffer = Arrays.copyOf(buffer, newLimitSize);
        limitSize = newLimitSize;
    }

    public void setGrowSize(int growSize) {
        this.growSize = growSize;
    }

    public void setAppendOffset(int appendOffset) {
        this.appendOffset = appendOffset;
    }

    public byte[] toByteArray() {
        return Arrays.copyOf(buffer, appendOffset);
    }

    public int getLimitSize() {
        return limitSize;
    }

    public int getGrowSize() {
        return growSize;
    }

    public int getAppendOffset() {
        return appendOffset;
    }
}
