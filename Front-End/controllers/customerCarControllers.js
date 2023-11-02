let carURL='http://localhost:8080/carRental/car/';
function getCarOB(){
    let car={
        registernumber:$('#txtRegisterNumber').val(),
        brand:$('#txtBrand').val(),
        rates:$('#slctRates').val(),
        frontview:$('#fileFrontView').val(),
        backview:$('#fileBackView').val(),
        freemilage:$('#txtFreeMilage').val(),
        sideview:$('#fileSideView').val(),
        interior:$('#fileinterior').val(),
        numberofpassengers:$('#txtNumberofPassengers').val(),
        type:$('#txtType').val(),
        dailyrate:$('#txtDailyRate').val(),
         mothlyrate:$('#txtMonthlyRate').val(),
        priceofextrakm:$('#txtPriceofExtraKm').val(),
        color:$('#txtColor').val(),
        vehicleavailabilitytype:$('#slctVehicleAvailabilityType').val(),
    }

return car;
}



$('#btnSaveCar').click(function () {

    let carJSON = JSON.stringify(getCarOB());
    console.log(carJSON);

    $.ajax({
        url: carURL + 'save',
        method: 'POST',
        data: carJSON,
        contentType: 'application/json',
        success: function (res) {
            console.log(res.state);
        },
        error: function (error) {
            console.error('Error:', error);
        }
    });
});

function loadAllCars(){
    $.ajax({
        url: carURL + 'getall',
        method: 'GET',
        success: function (res) {
            console.log(res.data);
        },
        error: function (error) {
            console.error('Error:', error);
        }
    });
}