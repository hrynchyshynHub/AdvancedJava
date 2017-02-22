<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
<form:form class="form-horizontal" action="/saveChanged" modelAttribute="user" method="post">
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">Ім*я</label>
        <div class="col-sm-10">
            <form:input path="firstName" type="text" class="form-control" id="inputEmail3" placeholder="ім*я"/>
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">Прізвище</label>
        <div class="col-sm-10">
            <form:input path="secondName" type="text" class="form-control"  placeholder="Прізвище"/>
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">Вік</label>
        <div class="col-sm-10">
            <form:input path="age" type="number" class="form-control" placeholder="вік"/>
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">Місто</label>
        <div class="col-sm-10">
            <form:input type="text" class="form-control" placeholder="Місто" path="city"/>
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">Статус</label>
        <div class="col-sm-10">
            <form:input type="text" class="form-control"  placeholder="статус" path="status"/>
        </div>
    </div>
    <div class="form-group">
        <label for="inputEmail3" class="col-sm-2 control-label">Номер телефону</label>
        <div class="col-sm-10">
            <form:input type="number" class="form-control"  placeholder="номер телефону" path="phoneNumber"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Change</button>
        </div>
    </div>
</form:form>
</div>