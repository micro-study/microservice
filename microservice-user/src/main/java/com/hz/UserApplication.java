package com.hz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: huangzhuo
 * @Date: 2019/5/14 19:39
 * @Description:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(UserApplication.class).run(args);
	}

}
