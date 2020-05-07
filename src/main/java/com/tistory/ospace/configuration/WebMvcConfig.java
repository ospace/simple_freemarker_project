package com.tistory.ospace.configuration;

import java.io.File;
import java.net.URL;
import java.util.Locale;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
		URL templateUrl = Class.class.getResource("/templates");
	    return factory -> {
	    	factory.setDocumentRoot(new File(templateUrl.getFile()));
	    };
	}
	
	// Tiles 설정
	@Bean
	public UrlBasedViewResolver tilesViewResolver() { // public
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		
		resolver.setViewClass(FreeMarkerTilesView.class);
//		resolver.setViewClass(TilesView2.class);
		resolver.setOrder(1); // 먼저 ViewResolver 타야함.

		return resolver;
	}

	@Bean
	public TilesConfigurer tilesConfigurer() {
		
		FreeMarkerTilesInitializer freeMarkerInitiaizer = new FreeMarkerTilesInitializer();
		
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setCheckRefresh(true);
		tilesConfigurer.setTilesInitializer(freeMarkerInitiaizer);
		
		return tilesConfigurer;
	}

	// Request에서 lang파라미터를 인터셉터해서 locale로 설정(1)
	// ex) ?lang=ko_KR
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor bean = new LocaleChangeInterceptor();
		bean.setParamName("lang");
		return bean;
	}

	// 언어 정보를 세션에 저장하여 사용.
	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.KOREA);
		return resolver;
	}

	// Intercepter 추가
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor()); // locale 인터셉터(1)
	}
}