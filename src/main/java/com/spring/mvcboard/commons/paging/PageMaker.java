package com.spring.mvcboard.commons.paging;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageMaker {

    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev;
    private boolean next;
    
    // 페이지 번호 개수
    private int displayPageNum = 10;

    private Criteria criteria;

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        calcData();
    }
    
    // 게시글의 전체 개수가 정해지면 메서드 호출해서 계산
    private void calcData() {
        endPage = (int) (Math.ceil(criteria.getPage() / (double) displayPageNum) * displayPageNum);
        startPage = (endPage - displayPageNum) + 1;

        int tempEndPage = (int) (Math.ceil(totalCount / (double) criteria.getPerPageNum()));
        if (endPage > tempEndPage) {
            endPage = tempEndPage;
        }

        prev = startPage == 1 ? false : true;
        next = endPage * criteria.getPerPageNum() >= totalCount ? false : true;
    }
    
    // UriComponentsBuilder
    public String makeQuery(int page) {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("page", page)
                .queryParam("perPageNum", criteria.getPerPageNum())
                .build();

        return uriComponents.toUriString();
    }
}