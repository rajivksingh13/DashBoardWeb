var ncJSONData = new Object();

function refreshPage() {
	location.reload();
}

$(document).ready(function() {

	$.getJSON("/getMessage", function(data) {
		//console.log(data);
		ncJSONData = data;
		var count = ncJSONData.length;
		var intervalTime=8000;
		var refreshTime= count*intervalTime;
		site = 0;
		document.getElementById('ifame1').src = ncJSONData[0].message;
		function iFrameLoader() {
			site++;
			if (site >= count.length) {
				site = 0
			}

			document.getElementById('ifame1').src = ncJSONData[site].message;
		}

		setInterval(iFrameLoader, intervalTime);
		setInterval(refreshPage, refreshTime);
	});
	
		
	
	$('#show_resource').click(function () { 
		  $('#showMessage').removeClass('noMessage');
		  $('#showMessage').addClass('showMessage');
		//Test Code Starts Here
		  $.each(ncJSONData, function(i, item) {
			  var tr = '<tr>';
			    tr += '<td>' + item.id + '</td>';
			    tr += '<td id="showID" class="showID">' + item.message + '</td>';
			    tr += '<td><button id="edit" class="btn btn-primary" data-key="'+ item.id +'"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></button></td>';
			    tr += '<td><button id="delete"class="btn btn-danger" data-key="'+ item.id +'"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></td>';
			    tr += '</tr>';
			  
			    $('tbody').append(tr);
			 
			});
		  $('#show_resource').removeClass('btn btn-primary');
		  $('#show_resource').addClass('noMessage');
		  //Test Code Ends Here
		  // Test2 Code Starts here
		  $('button#delete').click( function() {
			    var cRow = $(this).parents('tr');
			    var cId = $('td:nth-child(2)', cRow).text();
			    var intKey = $(this).data('key');
			    var isConfirmed = confirm("Do You Want to Delete the Resource URL ?"); 
	            if (isConfirmed == true) { 
	            	cRow.fadeOut('slow', function() { 
	  			      doDelete(cId, intKey);
	  			      location.href='deleteMessage/'+intKey;
	  			    }); 
	            } else { 
	            	alert('Cancel was pressed.'); 
	            } 
			    
			  });
			  
			  function doDelete(param1, param2) {
			    alert('Data with\n\nID: [' + param1 + ']\nKey: [' + param2 + ']\n\nRemoved.');
			  }
		  // Test2 Code Ends Here
		 // Test3 Code Starts here
			  $('button#edit').click(function () {
				  var intKey = $(this).data('key');
		          var currentTD = $(this).parents('tr').find("td[id='showID']");
		          var oldMessageUrl=$(this).parents('tr').find("td[id='showID']").text();
		          //alert(oldMessageUrl)
		          if ($(this).html() == '<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>') {                  
		              $.each(currentTD, function () {
		                  $(this).prop('contenteditable', true)
		              });
		          } else {
		             $.each(currentTD, function () {
		                  $(this).prop('contenteditable', false)
		              });
		          }
		          if ($(this).html() == 'Save') {
		        	  var isConfirmed = confirm("Do You Want to Edit the Resource URL ?");
		        	  if (isConfirmed == true) { 
		        	  var messageURL= $(this).parents('tr').find("td[id='showID']").text();
		        	  location.href='editMessage/resource?id='+intKey+'&message='+messageURL; 
		        	  }else{
		        		  alert('Cancel was pressed.');
		        	  }
		          }
		          $(this).html($(this).html() == '<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>' ? 'Save' : '<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>')

		      });
		// Test3 Code Ends here
		 
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
	var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
	var seconds = Math.floor((distance % (1000 * 60)) / 1000);

	// Output the result in an element with id="demo"
	document.getElementById("demo").innerHTML = days + "d " + hours + "h "
			+ minutes + "m " + seconds + "s ";

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

