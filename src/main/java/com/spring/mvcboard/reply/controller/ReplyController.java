package com.spring.mvcboard.reply.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mvcboard.reply.domain.ReplyVO;
import com.spring.mvcboard.reply.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	private final ReplyService replyService;

    @Inject
    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }
    
    // Reply 추가
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody ReplyVO replyVO) {
        ResponseEntity<String> entity = null;
        try {
            replyService.addReply(replyVO);
            entity = new ResponseEntity<>("regSuccess", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
    
    // Reply 목록
    @RequestMapping(value = "/all/{articleNo}", method = RequestMethod.GET)
    public ResponseEntity<List<ReplyVO>> list(@PathVariable("articleNo") Integer articleNo) {
        ResponseEntity<List<ReplyVO>> entity = null;
        try {
            entity = new ResponseEntity<>(replyService.getReplies(articleNo), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
    
    // Reply 수정
    @RequestMapping(value = "/{replyNo}", method = {RequestMethod.PUT, RequestMethod.PATCH})
    public ResponseEntity<String> update(@PathVariable("replyNo") Integer replyNo, @RequestBody ReplyVO replyVO) {
        ResponseEntity<String> entity = null;
        try {
            replyVO.setReplyNo(replyNo);
            replyService.modifyReply(replyVO);
            entity = new ResponseEntity<>("modSuccess", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
    
    // Reply 삭제
    @RequestMapping(value = "/{replyNo}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("replyNo") Integer replyNo) {
        ResponseEntity<String> entity = null;
        try {
            replyService.removeReply(replyNo);
            entity = new ResponseEntity<>("delSuccess", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

}
