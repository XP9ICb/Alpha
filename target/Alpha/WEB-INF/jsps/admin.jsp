<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>forensics</title>

    <script src="assets/jquery/jquery.min.js"></script>
    <script src="assets/jquery/jquery-validation/jquery.validate.js"></script>
    <script src="assets/jquery/jquery-validation/jquery.validate.min.js"></script>
    <script src="assets/jquery/jquery-validation/additional-methods.js"></script>
    <script src="assets/jquery/jquery-validation/additional-methods.min.js"></script>
    <script src="assets/jquery/jquery-validation/messages_ru.js"></script>

    <link href="assets/jquery/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/jquery/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="assets/jquery/bootstrap/css/bootstrap-theme.css" rel="stylesheet">
    <link href="assets/jquery/bootstrap/css/bootstrap-select.min.css" rel="stylesheet">
    <link href="assets/custom/css/form-style.css" rel="stylesheet">

    <script src="assets/jquery/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/jquery/bootstrap/js/bootstrap-select.min.js"></script>

    <script src="assets/custom/js/user-manage.js"></script>

</head>
<body>

<nav role="navigation" class="navbar navbar-inverse">
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav navbar-left">
            <li><a href="success.htm"><img src="assets/jquery/bootstrap/ico/png/glyphicons_020_home.png"></a></li>
        </ul>
        <ul id="login" class="nav navbar-nav navbar-right">
            <li><a href="j_spring_security_logout">Log Out</a></li>
        </ul>
    </div>
</nav>

<div>
    <table class="table table-condensed">
        <thead>
        <tr>
            <th>Login</th>
            <th>Role</th>
            <th>Password</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td class="login">${user.login}</td>

                <td>
                    <select name=${user.role.role} id=${user.login} class="selectpicker">
                        <option>admin</option>
                        <option>user</option>
                        <option>moderator</option>
                    </select>
                </td>
                <td>
                    <button class="btn btn-mini change">${change}</button>
                </td>
                <td>
                    <button class="btn btn-mini delete">${delete}</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="modal " id="change-modal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <form class="form-horizontal" id="change-form">
                    <fieldset>
                        <div class="control-group">
                            <label class="control-label" for="password">${password}</label>

                            <div class="controls">
                                <input class="form-control" type="text" id="password" name="password">
                            </div>
                            <label class="control-label" for="new-password">${password1}</label>

                            <div class="controls">
                                <input class="form-control" type="password" id="new-password" name="password1">
                            </div>
                            <label class="control-label" for="new-password1">${password2}</label>

                            <div class="controls">
                                <input class="form-control" type="password" id="new-password1" name="password2">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-primary change">${change}</button>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>

