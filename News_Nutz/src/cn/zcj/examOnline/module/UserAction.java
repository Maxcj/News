package cn.zcj.examOnline.module;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.util.NutMap;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import cn.zcj.examOnline.pojo.User;
import cn.zcj.examOnline.utils.BaseAct;
import cn.zcj.examOnline.utils.LoginFilter;

/*
 * 		@IocBean
 * 		@At				入口
 * 		@Inject			注入
 * 		@OK 	 		处理正常，无报错
 * 		@Parm			参数
 */

@IocBean
@At("/user")
@Filters({@By(type=LoginFilter.class)})
public class UserAction extends BaseAct{
	 @Inject
     protected Dao dao;
     //查--登录
     @At
     @Ok("json")
     @Filters()
     public Object doLogin(@Param("uid")String uid, @Param("pwd") String pwd,
			HttpSession session,HttpServletRequest req){
       NutMap re = new NutMap();
       /*
        * 通过User表取主键uid的值，通过uid主键获取数据,封装为user对象
        */
       User user = dao.fetch(User.class, uid);
       if (user == null ) {
           re.put("ok", false);
           re.put("msg", "考号不存在");
           return re;
       }
       String p =Code(pwd, "");
       if (!p.equals(user.getPwd())) {
           re.put("ok", false);
           re.put("msg", "密码不正确");
           return re;
       }
       
       
       /*
        *  获取用户角色信息
        *  
        *  1：管理员
        *  5：考生（普通用户）
        *  
        */
      
       String role=user.getRole();

       //登录成功后...将用户信息保存到session
       session.setAttribute("me", user);
       if(role.equals("5")) {
           re.put("ok", true);
           re.put("msg", "user/goIndex");
           return re;
       }
       else if(role.equals("1")) {
           re.put("ok", true);
           re.put("msg", "user/goAdmin");
           return re;
       }
      else {
           re.put("ok", false);
           re.put("msg", "系统错误！");
           return re;
     }
     }
     
     
     @At
     @Ok("beetl:web/index.html")//考生登录成功，跳转到考试信息页面
     public void goIndex(HttpSession session,HttpServletRequest req){
           User loginuser=(User)session.getAttribute("me");
           req.setAttribute("user", loginuser);
     }
     @At
     @Ok("beetl:web/admin.html")//管理员登录成功，跳转到管理信息页面
     public void goAdmin(HttpSession session,HttpServletRequest req){
           User loginuser=(User)session.getAttribute("me");
           req.setAttribute("user", loginuser);
     }
     
     //安全退出
     @At
     @Ok(">>:/")
     public void doLogout(HttpSession session) {
         session.invalidate();
     }

}
