package com.tistory.ospace.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContext;

import com.tistory.ospace.repository.AccountDto;

//https://www.javacodegeeks.com/2012/07/integrating-spring-velocity-and-tiles.html
//https://freemarker.apache.org/docs/index.html
//http://tiles.apache.org/framework/tutorial/integration/freemarker.html
//http://websystique.com/springmvc/spring-4-mvc-apache-tiles-3-annotation-based-example/

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping("/")
	public String index(HttpServletRequest req, HttpServletRequest res, Model model) {
		logger.info("index begin: locale[{}]", LocaleContextHolder.getLocale().toLanguageTag());
		long runtime = System.currentTimeMillis();
		
		model.addAttribute("say", "Hi");
		model.addAttribute("account", new AccountDto("foo", "누구"));
		
		String greeting = messageSource.getMessage("greeting", null, LocaleContextHolder.getLocale());
		
		RequestContext reqCtx = new RequestContext(req);
		String greeting2 = reqCtx.getMessage("greeting");
		
		logger.info("index end: greeting[{}] greeting2[{}] runtime[{} msec]", greeting, greeting2, System.currentTimeMillis()-runtime);

		return "none:index";
	}
	
	@RequestMapping("/normal")
	public String normal(HttpServletRequest req, HttpServletRequest res, Model model) {
		logger.info("normal begin: locale[{}]", LocaleContextHolder.getLocale().toLanguageTag());
		long runtime = System.currentTimeMillis();
		
		model.addAttribute("say", "Hello");
		model.addAttribute("account", null);
		
		logger.info("index end: runtime[{} msec]", System.currentTimeMillis()-runtime);

		return "normal:index";
	}
}
