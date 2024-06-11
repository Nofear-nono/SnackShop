package com;

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


    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootApplication.class);
        Environment env = context.getEnvironment();
                try {
            Runtime.getRuntime().exec("cmd /c start http://localhost:" + env.getProperty("server.port") +env.getProperty("server.servlet.context-path")+"/front/dist/index.html");
//            Runtime.getRuntime().exec("cmd /c start http://localhost:" + env.getProperty("server.port") +env.getProperty("server.servlet.context-path")+"/admin/dist/index.html");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootApplication.class);
    }
}
