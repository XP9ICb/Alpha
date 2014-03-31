$(document).ready(function () {

    $('#registration-form').validate({
        rules: {
            login: {
                required: true,
                minlength: 6
            },
            password1: {
                required: true,
                minlength: 3
            },

            password2: {
                required: true,
                minlength: 3,
                equalTo: $("#password1")
            },

            name: {
                required: true,
                minlength: 3
            },
            secondName: {
                required: true,
                minlength: 3
            },
            midleName: {
                required: true,
                minlength: 3
            },
            certificateNumber: {
                required: true,
                minlength: 3,
                number: true
            }

        },

        errorContainer: ".errors",

        submitHandler: function () {
            var login = $("#login").val();
            var password = $("#password1").val();
            var role = "user";
            var name = $("#name").val();
            var secondName = $("#secondName").val();
            var midleName = $("#midleName").val();
            var certificateNumber = $("#certificateNumber").val();
            $.ajax({
                type: "POST",
                url: "registration.htm",
                data: JSON.stringify({login: login, password: password, role: role, name:name, secondName: secondName, midleName:midleName, certificateNumber:certificateNumber}),

                contentType: "application/json",
                success: function (flag) {
                    if (flag == "true") {
                        $("#registration-modal").modal("hide");
                    } else {
                        alert("Данный логин занят!");
                    }
                }
            });
        }
    });

    $("#save").on("click", function () {
        $("#registration-form").submit();
    });

});