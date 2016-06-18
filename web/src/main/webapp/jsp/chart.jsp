<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<jsp:useBean id="buildName" class="java.lang.String" scope="session"/>
<jsp:useBean id="error" class="java.lang.String" scope="request"/>
<jsp:useBean id="chartNames" class="java.util.ArrayList" scope="session"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="locales.local" var="loc"/>
<fmt:message bundle="${loc}" key="result" var="result"/>
<fmt:message bundle="${loc}" key="result.change" var="change"/>
<fmt:message bundle="${loc}" key="result.download" var="download"/>
<fmt:message bundle="${loc}" key="result.save" var="save"/>

<%@ include file="parts/links.jsp" %>
<title>${result}</title>
<%@ include file="parts/header.jsp" %>

<br>
<br>
<br>
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
    <div class="col-md-3">

    </div>
    <div class="col-md-6">
        <c:forEach items="${chartNames}" var="name">
            <img src="jsp/other/${name}" WIDTH="600" HEIGHT="400" BORDER="0" alt="">
        </c:forEach>
        <br>
        <a href="jsp/other/<c:out value="${buildName}"/>.docx" download>
            <button class="btn btn-block btn-lg btn-primary">${download}</button>
        </a>

        <c:if test="${saveBuilding}">
            <a href="controller?command=savereport">
                <button class="btn btn-block btn-lg btn-primary">${save}</button>
            </a>
        </c:if>

        <a href="controller?command=torecalculate">
            <button class="btn btn-block btn-lg btn-primary">${change}</button>
        </a>
    </div>
    <div class="col-md-3">

    </div>
</div>


<%@ include file="parts/bottom.jsp" %>