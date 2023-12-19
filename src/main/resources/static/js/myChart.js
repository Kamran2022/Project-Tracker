var chartDataStr = decodeHtml(myChartData);
var chartJsonArray = JSON.parse(chartDataStr);

var arrayLength = chartJsonArray.length;

var numericData = [];
var labelData = [];

for(var i = 0; i < arrayLength; i++){
	numericData[i] = chartJsonArray[i].value;
	labelData[i] = chartJsonArray[i].label;
}






// for a pie chart
var ctx = document.getElementById('myPieChart').getContext('2d');
 new Chart(ctx, {
    // The type of chart we want to create
    type: 'pie',

    // The data for our dataset
    data: {
        labels: labelData, 
        datasets: [{
            label: 'Projects',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
		title: {
			display: true,
			text: "Project Status"
		}
	}
});





//"[{"value":1, "label": "COMPLETED"}, {"value": 2, "label": "INPROGRESS"}, {"value": 3, "label": "COMPLETED"}]"
   function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}
















