package org.microservice.discovery.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 使用Eureka做服务发现。
 *
 * @author huangzhuo
 * @version 创建时间： 2017年4月13日 下午2:58:49
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaApplication.class).run(args);
//		SpringApplication.run(EurekaServerApplication.class, args);
	}

}


