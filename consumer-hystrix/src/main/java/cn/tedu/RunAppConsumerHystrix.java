package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
@SpringCloudApplication
@EnableFeignClients     //表示feign

public class RunAppConsumerHystrix {

	public static void main(String[] args) {
		SpringApplication.run(RunAppConsumerHystrix.class, args);
	}

}
