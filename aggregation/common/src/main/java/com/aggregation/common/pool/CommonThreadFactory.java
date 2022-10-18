package com.aggregation.common.pool;

import java.util.concurrent.ThreadFactory;

/**
 * @Desc
 */
public class CommonThreadFactory implements ThreadFactory {

    private String namePrefix;


    public CommonThreadFactory(String namePrefix) {
        this.namePrefix = namePrefix + "-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setName(this.namePrefix + thread.getId());
        thread.setDaemon(false);
        return thread;
    }


}
