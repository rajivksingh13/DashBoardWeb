var ncJSONData = new Object();

function refreshPage() {
	location.reload();
}

$(document).ready(function() {

	$.getJSON("getMessage", function(data) {
		//console.log(data);
		ncJSONData = data;
		var count = ncJSONData.length;
		var intervalTime=8000;
		var refreshTime= count*intervalTime;
		var site = 0;
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
	
	$('#addURL').click(function () { 
		$('#show_p').removeClass('noMessage');
		$('#show_p').addClass('showMessage');
	});
	
	$('#show_resource').click(function () { 
		  $('#showMessage').removeClass('noMessage');
		  $('#showMessage').addClass('showMessage');
		//Test Code Starts Here
		  $.each(ncJSONData, function(i, item) {
			  var tr = '<tr>';
			    tr += '<td>' + item.id + '</td>';
			    tr += '<td id="showID" class="showID">' + item.resourceURL + '</td>';
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
			    //var messageUrl=$(this).parents('tr').find("td[id='showID']").text();
			    //alert(messageUrl);
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