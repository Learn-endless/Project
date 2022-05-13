$(document).ready(function(){
    var studentId = localStorage.getItem("studentId");
    if(studentId == 0){
        return;
    }
    $.ajax({
        url:"http://localhost:8080/StudentManage/subjectList",
        data:"",
        type:"post",
        async:false,
        success:function(msg){
            var obj = JSON.parse(msg);
            if(obj.flag == "success"){
                var optionStr = "";
                for(var i=0;i<obj.data.length;i++){
                    optionStr+="<option value='"+obj.data[i].subject_id+"'>"+obj.data[i].subject_name+"</option>";
                }
                $(".subjectId").append(optionStr);
            }
        }
    });
    $.ajax({
        url:"http://localhost:8080/StudentManage/toStudentModify",
        data:"id="+studentId,
        type:"post",
        success:function(msg){
            var obj = JSON.parse(msg);
            if(obj.flag == "success"){
                $(".name").val(obj.data.student_name);
                $(".gender").val(obj.data.student_gender);
                $(".subjectId").val(obj.data.student_subject);
            }
        }
    });
    $(".submit").click(function(){
        var name = $(".name").val();
        var gender = $(".gender").val();
        var subjectId = $(".subjectId").val();
        var param = "id="+studentId+"&name="+name+"&gender="+gender+"&subjectId="+subjectId;
        $.ajax({
            url:"http://localhost:8080/StudentManage/studentUpdate",
            data:param,
            type:"post",
            success:function(msg){
                var obj = JSON.parse(msg);
                if(obj.flag == "success"){
                    location.href="studentList.html";
                }
            }
        });
    })
})