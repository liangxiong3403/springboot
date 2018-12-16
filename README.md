- 框架

Spring Boot

- 版本

1.5.16.RELEASE

- JDK

1.8+

- Maven

3.3+

- 原则

书山有路勤为径,学海无涯苦作舟

- 自定义配置文件加载顺序
  - properties加载逻辑
    - org.springframework.context.ApplicationListener
      - org.springframework.boot.context.config.ConfigFileApplicationListener
        - org.springframework.boot.context.config.ConfigFileApplicationListener.onApplicationEvent
          - org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent
            - 自定义实现配置文件修改
            - org.liangxiong.springboot.listener.CustomizeSpringBootApplicationListener
- SpringBoot通过META-INF/*.properties实现自动装配
    - 比如`org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration`
        - Spring通过org.springframework.core.io.support.SpringFactoriesLoader加载org.springframework.boot.autoconfigure.EnableAutoConfiguration
            - EnableAutoConfiguration加载org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration
