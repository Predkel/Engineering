<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<jsp:useBean id="buildings" class="java.util.ArrayList" scope="request"/>
<jsp:useBean id="error" class="java.lang.String" scope="request"/>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="locales.local" var="loc"/>
<fmt:message bundle="${loc}" key="history" var="history"/>
<fmt:message bundle="${loc}" key="history.name" var="name"/>
<fmt:message bundle="${loc}" key="history.date" var="date"/>
<fmt:message bundle="${loc}" key="history.choose" var="choose"/>
<fmt:message bundle="${loc}" key="history.action" var="action"/>
<fmt:message bundle="${loc}" key="history.save" var="save"/>
<fmt:message bundle="${loc}" key="history.delete" var="delete"/>


<%@ include file="parts/links.jsp" %>
<title>${history}</title>
<%@ include file="parts/header.jsp" %>
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
        <b>
            <div class=col-md-4>${name}</div>
            <div class=col-md-4>${date}</div>
            <div class=col-md-4>${action}</div>
        </b>
    </div>
    <br>
    <%--<%=request.getContextPath()%>--%>
    <%--<%=request.getRequestURI()%>--%>
    <%--<%=request.getRequestURL()%>--%>
    <%--<%=request.getRemoteUser()%>--%>
    <%--<%=request.getServletPath()%>--%>
    <%--<%=request.getServletContext()%>--%>
    <%--<%=request.getScheme()%>--%>
    <%--<%=request.getContentType()%>--%>
    <%--<%=request.getLocale()%>--%>
    <c:forEach items="${buildings}" var="build">
        <div class="row">
            <form action="controller" method="GET">
                <input type="hidden" name="command" value="buildings">
                <input type="hidden" name="idBuilding" value="${build.id}">
                <div class="col-md-4">
                    <div class="form-group">
                        <input type="text" class="form-control" value="${build.nameOfBuilding}" readonly>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="form-group">
                        <input type="text" class="form-control" value="${build.dateOfBuilding}" readonly>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="btn-group">
                        <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                ${choose}<span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li>
                                <button value="save" name="buildingAction" class="btn btn-default"
                                        type="submit">${save}</button>
                            </li>
                            <li>
                                <button value="delete" name="buildingAction" class="btn btn-default"
                                        type="submit">${delete}</button>
                            </li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </c:forEach>
</div>

<%@ include file="parts/bottom.jsp" %>