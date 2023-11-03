let customerURL='http://localhost:8080/carRental/customer/';

function getCustomerOB() {
    let customer={
        id:$('#txtYourId').val(),
        name:$('#txtYourName').val(),
        email:$('#txtEmail').val(),
        phonenumber:$('#txtPhoneNumber').val(),
        username:$('#txtUserName').val(),
        password:$('#txtpassword').val(),
        nicnumber:$('#txtNICNumber').val(),
        address:$('#txtAddress').val(),
        idcardfrontphoto:$('#fileIDFrontPhoto').val(),
        idcardbackphoto:$('#fileIDBackPhoto').val(),
    }
return customer;

}


$('#btnRegisterCustomer').click(function () {

    let customerJSON = JSON.stringify(getCustomerOB());
    console.log(customerJSON);

    $.ajax({
        url: customerURL + 'save',
        method: 'POST',
        data: customerJSON,
        contentType: 'application/json',
        success: function (res) {
            console.log(res.state);
        },
        error: function (error) {
            console.error('Error:', error);
        }
    });
});

$('#-updatecu*stomer').click(function () {

    let customerJSON = JSON.stringify(getCustomerOB());
    console.log(customerJSON);

    $.ajax({
        url: customerURL + 'update',
        method: 'PUT',
        data: customerJSON,
        contentType: 'application/json',
        success: function (res) {
            console.log(res.state);
        },
        error: function (error) {
            console.error('Error:', error);
        }
    });
});


function loadAllCustomers(){
    $.ajax({
        url: customerURL + 'getall',
        method: 'GET',
        success: function (res) {
            console.log(res.data);
        },
        error: function (error) {
            console.error('Error:', error);
        }
    });
}