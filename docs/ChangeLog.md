## Release Note  
1.1.2版本  
&emsp;1:代码优化    
&emsp;2:增加渠道匹配   
1.1.1版本  
&emsp;1:增加AfterChain和BeforeChain注解    
&emsp;2:优化相关代码    
&emsp;3:更改DyanmicUrlPattern接口，增加参数        
&emsp;4:将创建责任链方法单独抽取       
&emsp;5:yml文件支持属性自动提示       
1.1.0版本  
&emsp;1:SpringBoot依赖版本升级为2.2.7.RELEASE,其他依赖升级为最新版本  	
&emsp;2:增加MessageSourceFilter,并从AsyncServletFilter中移除相关代码 
&emsp;3:增加DyanmicUrlPattern接口，可在系统中动态修改Pattern   
&emsp;4:Page,PageUtil,AsyncServlet标记为过期   
&emsp;5:增加雪花算法IdWorker,可直接使用IdWorker.getInstance().nextId()获得流水号  
&emsp;6：ServletMessage 增加 getFileBytes,getFileNames,getFiles,getFile,getFileStream,getClientIp,getHeaderIgnoreCase,getHeader等方法  
&emsp;7:注解ActorCfg增加excludeUrlPatterns,domains,view,timeout,methods等参数  
&emsp;8:Message方法中getContextData等修改为泛型,不再需要强转,增加getContextList直接获得客户端提交的列表参数
1.0.18版本  
&emsp;1:支持SpringBoot,只需要引用jar包，即可在springboot中自动启用，进一步简化代码配置    
&emsp;2:服务可优雅停止  
&emsp;3：依赖升级为最新版本  
&emsp;4：Actor接口增加默认方法   
1.0.15版本  
&emsp;1:解决在队列满的情况下，程序无法响应问题    
1.0.14版本  
&emsp;1:解决在队列满的情况下，互锁导致程序宕机问题  
1.0.13版本  
&emsp;1:完善代码解决消费者减少后,消息丢失问题   
&emsp;2:支持url路径中加动态参数  
1.0.12版本  
&emsp;1:动态调节消费者线程数  
&emsp;2：增加maxsize：动态消费最大增加数  
&emsp;3：修改threadNumber为minsize，可不配置，不配置为核心CPU个数  
&emsp;4：增加checktime函数，默认为1s,监控消费者线程是否不足  
&emsp;5：支持Rest格式,如/a/b.json格式，对应内部为namespace为a,actor的id为b  
1.0.11版本    
&emsp;1:对SpringBean进行缓存,缓解getBean造成的锁问题  
&emsp;2:增加对netty http的支持  
&emsp;3:日志默认级别调整为debug  
1.0.10版本    
&emsp; Message增加ControlData，将业务信息和控制信息分离   
1.0.9版本  
&emsp;修正在集成的Netty错误,并增加测试案例  
1.0.8版本  
&emsp;在Steps中的beginBeanId支持用Actor标签的BeanId  
&emsp;增加测试案例  
1.0.7版本  
&emsp;修正Step中所有条件不为真时，报错问题  
1.0.6版本  
&emsp;通过设置async=true的方式,便捷的增加旁路交易  
&emsp;移除对javax.mail-api的依赖  
1.0.5版本  
&emsp;ServletMessage的用户对象直接从会话中取得  
1.0.4版本  
&emsp;优化程序逻辑  
1.0.3版本  
&emsp;Message增加setUser和getUser对象  
1.0.2版本   
&emsp;初始化版本