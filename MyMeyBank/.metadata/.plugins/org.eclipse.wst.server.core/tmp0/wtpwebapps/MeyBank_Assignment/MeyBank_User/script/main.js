(function ($) {

	$(".select-btn").on('click', function() {
        let bool = $(this).parents('.select-menu').hasClass('active');

        $(".select-btn").parents('.select-menu').removeClass('active');

        if(bool){
            $(this).parents('.select-menu').removeClass('active');
        }else{
            $(this).parents('.select-menu').addClass('active');
        }
    });

})(window.jQuery);