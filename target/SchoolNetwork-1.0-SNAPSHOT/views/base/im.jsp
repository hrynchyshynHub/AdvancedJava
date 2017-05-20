<%--
  Created by IntelliJ IDEA.
  User: ваня
  Date: 25.04.2017
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:csrfMetaTags />

<div class="idDialog"></div>
    <div class="container">
   <%-- <form:form action="sendMessage" method="post">
        <div class="input-group post-input">
            <textarea name="message"
                      class="form-control custom-control" id = "text" rows="3" style="resize:none"></textarea>
            <button class="input-group-addon btn btn-success" type="submit" id = "send">Надіслати</button>
        </div>
    </form:form>--%>
       <input type="hidden" name="csrf_name"
              value="${_csrf.parameterName}" />
       <input type="hidden" name="csrf_value"
              value="${_csrf.token}" />

       <div class="input-group post-input">
           <form>
               <textarea class="form-control custom-control"
                         id = "message-textarea" rows="3" style="resize:none"></textarea>
               <span class="input-group-addon btn btn-success" id = "send-button">Надіслати</span>
           </form>
       </div>
    </div>
<script>

    window.onload = function () {
        $('#send-button').click(function() {
            var url = location.href.split('/');
            var id = url[url.length-1];
            var message = {
                message: document.getElementById('message-textarea').value,
                dialogId:id
            }
            $.ajax({
                url: '/messageSend?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
                method: 'POST',
                contentType: 'application/json; charset=UTF-8',
                data: JSON.stringify(message),
                success: function (res) {
                    alert(res);
                }
            });
        });
    }

</script>
