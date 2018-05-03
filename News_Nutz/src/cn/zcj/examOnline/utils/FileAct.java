package cn.zcj.examOnline.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.Mvcs;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;

import com.baidu.ueditor.ActionEnter;



@IocBean
@At("/file")
@Filters({@By(type=LoginFilter.class)})
public class FileAct {
	
	@At
	@Ok("raw")
	public void bdupfile(HttpSession session, HttpServletRequest req, HttpServletResponse res) throws IOException{
		req.setCharacterEncoding("utf-8");
		res.setHeader("Content‐Type", "text/html");
		String rootPath = Mvcs.getServletContext().getRealPath("/");
		PrintWriter out = res.getWriter();
		out.print(new ActionEnter(req, rootPath).exec());
	}

}
