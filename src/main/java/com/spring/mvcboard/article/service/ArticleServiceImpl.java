package com.spring.mvcboard.article.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvcboard.article.domain.ArticleVO;
import com.spring.mvcboard.article.persistence.ArticleDAO;
import com.spring.mvcboard.commons.paging.Criteria;
import com.spring.mvcboard.commons.paging.SearchCriteria;
import com.spring.mvcboard.upload.persistence.ArticleFileDAO;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	private final ArticleDAO articleDAO;
	private final ArticleFileDAO articleFileDAO;

	@Inject
	public ArticleServiceImpl(ArticleDAO articleDAO, ArticleFileDAO articleFileDAO) {
		this.articleDAO = articleDAO;
		this.articleFileDAO = articleFileDAO;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public void create(ArticleVO articleVO) throws Exception {
		articleDAO.create(articleVO);
        String[] files = articleVO.getFiles();

        if (files == null)
            return;
        for (String fileName : files)
            articleFileDAO.addFile(fileName);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public ArticleVO read(Integer articleNo) throws Exception {
		articleDAO.updateViewCnt(articleNo);
		return articleDAO.read(articleNo);
	}

	@Override
	public void update(ArticleVO articleVO) throws Exception {
		articleDAO.update(articleVO);
	}

	@Override
	public void delete(Integer articleNo) throws Exception {
		articleDAO.delete(articleNo);
	}

	@Override
	public List<ArticleVO> listAll() throws Exception {
		return articleDAO.listAll();
	}

	// 페이징
	@Override
	public List<ArticleVO> listCriteria(Criteria criteria) throws Exception {
		return articleDAO.listCriteria(criteria);
	}
	
	@Override
	public int countArticles(Criteria criteria) throws Exception {
	    return articleDAO.countArticles(criteria);
	}
	
	// 검색 기능 관련
	@Override
	public List<ArticleVO> listSearch(SearchCriteria searchCriteria) throws Exception {
	    return articleDAO.listSearch(searchCriteria);
	}

	@Override
	public int countSearchedArticles(SearchCriteria searchCriteria) throws Exception {
	    return articleDAO.countSearchedArticles(searchCriteria);
	}
}
