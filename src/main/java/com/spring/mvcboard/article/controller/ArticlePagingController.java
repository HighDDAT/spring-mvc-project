package com.spring.mvcboard.article.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvcboard.article.domain.ArticleVO;
import com.spring.mvcboard.article.service.ArticleService;
import com.spring.mvcboard.commons.paging.Criteria;
import com.spring.mvcboard.commons.paging.PageMaker;

@Controller
@RequestMapping("/article/paging")
public class ArticlePagingController {
	
	private static final Logger log = LoggerFactory.getLogger(ArticleController.class);

	private final ArticleService articleService;

	@Inject
	public ArticlePagingController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	// 등록 페이지로 이동
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGET() {

	    log.info("paging writeGET forwarding");

	    return "/article/paging/write";
	}
	
	// 등록 처리
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePOST(ArticleVO articleVO,
	                        RedirectAttributes redirectAttributes) throws Exception {

	    log.info("paging writePOST forwarding");
	    log.info(articleVO.toString());
	    articleService.create(articleVO);
	    redirectAttributes.addFlashAttribute("msg", "regSuccess");

	    return "redirect:/article/paging/list";
	}
	
	// paging list
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listPaging(Model model, Criteria criteria) throws Exception {
	    log.info("listPaging fowarding");

	    PageMaker pageMaker = new PageMaker();
	    pageMaker.setCriteria(criteria);
	    // pageMaker.setTotalCount(1000);
	    pageMaker.setTotalCount(articleService.countArticles(criteria));

	    model.addAttribute("articles", articleService.listCriteria(criteria));
	    model.addAttribute("pageMaker", pageMaker);

	    return "/article/paging/list";
	}
	
	// paing read
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String readPaging(@RequestParam("articleNo") int articleNo,
	                         @ModelAttribute("criteria") Criteria criteria,
	                         Model model) throws Exception {
		log.info("readPaging fowarding");
	    model.addAttribute("article", articleService.read(articleNo));

	    return "/article/paging/read";
	}
	
	// paing modify
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGETPaging(@RequestParam("articleNo") int articleNo,
	                              @ModelAttribute("criteria") Criteria criteria,
	                              Model model) throws Exception {
	    log.info("modifyGetPaging forwarding");
	    
	    model.addAttribute("article", articleService.read(articleNo));

	    return "/article/paging/modify";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOSTPaging(ArticleVO articleVO,
	                               Criteria criteria,
	                               RedirectAttributes redirectAttributes) throws Exception {
	    log.info("modifyPOSTPaging forwarding");
	    
	    articleService.update(articleVO);
	    redirectAttributes.addAttribute("page", criteria.getPage());
	    redirectAttributes.addAttribute("perPageNum", criteria.getPerPageNum());
	    redirectAttributes.addFlashAttribute("msg", "modSuccess");

	    return "redirect:/article/paging/list";
	}
	
	// paing remove
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String removePaging(@RequestParam("articleNo") int articleNo,
	                           Criteria criteria,
	                           RedirectAttributes redirectAttributes) throws Exception {
	    log.info("removePaging forwarding");
	    
	    articleService.delete(articleNo);
	    
	    redirectAttributes.addAttribute("page", criteria.getPage());
	    redirectAttributes.addAttribute("perPageNum", criteria.getPerPageNum());
	    redirectAttributes.addFlashAttribute("msg", "delSuccess");

	    return "redirect:/article/paging/list";
	}
}
