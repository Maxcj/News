package cn.zcj.examOnline.utils;

import javax.servlet.http.HttpServletRequest;

import org.nutz.lang.Strings;
import org.nutz.mvc.ActionContext;
import org.nutz.mvc.ActionFilter;
import org.nutz.mvc.View;
import org.nutz.mvc.view.ServerRedirectView;

import cn.zcj.examOnline.pojo.User;

public class LoginFilter implements ActionFilter{

	@Override
	public View match(ActionContext context) {
		 HttpServletRequest request=context.getRequest();
         User user = (User) request.getSession().getAttribute("me");
         String contentType=request.getContentType();
         if (user == null) {
            if(Strings.sNull(contentType).contains("application/x-www-form-urlencoded")){
               context.getResponse().setHeader("sessionstatus","timeout");
            } 
            ServerRedirectView view = new ServerRedirectView("/error/nologin.html");
            return view;
         }
         request.setAttribute("me", user);
         return null;
	}

}
