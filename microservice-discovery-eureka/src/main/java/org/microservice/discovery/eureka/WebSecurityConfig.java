//package org.microservice.discovery.eureka;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @Auther: huangzhuo
// * @Date: 2019/5/14 10:46
// * @Description:
// */
//@EnableWebSecurity
//class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().ignoringAntMatchers("/eureka/**");
//		super.configure(http);
//	}
//}