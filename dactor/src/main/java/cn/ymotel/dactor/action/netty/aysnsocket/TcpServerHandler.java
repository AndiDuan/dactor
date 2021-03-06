package cn.ymotel.dactor.action.netty.aysnsocket;

import cn.ymotel.dactor.Constants;
import cn.ymotel.dactor.core.ActorTransactionCfg;
import cn.ymotel.dactor.core.disruptor.MessageRingBufferDispatcher;
import cn.ymotel.dactor.message.DefaultMessage;
import cn.ymotel.dactor.message.Message;
import cn.ymotel.dactor.ActorUtils;
import com.alibaba.fastjson.JSON;
import io.netty.channel.*;
import io.netty.channel.ChannelHandler.Sharable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

@Sharable
public class TcpServerHandler extends SimpleChannelInboundHandler implements ApplicationContextAware {
    /**
     * Logger for this class
     */
    private static final Log logger = LogFactory.getLog(TcpServerHandler.class);

     private MessageRingBufferDispatcher MessageDispatcher;




    public MessageRingBufferDispatcher getMessageDispatcher() {
        return MessageDispatcher;
    }

    public void setMessageDispatcher(MessageRingBufferDispatcher messageDispatcher) {
        MessageDispatcher = messageDispatcher;
    }



    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        Message message=new DefaultMessage();
        Map data=(Map)JSON.parse((String)msg);
        message.getContext().putAll(data);
        message.getControlData().put("_ChannelHandlerContext", ctx);
        message.getControlData().put(Constants.TRANSPORT,Constants.TRANSPORT_NETTY_TCP);

        String transactionId = (String)data.get("actorId");
        ActorTransactionCfg cfg=(ActorTransactionCfg) ActorUtils.getCacheBean(applicationContext,transactionId);
//
//
        getMessageDispatcher().startMessage(message, cfg, false);


    }




    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        if (logger.isTraceEnabled()) {
            logger.trace("exceptionCaught(ChannelHandlerContext, Throwable) - " + cause); //$NON-NLS-1$
        }
        ctx.close();
    }


    private ApplicationContext applicationContext;


    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException {
        applicationContext = arg0;
    }


}
