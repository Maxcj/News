package cn.zcj.examOnline.module;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.sql.Criteria;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;

import cn.zcj.examOnline.pojo.News;
import cn.zcj.examOnline.utils.BaseAct;
import cn.zcj.examOnline.utils.LoginFilter;

@IocBean
@At("/news")
@Filters({ @By(type = LoginFilter.class) })
public class NewsAction extends BaseAct {

	@Inject
	protected Dao dao;

	// 增加新闻
	@At
	@Ok("beetl:web/newsadd.html")
	public void goAdd(HttpSession session, HttpServletRequest req) {
		
	}

	@At
	@Ok("raw")
	public String saveAdd(@Param("..") News news, HttpSession session,
			HttpServletRequest req) {
		try {
			news.setDate(new Date());
			news.setHitnum(0);
			dao.insert(news);
		} catch (Exception e) {
			e.printStackTrace();
			return "添加失败";
		}
		return "true";
	}

	// 删除指定id的单条新闻
	@At
	@Ok("raw")
	public String doDel1(@Param("id") int id, HttpSession session,
			HttpServletRequest req) {
		if (dao.delete(News.class, id) > 0)
			return "true";
		return "false";
	}

	@At
	@Ok("raw")
	// 删除指定id的多条新闻
	public String doDelN(@Param("ids") String ids, HttpSession session,
			HttpServletRequest req) {
		String[] s = ids.split(",");
		if (dao.clear(News.class, Cnd.where("id", "in", s)) > 0)
			return "true";
		return "false";
	}

	// 改
	@At
	@Ok("beetl:web/newsedit.html")
	public void goEdit(@Param("id") int id, HttpSession session,
			HttpServletRequest req) {
		News news = dao.fetch(News.class, id);
		req.setAttribute("news", news);
	}

	@At
	@Ok("raw")
	public String saveEdit(@Param("..") News news, HttpSession session,
			HttpServletRequest req) {
		try {
			news.setDate(null);
			news.setHitnum(null);
			if (dao.updateIgnoreNull(news) == 1)
				return "true";
			else
				return "修改失败";
		} catch (Exception e) {
			e.printStackTrace();
			return "修改失败";
		}
	}

	// 查
	@At
	@Ok("raw")
	@Filters()
	// 新闻数量
	public int getCount(HttpSession session, HttpServletRequest req) {
		return dao.count(News.class);
	}

	@At
	@Ok("beetl:web/newslist.html")
	// 跳转到新闻信息列表
	public void goList(@Param("page") int curPage, @Param("rows") int pageSize,
			HttpSession session, HttpServletRequest req) {
		Criteria cri = Cnd.cri();
		cri.where().andEquals("1", 1);
		cri.getOrderBy().desc("id");
		String newslist = listPageJson(dao, News.class, curPage, pageSize, cri);
		req.setAttribute("newslist", newslist);
		req.setAttribute("curPage", curPage);
	}

	@At
	@Ok("beetl:web/newsread.html")
	@Filters()
	// 读取指定id的新闻内容
	public void getNews(@Param("id") int id, HttpSession session,
			HttpServletRequest req) {
		News news = dao.fetch(News.class, id);
		int hitnum = news.getHitnum() + 1;
		news.setHitnum(hitnum);
		dao.update(news);
		req.setAttribute("news", news);
	}

	@At
	@Ok("raw")
	@Filters()
	// 分页查询指定新闻或所有新闻
	public String listNews(@Param("page") int curPage,
			@Param("rows") int pageSize, @Param("s_name") String s_name,
			HttpSession session) {
		Criteria cri = Cnd.cri();
		if (!Strings.isBlank(s_name)) {
			cri.where().andLike("title", s_name);
		} else
			cri.where().andEquals("1", 1);
		cri.getOrderBy().desc("id");
		return listPageJson(dao, News.class, curPage, pageSize, cri);
	}

}
