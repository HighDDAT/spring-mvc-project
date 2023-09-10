package com.spring.mvcboard.article.persistence;

import java.util.List;

import com.spring.mvcboard.article.domain.ArticleVO;
import com.spring.mvcboard.commons.paging.Criteria;
import com.spring.mvcboard.commons.paging.SearchCriteria;

public interface ArticleDAO {
	
	// 기본 CRUD 게시판
	void create(ArticleVO articleVO) throws Exception;
	
	ArticleVO read(Integer articleNo) throws Exception;
	
    void update(ArticleVO articleVO) throws Exception;
    
    void delete(Integer articleNo) throws Exception;
    
    List<ArticleVO> listAll() throws Exception;
    
    // 페이징 관련
    List<ArticleVO> listPaging(int page) throws Exception;
    
    List<ArticleVO> listCriteria(Criteria criteria) throws Exception;
    
    int countArticles(Criteria criteria) throws Exception;
    
    // 검색 기능 관련
    List<ArticleVO> listSearch(SearchCriteria searchCriteria) throws Exception;

    int countSearchedArticles(SearchCriteria searchCriteria) throws Exception;
    
    // 트랜잭션 처리
    void updateViewCnt(Integer articleNo) throws Exception;
    
    void updateReplyCnt(Integer articleNo, int amount) throws Exception;

}
