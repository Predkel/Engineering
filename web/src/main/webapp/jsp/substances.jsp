<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%--<jsp:useBean id="substances" class="java.util.ArrayList" scope="session"/>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="locales.local" var="loc"/>
<fmt:message bundle="${loc}" key="material" var="material"/>
<fmt:message bundle="${loc}" key="material.new" var="newMaterial"/>
<fmt:message bundle="${loc}" key="material.name" var="name"/>
<fmt:message bundle="${loc}" key="material.air" var="air"/>
<fmt:message bundle="${loc}" key="material.heat" var="heat"/>
<fmt:message bundle="${loc}" key="material.speed" var="speed"/>
<fmt:message bundle="${loc}" key="material.send" var="send"/>
<%@ include file="parts/links.jsp" %>
<script src="jsp/js/validate.js"></script>
<title>${material}</title>
<%@ include file="parts/header.jsp" %>
<div class="row">
    <div class="col-md-2">

    </div>
    <div class="col-md-8">
        <h3>${error}</h3>
    </div>
    <div class="col-md-2">

    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <form class="col-md-12 center-block" action="controller" method="POST">
                <input type="hidden" name="command" value="SUBSTANCES">
                <div id="accordion" class="panel-group">
                    <c:forEach items="${substances}" var="sub">

                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a href="#collapse-${sub.id}" data-parent="#accordion"
                                       data-toggle="collapse">${sub.nameOfSubstance}</a>
                                </h4>
                            </div>
                            <div id="collapse-${sub.id}" class="panel-collapse collapse">
                                <div class="panel-body">

                                    <input type="hidden" name="idSubstance" value="${sub.id}">

                                    <div class="form-group">
                                        <label>Наименование:</label>
                                        <input type="text" name="nameOfSubstance" class="form-control"
                                               placeholder="Наименование" value="${sub.nameOfSubstance}">
                                    </div>
                                    <div class="form-group">
                                        <label>Количество воздуха для выгорания:</label><br>
                                        <input type="text" name="amountOfCombustionAir" class="form-control"
                                               placeholder="${air}" value="${sub.amountOfCombustionAir}">
                                    </div>
                                    <div class="form-group">
                                        <label>Низшая теплота сгорания:</label>
                                        <input type="text" name="combustionHeat" class="form-control"
                                               placeholder="${heat}" value="${sub.combustionHeat}">
                                    </div>
                                    <div class="form-group">
                                        <label>Скорость выгорания:</label>
                                        <input type="text" name="averageSpeedBurnout" class="form-control"
                                               placeholder="${speed}" value="${sub.averageSpeedBurnout}">
                                    </div>
                                </div>
                            </div>
                        </div>

                    </c:forEach>
                    <!--Поля для нового материала-->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="#collapse-0" data-parent="#accordion" data-toggle="collapse">${newMaterial}</a>
                            </h4>
                        </div>
                        <div id="collapse-0" class="panel-collapse collapse">
                            <div class="panel-body">

                                <input type="hidden" name="idSubstance">

                                <div class="form-group">
                                    <label>Наименование:</label>
                                    <input type="text" name="nameOfSubstance" class="form-control"
                                           placeholder="Наименование">
                                </div>
                                <div class="form-group">
                                    <label>Количество воздуха для выгорания:</label><br>
                                    <input type="text" name="amountOfCombustionAir" class="form-control"
                                           placeholder="${air}">
                                </div>
                                <div class="form-group">
                                    <label>Низшая теплота сгорания:</label>
                                    <input type="text" name="combustionHeat" class="form-control"
                                           placeholder="${heat}">
                                </div>
                                <div class="form-group">
                                    <label>Скорость выгорания:</label>
                                    <input type="text" name="averageSpeedBurnout" class="form-control"
                                           placeholder="${speed}">
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="form-group">
                    <input type="submit" onclick="validateSubstance(this.form)" class="btn btn-block btn-primary"
                           value="${send}">
                </div>
            </form>
        </div>
        <div class="col-md-6">

        </div>
    </div>
</div>

<%@ include file="parts/bottom.jsp" %>