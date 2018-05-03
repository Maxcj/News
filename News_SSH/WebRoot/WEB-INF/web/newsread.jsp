<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>新闻管理系统——新闻阅读</title>
<script>var base="<%=basePath%>";</script>

<link rel="stylesheet" type="text/css" href="./include/css/default.min.css" />
<link rel="shortcut icon" href="include/img/favico.png"/> 
</head>



<body>
	<div id="contentDiv">
		<div id="content">
			<div class="rotLeft rotTop pageBack"></div>
			<div class="rotRight rotTop pageBack"></div>
			<div class="container page">
				<div class="pageTitle center ntitle"><s:property value="news.title" /></div>
				<p>
					<span style="text-align:center;color:orange;font-weight:bold;">创建人：<s:property value="news.cruser" />
					<br/>时间：<s:date name="news.date" format="yyyy-MM-dd" />
					<br/>点击量：<s:property value="news.hitnum" />
					</span>
				</p>
				<div style="float:right;line-height:50px;margin-right:10 px;font-size: 9pt;">
					<span> 【 </span><a style="color:blue; font-size: 14px;"
						href="javascript:window.opener=null;window.open('','_self');window.close();">
						<span>关闭窗口 </span></a><span>】</span>
				</div>
				<h1>内容如下：</h1>
				<s:property value="news.content" escape="false" />
				
			</div>
			<div class="rotLeft rotBottom pageBack"></div>
			<div class="rotRight rotBottom pageBack"></div>
		</div>
	</div>

</body>
</html>