<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/css/profile.css">
<div class="container">
    <div class="row">
        <div class="col-lg-3 main-inf">
        <h3>${user.firstName} ${user.secondName}</h3>
          <blockquote> ${user.status}</blockquote>
            <h4>Live in ${user.city}</h4>
            <h4>Has ${user.age} years old</h4>
            <h4>Phone number: ${user.phoneNumber}</h4>
        </div>
        <div class="col-lg-6" id = "wall">
            <textarea id = "text" class="form-control" rows="3"></textarea>
            <button type="submit" class="btn btn-primary" id = "post">Post</button>
            <div id="news"></div>
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

            url: 'loadUserEvent?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            success: function (res) {

                var all = '';

                for (var i = 0; i < res.length; i++) {
                    var index = res[i].id;
                    all += '<div>'+res[i].description +' '+ res[i].likeCounter +'<a id = "deleteEvent" onclick="deleteUserEvent(' + index + ')"> delete </a></div><br>';
                }
                document.getElementById('news').innerHTML = all;
            }
        })

    }

    function deleteUserEvent(index) {

        $.ajax({

            url: 'deleteUserEvent?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: '' + index,
            success: function (res) {

                var all = '';

                for (var i = 0; i < res.length; i++) {
                    var index = res[i].id;
                    all += '<div>'+res[i].description +' '+ res[i].likeCounter +'<a onclick="deleteUserEvent(' + index + ')"> delete </a></div><br>';
                }
                document.getElementById('news').innerHTML = all;
            }
        })


    }

    document.getElementById('post').onclick = function () {
        var userEvent = {
            description: document.getElementById('text').value
        }
        $.ajax({
            url: 'savePost?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: JSON.stringify(userEvent),
            success : function (res) {
                var all = '';
                for(var i = 0; i < res.length; i++){
                var index = res[i].id;
                all += '<div>'+res[i].description +' '+ res[i].likeCounter +'<a onclick="deleteUserEvent(' + index + ')"> delete </a></div><br>';
            }
                document.getElementById('text').innerHTML = ' ';
                document.getElementById('news').innerHTML = all;
            }
        })

    }

</script>