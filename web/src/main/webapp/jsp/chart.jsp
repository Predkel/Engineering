<%@ page import="by.pvt.predkel.parameters.Attributes" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
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
<%--<div id="slick-login">--%>
<%--<c:forEach items="${chartNames}" var="name">--%>
<%--<IMG SRC="${filepath}/${name}" WIDTH="600" HEIGHT="400" BORDER="0" USEMAP="#chart">--%>
<%--</c:forEach>--%>
<%--<br>--%>
<%--<a href="${filepath}/${buildName}.docx" download><button>Скачать отчет</button></a>--%>
<%--<br>--%>


<%--<a href=# onclick="history.back(); return false;">Вернуться назад</a>--%>

<%--</div>--%>

<%--<div id="carousel" class="carousel slide">--%>
<!--Индикаторы слайдов-->
<%--<ol class="carousel-indicators">--%>
<%--<c:forEach var="i" begin="0" end="${size-1}">--%>
<%--<li data-target="#carousel" data-slide-to="${i}"></li>--%>
<%--</c:forEach>--%>
<%--</ol>--%>

<%--<div class="carousel-inner">--%>

<%--<c:forEach items="${chartNames}" var="name">--%>
<%--<div class="item">--%>
<%--<img src="jsp/other/${name}" WIDTH="600" HEIGHT="400" BORDER="0" alt="">--%>
<%--<div class="carousel-caption">--%>
<%--<h3></h3>--%>
<%--<p></p>--%>
<%--</div>--%>
<%--</div>--%>
<%--</c:forEach>--%>
<%--</div>--%>
<%--<!--Слайды-->--%>

<%--</div>--%>
<%--<!--Стрелки переключения слайдов-->--%>
<%--<a href="#carousel" class="left carousel-control" data-slide="prev">--%>
<%--<span class="glyphicon glyphicon-chevron-left"></span>--%>
<%--</a>--%>
<%--<a href="#carousel" class="right carousel-control" data-slide="next">--%>
<%--<span class="glyphicon glyphicon-chevron-right"></span>--%>
<%--</a>--%>
<%--</div>--%>
<% if (request.getAttribute(Attributes.ERROR)!= null) { %>
<div class="row">
    <div class="col-md-2">

    </div>
    <div class="col-md-8">
        <h3>${error}</h3>
    </div>
    <div class="col-md-2">

    </div>
</div>
<% } else {%>
<br>
<br>
<br>
<% } %>
<div class="row">
    <div class="col-md-3">

    </div>
    <div class="col-md-6">
        <c:forEach items="<%=session.getAttribute(Attributes.NAME_OF_CHARTS)%>" var="name">
            <img src="jsp/other/${name}" WIDTH="600" HEIGHT="400" BORDER="0" alt="">
        </c:forEach>
        <br>
        <a href="jsp/other/<%=session.getAttribute(Attributes.NAME_OF_BUILDING)%>.docx" download>
            <button class="btn btn-block btn-lg btn-primary">${download}</button>
        </a>

        <% if ((Boolean) session.getAttribute(Attributes.SAVE_BUILDING)) { %>
        <a href="controller?command=savereport">
            <button class="btn btn-block btn-lg btn-primary">${save}</button>
        </a>
        <% } %>
        <a href="controller?command=torecalculate">
            <button class="btn btn-block btn-lg btn-primary">${change}</button>
        </a>
    </div>
    <div class="col-md-3">

    </div>
</div>


<%@ include file="parts/bottom.jsp" %>