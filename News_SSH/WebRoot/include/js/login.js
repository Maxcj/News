	var base = "./" ;
	 $(document).ready(function (){
		/* $('#login_form input').keydown(function (e) {
			if (e.keyCode == 13){	//enter 键值13
				 checkUserName();
	 		}
	 	}); */
	 	$("#login_submit").click(checkUserName);
	}) 


	function checkUserName()//登录前，校验用户信息
	{
		var a = $('#uid').val();
		var b = $('#pwd').val();
		if (a == "") {
			/*$.messager.alert('My Title','请输入考号','warning'); */
			alert("请输入考号!");
			
			return;
		}
		var re = /^\d{4}$|^\d{8}$/;
		if (!re.test(a)) {
			alert("考号格式错误(考号格式：4位或8位数字组成)");
			return;
		}
		if (b == "" || b == undefined) {
			alert("请输入登录密码");
			return;
		}
		
		$.ajax({
			url : base + "doLogin",
			//只封装和传输指定的数据
			data : {
				"uid" : a,
				"pwd" : b
			},
			type : "POST",
			success : function(res) {
				if (res.ok) {
					window.location.href = base + res.msg;
				} else {
					alert(res.msg);
				}
				return false;
			},
			error : function(res) {
				alert("系统错误321！");
			}
		});
	}