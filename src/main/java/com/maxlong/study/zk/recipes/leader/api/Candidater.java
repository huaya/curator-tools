package com.maxlong.study.zk.recipes.leader.api;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 候选人接口
 *
 * @author Nano
 * @version 1.0.0
 * @since 2015/6/17 16:39
 * abacus-parent
 */
public interface Candidater {

    /**
     * 参入选举
     *
     * @throws Exception
     */
    public void requireElection() throws Exception ;

    /**
     * 判断是否是Leader
     *
     * @return
     */
    public boolean isLeader();

    /**
     * 获得Leader  Id
     *
     * @return
     */
    public String getLeaderId() throws Exception;

    /**
     * 获取节点
     *
     * @return
     */
    public String getNodeId();

    /**
     * 等待选举结果(有结果立刻返回)
     *
     * @param timeout
     * @param unit
     * @return  true 领导 false 非领导
     * @throws InterruptedException
     */
    public boolean awaitElection(long timeout, TimeUnit unit) throws InterruptedException;

    /**
     * 释放参选资格关闭自己
     *
     * @throws IOException
     */
    public void close() throws IOException;

}
