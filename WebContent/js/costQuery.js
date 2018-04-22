var $tbody = $("#show");
var start = 0;
var end = 7;
$(function(){
	$(".confirm").click(query);
	$(".clear").click(clear);
});

//重置
function clear(){
	$("#costQueryForm:input").val("");
}

//查询
function query(){
	//提交form表单
	var findData = $("#costQueryForm").serialize();
	$.ajax({
		url:"cost/costQuery.do",
		type:"post",
		data:findData,
		dataType:"JSON",
		async:false,
		success:function(result){
			if(result.state==0){
				var list = result.data;
				$tbody.empty();
				//分页
				$('.pagination').pagination(list.length,{
					 callback: function(page){
						 start = page * this.items_per_page;
						 end = (page+1)*this.items_per_page;
						 $tbody.empty();
						 showList(list,start,end);
						 return true;
					}, 
					display_msg: true,	//是否显示记录信息
					setPageNo: true   //是否显示跳转第几页
				});
				showList(list,start,end);
			}	 
		}
	});
}

function showList(lists,start,end){
	if(lists.length>0){
		for(var i=start;i<end;i++){
			var cost = lists[i];
			var ctime = cost.costTime;
			var newDate = new Date();
			newDate.setTime(ctime);
			var trStyle;
			if((i+1)%2==0){
				trStyle = "<tr style='background-color:#eff6fa'>";
			}else{
				trStyle = "<tr>";
			}
			var $tr = trStyle+
					"<td class='num'>"+(i+1)+"</a></td>"+
					"<td class='name'>"+cost.id+"</td>"+
					"<td class='name'>"+cost.patientId+"</td>"+
					"<td class='name'>"+cost.patientName+"</td>"+
					"<td class='node'>"+cost.account+"</td>"+
					"<td class='node'>"+cost.type+"</td>"+
					"<td class='time'>"+newDate.toLocaleString()+"</td>"+
					"<td class='node'>"+cost.userId+"</td>"+
					"<td class='node'>"+cost.userName+"</td>"+
					"</tr>";
			$tbody.append($tr);
		}
	}
}

