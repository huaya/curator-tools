package com.maxlong.study.zk.api;

import com.maxlong.study.utils.DynamicPropertyHelper;
import org.apache.curator.RetryPolicy;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * CuratorFramework 创建工厂
 *
 * @author Nano
 * @version 1.0.0
 * @since 2015/6/1 14:05
 * abacus-parent
 */
public class CuratorFrameworkFactory {

    /**
     * 创建 CuratorFrameworkManager
     *
     * @param connectionString
     * @param retryBaseSleepTimems
     * @param maxretries
     * @param namespace
     * @param connectionTimeoutMs
     * @param sessionTimeoutMs
     * @return
     */
    public static final com.maxlong.study.zk.api.CuratorFrameworkManager createCuratorFrameworkManager(String connectionString, int retryBaseSleepTimems, int maxretries, String namespace, int connectionTimeoutMs, int sessionTimeoutMs) {
        RetryPolicy retryPolicy  = new ExponentialBackoffRetry(retryBaseSleepTimems, maxretries);
        com.maxlong.study.zk.api.CuratorFrameworkManager curatorFrameworkManager = new com.maxlong.study.zk.api.CuratorFrameworkManager();
        curatorFrameworkManager.initCuratorFramework(connectionString,retryPolicy,namespace,connectionTimeoutMs,sessionTimeoutMs);
        return curatorFrameworkManager;
    }

    /**
     * 创建 CuratorFrameworkManager
     *
     * @return
     */
    public static final com.maxlong.study.zk.api.CuratorFrameworkManager createCuratorFrameworkManager(){
        String connectionString  = DynamicPropertyHelper.getStringProperty("technology.zookeeper.connectstring", "192.168.128.128:2181");
        String namespace         = DynamicPropertyHelper.getStringProperty("technology.zookeeper.namespace", "maxlong");
        int retryBaseSleepTimems = DynamicPropertyHelper.getIntProperty("technology.zookeeper.retry.basesleeptimems", 1000);
        int maxretries           = DynamicPropertyHelper.getIntProperty("technology.zookeeper.retry.maxretries", 10);
        int connectionTimeoutMs  = DynamicPropertyHelper.getIntProperty("technology.zookeeper.connectiontimeoutms", 15 * 1000);
        int sessionTimeoutMs     = DynamicPropertyHelper.getIntProperty("technology.zookeeper.sessiontimeoutms", 60 * 1000);
        return createCuratorFrameworkManager(connectionString,retryBaseSleepTimems,maxretries,namespace,connectionTimeoutMs,sessionTimeoutMs);
    }

}