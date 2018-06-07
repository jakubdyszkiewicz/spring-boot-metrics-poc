package org.jakubd.metricspoc;

import io.micrometer.core.instrument.MeterRegistry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetricsPocApplicationTests {

    @Autowired
    MeterRegistry meterRegistry;

    @Test
    public void should_have_sample_binder_metric() {
        assertThat(meterRegistry.get("sample.binder").gauges()).isNotEmpty();
    }

    @Test
    public void should_have_executor_tasks_metric() {
        assertThat(meterRegistry.get("executor.tasks").gauges()).isNotEmpty();
    }
}
