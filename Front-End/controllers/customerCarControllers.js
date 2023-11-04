let carURL = 'http://localhost:8081/carRental/car/';
let allCars = [];

function getCarOB() {
    let car = {
        registernumber: $('#txtRegisterNumber').val(),
        brand: $('#txtBrand').val(),
        rates: $('#slctRates').val(),
        frontview: $('#fileFrontView').val(),
        backview: $('#fileBackView').val(),
        freemilage: $('#txtFreeMilage').val(),
        sideview: $('#fileSideView').val(),
        interior: $('#fileinterior').val(),
        numberofpassengers: $('#txtNumberofPassengers').val(),
        type: $('#txtType').val(),
        dailyrate: $('#txtDailyRate').val(),
        mothlyrate: $('#txtMonthlyRate').val(),
        priceofextrakm: $('#txtPriceofExtraKm').val(),
        color: $('#txtColor').val(),
        vehicleavailabilitytype: $('#slctVehicleAvailabilityType').val(),
    }

    return car;
}

loadAllCars();


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


$('#btnUpdateCar').click(function () {

    let carJSON = JSON.stringify(getCarOB());
    console.log(carJSON);

    $.ajax({
        url: carURL + 'update',
        method: 'PUT',
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

function loadAllCars() {
    $.ajax({
        url: 'http://localhost:8081/carRental/car/getall',
        method: 'GET',
        success: function (res) {
            allCars = res.data;
            $('#carsView').empty();
            $('#carRegNo').empty();
            for (let i = 0; i < res.data.length; i++) {
                loadCarDetails(res.data[i]);
            }
        },
        error: function (error) {
            console.error('Error:', error);
        }
    });
}

function loadCarDetails(car) {

    $('#carRegNo').append(`<option class="carRegOption" carid="${JSON.stringify(car)}"> ${car.registernumber} </option>`);
    // car.registernumber


    let carHtml = `<div style="height: 350px" class="carCard ms-2 me-5">
                <div class="carImg">

                    <div class="carousel slide" data-bs-ride="carousel" >
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img alt="fontView" class="d-block w-75" src=../assets/images/fitted.jpgg>
                            </div>
                            <div class="carousel-item">
                                <img alt="sideView" class="d-block w-75" src="assets/img/car03.png">
                            </div>
                            <div class="carousel-item">
                                <img alt="BackView" class="d-block w-75" src="assets/img/car03.png">
                            </div>
                            <div class="carousel-item">
                                <img alt="InteriorView" class="d-block w-75" src="assets/img/car03.png">
                            </div>
                        </div>
                        <button class="carousel-control-prev" data-bs-slide="prev" data-bs-target="#carouselExample1"
                                type="button">
                            <span aria-hidden="true" class="carousel-control-prev-icon"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" data-bs-slide="next"
                                data-bs-target="#carouselExampleAutoplaying"
                                type="button">
                            <span aria-hidden="true" class="carousel-control-next-icon"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>
                <div class="carDetail">
                    <div>
                        <h1>${car.brand}</h1>
                        <h2 class="dailyPrice">${car.dailyrate}</h2>
                        <h2 class="monthlyPrice">${car.mothlyrate}LKR/month</h2>
                    </div>
                    <div class="typeCon">
                        <div>
                            <img alt="logo" height="20" src="assets/img/steering-wheel.png" width="20">
                            <h1>${car.type}</h1>
                        </div>
                        <div>
                            <img alt="logo" height="20" src="../assets/logos/WhatsApp%20Image%202023-10-31%20at%2001.13.16_a7d8b326.jpg" width="20">
                            <h1>${car.numberofpassengers}Seats</h1>
                        </div>
                        <div>
                            <img alt="logo" height="20" src="assets/img/petrol-pump.png" width="20">
                            <h1>${car.vehicleavailabilitytype}</h1>
                        </div>
                    </div>
                    <div>
                        <button carID='${JSON.stringify(car)}' class="rentNow btn btn-outline-primary">Rent Now</button>
                    </div>
                </div>
            </div>`

    $('#carsView').append(carHtml);
}

$(document).ready(function () {

    $(document).on('click', '.rentNow', function () {
        let attr = $(this).attr('carID');
        let car = JSON.parse($(this).attr('carID'));
        console.log(attr);
        $('#addCart').attr('car', attr);
        $('#cost').val(car.dailyrate);
        $('#carRegNo').val(car.registernumber);
        $('#brand').val(car.brand);
        $('#transMissionType').val(car.type);
        $('#noOfPassengers').val(car.numberofpassengers);
    })
});

$('#addCart').click(function () {
    loadCarTr(JSON.parse($('#addCart').attr('car')))
    $('#driverState').val("");
});

let rentDetails = [];

function loadCarTr(car) {
    let tr = `<tr>
                 <td>${car.registernumber}</td>
                 <td>${$('#pickUpDate').val()}</td>
                 <td>${$('#pickUpTime').val()}</td>
                 <td>${$('#returnDate').val()}</td>
                 <td>${$('#returnTime').val()}</td>
                 <td>${$('#driverState').val()}</td>
                 <td>${$('#location').val()}</td>
            </tr>`


    $('#cart').append(tr);

    let detail = {
        rentid: $('#rentId').val(),
        carid: car.registernumber,
        driver: $('#driverState').val()
    }

    rentDetails.push(detail);
}


$('#reservation').click(function () {
    let rent = {
        rentid: $('#rentId').val(),
        customerid: $('#userNic').val(),
        pickupDate: $('#pickUpDate').val(),
        returnDate: $('#returnDate').val(),
        rentDetails: rentDetails
    }

    console.log(rent);

    $.ajax({
        url: 'http://localhost:8081/carRental/rent/save',
        method: 'POST',
        data:JSON.stringify(rent),
        contentType:'application/json',
        success: function (res) {

        },
        error: function (error) {
            console.error('Error:', error);
        }
    });

})

$('#rentId');
$('#userNic');
