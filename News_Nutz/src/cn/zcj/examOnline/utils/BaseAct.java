package cn.zcj.examOnline.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.json.Json;

public class BaseAct {
	
	protected String Code(String password,String salt){
		   if(salt=="") salt="abcdefghijklmnopqrstuvwx";
		   return new Sha256Hash(password, salt, 1024).toBase64();
		}
	
	  public <T> String listPageJson(Dao dao, Class<T> obj, int curPage, int pageSize, Condition cnd) {
          Map<String, Object> jsonobj = new HashMap<String, Object>();
          Pager pager = dao.createPager(curPage, pageSize);
          List<T> list = dao.query(obj, cnd, pager);
          pager.setRecordCount(dao.count(obj, cnd));
          jsonobj.put("total", pager.getRecordCount());
          jsonobj.put("rows", list);
          return Json.toJson(jsonobj);
      }

}
