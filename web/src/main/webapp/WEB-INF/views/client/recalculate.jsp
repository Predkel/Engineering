<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="by.pvt.predkel.entities.*" %>
<%@ page import="by.pvt.predkel.parameters.Attributes" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<jsp:useBean id="error" class="java.lang.String" scope="request"/>

<s:message code="calculate" var="calculate"/>
<s:message code="calculate.building.name" var="buildingName"/>
<s:message code="calculate.building.region" var="region"/>
<s:message code="calculate.building.brest" var="brest"/>
<s:message code="calculate.building.vitebsk" var="vitebsk"/>
<s:message code="calculate.building.gomel" var="gomel"/>
<s:message code="calculate.building.grodno" var="grodno"/>
<s:message code="calculate.building.minsk" var="minsk"/>
<s:message code="calculate.building.mogilev" var="mogilev"/>
<s:message code="calculate.building.coefficient" var="coefficientBuild"/>
<s:message code="calculate.building.s2" var="s2Text"/>
<s:message code="calculate.building.s2.1" var="s21"/>
<s:message code="calculate.building.s2.2" var="s22"/>
<s:message code="calculate.building.s2.3" var="s23"/>
<s:message code="calculate.building.s2.4" var="s24"/>
<s:message code="calculate.building.s3" var="s3Text"/>
<s:message code="calculate.building.s3.1" var="s31"/>
<s:message code="calculate.building.s3.2" var="s32"/>
<s:message code="calculate.building.s3.3" var="s33"/>
<s:message code="calculate.building.s5" var="s5Text"/>
<s:message code="calculate.building.s5.1" var="s51"/>
<s:message code="calculate.building.s5.2" var="s52"/>
<s:message code="calculate.building.s5.3" var="s53"/>
<s:message code="calculate.building.s5.4" var="s54"/>
<s:message code="calculate.building.s5.5" var="s55"/>
<s:message code="calculate.building.s6" var="s6Text"/>
<s:message code="calculate.building.s6.1" var="s61"/>
<s:message code="calculate.building.s6.2" var="s62"/>
<s:message code="calculate.building.coefficient5" var="coefficient5"/>
<s:message code="calculate.building.amountOfRoom" var="amountOfRoom"/>

<s:message code="calculate.room" var="room"/>
<s:message code="calculate.room.coefficient" var="coefficientRoom"/>
<s:message code="calculate.room.height" var="height"/>
<s:message code="calculate.room.name" var="roomName"/>
<s:message code="calculate.room.perimeter" var="perimeter"/>
<s:message code="calculate.room.position" var="position"/>
<s:message code="calculate.room.s1" var="s1Text"/>
<s:message code="calculate.room.s1.1" var="s11"/>
<s:message code="calculate.room.s1.2" var="s12"/>
<s:message code="calculate.room.s1.3" var="s13"/>
<s:message code="calculate.room.s1.4" var="s14"/>
<s:message code="calculate.room.s1.5" var="s15"/>
<s:message code="calculate.room.s1.6" var="s16"/>
<s:message code="calculate.room.s1.7" var="s17"/>
<s:message code="calculate.room.s4" var="s4Text"/>
<s:message code="calculate.room.s4.1" var="s41"/>
<s:message code="calculate.room.s4.2" var="s42"/>
<s:message code="calculate.room.s4.3" var="s43"/>
<s:message code="calculate.room.s4.4" var="s44"/>
<s:message code="calculate.room.s4.5" var="s45"/>
<s:message code="calculate.room.s7" var="s7Text"/>
<s:message code="calculate.room.s7.1" var="s71"/>
<s:message code="calculate.room.s7.2" var="s72"/>
<s:message code="calculate.room.s8" var="s8Text"/>
<s:message code="calculate.room.s8.1" var="s81"/>
<s:message code="calculate.room.s8.2" var="s82"/>
<s:message code="calculate.room.s9" var="s9Text"/>
<s:message code="calculate.room.s9.1" var="s91"/>
<s:message code="calculate.room.s9.2" var="s92"/>
<s:message code="calculate.room.s10" var="s10Text"/>
<s:message code="calculate.room.s10.1" var="s101"/>
<s:message code="calculate.room.s10.2" var="s102"/>
<s:message code="calculate.room.square" var="square"/>
<s:message code="calculate.room.squareOfWall" var="squareOfWall"/>
<s:message code="calculate.room.volume" var="volume"/>
<s:message code="calculate.room.specificFireLoad" var="specificFireLoad"/>

<s:message code="calculate.aperture" var="aperture"/>
<s:message code="calculate.aperture.aper" var="onlyAperture"/>
<s:message code="calculate.aperture.amount" var="amountOfAperture"/>
<s:message code="calculate.aperture.square" var="squareOfAperture"/>
<s:message code="calculate.aperture.width" var="widthOfAperture"/>
<s:message code="calculate.aperture.height" var="heightOfAperture"/>

<s:message code="calculate.material" var="typeOfMaterial"/>
<s:message code="calculate.material.mat" var="material"/>
<s:message code="calculate.material.weight" var="weightOfMaterial"/>

<s:message code="calculate.send" var="send"/>

<s:url value="/client/count" var="formUrl"/>
<form action="${formUrl}" method="POST" novalidate="">
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
                <%
                    Building b = (Building) request.getSession().getAttribute(Attributes.BUILDING);
                    List buildCoefficient = b.getCoefficientSForBuild();
                    List rooms = b.getRoom();
                    List substances = (List) request.getAttribute(Attributes.ALL_SUBSTANCES);
                    double s2 = ((Double) buildCoefficient.get(0)).doubleValue();
                    double s3 = ((Double) buildCoefficient.get(1)).doubleValue();
                    double s5 = ((Double) buildCoefficient.get(2)).doubleValue();
                    double s6 = ((Double) buildCoefficient.get(3)).doubleValue();
                    double temperature = b.getSelectedTemperatureOfRegion();
                %>
                <div class="form-group">
                    <label>
                        ${buildingName}
                    </label>
                    <input name="nameOfBuilding" class="form-control" placeholder="${buildingName}"
                           value="<%=b.getNameOfBuilding()%>">
                </div>

                <div class="form-group">
                    <label>
                        ${region}
                    </label>
                    <select name="selectedTemperatureOfRegion"
                            class="selectpicker form-control select-lg">
                        <option id="Brest" value="35" <% if (temperature == 35) { %> selected="selected" <% } %>>
                            ${brest}
                        </option>
                        <option id="Vitebsk" value="35"<% if (temperature == 35) { %> selected="selected" <% } %>>
                            ${vitebsk}
                        </option>
                        <option id="Grodno" value="35"<% if (temperature == 35) { %> selected="selected" <% } %>>
                            ${grodno}
                        </option>
                        <option id="Gomel" value="35"<% if (temperature == 35) { %> selected="selected" <% } %>>
                            ${gomel}
                        </option>
                        <option id="Minsk" value="35"<% if (temperature == 35) { %> selected="selected" <% } %>>
                            ${minsk}
                        </option>
                        <option id="Mogilev" value="35"<% if (temperature == 35) { %> selected="selected" <% } %>>
                            ${mogilev}
                        </option>
                    </select>
                </div>

                <label>
                    ${coefficientBuild}
                </label>
                <div class="form-group">

                    <select name="s2" class="selectpicker form-control select-lg">
                        <optgroup label="${s2Text}"></optgroup>
                        <option value="1.5"<% if (s2 == 1.5) { %> selected="selected" <% } %>>${s21}</option>
                        <option value="0.87"<% if (s2 == 0.87) { %> selected="selected" <% } %>>${s22}</option>
                        <option value="0.8"<% if (s2 == 0.8) { %> selected="selected" <% } %>>${s23}</option>
                        <option value="0.7"<% if (s2 == 0.7) { %> selected="selected" <% } %>>${s24}</option>
                    </select>
                    <select name="s3" class="selectpicker form-control select-lg">
                        <optgroup label="${s3Text}"></optgroup>
                        <option value="1.5"<% if (s3 == 1.5) { %> selected="selected" <% } %>>${s31}</option>
                        <option value="0.9"<% if (s3 == 0.9) { %> selected="selected" <% } %>>${s32}</option>
                        <option value="0.8"<% if (s3 == 0.8) { %> selected="selected" <% } %>>${s33}</option>
                    </select>

                    <select name="s5" class="selectpicker form-control select-lg">
                        <optgroup label="${s5Text}"></optgroup>
                        <option value="0.61"<% if (s5 == 0.61) { %> selected="selected" <% } %>>${s51}</option>
                        <option value="0.78"<% if (s5 == 0.78) { %> selected="selected" <% } %>>${s52}</option>
                        <option value="1.0"<% if (s5 == 1.0) { %> selected="selected" <% } %>>${s53}</option>
                        <option value="1.5"<% if (s5 == 1.5) { %> selected="selected" <% } %>>${s54}</option>
                        <option value="0.5"<% if (s5 == 0.5) { %> selected="selected" <% } %>>${s55}</option>
                    </select>
                    <select name="s6" class="selectpicker form-control select-lg">
                        <optgroup label="${s6Text}"></optgroup>
                        <option value="1.0"<% if (s6 == 1.0) { %> selected="selected" <% } %>>${s61}</option>
                        <option value="0.9"<% if (s6 == 0.9) { %> selected="selected" <% } %>>${s62}</option>
                    </select>
                </div>

                <div class="form-group">

                    <label>
                        ${coefficient5}
                    </label>
                    <input name="specifyingCoefficientS5" class="form-control" placeholder="${coefficient5}"
                           value="<%=b.getSpecifyingCoefficientS5()%>">
                </div>

                <div class="form-group">
                    <label>
                        ${amountOfRoom}
                    </label>
                    <input name="amountOfRooms" id="amountOfRooms" class="form-control"
                           placeholder="${amountOfRoom}" value="<%=rooms.size()%>">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="tabs">
                    <ul class="nav nav-tabs" id="Vkladka">
                        <c:forEach var="i" begin="1" end="<%=rooms.size()%>">
                            <li><a href="#tab-${i}" data-toggle="tab">${room} ${i}</a></li>
                        </c:forEach>
                    </ul>
                    <div class="tab-content" id="Content">

                        <%--<c:forEach items="<%=rooms%>" var="room">--%>
                        <% for (int i = 0; i < rooms.size(); i++) {%>
                        <%Room room = (Room) rooms.get(i);%>
                        <div class="tab-pane fade" id="tab-<%=i+1%>">

                            <div class="form-group">
                                <input name="positionOfRoom" class="form-control" placeholder="${position}"
                                       value="<%=room.getCommonParameters().getPositionOfRoom()%>">
                                <input name="nameOfRoom" class="form-control" placeholder="${roomName}"
                                       value="<%=room.getCommonParameters().getNameOfRoom()%>">
                                <input name="squareOfRoom" class="form-control" placeholder="${square}"
                                       value="<%=room.getCommonParameters().getSquare()%>">
                                <input name="heightOfRoom" class="form-control" placeholder="${height}"
                                       value="<%=room.getCommonParameters().getHeight()%>">
                                <input name="perimeterOfRoom" class="form-control" placeholder="${perimeter}"
                                       value="<%=room.getCommonParameters().getPerimeter()%>">
                                <!--параметры с возможный расчетом-->
                                <input name="volumeOfRoom" class="form-control" placeholder="${volume}"
                                       value="<%=room.getCommonParameters().getVolume()%>">
                                <input name="squareOfConstruction" class="form-control"
                                       placeholder="${squareOfWall}"
                                       value="<%=room.getCommonParameters().getSquareOfConstruction()%>">
                                <!-- конец параметров с возможный расчетом-->
                            </div>


                            <!--Описание проемов-->
                            <div class="row">
                                <div class="col-md-6">
                                    <%int k;%>
                                    <% for (k = 0; k < room.getAperture().size(); k++) {%>
                                    <%Aperture aperture = room.getAperture().get(k);%>
                                    <% if (k == 3) { %>
                                </div>
                                <div class="col-md-6">
                                    <% } %>
                                    <div class="form-group">
                                        <label>${onlyAperture} <%=k + 1%>
                                        </label>
                                        <!-- параметры проема -->
                                        <div class="parametersOfAperture">
                                            <input name="typeOfAperture" class="form-control"
                                                   placeholder="${aperture}"
                                                   value="<%=aperture.getTypeOfAperture()%>">
                                            <input name="widthOfAperture" class="form-control"
                                                   placeholder="${widthOfAperture}" value="<%=aperture.getWidth()%>">
                                            <input name="heightOfAperture" class="form-control"
                                                   placeholder="${heightOfAperture}" value="<%=aperture.getHeight()%>">
                                            <input name="countOfAperture" class="form-control"
                                                   placeholder="${amountOfAperture}"
                                                   value="<%=aperture.getCount()%>">
                                            <!--параметры с возможный расчетом-->
                                            <input name="squareOfAperture" class="form-control"
                                                   placeholder="${squareOfAperture}"
                                                   value="<%=aperture.getSquareOfAperture()%>">
                                            <!-- конец параметров с возможный расчетом-->
                                        </div>
                                        <!-- конец параметров проема -->
                                    </div>
                                    <% } %>

                                    <% if (k == 5) { %>
                                </div>
                                <% } %>

                                <% if (k < 5) { %>

                                <% for (int l = k; k < 6; k++) {%>
                                <% if (k == 3) { %>
                            </div>
                            <div class="col-md-6">
                                <% } %>
                                <div class="form-group">
                                    <label>${onlyAperture} <%=k + 1%>
                                    </label>
                                    <!-- параметры проема -->
                                    <div class="parametersOfAperture">
                                        <input name="typeOfAperture" class="form-control"
                                               placeholder="${aperture}">
                                        <input name="widthOfAperture" class="form-control"
                                               placeholder="${widthOfAperture}">
                                        <input name="heightOfAperture" class="form-control"
                                               placeholder="${heightOfAperture}">
                                        <input name="countOfAperture" class="form-control"
                                               placeholder="${amountOfAperture}">
                                        <!--параметры с возможный расчетом-->
                                        <input name="squareOfAperture" class="form-control"
                                               placeholder="${squareOfAperture}">
                                        <!-- конец параметров с возможный расчетом-->
                                    </div>
                                    <!-- конец параметров проема -->
                                </div>
                                <% if (k == 5) { %>
                            </div>
                            <% } %>
                            <% } %>
                            <% } %>
                        </div>


                        <div class="form-group">
                            <label>
                                ${coefficientRoom}
                            </label>
                            <%List roomCoefficient = room.getCoefficientSForRoom();%>
                            <%double s1 = ((Double) roomCoefficient.get(0)).doubleValue();%>
                            <%double s4 = ((Double) roomCoefficient.get(1)).doubleValue();%>
                            <%double s7 = ((Double) roomCoefficient.get(2)).doubleValue();%>
                            <%double s8 = ((Double) roomCoefficient.get(3)).doubleValue();%>
                            <%double s9 = ((Double) roomCoefficient.get(4)).doubleValue();%>
                            <%double s10 = ((Double) roomCoefficient.get(5)).doubleValue();%>
                            <select name="s1" class="selectpicker form-control select-lg">
                                <optgroup label="${s1Text}"></optgroup>
                                <option value="0.59"<% if (s1 == 0.59) { %> selected="selected" <% } %>>${s11}
                                </option>
                                <option value="0.57"<% if (s1 == 0.57) { %> selected="selected" <% } %>>${s12}
                                </option>
                                <option value="0.59"<% if (s1 == 0.59) { %> selected="selected" <% } %>>${s13}
                                </option>
                                <option value="1.0"<% if (s1 == 1.0) { %> selected="selected" <% } %>>${s14}
                                </option>
                                <optgroup label="${s1-5}"></optgroup>
                                <option value="0.63"<% if (s1 == 0.63) { %> selected="selected" <% } %>>${s16}
                                </option>
                                <option value="0.61"<% if (s1 == 0.61) { %> selected="selected" <% } %>>${s17}
                                </option>
                            </select>

                            <select name="s4" class="selectpicker form-control select-lg">
                                <optgroup label="${s4Text}"></optgroup>
                                <option value="1.5"<% if (s4 == 1.5) { %> selected="selected" <% } %>>${s41}
                                </option>
                                <option value="0.73"<% if (s4 == 0.73) { %> selected="selected" <% } %>>${s42}
                                </option>
                                <option value="0.87"<% if (s4 == 0.87) { %> selected="selected" <% } %>>${s43}
                                </option>
                                <!--<option value="">${s44}</option> -->
                                <option value="1.0"<% if (s4 == 1.0) { %> selected="selected" <% } %>>${s45}
                                </option>
                            </select>

                            <select name="s7"
                                    class="selectpicker form-control select-lg">
                                <optgroup label="${s7Text}"></optgroup>
                                <option value="1"<% if (s7 == 1) { %> selected="selected" <% } %>>${s71}</option>
                                <option value="0.9"<% if (s7 == 0.9) { %> selected="selected" <% } %>>${s72}
                                </option>
                            </select>

                            <select name="s8" class="selectpicker form-control select-lg">
                                <optgroup label="${s8Text}"></optgroup>
                                <option value="1"<% if (s8 == 1) { %> selected="selected" <% } %>>${s81}</option>
                                <option value="0.9"<% if (s8 == 0.9) { %> selected="selected" <% } %>>${s82}
                                </option>
                            </select>

                            <select name="s9"
                                    class="selectpicker form-control select-lg">
                                <optgroup label="${s9Text}"></optgroup>
                                <option value="1.5"<% if (s9 == 1.5) { %> selected="selected" <% } %>>${s91}
                                </option>
                                <option value="1.0"<% if (s9 == 1.0) { %> selected="selected" <% } %>>${s92}
                                </option>
                            </select>

                            <select name="s10"
                                    class="selectpicker form-control select-lg">
                                <optgroup label="${s10Text}"></optgroup>
                                <option value="0.9"<% if (s10 == 0.9) { %> selected="selected" <% } %>>${s101}
                                </option>
                                <option value="1.0"<% if (s10 == 1.0) { %> selected="selected" <% } %>>${s102}
                                </option>
                            </select>
                        </div>


                        <div class="row">
                            <div class="col-md-6">
                                <%int m;%>
                                <% for (m = 0; m < room.getSubstanceOfRoom().size(); m++) {%>
                                <%SubstanceOfRoom substanceOfRoom = room.getSubstanceOfRoom().get(m);%>
                                <% if (m == 3) { %>
                            </div>
                            <div class="col-md-6">
                                <% } %>
                                <div class="form-group">
                                    <label>${material} <%=m + 1%>
                                    </label>
                                    <select name="nameOfSubstance"
                                            class="selectpicker form-control select-lg">
                                        <optgroup label="${typeOfMaterial}"></optgroup>

                                        <% for (int j = 0; j < substances.size(); j++) {%>

                                        <%FlammableSubstance substance = (FlammableSubstance) substances.get(j);%>
                                        <%long id = substance.getId();%>
                                        <option value="<%=id%>"<% if (id == substanceOfRoom.getFlammableSubstance().getId()) { %>
                                                selected="selected" <% } %>><%=substance.getNameOfSubstance()%>
                                        </option>

                                        <% } %>
                                    </select>
                                    <input name="weight" class="form-control"
                                           placeholder="${weightOfMaterial}"
                                           value="<%=substanceOfRoom.getWeight()%>">
                                </div>
                                <% } %>

                                <% if (m == 5) { %>
                            </div>
                            <% } %>

                            <% if (m < 5) { %>

                            <% for (int l = m; m < 6; m++) {%>
                            <% if (m == 3) { %>
                        </div>
                        <div class="col-md-6">
                            <% } %>
                            <div class="form-group">
                                <label>${material} <%=m + 1%>
                                </label>
                                <select name="nameOfSubstance"
                                        class="selectpicker form-control select-lg">
                                    <optgroup label="${typeOfMaterial}"></optgroup>
                                    <c:forEach items="<%=substances%>" var="substance">
                                        <option value="${substance.id}">${substance.nameOfSubstance}</option>
                                    </c:forEach>
                                </select>
                                <input name="weight" class="form-control"
                                       placeholder="${weightOfMaterial}">
                            </div>
                            <% if (m == 5) { %>
                        </div>
                        <% } %>
                        <% } %>
                        <% } %>
                    </div>


                    <div class="form-group">
                        <label>
                            ${specificFireLoad}
                        </label>
                        <input name="specificFireLoadZVEZDOCHKA" class="form-control"
                               placeholder="${specificFireLoad}"
                               value="<%=room.getParametersCalculatedFireLoad().getSpecificFireLoadZVEZDOCHKA()%>">
                    </div>
                </div>
                <% } %>
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


</form>