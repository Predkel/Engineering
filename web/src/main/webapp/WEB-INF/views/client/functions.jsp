<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<jsp:useBean id="User" scope="session" type="by.pvt.predkel.entities.User"/>
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
    <div class="row masonry" data-columns>
        <div class="item">
            <div class="thumbnail">
                <a href="${pageContext.request.contextPath}/client/tohistory"><img
                        src="${pageContext.request.contextPath}/asserts/images/buildings.png" alt=""/></a>
                <div class="caption">
                    <h3><a href="${pageContext.request.contextPath}/client/tohistory"><s:message
                            code="functions.history"/></a></h3>
                    <p><s:message code="functions.history.discription"/></p>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="thumbnail">
                <a href="${pageContext.request.contextPath}/client/tocalculate"><img
                        src="${pageContext.request.contextPath}/asserts/images/calculate.png" alt=""/></a>
                <div class="caption">
                    <h3><a href="${pageContext.request.contextPath}/client/tocalculate"><s:message
                            code="functions.calculation"/></a></h3>
                    <p><s:message code="functions.calculation.discription"/></p>
                </div>
            </div>
        </div>

        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <div class="item">
                <div class="thumbnail">
                    <a href="${pageContext.request.contextPath}/admin/toregister"><img
                            src="${pageContext.request.contextPath}/asserts/images/register.png" alt=""/></a>
                    <div class="caption">
                        <h3><a href="${pageContext.request.contextPath}/admin/toregister"><s:message
                                code="functions.register"/></a></h3>
                        <p><s:message code="functions.register.discription"/></p>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="thumbnail">
                    <a href="${pageContext.request.contextPath}/admin/tomaterials"><img
                            src="${pageContext.request.contextPath}/asserts/images/substances.png" alt=""/></a>
                    <div class="caption">
                        <h3><a href="${pageContext.request.contextPath}/admin/tomaterials"><s:message
                                code="functions.substances"/></a></h3>
                        <p><s:message code="functions.substances.discription"/></p>
                    </div>
                </div>
            </div>
        </sec:authorize>
    </div>

    <br/>
    <br/>
    <br/>

</div>