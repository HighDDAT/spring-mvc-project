package com.spring.mvcboard.article.service;

import java.util.List;

import com.spring.mvcboard.article.domain.ArticleVO;
import com.spring.mvcboard.commons.paging.Criteria;

public interface ArticleService {

	void create(ArticleVO articleVO) throws Exception;

	ArticleVO read(Integer articleNo) throws Exception;

    void update(ArticleVO articleVO) throws Exception;

    void delete(Integer articleNo) throws Exception;

    List<ArticleVO> listAll() throws Exception;
    
    // 페이징
    List<ArticleVO> listCriteria(Criteria criteria) throws Exception;
    
    int countArticles(Criteria criteria) throws Exception;
    
}
