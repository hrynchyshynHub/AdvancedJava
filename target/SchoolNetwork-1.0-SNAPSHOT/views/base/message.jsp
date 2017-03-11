<%--
  Created by IntelliJ IDEA.
  User: ваня
  Date: 04.03.2017
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Повідомлення</title>
    <link rel="stylesheet" href="/css/message.css">
</head>
<script>
    function close() {
        $('#modal_form')
                .animate({opacity: 0, top: '45%'}, 200,  // плaвнo меняем прoзрaчнoсть нa 0 и oднoвременнo двигaем oкнo вверх
                        function () { // пoсле aнимaции
                            $(this).css('display', 'none'); // делaем ему display: none;
                            $('#overlay').fadeOut(400); // скрывaем пoдлoжку
                        }
                );
    }
</script>
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
            <div class="well" id="well">

            </div>
        </div>
    </div>
</div>
<c:forEach var ="user" items="${users}">${user.firstName}</c:forEach>

<div id="modal_form">
    <span id="modal_close" onclick="close()">X</span>
<form action="sendMessage" method="post">
    <p>Нове повідомлення</p>
    <select name="idUserTo">
        <c:forEach var="user" items="${users}">
            <option value="${user.id}">${user.firstName}</option>
        </c:forEach>
    </select>
    <textarea name="message" id="message" placeholder="Your message goes here..."></textarea>
    <p class="clearfix">
    <button class="btn btn-success">Надіслати</button>
    </p>
</form>
</div>

<div id="overlay"></div><!-- Пoдлoжкa -->
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
               for(var i = 0 ; i<res.length; i++){
                   var index = res[i].id;
                   document.getElementById('well').innerHTML += '<div class="media">'+
                          '<div class="media-left">'+
                           '<a href="#"><img class="media-object img-circle" src="http://lorempixel.com/70/70" alt="">'+
                           '</a></div><div class="media-body"> ' +
                           '<h4 class="media-heading">'+res[i].userFrom+'<span class="pull-right time"' +
                           'style="font-size:13px;">16:33</span></h4><a href = "/im/' + index + '">'+ res[i].message +
                           '</a><hr></div></div>';

               }
           }

       })
   }

   function writeMessage(){
       $('#overlay').fadeIn(400,
               function () {
                   $('#modal_form')
                           .css('display', 'block')
                           .animate({opacity: 1, top: '50%'}, 200);
               });


   }




</script>