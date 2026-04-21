package com.sohlman.liferay.bfdms.cache.proxy;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.BiConsumer;

class TimingInputStream extends FilterInputStream {

    TimingInputStream(
        InputStream delegate, BiConsumer<Long, Long> onComplete) {

        super(delegate);
        _onComplete = onComplete;
    }

    @Override
    public int read() throws IOException {
        _markStart();
        int b = super.read();
        if (b >= 0) _bytes++;
        return b;
    }

    @Override
    public int read(byte[] buf) throws IOException {
        _markStart();
        int n = super.read(buf);
        if (n > 0) _bytes += n;
        return n;
    }

    @Override
    public int read(byte[] buf, int off, int len) throws IOException {
        _markStart();
        int n = super.read(buf, off, len);
        if (n > 0) _bytes += n;
        return n;
    }

    @Override
    public void close() throws IOException {
        try {
            if (_startMs > 0 && !_reported) {
                _reported = true;
                _onComplete.accept(System.currentTimeMillis() - _startMs, _bytes);
            }
        }
        finally {
            super.close();
        }
    }

    private void _markStart() {
        if (_startMs == 0) {
            _startMs = System.currentTimeMillis();
        }
    }

    private final BiConsumer<Long, Long> _onComplete;
    private long _startMs;
    private long _bytes;
    private boolean _reported;

}