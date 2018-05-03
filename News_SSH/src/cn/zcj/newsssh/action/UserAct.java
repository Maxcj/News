package cn.zcj.newsssh.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zcj.newsssh.bean.User;
import cn.zcj.newsssh.service.UserSvc;
import cn.zcj.newsssh.utils.BaseUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@Controller("userAct")
@RequestMapping("/user")
public class UserAct extends ActionSupport {

	@Resource
	private UserSvc userSvc;

	private String uid, pwd;
	private String jsonResult;
	private HashMap<String, Object> jsonobj = new HashMap<String, Object>();

	public String doLogin() {
		try {
			Long num = userSvc.getCount();
			if (num == 0) {
				User user = new User();
				user.setUid("15436303");
				user.setXm("Maxcj");
				String salt = "abcdefghijklmnopqrstuvwx";
				user.setPwd(new Sha256Hash("zxcv123456", salt, 1024).toBase64());
				user.setBj("信息学院");
				user.setRole("1");

				userSvc.addU(user);
			}
			User u = userSvc.findU(uid, pwd);
			
			jsonobj.clear();
			if (u != null) {
				// 用户存在
				System.out.println("****************************************"+u.toString());
				
				jsonobj.put("ok", true);
				jsonobj.put("msg", "goIndex");
				Map<String, Object> session = ActionContext.getContext()
						.getSession();
				session.put("me", u);
			} else {
				jsonobj.put("ok", false);
				jsonobj.put("msg", "用户不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonobj.put("ok", false);
			jsonobj.put("msg", "系统错误2");
		}
		jsonResult = BaseUtil.toJson(jsonobj);
		HttpServletResponse response = ServletActionContext.getResponse();
		BaseUtil.outPrint(response, jsonResult);
		return null;
	}
	
	public String doLogout(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("me", null);
		return "logout";
	}
	
	public String goIndex(){
		return "goadmin";
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
