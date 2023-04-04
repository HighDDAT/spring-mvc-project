package com.spring.mvcboard.article.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.spring.mvcboard.article.domain.ArticleDTO;
import com.spring.mvcboard.article.persistence.ArticleDAO;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	private final ArticleDAO articleDAO;

	@Inject
	public ArticleServiceImpl(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	public void create(ArticleDTO articleDTO) throws Exception {
		articleDAO.create(articleDTO);
	}

	@Override
	public ArticleDTO read(Integer articleNo) throws Exception {
		return articleDAO.read(articleNo);
	}

	@Override
	public void update(ArticleDTO articleDTO) throws Exception {
		articleDAO.update(articleDTO);
	}

	@Override
	public void delete(Integer articleNo) throws Exception {
		articleDAO.delete(articleNo);
	}

	@Override
	public List<ArticleDTO> listAll() throws Exception {
		return articleDAO.listAll();
	}
	
	

}
