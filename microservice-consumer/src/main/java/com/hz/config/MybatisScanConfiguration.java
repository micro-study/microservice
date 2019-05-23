package com.hz.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author huangzhuo
 */
@Configuration
@AutoConfigureAfter(MyBatisConfiguration.class) // 注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
public class MybatisScanConfiguration {
	    /**
	     * MyBatis扫描接口
	     *
	     * @author liuzh
	     * @since 2015-12-19 14:46
	     */
        @Bean
        public MapperScannerConfigurer mapperScannerConfigurer() {
            MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
            mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
            mapperScannerConfigurer.setBasePackage("com.hz.mybatis.mapper");
            return mapperScannerConfigurer;
        }

}
