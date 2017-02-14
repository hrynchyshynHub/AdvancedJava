<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="/css/loginpage.css">
<style>
    nav{
        display: block;
        margin: 0;
        height: 70px;
    }
    </style>
<div class="container">
    <form:form class="form-horizontal" modelAttribute="user" action="/saveUser" method="post">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Your Name</label>
            <div class="col-sm-4 col-xs-12">
                <form:input type="text" class="form-control" path = "firstName" placeholder="Your name"/>
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Your Surname</label>
            <div class="col-sm-4 col-xs-12">
                <form:input type="text" class="form-control" path = "secondName" placeholder="Your surname"/>
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Age</label>
            <div class="col-sm-4 col-xs-12">
                <form:input type="number" class="form-control" path="age" placeholder="age"/>
            </div>
        </div>
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-4 col-xs-12">
                <form:input type="email" class="form-control" path="email" id = "inputEmail3" placeholder="Email"/>
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-4 col-xs-12">
                <form:input type="password" class="form-control" id="inputPassword3" path="password" placeholder="Password"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default" id = "register">Register</button>
            </div>
        </div>
    </form:form>
</div>
<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />
