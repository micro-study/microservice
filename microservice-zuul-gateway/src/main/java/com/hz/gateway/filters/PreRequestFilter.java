package com.hz.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @Auther: huangzhuo
 * @Date: 2019/5/21 17:29
 * @Description:
 */
public class PreRequestFilter extends ZuulFilter {
	private static Logger LOGGER = LoggerFactory.getLogger(PreRequestFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext currentContext = RequestContext.getCurrentContext();
		HttpServletRequest request = currentContext.getRequest();

		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());

		LOGGER.info("当前请求方法为{}，请求URL为{}", request.getMethod(), request.getRequestURL().toString());
		LOGGER.info("分布式全局唯一值为{}",uuid.toString());
		return null;
	}


}
