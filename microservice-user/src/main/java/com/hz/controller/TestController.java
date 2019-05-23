package com.hz.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hz.mapper.ScheduleMapper;
import com.hz.pojo.WechatSchedule;
import com.hz.service.IScheduleService;
import com.hz.service.Impl.ScheduleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

	private static Logger log = LoggerFactory.getLogger(TestController.class);
	@Autowired
	private ScheduleMapper scheduleMapper;


	@Autowired
	private ScheduleServiceImpl scheduleService;

	@RequestMapping("/test1")
	String home() {
		log.debug("测试controller，test方法开始 debug级别");
		Wrapper wrapper = new QueryWrapper();
		List<WechatSchedule> userList = scheduleMapper.selectList(wrapper);

		final IPage page = scheduleService.page(new Page<WechatSchedule>(1, 10), new QueryWrapper<>());
		Map<String, Object> map = new HashMap<>();
//		map.put();
		QueryWrapper<WechatSchedule> wrapper1 =new QueryWrapper<>();
		map.put("id","1");
		Collection collection = scheduleService.listByMap(map);

		List list1 = scheduleService.listMaps(wrapper1);

		log.info("info 级别");
		log.error("error级别");
		log.warn("warn级别");
		return "Hello Worldtest!";
	}
}
