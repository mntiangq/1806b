package cn.tedu.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@FeignClient("provider-user")    //通过eureka，找到提供者
public interface HelloFeign {

	//对提供的调用
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name);
}
