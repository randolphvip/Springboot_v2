package com;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
* @ClassName: SpringbootWebInitializer
* @Description: web容器中进行部署
* 
* @date 2018年8月18日
*
*/
public class WebInitializer  extends SpringBootServletInitializer{
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(Application.class);
    }
}
