/*
 * @(#)MessageDispatcher.java	1.0 2014年9月18日 下午12:42:56
 *
 * Copyright 2004-2010 Client Server International, Inc. All rights reserved.
 * CSII PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cn.ymotel.dactor.core;

import cn.ymotel.dactor.message.Message;

/**
 * {type specification, must edit}
 *
 * @author Administrator {must edit, use true name}
 * <p>
 * Created on 2014年9月18日
 * Modification history
 * {add your history}
 * </p>
 * @version 1.0
 * @since 1.0
 */
public interface MessageDispatcher {
    public boolean sendMessage(Message message,Object data);

    public boolean sendMessage(Message message);

    /**
     * 如果无可用的，立即返回
     * {method specification, must edit}
     *
     * @param message  需要处理的消息
     * @param actorcfg 消息对应的配置
     * @throws Exception 抛出异常
     * @return  是否可被执行
     * @version 1.0
     * @since 1.0
     */
    public boolean startMessage(Message message, ActorTransactionCfg actorcfg) throws Exception;

    /**
     * 阻塞是否立即返回，true等待可用,一般在内部调用时使用,false，一般在外部调用时使用
     * {method specification, must edit}
     *
     * @param message  需要处理的消息
     * @param actorcfg 消息对应的配置
     * @param blocked  是否阻塞
     * @throws Exception 抛出异常
     * @return  是否可被执行
     * @version 1.0
     * @since 1.0
     */
    public boolean startMessage(Message message, ActorTransactionCfg actorcfg, boolean blocked) throws Exception;

    public boolean startMessage(Message message, ActorTransactionCfg actorcfg, ActorChainCfg chain) throws Exception;

    public boolean startMessage(Message message, ActorTransactionCfg actorcfg, ActorChainCfg chain, boolean blocked) throws Exception;


}
