$(document).ready(function () {

    var currentLoginForChangePassword;

    $(".btn.btn-mini.delete").on("click", function () {

        var currentLogin = $(this).closest("tr").find(".login").text();

        $.ajax({
            type: "post",
            url: "delete_user.htm",
            data: {login: currentLogin},
            success: $(this).closest("tr").remove()
        });
    });


    $(".btn.btn-mini.change").on("click", function () {
        currentLoginForChangePassword = $(this).closest("tr").find(".login").text();
        $("#change-modal").modal({
            keyboard: true
        })
    });

    $(".selectpicker").selectpicker({
        style: "btn btn-mini change",
        width: "auto"
    });

    $("select.selectpicker").each(function () {
        var currentRole = $(this).attr("name");
        $(this).selectpicker("val", currentRole);
    });

    $("select.selectpicker").on("change", function () {
        var newRole = $(this).val();
        var currentLogin = $(this).closest("tr").find(".login").text();
        $.ajax({
            type: "post",
            url: "change_role.htm",
            data: JSON.stringify({login: currentLogin, password: null, role: newRole}),
            dataType: "json",
            contentType: "application/json",
            success: alert("Роль пользователя " + currentLogin + " изменена на " + newRole)
        });
    });

    $("#change-form").validate({
        rules: {
            password:{
                required: true
            },
            password1:{
                minlength: 3,
                required: true
            },
            password2: {
                required: true,
                minlength: 3,
                equalTo: $("#new-password")
            }
        },

        errorContainer: ".errors",

        submitHandler: function () {
            var currentPassword = $("#password").val();
            var newPassword = $("#new-password").val();

            $.ajax({
                type: "post",
                url: "change_password.htm",
                data: {login: currentLoginForChangePassword, currentPassword: currentPassword, newPassword: newPassword},
                success: function (flag) {
                    if (flag == "true") {
                        alert("Пароль пользователя " + currentLoginForChangePassword + " сменен на " + newPassword);
                        $("#change-modal").modal("hide");
                    } else {
                        alert("Неверный пароль пользователя");
                    }
                }
            });
        }

    });

    $(".btn.btn-primary.change").on("click", function () {
        $("#change-form").submit();
    });

});