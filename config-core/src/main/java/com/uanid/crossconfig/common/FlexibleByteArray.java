package com.uanid.crossconfig.common;

import com.uanid.crossconfig.util.Validate;

import java.util.Arrays;

/**
 * @author uanid
 * @since 2019-06-15
 */
public class FlexibleByteArray {
    private static final int DEFAULT_GROW_SIZE = 1024;
    private static final int DEFAULT_ARRAY_SIZE = 1024;

    public static int getDefaultGrowSize() {
        return DEFAULT_GROW_SIZE;
    }

    public static int getDefaultArraySize() {
        return DEFAULT_ARRAY_SIZE;
    }

    private byte[] array;
    private int arraySize;
    private int growSize;
    private int appendOffset;

    public FlexibleByteArray() {
        this(DEFAULT_ARRAY_SIZE, DEFAULT_GROW_SIZE);
    }

    public FlexibleByteArray(int arraySize, int growSize) {
        this.array = new byte[arraySize];
        this.arraySize = arraySize;
        this.growSize = growSize;
        this.appendOffset = 0;
    }

    public void grow() {
        grow(growSize);
    }

    public void grow(int passiveGrowSize) {
        Validate.positiveNumber(passiveGrowSize);

        int newBufferSize = arraySize + passiveGrowSize;
        array = Arrays.copyOf(array, newBufferSize);
        arraySize = newBufferSize;
    }

    public void append(byte b) {
        if (appendOffset >= arraySize) {
            grow();
        }
        array[appendOffset] = b;
        appendOffset++;
    }

    public void append(byte[] sourceArray) {
        append(sourceArray, 0, sourceArray.length);
    }

    public void append(byte[] sourceBuffer, int bufferOffset, int copyLength) {
        int atLeastArraySize = appendOffset + copyLength;
        int targetGrowSize = 0;
        while ((arraySize + targetGrowSize) < atLeastArraySize) {
            targetGrowSize += growSize;
        }

        grow(targetGrowSize);
        for (int i = 0; i < copyLength; i++) {
            array[appendOffset] = sourceBuffer[bufferOffset + i];
            appendOffset++;
        }
    }

    public void shrinkTo(int newArraySize) {
        Validate.betweenAnB(0, newArraySize, arraySize);
        setArraySize(newArraySize);
    }

    public void growTo(int newArraySize) {
        Validate.greaterThan(arraySize, newArraySize);
        setArraySize(newArraySize);
    }

    public void setArraySize(int newArraySize) {
        Validate.positiveNumber(newArraySize);

        array = Arrays.copyOf(array, newArraySize);
        arraySize = newArraySize;
    }

    public void setGrowSize(int growSize) {
        this.growSize = growSize;
    }

    public void setAppendOffset(int appendOffset) {
        this.appendOffset = appendOffset;
    }

    public byte[] toByteArray() {
        return Arrays.copyOf(array, appendOffset);
    }

    public int getArraySize() {
        return arraySize;
    }

    public int getGrowSize() {
        return growSize;
    }

    public int getAppendOffset() {
        return appendOffset;
    }
}
