package com.aggregation.common.utils;

/**
 * @Desc
 * @created by xlk on 2022/9/2 14:35
 */
public class TimeElapse {

    long start = System.currentTimeMillis();

    public TimeElapse() {
    }

    public long elapsed() {
        return System.currentTimeMillis() - this.start;
    }

    public long elapsedSeconds() {
        return (System.currentTimeMillis() - this.start) / 1000;
    }

    public void reset() {
        this.start = System.currentTimeMillis();
    }

    public long elapsedAndReset() {
        long now = System.currentTimeMillis();
        long elapse = now - this.start;
        this.start = now;
        return elapse;
    }

    public long nowAndReset() {
        long now = System.currentTimeMillis();
        this.start = now;
        return now;
    }

    public long now() {
        return System.currentTimeMillis();
    }

    public long getStart() {
        return this.start;
    }

}
