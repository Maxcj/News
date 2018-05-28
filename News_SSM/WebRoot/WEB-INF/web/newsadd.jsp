<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<title>新闻管理系统——新闻添加</title>
<script>var base="<%=basePath%>";</script>
<meta name="content-type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="<%=basePath%>include/css/easyui.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>include/css/icon.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>include/css/demo.css"/>
<script type="text/javascript" src="<%=basePath%>include/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>include/js/jquery.easyui.min.js"></script>

<script type="text/javascript" src="<%=basePath%>include/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=basePath%>include/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" src="<%=basePath%>include/ueditor/lang/zh-cn/zh-cn.js"></script>


</head>

<body>
	<div class="easyui-panel" title="新闻添加" style="width:90%;">
		<div style="padding:10px 60px 20px 60px;">
			<!--   <form> -->
			<table cellpadding="5" style="width:90%">
				<tr>
					<td>标题:</td>
					<td><input class="easyui-textbox" id="title" type="text"
						data-options="required:true" style="width:90%"></input></td>
				</tr>
				<tr>
					<td>发布人:</td>
					<td><input class="easyui-textbox" id="cruser" type="text"
						data-options="required:true" style="width:90%"></input></td>
				</tr>
				<tr>
					<td>新闻内容:</td>
					<td><script id="content" type="text/plain"
							style="width:100%;height:500px;"></script> <!-- <input class="easyui-textbox" id="content" 
	    				type="text" data-options="required:true" 
	    				style="width:90%"></input> --></td>
				</tr>


			</table>
			<!--  </form> -->

			<div style="text-align:center;padding:5px">
				<a id="newssave" style="width:120px;" class="easyui-linkbutton">保存</a>
			</div>


		</div>
	</div>

<script type="text/javascript">
	//实例化编辑器
	//建议使用工厂方法getEditor创建和引用编辑器实例， 如果在某个闭包下引用该编辑器， 直接调用UE.getEditor('editor')就能拿到相关的实例
	var ue;
	$(function() {
		ue = UE.getEditor('content');
		$("#newssave").click(function(){
			var title = $("#title").textbox("getValue");
			var cruser = $("#cruser").textbox("getValue");
			var content = ue.getContent();

			if (title == "") {
				parent.$.messager.alert("系统提示", "请输入新闻标题", "warning");
				return;
			}
            if(cruser == ""){
				parent.$.messager.alert("系统提示","必须填写新闻发布人或者发布机构名称","warning");
				return;
			}
            if(content == ""){
				parent.$.messager.alert("系统提示","必须填写新闻内容","warning");
				return;
			} 
			$.ajax({
				url : "<%=basePath%>news/saveAdd",
				//只封装和传输指定的数据
				data : {
					"title" : title,
					"cruser" : cruser,
					"content" : content
				},
				type : "POST",
				success : function(res) {
					if (res.ok) {
						parent.$.messager.alert("系统提示", "添加成功", "info");
					} else {
						parent.$.messager.alert("系统提示", res, "warning");
					}
					return false;
				},
				error : function(res) {
					parent.$.messager.alert("系统提示", "系统错误！", "error");
				}
			});
		});
	});
</script>



</body>
</html>

