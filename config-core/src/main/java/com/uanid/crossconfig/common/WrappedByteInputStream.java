package com.uanid.crossconfig.common;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author uanid
 * @since 2019-07-03
 *
 * TODO: 일단은 사용 금지
 * TODO: marked 기능을 완벽하게 지원하던가, 클래스를 삭제하던가
 * TODO: mark 관련해서 제대로 동작 안 할듯..
 */
public class WrappedByteInputStream extends InputStream {

    private FlexibleByteArray byteArray;
    private InputStream sourceStream;
    private int defaultByteArraySize;
    private int defaultByteArrayGrowSize;

    public WrappedByteInputStream() {
        this(new FlexibleByteArray(), null);
    }

    public WrappedByteInputStream(int byteArraySize, int byteArrayGrowSize, InputStream sourceInputStream) {
        this(new FlexibleByteArray(byteArraySize, byteArrayGrowSize), sourceInputStream);
    }

    public WrappedByteInputStream(FlexibleByteArray byteArray, InputStream sourceInputStream) {
        this.byteArray = byteArray;
        this.sourceStream = sourceInputStream;
        this.defaultByteArraySize = byteArray.getArraySize();
        this.defaultByteArrayGrowSize = byteArray.getGrowSize();
    }

    @Override
    public int read() throws IOException {
        int readValue = sourceStream.read();
        byteArray.append((byte) readValue);
        return readValue;
    }

    @Override
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int size = sourceStream.read(b, off, len);
        byteArray.append(b, off, len);
        return size;
    }

    @Override
    public long skip(long n) throws IOException {
        return sourceStream.skip(n);
    }

    @Override
    public int available() throws IOException {
        return sourceStream.available();
    }

    @Override
    public synchronized void mark(int readlimit) {
        sourceStream.mark(readlimit);
    }

    @Override
    public synchronized void reset() throws IOException {
        sourceStream.reset();
        byteArray = new FlexibleByteArray(defaultByteArraySize, defaultByteArrayGrowSize);
    }

    @Override
    public boolean markSupported() {
        return sourceStream.markSupported();
    }

    @Override
    public void close() throws IOException {
        byteArray = null;
        sourceStream.close();
    }
}
