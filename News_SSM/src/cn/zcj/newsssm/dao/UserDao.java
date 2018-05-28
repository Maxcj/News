package cn.zcj.newsssm.dao;

import org.apache.ibatis.annotations.Param;

import cn.zcj.newsssm.entity.User;

public interface UserDao {
	public int add(User user);
	
	public Long countofUser();
	
	public User get2(@Param("s1") String s1,@Param("s2") String s2) ;

}
