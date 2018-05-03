package cn.zcj.examOnline;


import org.apache.shiro.crypto.hash.Sha256Hash;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.nutz.ioc.Ioc;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.Setup;

import cn.zcj.examOnline.pojo.User;

public class MainSetup implements Setup {
	
	@Override
	 public void init(NutConfig nc) {
	        Ioc ioc = nc.getIoc();	//contect database
	        Dao dao = ioc.get(Dao.class);
	        Daos.createTablesInPackage(dao, "cn.zcj.examOnline.pojo", false);
	        // 初始化默认根用户
	        if (dao.count(User.class) == 0) {
	            User user = new User();
	            user.setUid("15436303");
	            user.setXm("钟乘剑");
	            String salt="abcdefghijklmnopqrstuvwx";
	            user.setPwd(new Sha256Hash("zxcv123456",salt,1024).toBase64());
	            user.setBj("信息学院");
	            user.setRole("1");
	            dao.insert(user);
	        }
	    } 
	 	
	 	@Override
	    public void destroy(NutConfig nc) {// webapp销毁之前执行的逻辑
	    } 
}
