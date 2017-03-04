<%--
  Created by IntelliJ IDEA.
  User: ваня
  Date: 04.03.2017
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Повідомлення</title>
</head>
<div class="container">
    <div class="row">
        <div class="col-sm-3">
            <div class="well">
                <a onclick="inputMessage()">Вхідні</a><br>
                <a onclick="outputMessage()">Вихідні</a><br>
                <a onclick="writeMessage()">Написати повідомлення</a><br>
            </div>
        </div>
        <div class="col-sm-9">
            <div class="well">
                <div class="media">
                    <div class="media-left">
                        <a href="#">
                            <img class="media-object img-circle" src="http://lorempixel.com/70/70" alt="">
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">Vanya Hrynchyshyn  <span class="pull-right time"
                                                                           style="font-size:13px;">16:33</span></h4>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Libero, consectetur maxime dolorum recusandae aperiam ducimus tempora minima nam magni adipisci corporis eius eum doloremque, cum a dolore, facere alias perferendis.
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />
<script>
   window.onload = function () {
       $.ajax({
           url: 'loadMessage?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
           method: 'POST',
           contentType: 'application/json; charset=UTF-8',
           dataType: 'json',
           success: function(res){
               document.getElementById('well').innerHTML = res;
           }

       })
   }
   function writeMessage() {

   }
</script>