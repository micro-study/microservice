package com.hz;

import com.hz.gateway.filters.PreRequestFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


/**
 * @param
 * @author huangzhuo
 * @date 2019/5/21 10:56
 * @description:
 */

@EnableDiscoveryClient
@SpringBootApplication
@EnableZuulProxy
public class GatewayApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(GatewayApplication.class).run(args);
	}

	@Bean
	public PreRequestFilter preRequestFilter() {
		return new PreRequestFilter();
	}


}
