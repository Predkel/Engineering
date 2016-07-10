$('#amountOfRooms').keypress(function (e) {
    if (e.keyCode < 48 || e.keyCode > 57) {
        return false;
    }
});
$(document).ready(function () {
    $('#coefficient').inputmask({'alias': 'decimal', 'groupSeparator': ',', 'autoGroup': 'true'});  //static mask
});
