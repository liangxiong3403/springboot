Spring Boot version:1.5.16.RELEASE
JDK:1.8+
Maven:3.3+
书山有路勤为径,学海无涯苦作舟

# properties加载逻辑
org.springframework.context.ApplicationListener
    |
    org.springframework.boot.context.config.ConfigFileApplicationListener
        |
        org.springframework.boot.context.config.ConfigFileApplicationListener.onApplicationEvent
            |
            org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent
                |自定义实现配置文件修改
                org.liangxiong.springboot.listener.CustomizeSpringBootApplicationListener