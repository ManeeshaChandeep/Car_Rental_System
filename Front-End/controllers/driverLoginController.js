let driveURL='http://localhost:8080/carRental/driver/';
let customerURL='http://localhost:8080/carRental/customer/';

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

function loadAllDrivers(){
   $.ajax({
      url: driveURL + 'getall',
      method: 'GET',
      success: function (res) {
         console.log(res.data);
      },
      error: function (error) {
         console.error('Error:', error);
      }
   });
}