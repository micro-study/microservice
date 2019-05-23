package com.hz.controller;

import com.hz.pojo.WechatSchedule;
import com.hz.service.TestService;
import com.hz.utils.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Auther: huangzhuo
 * @Date: 2019/5/22 15:10
 * @Description:
 */
@RestController
public class ScheduleController {
	private static Logger LOGGER = LoggerFactory.getLogger(ScheduleController.class);

	@Autowired
	private TestService testService;

	@CrossOrigin
	@RequestMapping(value = "/getSchedule/{userId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public Map<String, Map<String, List<WechatSchedule>>> getSchedule(HttpServletRequest request, HttpServletResponse response, @PathVariable String userId) {
		LOGGER.info("getSchedule接口请求，请求参数为{}", userId);
		Map<String, Map<String, List<WechatSchedule>>> something = testService.getSchedule(userId);

		LOGGER.info("方法一的ip{}", IpUtil.getLocalIp(request));
		LOGGER.info("方法二的ip{}", IpUtil.getIp(request));
		LOGGER.info("方法三的ip{}", IpUtil.getIp2(request));

		return something;
	}


}
