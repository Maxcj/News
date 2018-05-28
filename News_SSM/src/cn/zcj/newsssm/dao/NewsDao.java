package cn.zcj.newsssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zcj.newsssm.entity.News;

public interface NewsDao {
	public int add(News news) throws Exception;

	public void delete(int id) throws Exception;

	public int update(News news) throws Exception;

	public News get1(@Param("id") int id) throws Exception;

	public List<News> list3(@Param("offset") int page,@Param("rows") int rows) throws Exception;
	
	public List<News> list4(@Param("s1") String s1,@Param("offset") int offset, @Param("rows") int rows) throws Exception;
	
	public Long countofNews() throws Exception;

}
