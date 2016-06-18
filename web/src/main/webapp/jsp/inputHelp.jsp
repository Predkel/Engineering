
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="User" class="by.pvt.predkel.entities.User" scope="session"/>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="parts/links.jsp" %>
<title>Помощь. Ввод данных</title>
<%@ include file="parts/header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-2">

        </div>
        <div class="col-md-8">
            <h3>${error}</h3>
            <c:if test="${User.role==1}">
            <h3>Регистрация пользователя</h3>
            <p>На форме регистрации нового пользователя присутствуют три поля для ввода данных. Пример на рис. 1
                <br>
                <img src="jsp/images/register1.png" alt="форма регистрации" WIDTH="600" HEIGHT="400">
                <br>
                Поля "Логин" и "Пароль" вводятся администратором вручную. А поле "Пользователь" необходимо
                выбрать из двух возможных вариантов: "Администратор" или "Пользователь". Тем самым вы определяете роль
                данного пользователя в системе. При некорректном вводе данных: Логин занят или какое-то из полей пустое
                вы увидите соответствующее сообщение. Пример рис. 2
                <br>
                <img src="jsp/images/register2.png" alt="ошибка на форме регистрации" WIDTH="600" HEIGHT="400">
                <br>
                Если все действия выполнены правильно и вы вернетесь на главную страницу со списком доступных функций.
            </p>
            <h3>Список материалов</h3>
            <p>Первоначально страница списка материалов выглядит примерно так: пример на рис. 3
                <br>
                <img src="jsp/images/substance1.png" alt="список материалов" WIDTH="600" HEIGHT="400">
                <br>
                Для изменения или удаления уже существующего материала необходимо выбрать его из доступного списка.
                При этом откроются поле с характеристиками данного материала: пример рис.4.
                <br>
                <img src="jsp/images/substance2.png" alt="характеристики материала" WIDTH="600" HEIGHT="400">
                <br>
                Администратор, имеющий доступ к данной странице, может изменить любой параметр из перечисленных.
                Если же необходимо удалить один из материалов достаточно оставить одно из его полей пустым.
                Также в конце списка есть раздел для добавления нового материала в список. Все поля данного раздела
                должны быть заполнены, иначе изменения не вступят в силу.
                <br>
                <img src="jsp/images/substance3.png" alt="форма нового материала" WIDTH="600" HEIGHT="400">
                <br>
                Если все действия выполнены правильно вы вернетесь на главную страницу со списком доступных функций.
                При допущении ошибки при редактировании списка материалов будет предоставлено соответствующее сообщение:
                пример рис. 6
                <br>
                <img src="jsp/images/substance4.png" alt="ошибка формы материалов" WIDTH="600" HEIGHT="400">
                <br>
            </p>
            </c:if>
            <h3>История расчетов</h3>
            <p>При входе на данную страницу вы увидите список созданных вами ранее расчетов. Пример на рис.7
                <br>
                <img src="jsp/images/history1.png" alt="список ранее созданных расчетов" WIDTH="600" HEIGHT="400">
                <br>
                Напротив каждого расчета есть кнопка в которой можно выбрать действие (сохранить или удалить)
                При выборе функции "Удалить" расчет исезнет из списка и базы данных. Если выбрать "Сохранить"
                вы перейдете на страницу предпросмотра результат. Рис. 8
                <br>
                <img src="jsp/images/result.png" alt="предпросмотр результата" WIDTH="600" HEIGHT="400">
                <br>
                На данной странице вы можете скачать отчет, нажав на кнопку "Скачать отчет"
            </p>
            <h3>Новый расчет</h3>
            <p>При входе на данную страницу вы увидите множество форм, необходимых для расчета. Пример на рис.7
                <br>
                <img src="jsp/images/calculation1.png" alt="формы для здания нового расчета" WIDTH="600" HEIGHT="400">
                <br>
                Все поля на изображении являются обязательными. Во всплывающих списках вы должны выбрать
                характеристики, характерные всему зданию. После заполнения поля "Количество помещений"
                появятся ссылки для каждого помещения. Рис. 8
                <br>
                <img src="jsp/images/calculation2.png" alt="Ссылки на помещения" WIDTH="600" HEIGHT="400">
                <br>
                При нажатии на каждую из этих ссылок, под ними появится поле со всеми необходимыми формами
                для расчета. Рис. 9
                <br>
                <img src="jsp/images/calculation3.png" alt="Формы помещения" WIDTH="600" HEIGHT="400">
                <br>
                <img src="jsp/images/calculation4.png" alt="Формы помещения" WIDTH="600" HEIGHT="400">
                <br>
                Все поля здесь также обязательные, за одним исключением, если в форме написано "Возм. авт. расч."
                то заполнение данного поля не обязательно и они рассчитаются автоматически в программе.
                Также при заполнении полей проемов и горючих материалов, необходимо заполнить столько полей, сколько
                необходимо. И самое последнее поле "Удельная пожарная нагрузка" обязательно для заполнения только
                в случае, если вы не указали ни одного горючего материала. Если же вы ввели и то и другое, то расчет
                будет производиться по горючим материалам.
                <br>
                После заполнения всех полей, необходимо нажать на кнопку "Отправить", после чего вы прейдете на страницу
                предпросмотра результата.
                <br>
                <img src="jsp/images/result.png" alt="предпросмотр результата" WIDTH="600" HEIGHT="400">
                <br>
                На данной странице вы можете скачать отчет, нажав на кнопку "Скачать отчет"
            </p>
        </div>
        <div class="col-md-2">

        </div>
    </div>
</div>


<%@ include file="parts/bottom.jsp" %>
