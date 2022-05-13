$(document).ready(function(){
    var subjectId = localStorage.getItem("subjectId");
    if(subjectId == 0){
        return;
    }
    
    $.ajax({
        url:"http://localhost:8080/StudentManage/getSubjectInfo",
        data:"id="+subjectId,
        type:"post",
        success:function(msg){
            var obj = JSON.parse(msg);
            if(obj.flag == "success"){
                $(".name").val(obj.data.name);
                $(".credit").val(obj.data.credit);
            }
        }
    });
    $(".submit").click(function(){
        var name = $(".name").val();
        var credit = $(".credit").val();
        var param = "id="+subjectId+"&name="+name+"&credit="+credit;
        $.ajax({
            url:"http://localhost:8080/StudentManage/updateSubject",
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