package cn.zcj.newsssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zcj.newsssm.dao.CommentDao;
import cn.zcj.newsssm.entity.Comment;

@Service
public class CommentSvc {
	
	@Resource
	private CommentDao dao;
	
	public void addComment(Comment comment){
		dao.add(comment);
	}
	
	public List<Comment> findAllComments(int newsid) throws Exception{
		return dao.list(newsid);
	}
	
	public int getCount(int id){
		return dao.countofComment(id);
	}

}
