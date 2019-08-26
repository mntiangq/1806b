package cn.tedu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.tedu.feign.HelloFeign;

@RestController
public class HelloController {

	//注入feign接口
	@Autowired
	private HelloFeign helloFeign;
	
	
	@RequestMapping("/hello/{name}")
	@HystrixCommand(fallbackMethod="helloFallback")
	public String hello(@PathVariable String name) {
		return helloFeign.hello(name);
	}
	
	//hystrix不够完美，第一次可能会进入断路器
	public String helloFallback( String name) {
		return "tom";
	}
}
