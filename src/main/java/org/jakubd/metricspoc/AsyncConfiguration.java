package org.jakubd.metricspoc;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class AsyncConfiguration extends AsyncConfigurerSupport {

    private final MeterRegistry meterRegistry;

    public AsyncConfiguration(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        meterRegistry.gauge("executor.tasks", executor, ThreadPoolExecutor::getTaskCount);
        return super.getAsyncExecutor();
    }
}
