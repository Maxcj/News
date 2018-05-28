var pageN = 1, pageTotal = 100;

$(function() {
	$.ajax({
		url:"./news/getCount",
		type : "post",
		success : function(res) {
			pageTotal = parseInt(res);
			listNews(1, 100);
			//loadPager();
		},
		error : function(res) {
			$.messager.alert("系统提示", "系统错误 ", "error");
		}
	});

});

function listNews(pageNumber, pageSize) {
			$.ajax({
				url : "./news/listNews",
				data : {
					"page" : pageNumber,
					"rows" : pageSize
				},
				type : "post",
				success : function(res) {
					$(".inews").remove();
					//res = JSON.parse(res);
					if (res.total <= 0) {
						var article = "<article class='trpp post post-list'>";
						article+="";
						var tr = "<tr class='inews' height=\"25\"><td >";
						tr += "<div class='t'>暂无相关新闻</div>";
						tr += "</td><td width='1%' nowrap=''><span >&nbsp;</span></td></tr>";
						$("#trpp").before(tr);
					} else {
						pageN = pageNumber;
						pageTotal = res.total;
						var rows = res.rows;
						for (var i = 0; i < rows.length;) {
							var row = rows[i];
							var tr = "<tr class='inews' height=\"25\"><td >";
							tr += "<div class='t'><a href='./news/getNews?id="
									+ row.id + "' target='_blank'>"
									+ cutstr(row.title, 29) + "</a></div>";
							tr += "</td><td width='1%' nowrap=''><span >"
									+ row.date.substr(0, 10)
									+ "&nbsp;</s pan></td></tr>";
							$("#trpp").before(tr);
							i++;
							if (i % 5 == 0) {
								tr = "<tr class='inews' height='1'><td colspan='2' align='center'>";
								tr += "<hr style='border-style:dashed;border-color:#999999;width :99%;" +
										"height:1px;border-width:1px 0px 0px 0px;" +
										"visibility:inherit'></td></tr>";
								$("#trpp").before(tr);
							}
						}
					}
				},
				error : function(res) {
					parent.dlg_ok(300, 140, "系统提示", "系统错误 ", null, "error");
				}
			})
			
			
}