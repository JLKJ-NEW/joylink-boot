package com.joylink.userms.configuration;

import java.nio.charset.Charset;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.joylink.userms.configuration.support.WxMappingJackson2HttpMessageConverter;

@Configuration
public class RestTemplateConfiguration {
	
	@Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
		StringHttpMessageConverter m = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		RestTemplate restTemplate = new RestTemplate(factory);
		restTemplate.getMessageConverters().add(0, m);
		restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);//单位为ms
        factory.setConnectTimeout(5000);//单位为ms
        return factory;
    }
	
}
