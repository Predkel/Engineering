<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu">
                <span class="sr-only"><s:message var="choose" code="header.navigation"/></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="http://www.engin.by" class="navbar-brand">
                <img src="${pageContext.request.contextPath}/asserts/images/logo.png" alt="Logo"/>
            </a>
        </div>
        <div class="collapse navbar-collapse" id="responsive-menu">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/tofunctions"><s:message var="choose"
                                                                                        code="header.toMain"/></a></li>
                <li><a href="${pageContext.request.contextPath}/logout"><s:message var="choose"
                                                                                   code="header.signOut"/></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><s:message var="choose"
                                                                                          code="header.myHelp"/><b
                            class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/tohelp"><s:message var="choose"
                                                                                           code="header.dataInput"/></a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/setlanguage?language=en">
                        <img src="${pageContext.request.contextPath}/asserts/images/uk.png" alt=""/>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/setlanguage?language=ru">
                        <img src="${pageContext.request.contextPath}/asserts/images/rus.png" alt=""/>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/setlanguage?language=be">
                        <img src="${pageContext.request.contextPath}/asserts/images/by.png" alt=""/>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>