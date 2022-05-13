$(document).ready(function(){
    $.ajax({
        url:"http://localhost:8080/StudentManage/subjectList",
        data:"",
        type:"post",
        success:function(msg){
            var obj = JSON.parse(msg);
            if(obj.flag == "success"){
                var trStr = "";
                for(var i=0;i<obj.data.length;i++){
                    trStr+="<tr>"+
						"<td>"+obj.data[i].id+"</td>"+
						"<td>"+obj.data[i].name+"</td>"+
						"<td>"+obj.data[i].credit+"</td>"+
						"<td><input type='button' value='修改' onClick='updateSubject("+obj.data[i].id+")'/>&nbsp;&nbsp;&nbsp;<input type='button' value='删除' onClick='deleteSubject("+obj.data[i].id+")'/></td>"+
					"</tr>";
                }
                $("table").append(trStr);
            }
        }
    });

    $(".toSubjectAdd").click(function(){
        localStorage.setItem("subjectId",0);
        location.href="subjectAdd.html";
    });
})

function updateSubject(id){
    localStorage.setItem("subjectId",id);
    location.href="subjectModify.html";
}

function deleteSubject(id){
    $.ajax({
        url:"http://localhost:8080/StudentManage/deleteSubject",
        data:"id="+id,
        type:"post",
        success:function(msg){
            var obj = JSON.parse(msg);
            if(obj.flag == "success"){
                location.href="subjectList.html";
            }
        }
    });
    
}