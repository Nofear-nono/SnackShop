package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.io.IOException;

/**
 * 项目启动类
 */
@SpringBootApplication
@MapperScan("com.dao")
public class SpringbootApplication extends SpringBootServletInitializer {

    private static Logger log = LoggerFactory.getLogger(SpringbootApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootApplication.class);
        Environment env = context.getEnvironment();
        log.info("====================================================================");
        log.info("项目版本: {}", env.getProperty("project.version"));
        log.info("启动环境: {}", env.getProperty("project.env"));
        log.info("启动端口: {}", env.getProperty("server.port"));
        log.info("日志等级: {}", env.getProperty("logback.level"));
        log.info("日志Appender: {}", env.getProperty("logback.appender"));
        log.info("Startup complete ...");
        log.info("====================================================================");
        try {
            Runtime.getRuntime().exec("cmd /c start http://localhost:" + env.getProperty("server.port") +env.getProperty("server.servlet.context-path")+"/front/dist/index.html");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootApplication.class);
    }
}
