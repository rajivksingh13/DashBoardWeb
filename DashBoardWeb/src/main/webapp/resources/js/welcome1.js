var ncJSONData = new Object();

$(document).ready(function () {
			$.getJSON("/getMessage", function(data) {
				//console.log(data);
				ncJSONData = data;
				var count = ncJSONData.length;	
				
//					$.each(ncJSONData, function (i, item) {
//						//alert(ncJSONData[i].message);
//			           //document.getElementById('ifame1').src = ncJSONData[i].message;
//			           $("#ifame1").attr("src",ncJSONData[i].message)
//			           
//			     });
					
//					$.each(ncJSONData, function(i, item) {
//					    setInterval( function() {
//					    	$("#ifame1").attr("src",item.message);
//					    }, 0);
//					});

				//alert(ncJSONData[0].message)
					site = 0;
					document.getElementById('ifame1').src = ncJSONData[0].message;
					function iFrameLoader() {
						site++;
						if (site >= count.length) {
							site = 0
						}
						;
						document.getElementById('ifame1').src = ncJSONData[site].message;
					}
			
					setInterval(iFrameLoader, 10000);

   });
});
					
			// Set the date we're counting down to
			var countDownDate = new Date("May 6, 2020 15:37:25").getTime();

			// Update the count down every 1 second
			var countdownfunction = setInterval(function() {

				// Get todays date and time
				var now = new Date().getTime();

				// Find the distance between now an the count down date
				var distance = countDownDate - now;

				// Time calculations for days, hours, minutes and seconds
				var days = Math.floor(distance / (1000 * 60 * 60 * 24));
				var hours = Math.floor((distance % (1000 * 60 * 60 * 24))
						/ (1000 * 60 * 60));
				var minutes = Math.floor((distance % (1000 * 60 * 60))
						/ (1000 * 60));
				var seconds = Math.floor((distance % (1000 * 60)) / 1000);

				// Output the result in an element with id="demo"
				document.getElementById("demo").innerHTML = days + "d " + hours
						+ "h " + minutes + "m " + seconds + "s ";

				// If the count down is over, write some text
				if (distance < 0) {
					clearInterval(countdownfunction);
					document.getElementById("demo").innerHTML = "EXPIRED";
				}
			}, 1000);		

//		var sites = [ 'http://localhost:8080/dashboard',
//				'https://www.ndtv.com/', 'https://indianexpress.com/',
//				'https://www.hindustantimes.com/' ];
//		site = 0;
//		document.getElementById('ifame1').src = sites[0];
//		function iFrameLoader() {
//			site++;
//			if (site >= sites.length) {
//				site = 0
//			}
//			;
//			document.getElementById('ifame1').src = sites[site];
//		}
//
//		setInterval(iFrameLoader, 10000);

//alert(sites)

