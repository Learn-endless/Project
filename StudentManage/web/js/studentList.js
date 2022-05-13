$(document).ready(function(){
    $.ajax({
        url:"http://localhost:8080/StudentManage/studentList",
        data:"",
        type:"post",
        success:function(msg){
            var obj = JSON.parse(msg);
            if(obj.flag == "success"){
                var trStr = "";
                for(var i=0;i<obj.data.length;i++){
                	var subject = obj.data[i].subject;
                    trStr+="<tr>"+
						"<td>"+obj.data[i].student_id+"</td>"+
						"<td>"+obj.data[i].student_name+"</td>"+
						"<td>"+obj.data[i].student_gender+"</td>"+
                        "<td>"+obj.data[i].subject_name+"</td>"+
						"<td><input type='button' value='修改' onClick='updateStudent("+obj.data[i].student_id+")'/>&nbsp;&nbsp;&nbsp;<input type='button' value='删除' onClick='deleteStudent("+obj.data[i].student_id+")'/></td>"+
					"</tr>";
                }
                $("table").append(trStr);
            }
        }
    });

    $(".toStudentAdd").click(function(){
        localStorage.setItem("studentId",0);
        location.href="studentAdd.html";
    });
    
})

function updateStudent(id){
    localStorage.setItem("studentId",id);
    location.href="studentModify.html";
}

function deleteStudent(id){
    $.ajax({
        url:"http://localhost:8080/StudentManage/studentDelete",
        data:"id="+id,
        type:"post",
        success:function(msg){
            var obj = JSON.parse(msg);
            if(obj.flag == "success"){
                location.href="studentList.html";
            }
        }
    });
}