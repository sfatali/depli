package com.depli.utility.observer;

import com.depli.store.cache.descriptor.OperatingSystemDescriptor;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

/**
 * OperatingSystemDataObserver
 * <p>
 * Depli implementation for initializing observer OperatingSystemMxBean
 * Load operating system monitoring interface of the observer
 * <p>
 * Created by lpsandaruwan on 3/23/17.
 */

public class OperatingSystemDataObserver {

    private JMXConnectionObserver jmxConnectionObserver;
    private OperatingSystemMXBean operatingSystemMXBean;
    private OperatingSystemDescriptor operatingSystemDescriptor;

    public OperatingSystemDataObserver(JMXConnectionObserver jmxConnectionObserver) {
        this.jmxConnectionObserver = jmxConnectionObserver;
        this.operatingSystemDescriptor = new OperatingSystemDescriptor();
    }

    public OperatingSystemMXBean getOperatingSystemMXBean() {
        return operatingSystemMXBean;
    }

    public OperatingSystemDescriptor getOperatingSystemDescriptor() {
        return operatingSystemDescriptor;
    }

    // Initialize observer OperatingSystemMXBean
    public OperatingSystemMXBean initialize() throws IOException {
        operatingSystemMXBean = ManagementFactory.newPlatformMXBeanProxy(
                jmxConnectionObserver.getmBeanServerConnection(),
                ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME,
                OperatingSystemMXBean.class
        );

        return operatingSystemMXBean;
    }

    // Refresh and get OperatingSystemDataObserver object
    public OperatingSystemDescriptor refreshData() {
        operatingSystemDescriptor.setData(
                operatingSystemMXBean.getArch(),
                operatingSystemMXBean.getAvailableProcessors(),
                operatingSystemMXBean.getName(),
                operatingSystemMXBean.getVersion()
        );
        return operatingSystemDescriptor;
    }
}