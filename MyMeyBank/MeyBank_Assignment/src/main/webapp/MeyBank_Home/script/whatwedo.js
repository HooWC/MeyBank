(function ($) {
	
	"use strict";

	$('.schedule-filter li').on('click', function() {
        var tsfilter = $(this).data('tsfilter');
        $('.schedule-filter li').removeClass('active');
        $(this).addClass('active');

        if (tsfilter == 'all') {
            $('.schedule-table').removeClass('filtering');
            $('.ts-item').removeClass('show');
        } else {
            $('.schedule-table').addClass('filtering');
        }

		var index = $(this).index();
		console.log(index)
		$('.tr-item').eq(index).show().siblings().hide();

        $('.ts-item').each(function() {
            $(this).removeClass('show');
            if ($(this).data('tsmeta') == tsfilter) {
                $(this).addClass('show');
            }
        });
    });

})(window.jQuery);