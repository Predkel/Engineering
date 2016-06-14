function resetError(block) {
    block.className = '';
    if (block.lastChild.className == "ermessage") {
        block.removeChild(block.lastChild);
    }
}

function showError(block, errorMessage) {
    block.className = 'form-group';
    var errorSpan = document.createElement('span');
    errorSpan.className = "ermessage";
    errorSpan.innerHTML = errorMessage;
    block.appendChild(errorSpan);
}

function trim(stroka) {
    stroka = stroka.replace(/\s+/g, "");
    return stroka;
}
function validateUser(form) {
    var elementsForm = form.elements;
    var checker = true;
    resetError(elementsForm.login.parentNode);
    if ((trim(elementsForm.login.value)).length == 0) {
        if ((trim(elementsForm.login.value)).length != (elementsForm.login.value).length) {
            alert(' Логин не может состоять только из пробелов! ');
            elementsForm.login.value = "";
            checker = false;
        }
        showError(elementsForm.login.parentNode, ' Укажите логин');
        checker = false;
    }
    resetError(elementsForm.password.parentNode);
    if ((trim(elementsForm.password.value)).length == 0) {
        if ((trim(elementsForm.password.value)).length != (elementsForm.login.value).length) {
            alert(' Пароль не может состоять только из пробелов! ');
            elementsForm.password.value = "";
            checker = false;
        }
        showError(elementsForm.password.parentNode, ' Укажите пароль');
        checker = false;
    }
    if (!checker)
        event.preventDefault()
}
function validateSubstance(form) {
    var elementsForm = form.elements;
    var checker = true;
    var air = elementsForm.amountOfCombustionAir.value;
    var heat = elementsForm.combustionHeat.value;
    var speed = elementsForm.averageSpeedBurnout.value;


    resetError(elementsForm.amountOfCombustionAir.parentNode);
    if (/\D/.test(air)) {
        showError(elementsForm.amountOfCombustionAir.parentNode, ' Нельзя использовать строковые значения');
        checker = false;
    }
    resetError(elementsForm.combustionHeat.parentNode);
    if (/\D/.test(heat)) {
        showError(elementsForm.combustionHeat.parentNode, ' Нельзя использовать строковые значения');
        checker = false;
    }
    resetError(elementsForm.averageSpeedBurnout.parentNode);
    if (/\D/.test(speed)) {
        showError(elementsForm.averageSpeedBurnout.parentNode, ' Нельзя использовать строковые значения');
        checker = false;
    }
    if (!checker)
        event.preventDefault()
}