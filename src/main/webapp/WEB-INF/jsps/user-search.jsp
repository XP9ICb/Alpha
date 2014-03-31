<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="ru">
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
    <link href="assets/jquery/bootstrap/css/bootstrap-editable.css" rel="stylesheet">
    <link href="assets/jquery/bootstrap/css/datepicker.css" rel="stylesheet">
    <link href="assets/jquery/bootstrap/css/bootstrap-select.min.css" rel="stylesheet">
    <link href="assets/custom/css/success.css" rel="stylesheet">

    <script src="assets/jquery/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/jquery/bootstrap/js/bootstrap-editable.min.js"></script>
    <script src="assets/jquery/bootstrap/js/bootstrap-datepicker.js"></script>
    <script src="assets/jquery/bootstrap/js/bootstrap-select.min.js"></script>
    <script src="assets/custom/js/expertise.js"></script>
    <script src="assets/custom/js/profile.js"></script>

</head>
<body>

<nav role="navigation" class="navbar navbar-inverse">
    <div id="navbarCollapse" class="collapse navbar-collapse">
        <ul class="nav navbar-nav navbar-left">
            <li><a href="success.htm"><img src="assets/jquery/bootstrap/ico/png/glyphicons_020_home.png"></a></li>
        </ul>
        <ul class="nav navbar-nav navbar-left">
            <li><a data-toggle="modal" data-target="#profile-modal">${profile}</a></li>
        </ul>
        <form class="navbar-form navbar-left" role="search">
            <div class="input-group">
                <input id="user-search" type="text" class="form-control">
                    <span class="input-group-btn">
                        <button class="btn btn-mini search" type="button">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </span>
            </div>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="j_spring_security_logout">${logOut}</a></li>
        </ul>
    </div>
</nav>

<div>
    <table id="expertise-table" class="table table-condensed">
        <thead>
        <tr>
            <th>${number}</th>
            <th>${startDate}</th>
            <th>${endDate}</th>
            <th>${organization}</th>
            <th>${crimeNumber}</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="expertise" items="${userExpertises}">
            <tr>
                <td class="number">${expertise.number}</td>
                <td class="start-date">${expertise.startDate}</td>
                <td class="end-date">
                    <c:if test="${expertise.endDate == null}">
                        <div class="input-group col-md-6 input-append date" data-date="2012-01-01"
                             data-date-format="yyyy-mm-dd">
                            <span class="input-group-addon add-on glyphicon glyphicon-calendar"></span>
                            <input class="form-control" type="text">
                        </div>
                    </c:if>
                        ${expertise.endDate}
                </td>
                <td class="organization">${expertise.organization}</td>
                <td class="crime-number">${expertise.crimeNumber}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

