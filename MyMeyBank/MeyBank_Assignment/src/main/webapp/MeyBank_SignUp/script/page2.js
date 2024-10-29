$(function(){



    var userid = false;
    var password = false;
    var verifyWord = false;

    $("#userid").keyup(function(){
        if($(this).val() != ""){
            userid = true;
        }else{
            userid = false;
        }
       checkValue(userid,password,verifyWord);
    })

    $("#password").keyup(function(){
        var value = $(this).val();
        if(value != "" && value.length == 6){
            password = true;
        }else{
            password = false;
        }
        checkValue(userid,password,verifyWord);
    })

    $("#verifyWord").keyup(function(){
        var value = $(this).val();
        if(value != "" && value.length == 16){
            verifyWord = true;
        }else{
            verifyWord = false;
        }
        checkValue(userid,password,verifyWord);
    })
    
    function checkValue(userid,password,verifyWord){
    if(userid == true && password == true && verifyWord == true){
        $("#btn-submit").prop('disabled',false)
    }else{
        $("#btn-submit").prop('disabled',true)
    }
}

})

