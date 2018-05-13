var $tbody = $("#show");
var start = 0;
var end = 7;
//加载后执行
$(function(){
	 $(".confirm").click(confirm);
	 $(".clear").click(clear);
});

//执行查询
function confirm(){
	var queryData = $("#adviceQueryForm").serialize();
	$.ajax({
		url:'adviceQuery.do',
		type:'post',
		data:queryData,
		dataType: 'JSON',
		success:function(result){
			if(result.state==0){
				var lists = result.data;
				$tbody.empty();
				//分页
				$('.pagination').pagination(lists.length,{
					 callback: function(page){
						 start = page * this.items_per_page;
						 end = (page+1)*this.items_per_page;
						 $tbody.empty();
						 showList(lists,start,end);
						 return true;
					}, 
					display_msg: true,	//是否显示记录信息
					setPageNo: true  //是否显示跳转第几页
				});
				showList(lists,start,end);
			}	 		 
		}
	});
}
//显示查询结果
function showList(lists,start,end){
	if(lists.length>0){
		for(var i=start;i<end;i++){
			var patient = lists[i];
			// var ctime = patient.createTime;
			// var newDate = new Date();
			// newDate.setTime(ctime);
			var trStyle;

			if((i+1)%2==0){
				trStyle = "<tr style='background-color:#eff6fa'>";
			}else{
				trStyle = "<tr>";
			}
			var $tr = trStyle+
					"<td class='num'>"+(i+1)+"</td>"+
					"<td class='node'>"+patient.patientId+"</td>"+
					"<td class='num'>"+patient.bedNo+"</td>"+
					"<td class='num'>"+patient.patientName+"</td>"+
					"<td class='name'>"+patient.adviceName+"</td>"+
					"<td class='name'>"+patient.frequency+"</td>"+
					"<td class='name'>"+patient.hospitalStays+"</td>"+
					"<td class='name'>"+patient.result+"</td>"+
					"<td class='name'>"+patient.spec+"</td>"+
					"<td class='name'>"+patient.dosage+"</td>"+
					"<td class='name'>"+patient.giveType+"</td>"+
					"<td class='time'>"+patient.createTime+"</td>"+
					// "<td class='name'>"+patient.userName+"</td>"+
					"</tr>";
			$tbody.append($tr);
			}
	}
}

//清空条件按钮
function clear(){
	$("#adviceQueryForm :input").val("");
}