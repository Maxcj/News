package cn.zcj.newsssm.web;

import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zcj.newsssm.entity.User;
import cn.zcj.newsssm.service.UserSvc;
import cn.zcj.newsssm.utils.BaseUtil;

@Controller
@RequestMapping("/user")
public class UserAct {
	@Autowired
	private UserSvc userSvc;

	private HashMap<String, Object> jsonobj = new HashMap<String, Object>();

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public void doLogin(String uid, String pwd, HttpSession session,
			HttpServletResponse response, Model model) {
		try {
			Long n = userSvc.getCount();
			if (n == 0) {
				User user = new User();
				user.setUid("15436303");
				user.setXm("Maxcj");
				user.setPwd(BaseUtil.Code("123", ""));
				user.setBj("信息学院");
				user.setRole("1");
				userSvc.addUser(user);
			}
			pwd = BaseUtil.Code(pwd, "");
			User user0 = userSvc.findUser(uid, pwd);
			jsonobj.clear();
			if (user0 != null) {
				jsonobj.put("ok", true);
				jsonobj.put("msg", "user/goIndex");
				session.setAttribute("me", user0);
			} else {
				jsonobj.put("ok", false);
				jsonobj.put("msg", "用户不存在");
			}
		} catch (Exception e) {
			jsonobj.put("ok", false);
			jsonobj.put("msg", "系统错误2");
		}
		BaseUtil.outPrint(response, BaseUtil.toJson(jsonobj));
	}

	@RequestMapping(value = "/doLogout", method = RequestMethod.GET)
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/index.jsp";
	}

	@RequestMapping(value = "/goIndex")
	public String goIndex() {
		return "/admin";
	}

}
