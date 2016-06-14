<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="locales.local" var="loc"/>
<fmt:message bundle="${loc}" key="header.navigation" var="navigation"/>
<fmt:message bundle="${loc}" key="header.toMain" var="tomain"/>
<fmt:message bundle="${loc}" key="header.signOut" var="signout"/>
<fmt:message bundle="${loc}" key="header.myHelp" var="myhelp"/>
<fmt:message bundle="${loc}" key="header.dataInput" var="datainput"/>
</head>
<body>
<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu">
                <span class="sr-only">${navigation}</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="http://www.engin.by" class="navbar-brand"><img src="jsp/images/logo.png" alt="Logo"></a>
        </div>
        <div class="collapse navbar-collapse" id="responsive-menu">
            <ul class="nav navbar-nav">
                <li><a href="controller?command=tofunctions">${tomain}</a></li>
                <li><a href="controller?command=logout">${signout}</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">${myhelp}<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="controller?command=tohelp">${datainput}</a></li>
                        <%--<li><a href="#">Навигация</a></li>--%>
                    </ul>
                </li>
                <li><a href="controller?command=setlanguage&language=en"><img src="jsp/images/uk.png" alt=""></a></li>
                <li><a href="controller?command=setlanguage&language=ru"><img src="jsp/images/rus.png" alt=""></a></li>
                <li><a href="controller?command=setlanguage&language=be"><img src="jsp/images/by.png" alt=""></a></li>
            </ul>
        </div>
    </div>
</div>