package cn.zcj.newsssm.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zcj.newsssm.entity.Comment;
import cn.zcj.newsssm.service.CommentSvc;
import cn.zcj.newsssm.utils.BaseUtil;

@Controller
@RequestMapping("/comment")
public class CommentAct {
	@Autowired
	private CommentSvc commentSvc;
	
	private String jsonResult;
	private HashMap<String, Object> jsonobj = new HashMap<String, Object>();
	
	
	@RequestMapping(value = "/listComments", method = RequestMethod.POST)
	public void listComments(int id,HttpServletResponse response) throws Exception {
		List<Comment> commentslist = commentSvc.findAllComments(id);
		jsonobj.clear();
		jsonobj.put("total", commentslist.size());
		jsonobj.put("rows", commentslist);
		jsonResult = BaseUtil.toJson(jsonobj);
		BaseUtil.outPrint(response, jsonResult);
	}
	
	
	@RequestMapping(value = "/saveAddComment", method = RequestMethod.POST)
	public void saveAddComment(int id, Comment comment, HttpServletResponse response) {
		jsonobj.clear();
		try {
			comment.setId(id);
			comment.setCdate(new Date());
			System.out.println(comment.toString());
			
			
			commentSvc.addComment(comment);
			jsonobj.put("ok", true);
			//jsonobj.put("msg", "goadmin");
		} catch (Exception e) {
			e.printStackTrace();
			jsonobj.put("ok", false);
			jsonobj.put("msg", "评论系统错误");
		}
		jsonResult = BaseUtil.toJson(jsonobj);

		BaseUtil.outPrint(response, jsonResult);
	}
	
	
	
	@RequestMapping(value = "/getCommentCount", method = RequestMethod.POST)
	public void getCount(int id, HttpServletResponse response) {
		int c = 0;
		try {
			c = commentSvc.getCount(id);
		} catch (Exception e) {
			e.printStackTrace();
			c = 0;
		}
		jsonobj.clear();
		jsonobj.put("commentcount", c);
		jsonResult = BaseUtil.toJson(jsonobj);
		BaseUtil.outPrint(response, jsonResult);
	}

}
