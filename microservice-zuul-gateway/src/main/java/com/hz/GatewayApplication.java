package com.hz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
 * @author huangzhuo
 * @date 2019/5/21 10:56
 * @description:  
 * @param   
 */

@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
public class GatewayApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(GatewayApplication.class).run(args);
	}
}
