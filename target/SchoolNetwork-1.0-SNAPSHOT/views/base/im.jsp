<%--
  Created by IntelliJ IDEA.
  User: ваня
  Date: 25.04.2017
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    <div class="container">

        <div id = "messages_container">
            <c:forEach var  = "message" items="${messages}">
                ${message.message} ${message.userFrom} id Dialog = ${message.dialog.id}<br>
            </c:forEach>
        </div>
        <div class="input-group post-input">
            <textarea class="form-control custom-control" id = "text" rows="3" style="resize:none"></textarea>
           <span class="input-group-addon btn btn-success" id = "send">Надіслати</span>
        </div>

    </div>

<csrf disabled="true"/>


<script>
    document.getElementById('send').onclick = function () {
        var index = window.location.href.split('/');
        var messageDto = {
            message: document.getElementById('text').value,
            dialogId:index[index.length -1]
        }
        $.ajax({
            url:'sendMessage',
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: JSON.stringify(messageDto),
            success:function (res) {
                alert(res);
            }
        })
    }

</script>