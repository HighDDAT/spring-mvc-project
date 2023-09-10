package com.spring.mvcboard.tutorial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvcboard.article.controller.ArticleController;

@Controller
@RequestMapping("/interceptor")
public class InterceptorController {
	
	private static final Logger log = LoggerFactory.getLogger(ArticleController.class);
	
	@RequestMapping(value = "/doA", method = RequestMethod.GET)
    public String doA() {
        log.info("doA() called");

        return "/tutorial/interceptor_test";
    }

    @RequestMapping(value = "/doB", method = RequestMethod.GET)
    public String doB(Model model) {
        log.info("doB() called");
        model.addAttribute("result", "doB result data...");

        return "/tutorial/interceptor_test";
    }

}
