

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

$(document).ready(function() {

   // inspired by http://jsfiddle.net/arunpjohny/564Lxosz/1/
   $('.table-responsive-stack').each(function (i) {
      var id = $(this).attr('id');
      //alert(id);
      $(this).find("th").each(function(i) {
         $('#'+id + ' td:nth-child(' + (i + 1) + ')').prepend('<span class="table-responsive-stack-thead">'+             $(this).text() + ':</span> ');
         $('.table-responsive-stack-thead').hide();
         
      });
      

      
   });

   
   
   
   

   
   
   
   
function flexTable(){
   if ($(window).width() < 768) {
      
   $(".table-responsive-stack").each(function (i) {
      $(this).find(".table-responsive-stack-thead").show();
      $(this).find('thead').hide();
   });
      
    
   // window is less than 768px   
   } else {
      
      
   $(".table-responsive-stack").each(function (i) {
      $(this).find(".table-responsive-stack-thead").hide();
      $(this).find('thead').show();
   });
      
      

   }
// flextable   
}      
 
flexTable();
   
window.onresize = function(event) {
    flexTable();
};
   
   
   
   

  
// document ready  
});





/**
 * ---------------------------------------
 * This demo was created using amCharts 4.
 *
 * For more information visit:
 * https://www.amcharts.com/
 *
 * Documentation is available at:
 * https://www.amcharts.com/docs/v4/
 * ---------------------------------------
 */

am4core.useTheme(am4themes_animated);

var chart = am4core.create("chartdiv", am4charts.XYChart);
chart.hiddenState.properties.opacity = 0; // this makes initial fade in effect

// using math in the data instead of final values just to illustrate the idea of Waterfall chart
// a separate data field for step series is added because we don't need last step (notice, the last data item doesn't have stepValue)
chart.data = [ {
  category: "Net revenue",
  value: 8786,
  open: 0,
  stepValue: 8786,
  color: chart.colors.getIndex( 13 ),
  displayValue: 8786
}, {
  category: "Cost of sales",
  value: 8786 - 2786,
  open: 8786,
  stepValue: 8786 - 2786,
  color: chart.colors.getIndex( 8 ),
  displayValue: 2786
}, {
  category: "Operating expenses",
  value: 8786 - 2786 - 1786,
  open: 8786 - 2786,
  stepValue: 8786 - 2786 - 1786,
  color: chart.colors.getIndex( 9 ),
  displayValue: 1786
}, {
  category: "Amortisation",
  value: 8786 - 2786 - 1786 - 453,
  open: 8786 - 2786 - 1786,
  stepValue: 8786 - 2786 - 1786 - 453,
  color: chart.colors.getIndex( 10 ),
  displayValue: 453
}, {
  category: "Income from equity",
  value: 8786 - 2786 - 1786 - 453 + 1465,
  open: 8786 - 2786 - 1786 - 453,
  stepValue: 8786 - 2786 - 1786 - 453 + 1465,
  color: chart.colors.getIndex( 16 ),
  displayValue: 1465
}, {
  category: "Operating income",
  value: 8786 - 2786 - 1786 - 453 + 1465,
  open: 0,
  color: chart.colors.getIndex( 17 ),
  displayValue: 8786 - 2786 - 1786 - 453 + 1465
} ];

var categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
categoryAxis.dataFields.category = "category";

var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());

var columnSeries = chart.series.push(new am4charts.ColumnSeries());
columnSeries.dataFields.categoryX = "category";
columnSeries.dataFields.valueY = "value";
columnSeries.dataFields.openValueY = "open";
columnSeries.fillOpacity = 0.8;
columnSeries.sequencedInterpolation = true;
columnSeries.interpolationDuration = 1500;

var columnTemplate = columnSeries.columns.template;
columnTemplate.strokeOpacity = 0;
columnTemplate.propertyFields.fill = "color";

var label = columnTemplate.createChild(am4core.Label);
label.text = "{displayValue.formatNumber('$#,## a')}";
label.align = "center";
label.valign = "middle";


var stepSeries = chart.series.push(new am4charts.StepLineSeries());
stepSeries.dataFields.categoryX = "category";
stepSeries.dataFields.valueY = "stepValue";
stepSeries.noRisers = true;
stepSeries.stroke = am4core.color("#000");
stepSeries.strokeDasharray = "3,3";
stepSeries.interpolationDuration = 2000;
stepSeries.sequencedInterpolation = true;

// because column width is 80%, we modify start/end locations so that step would start with column and end with next column
stepSeries.startLocation = 0.1;
stepSeries.endLocation = 1.1;

chart.cursor = new am4charts.XYCursor();
chart.cursor.behavior = "none";