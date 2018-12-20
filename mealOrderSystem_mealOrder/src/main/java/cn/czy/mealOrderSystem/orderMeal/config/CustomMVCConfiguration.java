package cn.czy.mealOrderSystem.orderMeal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.czy.mealOrderSystem.orderMeal.interceptor.CustomInterceptor;

@Configuration
public class CustomMVCConfiguration implements WebMvcConfigurer {

	@Autowired
	private CustomInterceptor customInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addInterceptors(registry);
		registry.addInterceptor(customInterceptor).addPathPatterns("/**");
	}

	// @Bean
	// public HttpMessageConverter<String> responseBodyConverter() {
	// StringHttpMessageConverter converter = new
	// StringHttpMessageConverter(Charset.forName("UTF-8"));
	// return converter;
	// }

}