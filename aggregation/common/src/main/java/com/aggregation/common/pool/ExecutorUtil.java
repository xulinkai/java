package com.aggregation.common.pool;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Desc
 */
@Slf4j
public class ExecutorUtil {

    private static final int coreSize = 2;
    private static final int maxSize = 5;
    private static final int keepAliveTime = 60;
    private static final int queueSize = 1000;

    /**
     * @Desc 注：公共线程池 根据任务情况 慎用  拒绝大范围大任务量使用此线程池
     */
    private static final ThreadPoolExecutor commonThreadPool = new ThreadPoolExecutor(
            coreSize,
            maxSize,
            keepAliveTime,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(queueSize),
            new CommonThreadFactory("commonThreadPool"),
            new ThreadPoolExecutor.AbortPolicy()
    );

    /**
     * @Desc 提交线程的内部异常 不会被线程池捕获
     */
    public static void execute(Runnable runnable) {
        try {
            commonThreadPool.execute(runnable);
        } catch (Exception e) {
            log.error("任务提交线程池异常", e);
            throw e;
        }
    }


}


