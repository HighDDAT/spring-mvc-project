package com.spring.mvcboard.article.persistence;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.spring.mvcboard.article.domain.ArticleDTO;

@Repository
public class ArticleDAOlmpl implements ArticleDAO {
	
	private static final String NAMESPACE = "com.spring.mvcboard.mappers.article.ArticleMapper";

    private final SqlSession sqlSession;
    
    @Inject
	public ArticleDAOlmpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void create(ArticleDTO articleDTO) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", articleDTO);
	}

	@Override
	public ArticleDTO read(Integer articleNo) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".read", articleNo);
	}

	@Override
	public void update(ArticleDTO articleDTO) throws Exception {
		sqlSession.update(NAMESPACE + ".update", articleDTO);
	}

	@Override
	public void delete(Integer articleNo) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", articleNo);
	}

	@Override
	public List<ArticleDTO> listAll() throws Exception {
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}

}
