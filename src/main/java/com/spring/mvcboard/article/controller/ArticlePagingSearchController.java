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
import com.spring.mvcboard.commons.paging.PageMaker;
import com.spring.mvcboard.commons.paging.SearchCriteria;

@Controller
@RequestMapping("/article/paging/search")
public class ArticlePagingSearchController {
	
	private static final Logger log = LoggerFactory.getLogger(ArticleController.class);

	private final ArticleService articleService;
	
	@Inject
	public ArticlePagingSearchController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	// write
	@RequestMapping(value = "/write", method = RequestMethod.GET)
    public String writeGET(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria) throws Exception {

        return "article/search/write";
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String writePOST(ArticleVO articleVO,
                            RedirectAttributes redirectAttributes) throws Exception {

        articleService.create(articleVO);
        redirectAttributes.addFlashAttribute("msg", "regSuccess");

        return "redirect:/article/paging/search/list";
    }
	
	// search list
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria,
                       Model model) throws Exception {

		log.info("listPagingSearch fowarding");

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCriteria(searchCriteria);
        pageMaker.setTotalCount(articleService.countSearchedArticles(searchCriteria));

        model.addAttribute("articles", articleService.listSearch(searchCriteria));
        model.addAttribute("pageMaker", pageMaker);

        return "article/search/list";
    }
	
	// search read
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(@RequestParam("articleNo") int articleNo,
	                   @ModelAttribute("searchCriteria") SearchCriteria searchCriteria,
	                   Model model) throws Exception {

	    log.info("readPagingSearch fowarding");
	    model.addAttribute("article", articleService.read(articleNo));

	    return "article/search/read";
	}
	
	// serach modify
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("articleNo") int articleNo,
	                        @ModelAttribute("searchCriteria") SearchCriteria searchCriteria,
	                        Model model) throws Exception {

	    log.info("modifyGetPagingSearch forwarding");
	    log.info(searchCriteria.toString());
	    model.addAttribute("article", articleService.read(articleNo));

	    return "article/search/modify";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(ArticleVO articleVO,
	                         SearchCriteria searchCriteria,
	                         RedirectAttributes redirectAttributes) throws Exception {

	    log.info("modifyPOSTPagingSearch forwarding");
	    articleService.update(articleVO);
	    redirectAttributes.addAttribute("page", searchCriteria.getPage());
	    redirectAttributes.addAttribute("perPageNum", searchCriteria.getPerPageNum());
	    redirectAttributes.addAttribute("searchType", searchCriteria.getSearchType());
	    redirectAttributes.addAttribute("keyword", searchCriteria.getKeyword());
	    redirectAttributes.addFlashAttribute("msg", "modSuccess");

	    return "redirect:/article/paging/search/list";
	}
	
	// search remove
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("articleNo") int articleNo,
	                     SearchCriteria searchCriteria,
	                     RedirectAttributes redirectAttributes) throws Exception {

	    log.info("removePagingSearch forwarding");
	    
	    articleService.delete(articleNo);
	    
	    redirectAttributes.addAttribute("page", searchCriteria.getPage());
	    redirectAttributes.addAttribute("perPageNum", searchCriteria.getPerPageNum());
	    redirectAttributes.addAttribute("searchType", searchCriteria.getSearchType());
	    redirectAttributes.addAttribute("keyword", searchCriteria.getKeyword());
	    redirectAttributes.addFlashAttribute("msg", "delSuccess");

	    return "redirect:/article/paging/search/list";
	}
}
