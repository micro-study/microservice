package com.hz.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
	
	private static Logger log = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping("/test1")
    @ResponseBody
    String home() {
		log.debug("测试controller，test方法开始 debug级别");
		log.info("info 级别");
		log.error("error级别");
		log.warn("warn级别" );
        return "Hello Worldtest!";
    }
}
