let driveURL='http://localhost:8081/carRental/driver/';


function getDriverOB(){
    let driver={

       nicnumber:$('#txtNICNumber').val(),
       licensecardnumber:$('#txtLicenseCardNumber').val(),
       yourname:$('#txtYourName').val(),
       address:$('#txtAddress').val(),
       availability:$('#txtAvailability').val(),
       phonenumber:$('#txtPhoneNumber').val(),
       email:$('#txtEmail').val(),
       username:$('#txtUserName').val(),
       password:$('#txtPassword').val(),


    }

    return driver;


}

$('#btnSaveDriver').click(function () {

   let driverJSON = JSON.stringify(getDriverOB());
   console.log(driverJSON);

   $.ajax({
      url: driveURL + 'save',
      method: 'POST',
      data: driverJSON,
      contentType: 'application/json',
      success: function (res) {
         console.log(res.state);
      },
      error: function (error) {
         console.error('Error:', error);
      }
   });
});


$('#btnUpdateDriver').click(function () {

   let driverJSON = JSON.stringify(getDriverOB());
   console.log(driverJSON);

   $.ajax({
      url: driveURL + 'update',
      method: 'PUT',
      data: driverJSON,
      contentType: 'application/json',
      success: function (res) {
         console.log(res.state);
      },
      error: function (error) {
         console.error('Error:', error);
      }
   });
});
loadAllDrivers();
function loadAllDrivers(){
   $.ajax({
      url: driveURL + 'getall',
      method: 'GET',
      success: function (res) {
         console.log(res.data);
         $('#driverDetails').empty();
         for (let i = 0; i < res.data.length; i++) {
            loadTable(res.data[i]);
         }
      },
      error: function (error) {
         console.error('Error:', error);
      }
   });
}

function loadTable(driver) {
   let tr=`<tr driver='${JSON.stringify(driver)}'>
                                    <td>${driver.nicnumber}</td>
                                    <td>${driver.yourname}</td>
                                    <td>${driver.email}</td>
                                    <td>${driver.address}</td>
                                </tr>`;

   $('#driverDetails').append(tr);
}

$('#driverDetails').dblclick(function (event){

   let driver = event.target.closest("tr").attr('driver');

   console.log(driver);

});
