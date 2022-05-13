$(document).ready(function(){
    var subjectId = localStorage.getItem("subjectId");
    if(subjectId == 0){
        return;
    }
    
    $.ajax({
        url:"http://localhost:8080/StudentManage/toModifySubject",
        data:"id="+subjectId,
        type:"post",
        success:function(msg){
            var obj = JSON.parse(msg);
            if(obj.flag == "success"){
                $(".name").val(obj.data.subject_name);
                $(".credit").val(obj.data.subject_credit);
            }
        }
    });
    $(".submit").click(function(){
        var name = $(".name").val();
        var credit = $(".credit").val();
        var param = "id="+subjectId+"&name="+name+"&credit="+credit;
        $.ajax({
            url:"http://localhost:8080/StudentManage/subjectUpdate",
            data:param,
            type:"post",
            success:function(msg){
                var obj = JSON.parse(msg);
                if(obj.flag == "success"){
                    location.href="subjectList.html";
                }
            }
        });
    })
})