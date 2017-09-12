package com.depli.service.store.descriptor;

import com.depli.store.cache.descriptor.ClassLoadingDataDescriptor;

/**
 * Class Loading Data Descriptor Service
 *
 * Provides service to manage class loading data descriptor cache and to retrieve
 * manipulated data from cache.
 *
 * @author lpsandaruwan
 * @since 9/11/17
 */

public interface ClassLoadingDataDescriptorService {

    /**
     * Retrieves class loading data descriptor object from class loading data descriptor cache
     * using Long value, nodeId which is generated by application when persisting JMX remote
     * connection node's metadata.
     *
     * @param nodeId node ID of the JMX remote connection
     * @return class loading data descriptor for particular node ID
     */
    public ClassLoadingDataDescriptor getByNodeId(Long nodeId);

    /**
     * Stores class loading data descriptor object in class loading data descriptor cache
     * using Long value, nodeId which is generated by application when persisting JMX remote
     * connection node's metadata.
     *
     * @param nodeId node ID of the JMX remote connection
     * @param classLoadingDataDescriptor class loading data descriptor for particular node ID
     */
    public void save(Long nodeId, ClassLoadingDataDescriptor classLoadingDataDescriptor);
}