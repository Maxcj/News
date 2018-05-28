<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>新闻管理系统——新闻阅读</title>
<script>var base="<%=basePath%>";</script>

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>include/css/default.min.css" />
<link rel="shortcut icon" href="<%=basePath%>include/img/favico.png" />

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>include/css/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>include/css/icon.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>include/css/demo.css" />
<script type="text/javascript"
	src="<%=basePath%>include/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>include/js/jquery.easyui.min.js"></script>

<script type="text/javascript"
	src="<%=basePath%>include/ueditor/ueditor.config.js"></script>
<script type="text/javascript"
	src="<%=basePath%>include/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>include/ueditor/lang/zh-cn/zh-cn.js"></script>

<%-- <script type="text/javascript"
	src="<%=basePath%>include/js/comment.js"></script> --%>
</head>



<body>



	<div id="contentDiv">
		<div id="content">
			<div class="rotLeft rotTop pageBack"></div>
			<div class="rotRight rotTop pageBack"></div>
			<div class="container page">
				<div class="pageTitle center ntitle">${news.title}</div>
				<p>
					<span style="text-align:center;color:orange;font-weight:bold;">创建人：${news.cruser}
						<br />时间：<fmt:formatDate value="${news.date}"
							pattern="yyyy-MM-dd" /> <br />点击量：${news.hitnum}
					</span>
				</p>
				<div
					style="float:right;line-height:50px;margin-right:10 px;font-size: 9pt;">
					<span> 【 </span><a style="color:blue; font-size: 14px;"
						href="javascript:window.opener=null;window.open('','_self');window.close();">
						<span>关闭窗口 </span>
					</a><span>】</span>
				</div>
				<h1>内容如下：</h1>${news.content}

				<div>
					<h1>评论如下：</h1>
					
					
	</div>
	<div class="nlist">
		<table id="newstable" width="100%">
			<tbody>
				<tr id="trpp">
					<td colspan="3" align="left"></td>
				</tr>
			</tbody>
		</table>
		<div class="panel">
				<div id="pp" style="background:#efefef;"></div>
			</div>
			<div>-------------------------------</div>
		
	</div>






					<div class="panel" id="replyAdd">
						<div class="header"></div>
						<div class="inner reply">
							<form id="addreply_form">
								<table>
								<tr>
					
					<td><span>昵称:</span><input class="easyui-textbox" id="username" type="text"
						data-options="required:true" style="width:100%"></input></td>
				</tr>
								
								<tr>
									<td><script id="ccontent" type="text/plain"
											style="width:100%;height:200px;"></script></td>
								</tr>
								</table>
							</form>

							<button id="commentsave" class="easyui-linkbutton"
								style="padding:5px">添加评论</button>
						</div>
					</div>
				</div>

			</div>

			<div class="rotLeft rotBottom pageBack"></div>
			<div class="rotRight rotBottom pageBack"></div>
		</div>
	</div>


	<script>
	var pageN = 1, pageTotal = 100;

$(function() {
	$.ajax({
		url:"<%=basePath%>comment/getCommentCount",
		data:{"id":${news.id}},
		type : "post",
		success : function(res) {
			pageTotal = res.commentcount;
			listComments();
			
			//alert(pageTotal);
			loadPager();
		},
		error : function(res) {
			alert(res);
			$.messager.alert("系统提示", "加载系统错误12", "error");
		}
	});

});


function listComments(){
	$.ajax({
	url:"<%=basePath%>comment/listComments",
	data:{			"id":${news.id}},
					type : "post",
					success : function(res) {
						$(".inews").remove();
						if (res.total <= 0) {
							var tr = "<tr class='inews' height=\"25\"><td >";
							tr += "<div class='t'>暂无相关评论</div>";
							tr += "</td><td width='1%' nowrap=''><span >&nbsp;</span></td></tr>";
							$("#trpp").before(tr);
						} else {
							pageTotal = res.total;
							var rows = res.rows;
							for (var i = 0; i < rows.length;) {
								if (i % 1 == 0) {
										tr = "<tr class='inews' height='1'><td colspan='2' align='center'>";
										tr += "<hr class='inews' style='border-style:dashed;border-color:#999999;width:99%;height:1px;border-width:1px 0px 0px0px;visibility:inherit'></td></tr>";
										$("#trpp").before(tr);
									}
									var row = rows[i];
									var tr = "<tr class='inews' height=\"25\"><td >";
									 tr += "<div class='t'>"
											+ row.username + "</div>"; 
									tr += "</td><td class='inews' width='1%' nowrap=''><span >"
											+ row.cdate
											+ "&nbsp;</span></td></tr>";
									tr += "</td><td class='inews' width='1%' nowrap=''><span >"
											+ row.ccontent
											+ "&nbsp;</span></td></tr>";
									$("#trpp").before(tr);
									i++;
							}
						}
					},
					error : function(res) {
						parent.dlg_ok(300, 140, "系统提示", "系统错误3", null, "error");
					}
				})
	}




	
	
	
	
	
	
	var ue;
	$(function() {
		ue = UE.getEditor('ccontent');
		$("#commentsave").click(function(){
			var username = $("#username").val();
			var ccontent = ue.getContent();
			if($("#username").val().length<=1){
				parent.$.messager.alert("系统提示","昵称不能为空，请重新填写！","warning");
				return;
			}

            if(ccontent == ""){
				parent.$.messager.alert("系统提示","评论内容不符合规则，请重新填写！","warning");
				return;
			}
          
			$.ajax({
				url : "<%=basePath%>comment/saveAddComment",
											//只封装和传输指定的数据
											data : {
												"id" : ${news.id},
												"username" : username,
												"ccontent" : ccontent
											},
											type : "POST",
											success : function(res) {
												if (res.ok) {
													parent.$.messager.alert(
															"系统提示", "评论成功,请重新加载页面",
															"info");
												} else {
													parent.$.messager.alert(
															"评论添加系统提示", res,
															"warning");
												}
												return false;
											},
											error : function(res) {
												parent.$.messager.alert("系统提示",
														"评论添加系统错误！", "error");
											}
										});
							});
		});
		
		


function loadPager(){
	$('#pp').pagination({
	    total:pageTotal,
	    pageSize:10,
	    pageNumber:pageN,
	    
	    displayMsg:'{from}/{to} 共{total}条评论',
	    onSelectPage:function(pageNumber, pageSize){
	    	listAssess(pageNumber,pageSize);
	    }
	});
} 
	</script>


</body>
</html>