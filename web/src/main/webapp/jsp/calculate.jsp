<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<jsp:useBean id="error" class="java.lang.String" scope="request"/>
<jsp:useBean id="substances" class="java.util.ArrayList" scope="request"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="locales.local" var="loc"/>
<fmt:message bundle="${loc}" key="calculate" var="calculate"/>
<fmt:message bundle="${loc}" key="calculate.building.name" var="buildingName"/>
<fmt:message bundle="${loc}" key="calculate.building.region" var="region"/>
<fmt:message bundle="${loc}" key="calculate.building.brest" var="brest"/>
<fmt:message bundle="${loc}" key="calculate.building.vitebsk" var="vitebsk"/>
<fmt:message bundle="${loc}" key="calculate.building.gomel" var="gomel"/>
<fmt:message bundle="${loc}" key="calculate.building.grodno" var="grodno"/>
<fmt:message bundle="${loc}" key="calculate.building.minsk" var="minsk"/>
<fmt:message bundle="${loc}" key="calculate.building.mogilev" var="mogilev"/>
<fmt:message bundle="${loc}" key="calculate.building.coefficient" var="coefficientBuild"/>
<fmt:message bundle="${loc}" key="calculate.building.s2" var="s2"/>
<fmt:message bundle="${loc}" key="calculate.building.s2.1" var="s21"/>
<fmt:message bundle="${loc}" key="calculate.building.s2.2" var="s22"/>
<fmt:message bundle="${loc}" key="calculate.building.s2.3" var="s23"/>
<fmt:message bundle="${loc}" key="calculate.building.s2.4" var="s24"/>
<fmt:message bundle="${loc}" key="calculate.building.s3" var="s3"/>
<fmt:message bundle="${loc}" key="calculate.building.s3.1" var="s31"/>
<fmt:message bundle="${loc}" key="calculate.building.s3.2" var="s32"/>
<fmt:message bundle="${loc}" key="calculate.building.s3.3" var="s33"/>
<fmt:message bundle="${loc}" key="calculate.building.s5" var="s5"/>
<fmt:message bundle="${loc}" key="calculate.building.s5.1" var="s51"/>
<fmt:message bundle="${loc}" key="calculate.building.s5.2" var="s52"/>
<fmt:message bundle="${loc}" key="calculate.building.s5.3" var="s53"/>
<fmt:message bundle="${loc}" key="calculate.building.s5.4" var="s54"/>
<fmt:message bundle="${loc}" key="calculate.building.s5.5" var="s55"/>
<fmt:message bundle="${loc}" key="calculate.building.s6" var="s6"/>
<fmt:message bundle="${loc}" key="calculate.building.s6.1" var="s61"/>
<fmt:message bundle="${loc}" key="calculate.building.s6.2" var="s62"/>
<fmt:message bundle="${loc}" key="calculate.building.coefficient5" var="coefficient5"/>
<fmt:message bundle="${loc}" key="calculate.building.amountOfRoom" var="amountOfRoom"/>

<fmt:message bundle="${loc}" key="calculate.room" var="room"/>
<fmt:message bundle="${loc}" key="calculate.room.coefficient" var="coefficientRoom"/>
<fmt:message bundle="${loc}" key="calculate.room.height" var="height"/>
<fmt:message bundle="${loc}" key="calculate.room.name" var="roomName"/>
<fmt:message bundle="${loc}" key="calculate.room.perimeter" var="perimeter"/>
<fmt:message bundle="${loc}" key="calculate.room.position" var="position"/>
<fmt:message bundle="${loc}" key="calculate.room.s1" var="s1"/>
<fmt:message bundle="${loc}" key="calculate.room.s1.1" var="s11"/>
<fmt:message bundle="${loc}" key="calculate.room.s1.2" var="s12"/>
<fmt:message bundle="${loc}" key="calculate.room.s1.3" var="s13"/>
<fmt:message bundle="${loc}" key="calculate.room.s1.4" var="s14"/>
<fmt:message bundle="${loc}" key="calculate.room.s1.5" var="s15"/>
<fmt:message bundle="${loc}" key="calculate.room.s1.6" var="s16"/>
<fmt:message bundle="${loc}" key="calculate.room.s1.7" var="s17"/>
<fmt:message bundle="${loc}" key="calculate.room.s4" var="s4"/>
<fmt:message bundle="${loc}" key="calculate.room.s4.1" var="s41"/>
<fmt:message bundle="${loc}" key="calculate.room.s4.2" var="s42"/>
<fmt:message bundle="${loc}" key="calculate.room.s4.3" var="s43"/>
<fmt:message bundle="${loc}" key="calculate.room.s4.4" var="s44"/>
<fmt:message bundle="${loc}" key="calculate.room.s4.5" var="s45"/>
<fmt:message bundle="${loc}" key="calculate.room.s7" var="s7"/>
<fmt:message bundle="${loc}" key="calculate.room.s7.1" var="s71"/>
<fmt:message bundle="${loc}" key="calculate.room.s7.2" var="s72"/>
<fmt:message bundle="${loc}" key="calculate.room.s8" var="s8"/>
<fmt:message bundle="${loc}" key="calculate.room.s8.1" var="s81"/>
<fmt:message bundle="${loc}" key="calculate.room.s8.2" var="s82"/>
<fmt:message bundle="${loc}" key="calculate.room.s9" var="s9"/>
<fmt:message bundle="${loc}" key="calculate.room.s9.1" var="s91"/>
<fmt:message bundle="${loc}" key="calculate.room.s9.2" var="s92"/>
<fmt:message bundle="${loc}" key="calculate.room.s10" var="s10"/>
<fmt:message bundle="${loc}" key="calculate.room.s10.1" var="s101"/>
<fmt:message bundle="${loc}" key="calculate.room.s10.2" var="s102"/>
<fmt:message bundle="${loc}" key="calculate.room.square" var="square"/>
<fmt:message bundle="${loc}" key="calculate.room.squareOfWall" var="squareOfWall"/>
<fmt:message bundle="${loc}" key="calculate.room.volume" var="volume"/>
<fmt:message bundle="${loc}" key="calculate.room.specificFireLoad" var="specificFireLoad"/>

<fmt:message bundle="${loc}" key="calculate.aperture" var="aperture"/>
<fmt:message bundle="${loc}" key="calculate.aperture.aper" var="onlyAperture"/>
<fmt:message bundle="${loc}" key="calculate.aperture.amount" var="amountOfAperture"/>
<fmt:message bundle="${loc}" key="calculate.aperture.square" var="squreOfAperture"/>
<fmt:message bundle="${loc}" key="calculate.aperture.width" var="widthOfAperture"/>
<fmt:message bundle="${loc}" key="calculate.aperture.height" var="heightOfAperture"/>

<fmt:message bundle="${loc}" key="calculate.material" var="typeOfMaterial"/>
<fmt:message bundle="${loc}" key="calculate.material.mat" var="material"/>
<fmt:message bundle="${loc}" key="calculate.material.weight" var="weightOfMaterial"/>

<fmt:message bundle="${loc}" key="calculate.send" var="send"/>
<%@ include file="parts/links.jsp" %>
<title>${calculate}</title>
<script>
    function spoiler_1() {
        var str = document.getElementById('amountOfRooms').value;
        if (str.length > 2)
            return false;
        var str1 = "";
        var str2 = "";
        var file = document.getElementById('data').innerHTML;
        var k = 0;
        for (var i = 0; i < parseInt(str); i++) {
            k++;
            str1 += '<div class="tab-pane fade" id="tab-' + i + '" >' + file + '</div>';
            str2 += '<li><a href="#tab-' + i + '" data-toggle="tab">${room}' + k + '</a></li>';
        }
        document.getElementById('Vkladka').innerHTML = str2;
        document.getElementById('Content').innerHTML = str1;
    }
</script>
<%@ include file="parts/header.jsp" %>
<form action="controller" method="POST" novalidate="">
    <input type="hidden" name="command" value="calculate">
    <div class="container">
        <div class="row">
            <div class="col-md-2">

            </div>
            <div class="col-md-8">
                <h3>${error}</h3>
            </div>
            <div class="col-md-2">

            </div>
        </div>
        <div class="row">
            <div class="col-md-12">

                <div class="form-group">
                    <label>
                        ${buildingName}
                    </label>
                    <input name="nameOfBuilding" class="form-control" placeholder="${buildingName}">
                </div>

                <div class="form-group">
                    <label>
                        ${region}
                    </label>
                    <select name="selectedTemperatureOfRegion" class="selectpicker form-control select-lg">
                        <option id="Brest" value="35">${brest}</option>
                        <option id="Vitebsk" value="35">${vitebsk}</option>
                        <option id="Grodno" value="35">${grodno}</option>
                        <option id="Gomel" value="35">${gomel}</option>
                        <option id="Minsk" value="35">${minsk}</option>
                        <option id="Mogilev" value="35">${mogilev}</option>
                    </select>
                </div>

                <label>
                    ${coefficientBuild}
                </label>
                <div class="form-group">

                    <select name="s2" class="selectpicker form-control select-lg">
                        <optgroup label="${s2}"></optgroup>
                        <option value="1.5">${s21}</option>
                        <option value="0.87">${s22}</option>
                        <option value="0.8">${s23}</option>
                        <option value="0.7">${s24}</option>
                    </select>
                    <select name="s3" class="selectpicker form-control select-lg">
                        <optgroup label="${s3}"></optgroup>
                        <option value="1.5">${s31}</option>
                        <option value="0.9">${s32}</option>
                        <option value="0.8">${s33}</option>
                    </select>

                    <select name="s5" class="selectpicker form-control select-lg">
                        <optgroup label="${s5}"></optgroup>
                        <option value="0.61">${s51}</option>
                        <option value="0.78">${s52}</option>
                        <option value="1.0">${s53}</option>
                        <option value="1.5">${s54}</option>
                        <option value="0.5">${s55}</option>
                    </select>
                    <select name="s6" class="selectpicker form-control select-lg">
                        <optgroup label="${s6}"></optgroup>
                        <option value="1.0">${s61}</option>
                        <option value="0.9">${s62}</option>
                    </select>
                </div>

                <div class="form-group">

                    <label>
                        ${coefficient5}
                    </label>
                    <input name="specifyingCoefficientS5" class="form-control" placeholder="${coefficient5}"
                           value="1">
                </div>

                <div class="form-group">
                    <label>
                        ${amountOfRoom}
                    </label>
                    <input name="amountOfRooms" id="amountOfRooms" onkeyup="spoiler_1()" class="form-control"
                           placeholder="${amountOfRoom}" value="0">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="tabs">
                    <ul class="nav nav-tabs" id="Vkladka">
                        <%--<li><a href="#tab-1" data-toggle="tab">Вкладка 1</a></li>--%>
                        <%--<li><a href="#tab-2" data-toggle="tab">Вкладка 2</a></li>--%>
                    </ul>
                    <div class="tab-content" id="Content">

                        <div id="data" style="display: none">

                            <div class="form-group">
                                <input name="positionOfRoom" class="form-control" placeholder="${position}">
                                <input name="nameOfRoom" class="form-control" placeholder="${roomName}">
                                <input name="squareOfRoom" class="form-control" placeholder="${square}">
                                <input name="heightOfRoom" class="form-control" placeholder="${height}">
                                <input name="perimeterOfRoom" class="form-control" placeholder="${perimeter}">
                                <input name="volumeOfRoom" class="form-control" placeholder="${volume}">
                                <input name="squareOfConstruction" class="form-control" placeholder="${squareOfWall}">
                            </div>
                            <div class="row">
                                <c:forEach var="k" begin="0" end="1">
                                    <div class="col-md-6">
                                        <c:forEach var="i" begin="1" end="3">
                                            <div class="form-group">
                                                <label>${onlyAperture} ${i+k*3}</label>
                                                <div class="parametresOfAperture">
                                                    <input name="typeOfAperture" class="form-control"
                                                           placeholder="${aperture}">
                                                    <input name="widthOfAperture" class="form-control"
                                                           placeholder="${widthOfAperture}">
                                                    <input name="heightOfAperture" class="form-control"
                                                           placeholder="${heightOfAperture}">
                                                    <input name="countOfAperture" class="form-control"
                                                           placeholder="${amountOfAperture}">
                                                    <input name="squareOfAperture" class="form-control"
                                                           placeholder="${squreOfAperture}">
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="form-group">
                                <label>${coefficientRoom}</label>
                                <select name="s1" class="selectpicker form-control select-lg">
                                    <optgroup label="${s1}"></optgroup>
                                    <option value="0.59">${s11}</option>
                                    <option value="0.57">${s12}</option>
                                    <option value="0.59">${s13}</option>
                                    <option value="1.0">${s14}</option>
                                    <optgroup label="${s15}"></optgroup>
                                    <option value="0.63">${s16}</option>
                                    <option value="0.61">${s17}</option>
                                </select>
                                <select name="s4" class="selectpicker form-control select-lg">
                                    <optgroup label="${s4}"></optgroup>
                                    <option value="1.5">${s41}</option>
                                    <option value="0.73">${s42}</option>
                                    <option value="0.87">${s43}</option>
                                    <!--<option value="">${s44}</option> -->
                                    <option value="1.0">${s45}</option>
                                </select>
                                <select name="s7" class="selectpicker form-control select-lg">
                                    <optgroup label="${s7}"></optgroup>
                                    <option value="1">${s71}</option>
                                    <option value="0.9">${s72}</option>
                                </select>
                                <select name="s8" class="selectpicker form-control select-lg">
                                    <optgroup label="${s8}"></optgroup>
                                    <option value="1">${s81}</option>
                                    <option value="0.9">${s82}</option>
                                </select>
                                <select name="s9" class="selectpicker form-control select-lg">
                                    <optgroup
                                            label="${s9}"></optgroup>
                                    <option value="1.5">${s91}</option>
                                    <option value="1.0">${s92}</option>
                                </select>
                                <select name="s10" class="selectpicker form-control select-lg">
                                    <optgroup label="${s10}"></optgroup>
                                    <option value="0.9">${s101}</option>
                                    <option value="1.0">${s102}</option>
                                </select>
                            </div>
                            <div class="row">
                                <c:forEach var="k" begin="0" end="1">
                                    <div class="col-md-6">
                                        <c:forEach var="i" begin="1" end="3">
                                            <div class="form-group">
                                                <label>${material} ${i+k*3}</label>
                                                <select name="nameOfSubstance"
                                                        class="selectpicker form-control select-lg">
                                                    <optgroup label="${typeOfMaterial}"></optgroup>
                                                    <c:forEach items="${substances}" var="substance">
                                                        <option value="${substance.id}">${substance.nameOfSubstance}</option>
                                                    </c:forEach>
                                                </select>
                                                <input name="weight" class="form-control"
                                                       placeholder="${weightOfMaterial}"></div>
                                        </c:forEach>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="form-group">
                                <label>${specificFireLoad}</label>
                                <input name="specificFireLoadZVEZDOCHKA" class="form-control"
                                       placeholder="${specificFireLoad}">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="form-group">
                    <input class="btn btn-primary btn-block" value="${send}" type="submit">
                </div>
            </div>
        </div>
    </div>
    <br>
    <br>
    <br>
    <br>
    <br>
    <script>
        $('#amountOfRooms').keypress(function (e) {
            if (e.keyCode < 48 || e.keyCode > 57) {
                return false;
            }
        });
    </script>
</form>


<%@ include file="parts/bottom.jsp" %>