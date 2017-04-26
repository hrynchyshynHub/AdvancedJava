<%--
  Created by IntelliJ IDEA.
  User: ваня
  Date: 25.04.2017
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="container">
        <c:forEach var  = "message" items="${messages}">
            ${message.message}
        </c:forEach>
        <div id = "messages_container"></div>
        <div class="input-group post-input">
            <textarea class="form-control custom-control" id = "text" rows="3" style="resize:none"></textarea>
            <span class="input-group-addon btn btn-success" id = "post">Надіслати</span>
        </div>

    </div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>

   <script>
       document.onload = function () {

           document.getElementById('post').onclick = function () {
               var message = {
                   message: document.getElementById('text').value
               }
               $.ajax({
                   url:'sendMessage/?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
                   method: 'POST',
                   contentType: 'application/json; charset=UTF-8',
                   dataType: 'json',
                   data: JSON.stringify(message),
                   success: function (res) {
                       alert(res);
                       var message = '<div>' +
                               'res.userFrom' +
                               'res.message' +
                               'res.date'+
                                       '</div>'
                       $('#messages_container').append(message);
                   }
               })

           }
       }

   </script>
