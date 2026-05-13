package com.test.java.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	// C:/Ssangyong/code/springai 와 /uploads 가 같은 표현입니다
	// 라고 알려주기 위해 작성
	@Value("${upload.path}")
    private String uploadPath;
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/uploads/**")
                            .addResourceLocations("file:///" + uploadPath + "/");
    }
}
