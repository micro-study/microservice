package com.hz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: huangzhuo
 * @Date: 2019/5/14 19:39
 * @Description:
 */
//@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return  new RestTemplate();
	}


	public static void main(String[] args) {
		new SpringApplicationBuilder(ConsumerApplication.class).run(args);
	}

}
