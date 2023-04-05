package com.spring.mvcboard.article.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvcboard.article.domain.ArticleVO;
import com.spring.mvcboard.article.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	private static final Logger log = LoggerFactory.getLogger(ArticleController.class);

	private final ArticleService articleService;

	@Inject
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	// 등록 페이지로 이동
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGET() {

	    log.info("writeGET forwarding");

	    return "/article/write";
	}
	
	// 등록 처리
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePOST(ArticleVO articleVO,
	                        RedirectAttributes redirectAttributes) throws Exception {

	    log.info("write POST...");
	    log.info(articleVO.toString());
	    articleService.create(articleVO);
	    redirectAttributes.addFlashAttribute("msg", "regSuccess");

	    return "redirect:/article/list";
	}
	
	// 목록 페이지로 이동
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {

	    log.info("List page fowarding");
	    model.addAttribute("articles", articleService.listAll());

	    return "/article/list";
	}
	
	// 조회 페이지로 이동
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(@RequestParam("articleNo") int articleNo,
	                   Model model) throws Exception {

	    log.info("Read page fowarding");
	    model.addAttribute("article", articleService.read(articleNo));

	    return "/article/read";
	}
	
	// 수정 페이지로 이동
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("articleNo") int articleNo,
	                        Model model) throws Exception {

	    log.info("modifyGet fowarding");
	    model.addAttribute("article", articleService.read(articleNo));

	    return "/article/modify";
	}
	
	// 수정 처리
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(ArticleVO articleVO,
	                         RedirectAttributes redirectAttributes) throws Exception {

	    log.info("modifyPOST fowarding");
	    articleService.update(articleVO);
	    redirectAttributes.addFlashAttribute("msg", "modSuccess");

	    return "redirect:/article/list";
	}
	
	// 삭제 처리
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("articleNo") int articleNo,
	                     RedirectAttributes redirectAttributes) throws Exception {

	    log.info("remove ...");
	    articleService.delete(articleNo);
	    redirectAttributes.addFlashAttribute("msg", "delSuccess");

	    return "redirect:/article/list";
	}
}
