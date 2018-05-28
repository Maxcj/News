var pageN = 1, pageTotal = 100;

$(function() {
	$.ajax({
		url:"<%=basePath%>comment/getCommentCount",
		data:{"id":${news.id}},
		type : "post",
		success : function(res) {
			pageTotal = res.commentcount;
			listComments();
			//alert(res);
			/*pageTotal = parseInt(res);
			alert(pageTotal);
			listNews(1, 100	);
			loadPager();*/
		},
		error : function(res) {
			alert(res);
			$.messager.alert("系统提示", "加载系统错误12", "error");
		}
	});

});

/*function listComments() {
			$.ajax({
				url : "<%=basePath%>comment/listComments",
				data : {
					"id":${news.id};
				},
				type : "post",
				success : function(res) {
					$(".reply_area").remove();
					res = JSON.parse(res);
					if(res.total<=0){
						var tr='<div class="cell reply_area" ><div class="author_content"><div class="user_info">';
							tr+='<a class="reply_time" href="####"></a><a class="dark reply_author" href="####"></a>';
							tr+='</div></div><div class="reply_content from-wendal"><div class="markdown-text"><p>';
							tr+='暂无相关评论</p></div></div></div>'
			 				$("#pp").before(tr);
					}else {
						pageN=pageNumber;
						pageTotal=res.total;
						var rows=res.rows;
						for(var i=0;i<rows.length;i++){ 
							var row=rows[i];
							var tr='<div class="cell reply_area" ><div class="author_content"><div class="user_info">';
							tr+='<a class="reply_time" href="####">'+row.id+'楼•</a>';
							tr+='<a href="####"><img src="/exam/include/img/Octocat_32.png"></a>';
							tr+='<a class="dark reply_author" href="####">'+row.cruser+'</a>';
							tr+='</div></div><div class="reply_content from-wendal"><div class="markdown-text"><p>';
							tr+=row.content+'</p></div></div></div>'
			 				$("#pp").before(tr);
						}
						loadPager();
					}

				},
				error : function(res) {
					$.messager.alert("系统提示", "加载系统错误34", "error");
				}
			})	
}*/

function listComments(){
	$.ajax({
	url:"<%=basePath%>comment/listComments",
	data:{"id":${news.id}},
					type : "post",
					success : function(res) {
						$(".inews").remove();
						//res=JSON.parse(res);
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
									tr += "<hr style='border-style:dashed;border-color:#999999;width:99%;height:1px;border-width:1px 0px 0px0px;visibility:inherit'></td></tr>";
									$("#trpp").before(tr);
								}
								var row = rows[i];
								var tr = "<tr class='inews' height=\"25\"><td >";
								tr += "<div class='t'>"
										+ cutstr(row.username, 29) + "</div>";
								tr += "</td><td width='1%' nowrap=''><span >"
										+ row.cdate
										+ "&nbsp;</span></td></tr>";
								tr += "</td><td width='1%' nowrap=''><span >"
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



function loadPager(){
	$('#pp').pagination({
	    total:pageTotal,
	    pageSize:20,
	    pageNumber:pageN,
	    layout:['sep','first','prev','links','next','last'],
	    links:5,
	    displayMsg:'{from}/{to} 共{total}条评论',
	    onSelectPage:function(pageNumber, pageSize){
	    	listComments(pageNumber,pageSize);
	    }
	});
}


