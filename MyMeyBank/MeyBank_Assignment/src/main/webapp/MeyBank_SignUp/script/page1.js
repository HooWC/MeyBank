$(function(){


	
    var fullname = false;
    var email = false;
    var nric = false;

    $("#fullname").keyup(function(){
        if($(this).val() != ""){
            fullname = true;
        }else{
            fullname = false;
        }
        checkValue(fullname,email,nric);
    })

    $("#email").keyup(function(){
        var value = $(this).val();
        if(value != "" && value.includes("@gmail.com")){
            email = true;
        }else{
            email = false;
        }
        checkValue(fullname,email,nric);
    })

    $("#nric").keyup(function(){
        var value = $(this).val();
        if(value != "" && value.length == 12){
            nric = true;
            
            var x = $(this).val().match(/^(\d{2})(\d{2})(\d{2})-?(\d{2})-?(\d{3})(\d)$/);

			var year = RegExp.$1;
			var mon = RegExp.$2;
			var day = RegExp.$3;
			var gender = RegExp.$6

			var now = new Date().getFullYear().toString();
			var d = now.substr(0, 2);

			if (now.substr(2, 2) > year) {
				year = d + year;

			} else {
				year = "19" + year;
			}

			var g = (gender % 2 == 0) ? "Female" : "Male";
			var b = new Date(year, (mon - 1), day);
			var age = new Date().getFullYear() - b.getFullYear();

			$("#age").val(age);
			var b2 = moment(b).format("YYYY-MM-DD");
			$("#birth").val(b2);
			$("#gender").val(g);

        }else{
            nric = false;
        }
        checkValue(fullname,email,nric);
    })
    
    function checkValue(fullname,email,nric){
    if(fullname == true && email == true && nric == true){
        $("#btn-submit").prop('disabled',false)
    }else{
        $("#btn-submit").prop('disabled',true)
    }
}

})

