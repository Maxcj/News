package cn.zcj.newsssh.action;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import cn.zcj.newsssh.bean.News;
import cn.zcj.newsssh.service.NewsSvc;
import cn.zcj.newsssh.utils.BaseUtil;

import com.opensymphony.xwork2.ActionSupport;

@Controller("news")
public class NewsAct extends ActionSupport {

	@Resource
	private NewsSvc newsSvc;

	private News news;
	private int page, rows, id;
	private String s_name;
	private String jsonResult;
	private HashMap<String, Object> jsonobj = new HashMap<String, Object>();

	/*
	 * 增加新闻
	 */
	public String goAdd() {
		return "goadd";
	}

	public String saveAdd() {
		jsonobj.clear();
		try {
			news.setDate(new Date());
			news.setHitnum(0);
			newsSvc.addNews(news);
			jsonobj.put("ok", true);
			jsonobj.put("msg", "goadmin");
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

	/*
	 * 删除新闻
	 */
	public String doDel1() {
		jsonobj.clear();
		boolean delflag = false;
		try {
			newsSvc.deleteNews(id, News.class);
			delflag = true;
		} catch (Exception e) {
			e.printStackTrace();
			delflag = false;
		}
		jsonobj.put("delflag", delflag);
		HttpServletResponse response = ServletActionContext.getResponse();
		BaseUtil.outPrint(response, BaseUtil.toJson(jsonobj));
		return null;
	}

	/*
	 * 修改新闻
	 */
	public String goEdit() {
		news = newsSvc.getNews(News.class, id);
		return "goedit";
	}

	public String saveEdit() {
		jsonobj.clear();
		try {
			News news0 = newsSvc.getNews(News.class, news.getId());
			news0.setContent(news.getContent());
			news0.setCruser(news.getCruser());
			news0.setTitle(news.getTitle());
			newsSvc.updateNews(news0);
			jsonobj.put("ok", true);
			jsonobj.put("msg", "goadmin");
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

	/*
	 * 查询新闻
	 */
	public String goList() {
		return "golist";
	}

	public String getCount() {
		int c = 0;
		try {
			c = newsSvc.getNewsCount();
		} catch (Exception e) {
			e.printStackTrace();
			c = 0;
		}
		jsonobj.clear();
		jsonobj.put("newscount", c);
		jsonResult = BaseUtil.toJson(jsonobj);
		HttpServletResponse response = ServletActionContext.getResponse();
		BaseUtil.outPrint(response, jsonResult);
		return null;
	} 
	
	// 阅读一条新闻
	public String getaNews() {
		news = newsSvc.getNews(News.class, id);
		return "goread";
	} 
	
	// 分页查询新闻
	public String listNews() {
		List<News> newslist = newsSvc.listDgNews(s_name, page, rows);
		jsonobj.clear();
		jsonobj.put("total", newslist.size());
		jsonobj.put("rows", newslist);
		jsonResult = BaseUtil.toJson(jsonobj);
		HttpServletResponse response = ServletActionContext.getResponse();
		BaseUtil.outPrint(response, jsonResult);
		return null;
	}

	
	
	/*
	 * 属性注入set get方法
	 */
	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

}
