$(document).ready(function(){
    $.ajax({
        url:"http://localhost:8080/StudentManage/subjectList",
        data:"",
        type:"post",
        success:function(msg){
            var obj = JSON.parse(msg);
            if(obj.flag == "success"){
                var optionStr = "";
                for(var i=0;i<obj.data.length;i++){
                    optionStr+="<option value='"+obj.data[i].id+"'>"+obj.data[i].name+"</option>";
                }
                $(".subjectId").append(optionStr);
            }
        }
    });
    
    $(".submit").click(function(){
        var name = $(".name").val();
        var gender = $(".gender").val();
        var subjectId = $(".subjectId").val();
        var param = "name="+name+"&gender="+gender+"&subjectId="+subjectId;
        $.ajax({
            url:"http://localhost:8080/StudentManage/addStudent",
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