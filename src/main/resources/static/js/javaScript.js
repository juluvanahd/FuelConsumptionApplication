var userSelectedRequestType = -1;

function checkClick(clickedBtn) {

    if(clickedBtn === 0) {
        userSelectedRequestType = -1;
    }
    else {
        var insertedDriverID = parseInt(prompt("Please Enter driverID:"));

        if(isNaN(insertedDriverID) || insertedDriverID.toString() === "" || insertedDriverID < 0) {
            alert("Please enter a valid Driver ID!");
        }
        else {
            document.getElementById("radio" + clickedBtn.toString()).innerHTML = "Specific driver (" + insertedDriverID.toString() + ")";
            userSelectedRequestType = insertedDriverID;
        }
    }
}

function getSpecifiedMonth() {

    var month = document.getElementById("month").value;

    getRequest("/resultSpecifiedMonth", "month", month)
}

function totalMoney() {

    getRequest("/resultMoney", null, null);
}

function getFuelType() {

    var fuelType = document.getElementById("fuelTypeInput").value;

    getRequest("/resultFuel", "fuelType", fuelType);
}

function addDriver() {

    var driverID = document.getElementById("driverID").value;
    var fuelType = document.getElementById("fuelType").value;
    var price = document.getElementById("price").value;
    var liters = document.getElementById("liters").value;
    var date = document.getElementById("date").value;

    if(!isNaN(parseInt(driverID)) && driverID >= 0 && date !== "" && !isNaN(parseFloat(liters)) && !isNaN(parseFloat(price)))
    {
        var data = {
            driverID: driverID,
            fuelType: fuelType,
            price: price,
            liters: liters,
            date: date
        };

        var json = JSON.stringify(data);

        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/api");
        xhr.setRequestHeader("Content-Type", "application/json");
        xhr.send(json);
        alert("Driver: '" + driverID + "' added to database!");
    }
    else
    {
        alert("Please enter a valid data!");
    }
}
function getRequest(url, parameter, value) {

    if(parameter === null && userSelectedRequestType !== -1)
    {
        window.location = url + "?driverID=" + userSelectedRequestType;
    }
    else if (parameter !== null && userSelectedRequestType !== -1)
    {
        window.location = url + "?driverID=" + userSelectedRequestType + "&" + parameter + "=" + value;
    }
    else if(parameter === null)
    {
        window.location = url;
    }
    else
    {
        window.location = url + "?" + parameter + "=" + value;
    }
}