package cn.zcj.newsssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zcj.newsssm.entity.Comment;

public interface CommentDao {
	public int add(Comment comment);
	
	public int countofComment(int id);
	
	public List<Comment> list(int id) throws Exception;
	
}
