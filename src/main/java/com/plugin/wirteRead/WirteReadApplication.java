package com.plugin.wirteRead;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


import javax.sql.DataSource;

@EnableAutoConfiguration
@EnableAspectJAutoProxy
@ComponentScan
@MapperScan("com.plugin.wirteRead.mapper")
@SpringBootApplication
public class WirteReadApplication {




	public static void main(String[] args) {
		SpringApplication.run(WirteReadApplication.class, args);
	}

}
