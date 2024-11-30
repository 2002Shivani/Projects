$(document).ready(function() {
    $('#plot_button').click(function() {
      var dropdown1Value = $("#top_data").val();
      var dropdown2Value = $("#bottom_data").val();
      var dropdown3Value = $("#chart_menu").val();
      var dropdown4Value = $("#xaxis").val();
      var dropdown5Value = $("#yaxis").val();
      var dropdown6Value = $("#operation_menu").val();
      var dropdown7Value = $("#colorc").val();
      var dropdown8Value = $('input[name=hv]:checked').val();
      var dropdown9Value = $('input[name=ad]:checked').val();
      var dropdown10Value = $('#chart_title').val();
         
      $.ajax({
        url: "/data",
        type: "GET",
        contentType: 'application/json;charset=UTF-8',
        data:({
          'selected_top': dropdown1Value,
          'selected_bottom': dropdown2Value,
          'selected_type': dropdown3Value,
          'selected_x': dropdown4Value,
          'selected_y': dropdown5Value,
          'selected_op': dropdown6Value,
          'selected_color' : dropdown7Value,
          'selected_hv':dropdown8Value,
          'selected_ad':dropdown9Value,
          'selected_title':dropdown10Value
         
        }),
        dataType:"json",
        success: function(data) {
          Plotly.newPlot('chart', data );
          console.log(data)
          alert("Data Submitteed")
        }
      });

  
    });
  });


