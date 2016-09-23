package com.victommasi.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public EmbeddedServletContainerCustomizer customizer() {
		return new EmbeddedServletContainerCustomizer() {

			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"),
							            new ErrorPage(HttpStatus.FORBIDDEN, "/403"),
							            new ErrorPage(HttpStatus.BAD_REQUEST, "/500"));
			}
		};
	}
}
