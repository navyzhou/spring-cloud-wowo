eureka: 找到了
hystrix: 豪猪
	服务降级、依赖隔离、服务熔断、监控等

Hystrix设计原则
	1、防止单个服务的故障，耗尽整个系统服务的容器的线程资源，避免分布式环境里大量级联失败
	2、用快速失败代替排队
	3、提供接近实时的加监控和报警，从而能够快速发现故障和修复
	4、将所有请求外部系统封装到一个独立的线程中