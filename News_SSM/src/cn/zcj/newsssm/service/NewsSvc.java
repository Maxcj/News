package cn.zcj.newsssm.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Service;

import cn.zcj.newsssm.dao.NewsDao;
import cn.zcj.newsssm.entity.News;

@Service
public class NewsSvc {

	@Resource
	private NewsDao dao;

	public void addNews(News news) throws Exception {
		dao.add(news);
	}

	
	public void deleteNews(int id) throws Exception {
		dao.delete(id);
	}

	public void updateNews(News news) throws Exception {
		dao.update(news);
	}

	public List<News> listDgNews(String title, int page, int rows)
			throws Exception {
		if (page < 1) {
			page = 1;
		}
		if (rows < 1) {
			rows = 10;
		}
		page = (page - 1) * rows;
		if (title == null || "".equals(title))
			return dao.list3(page, rows);
		else
			return dao.list4(title, page, rows);
	}

	public News getNews(int id) throws Exception {
		News news = dao.get1(id);
		news.setHitnum(news.getHitnum() + 1);
		dao.update(news);
		return news;
	}

	public int getNewsCount() throws Exception {
		Long a = dao.countofNews();
		return Integer.parseInt(a.toString());
	}

}
