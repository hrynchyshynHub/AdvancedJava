<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="/css/profile.css">
<script>
    function deleteUserEvent(index) {
        var idx = index;
        $.ajax({
            url: 'deleteUserEvent?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: '' + index,
            success: function () {
                $("#media-" + idx).animate({opacity: 0, height: 0}, 400, function () {
                    $(this).css("display", "none");
                })
            }

        })


    }
    function commentEvent(index) {
        var Comments = {
            "comment":document.getElementById('comment-input-' + index).value,
            "userEventId":index
        };

        $.ajax({
            url: 'saveComment?'+ $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            data: JSON.stringify(Comments),
            success: function (res) {
                var Comment = 	'<div class="comment">'+
                        '<div class="media-left">'+
                        '<a href="#">'+
                        '<img class="media-object img-circle" src="http://lorempixel.com/30/30" alt="">'+
                        '</a>'+
                        '</div>'+
                        '<div class="media-body">'+
                        '<h4 class="media-heading">'+ res.firstName +' ' + res.secondName+'<span class="pull-right" ' +
                        'style="font-size:13px;">16:33</span></h4>'+ res.comment +
                '</div>'+
                '</div>';
                var cssSelector = '#comments-wrapper-' + index;
                $(cssSelector).append(Comment);
            }
        });
    }
</script>
<input type="hidden" name="csrf_name"
       value="${_csrf.parameterName}" />
<input type="hidden" name="csrf_value"
       value="${_csrf.token}" />
<div class="container">
    <div class="row">
        <div class="col-sm-3 col-lg-3 well text-center">
            <div class="well">
                <p><h4><a href="#">${user.firstName} ${user.secondName}</a></h4></p>
                <img src="${user.pathToImage}" id = "profileImg" class="img-circle" height="200" width="200" alt="Avatar">
                <form:form action="./saveProfileImage?${_csrf.parameterName}=${_csrf.token}"
                           method="post" enctype="multipart/form-data">
                    <input type="file" name="image">
                    <button class="btn btn-success">save image</button>
                </form:form>
            </div>
            <div class="well">
                <p><a href="#">Information</a></p>
                <p>
                    <table>
                <tr><td><i class="fa fa-comment-o fa-1x" aria-hidden="true"></i></td><td> ${user.status}</td></tr>
                <tr><td><i class="fa fa-home fa-1x" aria-hidden="true"></i></td><td> live in ${user.city}</td></tr>
                <tr><td><i class="fa fa-phone fa-1x" aria-hidden="true"></i></td><td>    ${user.phoneNumber}</td></tr>
                <tr><td><i class="fa fa-envelope fa-1x" aria-hidden="true"></i></td><td>${user.email}</td></tr>

                    </table>
                </p>
            </div>
            <div class="alert alert-success fade in">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
                <p><strong>Ey!</strong></p>
                People are looking at your profile. Find out who.
            </div>
            <p><a href="#">Link</a></p>
            <p><a href="#">Link</a></p>
            <p><a href="#">Link</a></p>
        </div>

        <div class="col-lg-6" id = "wall">
            <div class="input-group post-input">
                <textarea class="form-control custom-control" id = "text" rows="3" style="resize:none"></textarea>
                <span class="input-group-addon btn btn-success" id = "post">Post</span>
            </div>
                <div id="news">

                </div>
             </div>
        <div class="col-sm-2 col-lg-2 well">
            <div class="thumbnail">
                <p>Upcoming Events:</p>
                <img src="http://lorempixel.com/70/70" alt="Paris" width="400" height="300">
                <p><strong>Paris</strong></p>
                <p>Fri. 27 November 2015</p>
                <button class="btn btn-primary">Info</button>
            </div>
            <div class="well">
                <p>ADS</p>
            </div>
            <div class="well">
                <p>ADS</p>
            </div>
        </div>
        </div>
      </div>



<script>
    window.onload = function () {
        $.ajax({
            url: 'loadUserEvent?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
            method: 'POST',
            contentType: 'application/json; charset=UTF-8',
            dataType: 'json',
            success: function (res) {
                for (var i = 0; i < res.length; i++) {
                    var index = res[i].id;
                    var wrapper = document.getElementById('news');
                    wrapper.innerHTML += '<div class="media singleNews" id="media-' + index + '"> ' +
                            '<div class="media-left">' +
                            ' <a href="#"> <img class="media-object img-circle" src="' +
                            res[i].pathToImage + '" alt="" style="width: 70px; height: 70px"></a>' +
                            '</div> <div class="media-body"> <h4 class="media-heading">' + res[i].firstName +
                            res[i].secondName + '<span class="pull-right time" style="font-size:13px;">' +
                            '13:45' + '</span></h4>' + res[i].description +
                            '<span class="pull-right"><a onclick="deleteUserEvent(' + index + ')">delete</a></span>' +
                            '<div class="comments-wrapper-'+ res[i].id +'"><div class="comment"></div>' +
                            '<div class="comment-form"><a onclick="loadComment(' + index + ')">Коментарі</a>' +
                            ' <div class="input-group"> ' +
                            '<input type="text" class="form-control" id="comment-input-' + index +'" ' +
                            'placeholder="Введіть коментар">' +
                            '<div class="input-group-btn">' +
                            '<a class="btn btn-success push-comment" onclick="commentEvent(' + index + ')">+</a>' +
                            '</div> </div> </div>'

                }


            }

        });

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
                success: function (res) {
                    var index = res.id;
                    var singleNews = '<div class="media singleNews" id="media-' + index + '"> <div class="media-left">' +
                            '<a href="#">' +
                            '<img class="media-object img-circle" src="' + res.pathToImage + '" alt="" ' +
                            'style = "width:70px; height:70px"' + '></a>' +
                            '</div> <div class="media-body"> <h4 class="media-heading">' + res.firstName + ' ' +
                            res.secondName + '<span class="pull-right time" style="font-size:13px;">' +
                            '14:45' + '</span></h4>' + res.description +
                            '<br><a class="pull-right" onclick="deleteUserEvent(' + index + ')">delete</a>' +
                            '<div class="comments-wrapper-'+res.id+'"><div class="comment"></div>' +
                            '<div class="comment-form"><a onclick="loadComment(' + index + ')">Коментарі</a>' +
                            ' <div class="input-group"> ' +
                            '<input type="text" class="form-control"  id="comment-input-'+ index +'" ' +
                            'placeholder="Введіть коментар">' +
                            '<div class="input-group-btn">' +
                            '<a class="btn btn-success push-comment" onclick="commentEvent(' + index + ')">+</a>' +
                            '</div> </div> </div>';
                    $('#news').append(singleNews);
                }
            })

        }




        function loadComment(index) {
            $.ajax({
                url: 'loadComments?',
                method: 'POST',
                contentType: 'application/json; charset=UTF-8',
                dataType: 'json',
                data: '' + index,
                success: function (res) {
                    alert(res);
                }

            })
        }

        function likeUserEvent(index) {
            $.ajax({
                url: 'likeUserEvent?',
                contentType: 'application/json; charset=UTF-8',
                dataType: 'json',
                data: '' + index,
                success: function (res) {
                    var all = '';
                    all = '<div>' + res.description + ' ' + res.likeCounter + '</div>';
                    $('#singleNews').html(all);
                }
            });
        }

    }
</script>