<%@ page import="by.pvt.predkel.parameters.Attributes" %>
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.math.RoundingMode" %>
<%@ page import="by.pvt.predkel.entities.FlammableSubstance" %>
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
<fmt:message bundle="${loc}" key="material.change.size" var="size"/>
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
    <form class="center-block" action="controller" method="POST">
        <input type="hidden" name="command" value="substances">
        <div class="row">

            <div class="col-md-6">
                <%
                    List t = (List<Object>) request.getAttribute("substances");
                    int size = t.size();
                    int firstHalf = new BigDecimal(size / 2).setScale(0, RoundingMode.UP).intValue();
                %>
                <div id="accordion" class="panel-group">
                    <%for (int m = 0; m < firstHalf; m++) {%>
                    <%FlammableSubstance sub = (FlammableSubstance) t.get(m);%>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="#collapse-<%=sub.getId()%>" data-parent="#accordion"
                                   data-toggle="collapse"><%=sub.getNameOfSubstance()%>
                                </a>
                            </h4>
                        </div>
                        <div id="collapse-<%=sub.getId()%>" class="panel-collapse collapse">
                            <div class="panel-body">

                                <input type="hidden" name="idSubstance" value="<%=sub.getId()%>">

                                <div class="form-group">
                                    <label>${name}</label>
                                    <input type="text" name="nameOfSubstance" class="form-control"
                                           placeholder="${name}" value="<%=sub.getNameOfSubstance()%>">
                                </div>
                                <div class="form-group">
                                    <label>${air}</label><br>
                                    <input type="text" name="amountOfCombustionAir" class="form-control"
                                           placeholder="${air}" value="<%=sub.getAmountOfCombustionAir()%>">
                                </div>
                                <div class="form-group">
                                    <label>${heat}</label>
                                    <input type="text" name="combustionHeat" class="form-control"
                                           placeholder="${heat}" value="<%=sub.getCombustionHeat()%>">
                                </div>
                                <div class="form-group">
                                    <label>${speed}</label>
                                    <input type="text" name="averageSpeedBurnout" class="form-control"
                                           placeholder="${speed}" value="<%=sub.getAverageSpeedBurnout()%>">
                                </div>
                            </div>
                        </div>
                    </div>

                    <%}%>
                </div>
            </div>
            <div class="col-md-6">
                <div id="accordion2" class="panel-group">
                    <%for (int m = firstHalf; m < size; m++) {%>
                    <%FlammableSubstance sub = (FlammableSubstance) t.get(m);%>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="#collapse-<%=sub.getId()%>" data-parent="#accordion2"
                                   data-toggle="collapse"><%=sub.getNameOfSubstance()%>
                                </a>
                            </h4>
                        </div>
                        <div id="collapse-<%=sub.getId()%>" class="panel-collapse collapse">
                            <div class="panel-body">

                                <input type="hidden" name="idSubstance" value="<%=sub.getId()%>">

                                <div class="form-group">
                                    <label>${name}</label>
                                    <input type="text" name="nameOfSubstance" class="form-control"
                                           placeholder="${name}" value="<%=sub.getNameOfSubstance()%>">
                                </div>
                                <div class="form-group">
                                    <label>${air}</label><br>
                                    <input type="text" name="amountOfCombustionAir" class="form-control"
                                           placeholder="${air}" value="<%=sub.getAmountOfCombustionAir()%>">
                                </div>
                                <div class="form-group">
                                    <label>${heat}</label>
                                    <input type="text" name="combustionHeat" class="form-control"
                                           placeholder="${heat}" value="<%=sub.getCombustionHeat()%>">
                                </div>
                                <div class="form-group">
                                    <label>${speed}</label>
                                    <input type="text" name="averageSpeedBurnout" class="form-control"
                                           placeholder="${speed}" value="<%=sub.getAverageSpeedBurnout()%>">
                                </div>
                            </div>
                        </div>
                    </div>

                    <%}%>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-2">
            </div>
            <!--Поля для нового материала-->

            <div class="col-md-8">
                <div id="accordion3" class="panel-group">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="#collapse-0" data-parent="#accordion3"
                                   data-toggle="collapse">${newMaterial}</a>
                            </h4>
                        </div>
                        <div id="collapse-0" class="panel-collapse collapse">
                            <div class="panel-body">

                                <input type="hidden" name="idSubstance">

                                <div class="form-group">
                                    <label>${name}</label>
                                    <input type="text" name="nameOfSubstance" class="form-control"
                                           placeholder="${name}">
                                </div>
                                <div class="form-group">
                                    <label>${air}</label><br>
                                    <input type="text" name="amountOfCombustionAir" class="form-control"
                                           placeholder="${air}">
                                </div>
                                <div class="form-group">
                                    <label>${heat}</label>
                                    <input type="text" name="combustionHeat" class="form-control"
                                           placeholder="${heat}">
                                </div>
                                <div class="form-group">
                                    <label>${speed}</label>
                                    <input type="text" name="averageSpeedBurnout" class="form-control"
                                           placeholder="${speed}">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <input type="submit"
                    <%--onclick="validateSubstance(this.form)" --%>
                           class="btn btn-block btn-primary"
                           value="${send}">
                </div>
            </div>

            <div class="col-md-2">
            </div>
        </div>
        <%int thisPage = (Integer) request.getAttribute(Attributes.PAGE);%>
        <input type="hidden" name="amountOfSubstances" value="<%=size%>">
        <input type="hidden" name="page" value="<%=thisPage%>">
    </form>


    <%int betweenNumbers = 4;%>
    <%int firstPage = 1;%>

    <%int earlyPage = thisPage - betweenNumbers;%>
    <%int previousPage = thisPage - 1;%>
    <%int nextPage = thisPage + 1;%>
    <%int laterPage = thisPage + betweenNumbers;%>
    <%int lastPage = (Integer) request.getAttribute(Attributes.COUNT_OF_PAGES);%>
    <div class="row">
        <div class="center-block">
            <%if (lastPage == firstPage) { %>
            <span><%=thisPage%></span>
            <%} else if (lastPage > firstPage) { %>

            <% if (thisPage > firstPage + betweenNumbers) { %>
            <a href="controller?command=tosubstances&page=1">1</a>

            <span>...</span>

            <c:forEach var="i" begin="<%=earlyPage%>" end="<%=previousPage%>">
                <a href="controller?command=tosubstances&page=${i}">${i}</a>
            </c:forEach>

            <% } else if ((thisPage <= firstPage + betweenNumbers) && (thisPage >= firstPage)) {%>
            <c:forEach var="i" begin="1" end="<%=previousPage%>">
                <a href="controller?command=tosubstances&page=${i}">${i}</a>
            </c:forEach>
            <% } %>

            <span><%=thisPage%></span>

            <% if (laterPage < lastPage) { %>
            <c:forEach var="i" begin="<%=nextPage%>" end="<%=laterPage%>">
                <a href="controller?command=tosubstances&page=${i}">${i}</a>
            </c:forEach>

            <span>...</span>

            <a href="controller?command=tosubstances&page=<%=lastPage%>"><%=lastPage%>
            </a>

            <% } else if ((thisPage >= lastPage - betweenNumbers)) {%>
            <c:forEach var="i" begin="<%=nextPage%>" end="<%=lastPage%>">
                <a href="controller?command=tosubstances&page=${i}">${i}</a>
            </c:forEach>
            <% } %>
            <% } %>
            <span class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <button class="btn btn-primary">${size}</button><b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="controller?command=setsize&paginationSize=2">2</a></li>
                    <li><a href="controller?command=setsize&paginationSize=4">4</a></li>
                    <li><a href="controller?command=setsize&paginationSize=6">6</a></li>
                    <li><a href="controller?command=setsize&paginationSize=8">8</a></li>
                    <li><a href="controller?command=setsize&paginationSize=10">10</a></li>
                    <li><a href="controller?command=setsize&paginationSize=16">16</a></li>
                    <li><a href="controller?command=setsize&paginationSize=20">20</a></li>
                </ul>
            </span>
            <br>
            <br>
        </div>
        <%--<form class="center-block" action="controller" method="POST">--%>
        <%--<input type="hidden" name="command" value="setsize">--%>
        <%--<select name="paginationSize" class="selectpicker form-control select-lg">--%>
        <%--<optgroup label="Размерность"></optgroup>--%>
        <%--<option value="2">2</option>--%>
        <%--<option value="4">4</option>--%>
        <%--<option value="6">6</option>--%>
        <%--<option value="8">8</option>--%>
        <%--<option value="10">10</option>--%>
        <%--<option value="16">16</option>--%>
        <%--<option value="20">20</option>--%>
        <%--</select>--%>
        <%--<div class="form-group">--%>
        <%--<input type="submit" class="btn btn-block btn-primary" value="Изменить размерность">--%>
        <%--</div>--%>
        <%--</form>--%>
    </div>
</div>

<%@ include file="parts/bottom.jsp" %>