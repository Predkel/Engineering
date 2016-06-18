<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<jsp:useBean id="User" class="by.pvt.predkel.entities.User" scope="session"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="locales.local" var="loc"/>
<fmt:message bundle="${loc}" key="functions" var="functions"/>
<fmt:message bundle="${loc}" key="functions.history" var="history"/>
<fmt:message bundle="${loc}" key="functions.history.discription" var="historyDiscription"/>
<fmt:message bundle="${loc}" key="functions.calculation" var="calculation"/>
<fmt:message bundle="${loc}" key="functions.calculation.discription" var="calculationDiscription"/>
<fmt:message bundle="${loc}" key="functions.register" var="register"/>
<fmt:message bundle="${loc}" key="functions.register.discription" var="registerDiscription"/>
<fmt:message bundle="${loc}" key="functions.substances" var="substances"/>
<fmt:message bundle="${loc}" key="functions.substances.discription" var="substancesDiscription"/>

<%@ include file="parts/links.jsp" %>
<title>${functions}</title>
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
    <div class="row masonry" data-columns>
        <div class="item">
            <div class="thumbnail">
                <a href="controller?command=tobuildings"><img src="jsp/images/buildings.png" alt=""></a>
                <div class="caption">
                    <h3><a href="controller?command=tobuildings">${history}</a></h3>
                    <p>${historyDiscription}</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnail">
                <a href="controller?command=tocalculate"><img src="jsp/images/calculate.png" alt=""></a>
                <div class="caption">
                    <h3><a href="controller?command=tocalculate">${calculation}</a></h3>
                    <p>${calculationDiscription}</p>
                </div>
            </div>
        </div>
        <c:if test="${User.role==1}">
        <div class="item">
            <div class="thumbnail">
                <a href="controller?command=toregister"><img src="jsp/images/register.png" alt=""></a>
                <div class="caption">
                    <h3><a href="controller?command=toregister">${register}</a></h3>
                    <p>${registerDiscription}</p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnail">
                <a href="controller?command=tosubstances"><img src="jsp/images/substances.png" alt=""></a>
                <div class="caption">
                    <h3><a href="controller?command=tosubstances">${substances}</a></h3>
                    <p>${substancesDiscription}</p>
                </div>
            </div>
        </div>
        </c:if>
    </div>
</div>
<%@ include file="parts/bottom.jsp" %>