<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<title>新闻管理系统——后台</title>
<script>var base="<%=basePath%>";</script>

<meta name="content-type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=basePath%>include/js/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>include/css/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>include/css/easyui.css">

<script type="text/javascript" src="<%=basePath%>include/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath%>include/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>include/js/zcjtab.js"></script>

<!-- 站点图标 -->
<link rel="shortcut icon" href="<%=basePath%>include/img/favico.png"/> 

<script>
	$(function() {
		$("#logout").click(function() {
			top.location.href="<%=basePath%>doLogout";
		})
	})
	
	var opened_node;
	$(function() {
		$("#menutree").tree( {
		     url : "<%=basePath%>menu",
		     animate : true,
		   onClick : function(node) {
		      if (!node.attributes) {
		       if (!opened_node) { 
		       		$("#menutree").tree('expand', node.target);
		       		opened_node = node.target;                
		       } else if (opened_node != node.target) {
					$("#menutree").tree('collapse', opened_node);
					$("#menutree").tree('expand', node.target);                      
					opened_node = node.target;                
				}         
			} else {
				swNewTab(node.text,"<%=basePath%>" +node.attributes.url);
			}     
		},
			onLoadSuccess : function(node, data) {
				$("#menutree").tree('expandAll');
			} });	
	})
	
	
	$(function(){
		swNewTab('新闻管理',"<%=basePath%>goListNews"); 
	});
	
	
</script>





</head>

<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="background:#B3DFDA;padding:0 10px 0 10px;vertical-align: middle;">
		<img src="./include/img/TIL-LINK.png" width="126" height="50" />
		<div style="float:right;line-height:50px;margin-right:10px;">
			<a id="logout" href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-cancel'">退出</a>
		</div>
		<div style="float:right;line-height:50px;margin-right:10px;">登录用户：${me.xm}|</div>
	</div>

	<div data-options="region:'west',split:true,title:'系统菜单'"
		style="width:180px;padding:10px;">
		<ul id="menutree" class="easyui-tree"></ul>
	</div>

	<div data-options="region:'south',border:false"
		style="height:30px;padding:5px;text-align:center;font-family: arial;color: #A0B1BB;">
		© 2018 <a href="http://maxcj.cn" target="_blank">May丶乘剑</a>
	</div>

	<div data-options="region:'center'">
		<div id="tabs" class="easyui-tabs" fit="true" border="false"></div>
	</div>

</body>
</html>

