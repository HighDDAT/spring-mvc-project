package com.spring.mvcboard.article.persistence;

import java.util.List;

import com.spring.mvcboard.article.domain.ArticleDTO;

public interface ArticleDAO {
	
	// 기본 CRUD 게시판
	void create(ArticleDTO articleDTO) throws Exception;
	
	ArticleDTO read(Integer articleNo) throws Exception;
	
    void update(ArticleDTO articleDTO) throws Exception;
    
    void delete(Integer articleNo) throws Exception;
    
    List<ArticleDTO> listAll() throws Exception;


}
