$(document).ready(function() {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "http://localhost:8085/api/users",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
          $('#feedback').html(json);
          var json1=JSON.stringify(data, null, 4);
        

            console.log("SUCCESS : ", data);
           const mytable=document.querySelector("#mytable > tbody");
            console.log(mytable);
            data.forEach((row) =>{
			const tr=document.createElement("tr");
				Object.keys(row).forEach(key => {
  				
  				const td=document.createElement("td");
  				console.log(key);
  				td.textContent=row[key];
  				tr.appendChild(td);
			});
			mytable.appendChild(tr);
			});
			
        },
        
        error: function (e) {

            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
         $('#feedback').html(json);

            console.log("ERROR : ", e);
         

        }
    });
});