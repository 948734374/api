package com.mcfish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * 主类
 * @package com.mcfish.app
 * @description   
 * @author shangfei
 * @date 2018年1月17日
 *
 */
@EnableHystrix
@EnableFeignClients
@EnableCircuitBreaker
//@EnableEurekaClient
@Controller
@EnableWebMvc
@EnableTransactionManagement
@SpringBootApplication
@MapperScan(basePackages = "com.mcfish.common.mapper")
public class Application extends WebMvcConfigurerAdapter implements CommandLineRunner {
	
    private Logger log = LoggerFactory.getLogger(Application.class);
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    	log.info("服务启动完成!");
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String mainPage(){
        return "main";
    }
    
}
