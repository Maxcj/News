<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="eng" lang="eng">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>404页面</title>
<link rel="stylesheet" media="screen" href="../include/css/404style.css" type="text/css" />
<link rel="shortcut icon" href="../include/img/favico.png"/> 
</head>
<body>
	<div class="controller">
		<div class="objects">
			<div class="text-area rotate">
				<p class="error">Error 404</p>
				<p class="details">
					There was a problem<br />
					<br />The page you are looking for is not here or moved.
				</p>
			</div>

			<div class="homepage rotate">
				<a href="<%=basePath%>">Back to homepage</a>
			</div>
		</div>

	</div>
	<script type="text/javascript">
		setTimeout(reDo, 10000);
		function reDo() {
			top.location.href = "<%=basePath%>";
		}
	</script>

</body>
</html>