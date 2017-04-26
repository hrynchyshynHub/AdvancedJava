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

</script>

<div class="container">
    <div class="row">
        <div class="col-md-4">
            <button class="btn btn-info btn-lg" type="button" data-toggle="modal" data-target="#myModal">Створити діалог</button>
            <div id="myModal" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header"><button class="close" type="button" data-dismiss="modal">×</button>
                            <h4 class="modal-title">Новий діалог</h4>
                        </div>
                        <div class="modal-body">
                           <form:form action="createDialog"  method="post">
                               <h6>Додайте учасників в діалог</h6>
                           <select multiple="multiple" name="usersId">
                               <c:forEach var="user" items="${users}">
                                   <option value="${user.id}">${user.secondName}</option>
                               </c:forEach>
                           </select>

                            <input type="text" placeholder="назва бесіди" name="name"/>
                               <button type="submit">Створити</button>
                           </form:form>
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-default" type="button" data-dismiss="modal">Закрыть</button></div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-8">
            <c:forEach var="dialog" items="${dialogs}">
               <a href = "im/${dialog.id}">${dialog.name}</a><br>
            </c:forEach>
        </div>
    </div>
</div>

<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}"/>
