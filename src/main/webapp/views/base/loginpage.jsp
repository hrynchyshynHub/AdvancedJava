<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="/css/loginpage.css">


<div class="container">
    ${fail}
    <form:form class="form-horizontal" action="loginprocesing" method="post">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-4 col-xs-12">
                <input name = "username" type="text" class="form-control" id="inputEmail3"  placeholder="Email">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
            <div class="col-sm-4 col-xs-12">
                <input name = "password" type="password" class="form-control" id="inputPassword3" placeholder="Password">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Remember me
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default" id="login">Sign in</button>
            </div>
        </div>
    </form:form>
</div>
<script>
    document.getElementById('login').onclick = function () {
        if(document.getElementById('inputEmail3').value == ''){
            console.log("empty field");
        }
    }
</script>