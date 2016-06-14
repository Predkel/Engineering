<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="jsp/parts/links.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="locales.local" var="loc"/>
<fmt:message bundle="${loc}" key="login.authorization" var="authorization"/>
<fmt:message bundle="${loc}" key="login.login" var="login"/>
<fmt:message bundle="${loc}" key="login.password" var="password"/>
<fmt:message bundle="${loc}" key="login.signIn" var="signIn"/>

<script src="jsp/js/validate.js"></script>
<title>${authorization}</title>
</head>
<body>
<div class="row">
    <div class="col-md-2">

    </div>
    <div class="col-md-8">
        <h3>${error}</h3>
    </div>
    <div class="col-md-2">

    </div>
</div>
<%--<c:forEach var="friend_i" begin="0" end="2">--%>
<%--<h5>--%>
<%--<c:out value="${friend_i}"/>--%>
<%--</h5>--%>
<%--</c:forEach>--%>
<!--
	<form id="slick-login" action="controller" method="POST">
		<input type="hidden" name="command" value="login" />
		<label for="username">Логин:</label><input type="text" id="username" name="login" class="placeholder" placeholder="Логин">
		<label for="password">Пароль:</label><input type="password" id="password" name="password" class="placeholder" placeholder="Пароль">
		<input type="submit" value="ВОЙТИ">
	</form>

-->
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <div class="col-md-12 center-block">
                <h1 class="text-center">${authorization}</h1>
            </div>
        </div>
        <div class="modal-body">
            <form class="col-md-12 center-block" action="controller" method="POST">
                <input type="hidden" name="command" value="login">
                <div class="form-group">
                    <input type="text" class="form-control input-lg" name="login" placeholder="${login}" required>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control input-lg" name="password" placeholder="${password}"
                           required>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-block btn-lg btn-primary"
                           <%--onclick="validateUser(this.form)" --%>
                           value="${signIn}">
                </div>
            </form>
            <div class="modal-footer">
                <!--<div class="col-md-12">
                </div>-->
            </div>
        </div>
    </div>
</div>
<%@ include file="jsp/parts/bottom.jsp" %>