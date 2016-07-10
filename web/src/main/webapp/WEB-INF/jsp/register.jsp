<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="error" class="java.lang.String" scope="request"/>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="locales.local" var="loc"/>
<fmt:message bundle="${loc}" key="registration" var="registration"/>
<fmt:message bundle="${loc}" key="registration.register" var="register"/>
<fmt:message bundle="${loc}" key="login.login" var="login"/>
<fmt:message bundle="${loc}" key="login.password" var="password"/>
<fmt:message bundle="${loc}" key="user" var="user"/>
<fmt:message bundle="${loc}" key="administrator" var="administrator"/>
<%@ include file="parts/links.jsp" %>
<script src="../../jsp/js/validate.js"></script>
<title>${registration}</title>
<%@ include file="parts/header.jsp" %>
<!--<form id="slick-login" action="controller" method="POST">
<input type="hidden" name="command" value="registration" />
<label for="username">Логин:</label><input type="text" id="username" name="username" class="placeholder" placeholder="Логин">
<label for="password">Пароль:</label><input type="password" id="password" name="password" class="placeholder" placeholder="Пароль">
<select id="role" name="role">
<option value="0">Пользователь</option>
<option value="1">Администратор</option>
</select>
<input type="submit" value="Зарегистрировать">
</form>-->
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
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <h1 class="text-center">${registration}</h1>
        </div>
        <div class="modal-body">
            <form class="col-md-12 center-block" action="registration" method="POST">

                <div class="form-group">
                    <input type="text" name="login" class="form-control input-lg" placeholder="${login}">
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control input-lg" placeholder="${password}">
                </div>
                <div class="form-group">
                    <select class="selectpicker form-control select-lg" name="role">
                        <option value="0">${user}</option>
                        <option value="1">${administrator}</option>
                    </select>
                </div>
                <div class="form-group">
                    <input type="submit" onclick="validateUser(this.form)" class="btn btn-block btn-lg btn-primary"
                           value="${register}">
                </div>
            </form>
            <div class="modal-footer">
                <!--<div class="col-md-12">
                </div>-->
            </div>
        </div>
    </div>
</div>
</div>
<%@ include file="parts/bottom.jsp" %>