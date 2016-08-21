$('#amountOfRooms').keypress(function (e) {
    if (e.keyCode < 48 || e.keyCode > 57) {
        return false;
    }
});
function toJson() {
    var amountOfRooms = parseInt(document.getElementById('amountOfRooms').value);
    var amountOfApertures = 6;
    var amountOfSubstances = 6;

    var currentAmountOfApertures = 0;
    var currentAmountOfSubstances = 0;


    var nameOfBuilding = document.getElementsByName('nameOfBuilding');
    var selectedTemperatureOfRegion = document.getElementsByName('selectedTemperatureOfRegion');
    var s2 = document.getElementsByName('s2');
    var s3 = document.getElementsByName('s3');
    var s5 = document.getElementsByName('s5');
    var s6 = document.getElementsByName('s6');
    var builingS = [s2, s3, s5, s6];
    var specifyingCoefficientS5 = document.getElementsByName('specifyingCoefficientS5');

    for (var i = 0; i < amountOfRooms; i++) {
        var positionOfRoom = document.getElementsByName('positionOfRoom')[i];
        var nameOfRoom = document.getElementsByName('nameOfRoom')[i];
        var square = document.getElementsByName('squareOfRoom')[i];
        var heightR = document.getElementsByName('heightOfRoom')[i];
        var perimeter = document.getElementsByName('perimeterOfRoom')[i];

        var volume = document.getElementsByName('volumeOfRoom')[i];
        var squareOfConstruction = document.getElementsByName('squareOfConstruction')[i];

        var s1 = document.getElementsByName('s1');
        var s4 = document.getElementsByName('s4');
        var s7 = document.getElementsByName('s7');
        var s8 = document.getElementsByName('s8');
        var s9 = document.getElementsByName('s9');
        var s10 = document.getElementsByName('s10');
        var roomS = [s1, s4, s7, s8, s9, s10];

        var apertures = [];
        var substances = [];
        for (var k = 0; k < amountOfApertures; k++) {
            var TypeOfAperture = document.getElementsByName('typeOfAperture')[k];
            var width = document.getElementsByName('widthOfAperture')[k];
            var height = document.getElementsByName('heightOfAperture')[k];
            var count = document.getElementsByName('countOfAperture')[k];

            var squareOfAperture = document.getElementsByName('squareOfAperture')[k];
        }
        for (var m = 0; m < amountOfSubstances; m++) {

        }


    }
}
// $(document).ready(function () {
//     $('#coefficient').inputmask({'alias': 'decimal', 'groupSeparator': ',', 'autoGroup': 'true'});  //static mask
// });