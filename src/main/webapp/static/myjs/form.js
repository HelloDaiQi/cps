var passwordObj;
var confirmObj;

window.onload = function() {	// 页面加载之后, 获取页面中的对象
    passwordObj = document.getElementById("password");
    confirmObj = document.getElementById("repassword");
};

$(function(){
    $("#repassword").focus(function () {
        //alert("aaa");
    });
    //失去焦点
    $("#repassword").blur(function(){
        confirm();
    });
});

function confirm() {
    var passwordValue = passwordObj.value;
    var confirmValue = confirmObj.value;

    if (passwordValue != confirmValue){
        setTimeout('repassword.focus()',1);//终于被我给实现了，找了半天，还是这句话好使(大概意思就是要延迟一会再去执行)
        //$("#repassword").focus();
        //$("#repassword").select();
        $("#submit").attr("disabled",true);
    }else {
        $("#submit").attr("disabled",false);
    }
}