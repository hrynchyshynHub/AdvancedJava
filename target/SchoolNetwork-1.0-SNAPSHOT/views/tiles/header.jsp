<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar-wrapper" style="margin: 0">
    <nav class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">SchoolBook</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="/home">Стартова</a></li>
                    <li><a href="#about">Про сайт</a></li>
                    <li><a href="/profile">Профіль</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Спадне меню <span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="/loginpage">Увійти</a></li>
                            <li><a href="/logout">Вийти</a></li>
                            <li class="divider"></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

</div>