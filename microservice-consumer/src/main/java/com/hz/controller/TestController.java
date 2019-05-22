package com.hz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {
	
	private static Logger log = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private RestTemplate restTemplate;

	
	@RequestMapping("/test1")
    String home() {
		log.debug("测试controller，test方 法开始 debug级别");
		log.info("info 级别");
		log.error("error级别");
		log.warn("warn级别" );
        return "Hello Worldtest!";
    }


	@RequestMapping("/test2")
	String test2() {
		log.debug("测试controller，test方法开始 debug级别");
		log.info("info 级别");
		log.error("error级别");
		log.warn("warn级别" );
		Object obj = this.restTemplate.getForObject("http://microservice-user/test/test1",String.class);

		return obj.toString();
	}
}
