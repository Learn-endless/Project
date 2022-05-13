$(document).ready(function(){
    $(".submit").click(function(){
        var name = $(".name").val();
        var credit = $(".credit").val();
        var param = "name="+name+"&credit="+credit;
        $.ajax({
            url:"http://localhost:8080/StudentManage/addSubject",
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