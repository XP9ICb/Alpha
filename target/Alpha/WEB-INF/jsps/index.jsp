<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>forensics</title>

    <script src="assets/jquery/jquery.min.js"></script>
    <script src="assets/jquery/jquery-validation/jquery.validate.min.js"></script>
    <script src="assets/jquery/jquery-validation/additional-methods.min.js"></script>
    <script src="assets/jquery/jquery-validation/messages_ru.js"></script>

    <link href="assets/jquery/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/jquery/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
    <script src="assets/jquery/bootstrap/js/bootstrap.min.js"></script>

    <link href="assets/custom/css/form-signin.css" rel="stylesheet">

    <script src="assets/custom/js/index.js"></script>

</head>
<body>

<div class="container">

    <form method="post" class="form-signin" action="j_spring_security_check">
        <h2 class="form-signin-heading">${signin}</h2>
        <input type="text" name="j_username" id="j_username" class="form-control" placeholder="${login}" required>
        <input type="password" name="j_password" id="j_password" class="form-control" placeholder="${password}"
               required>
        <label class="checkbox">
            <input type="checkbox" name="_spring_security_remember_me" value="remember-me">${rememberme}
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">${enter}</button>
        <button class="btn btn-lg btn-default btn-block" data-toggle="modal"
                data-target="#registration-modal">${registration}</button>
    </form>

    <%@include file="registration-modal.jsp" %>

</div>

</body>
</html>

