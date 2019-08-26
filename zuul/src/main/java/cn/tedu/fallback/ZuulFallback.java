package cn.tedu.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component //包扫描
public class ZuulFallback implements ZuulFallbackProvider {

	@Override //设置返回的值，一般用json体现
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
			
			@Override //请求响应头信息，contentType和字符类型
			public HttpHeaders getHeaders() {
				HttpHeaders header = new HttpHeaders();
				header.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return header;
			}
			
			@Override  //响应体，具体返回内容
			public InputStream getBody() throws IOException {
				String returnValue="tony6";
				return new ByteArrayInputStream(returnValue.getBytes());
			}
			
			@Override  //返回文字描述
			public String getStatusText() throws IOException {
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}
			
			@Override  //返回状态码
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST;
			}
			
			@Override  //返回二进制状态码
			public int getRawStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override  //关闭释放资源
			public void close() {
				// TODO Auto-generated method stub
				
			}
		};
		
	}

	@Override//获取路由
	public String getRoute() {
		return "provider-user";
	}

}
