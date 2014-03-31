$(document).ready(function () {

    var newExpertise = function () {
        var startdate = $("#startdate").val();
        var organization = $("#organization").val();
        var crimenumber = $("#crimenumber").val();
        var selectOptions = $(".admin-tbody > tr:last > td.expert > select.selectpicker").html();

        $.ajax({
            type: "POST",
            url: "new-expertise.htm",
            data: JSON.stringify({startdate: startdate, organization: organization, crimenumber: crimenumber}),
            contentType: "application/json",
            success: function (number) {
                var newExperiseHtml =
                    "<tr>" +
                        "<td class='number'>"+number+"</td>"+
                        "<td class='start-date'>"+startdate+"</td>"+
                        "<td class='end-date'></td>"+
                        "<td class='organization'>"+organization+"</td>"+
                        "<td class='crime-number'>"+crimenumber+"</td>"+
                        "<td class='expert'>"+
                            "<select class='selectpicker'>"+
                                selectOptions +
                            "</select>"+
                        "</td>"+
                        "<td>"+
                            "<button class='btn btn-mini delete-expertise'>"+
                                "<img src='assets/jquery/bootstrap/ico/png/glyphicons_016_bin.png'>"+
                            "</button>"+
                        "</td>"+
                    "</tr>";
                $("tbody.admin-tbody>tr:last").after(newExperiseHtml);
                $(".selectpicker").selectpicker({
                    style: "btn btn-mini change",
                    width: "auto"
                });
                $("#new-expertise-modal").modal("hide");
            }
        });
    }

    var changeExpert = function () {
        var userLogin = $("option:selected", this).attr("value");
        var expertiseNumber = $(this).closest("tr").find(".number").text();
        var expertiseStartDate = $(this).closest("tr").find(".start-date").text();

        $.ajax({
            type: "post",
            url: "change-expert.htm",
            data: JSON.stringify({number: expertiseNumber, startDate: expertiseStartDate, userLogin: userLogin}),
            contentType: "application/json"
        });
    };

    var deleteExpertise = function () {
        var userLogin = $("option:selected", this).attr("value");
        var expertiseNumber = $(this).closest("tr").find(".number").text();
        var expertiseStartDate = $(this).closest("tr").find(".start-date").text();
        $.ajax({
            type: "post",
            url: "delete-expertise.htm",
            data: JSON.stringify({userLogin: userLogin, number: expertiseNumber, startDate: expertiseStartDate}),
            contentType: "application/json",
            success: $(this).closest($("tr")).remove()
        });
    };

    $("#new-expertise-form").validate({
        rules: {
            startdate: {
                required: true
            },
            organization: {
                required: true
            },
            crimenumber: {
                required: true,
                number: true
            }
        },
        errorContainer: ".errors",
        submitHandler: newExpertise
    });

    $("#save").on("click", function () {
        $("#new-expertise-form").submit();
    });

    $("#startdate").datepicker();

    $("#startdate").on("changeDate", function () {
        $(this).datepicker("hide");
    });

    $(".selectpicker").selectpicker({
        style: "btn btn-mini change",
        width: "auto"
    });

    $("#expertise-table").on("change", ".selectpicker", changeExpert);
    $("#expertise-table").on("click", ".delete-expertise", deleteExpertise);

    $(".selectpicker").each(function(){
        var login = $(this).attr("name");
        $(this).val(login);
    });

    $("button.btn.btn-mini.search").on("click", function(){
        var searchString = $("#user-search").val();
        if($("#user-search").val() != ""){
            window.location.href = "user-search.htm?searchString=" + searchString;
        } else {
            alert("Строка поиска пуста!!!");
        }
    });

    $(".input-append.date").datepicker();
    $(".input-append.date").on("changeDate", function(){
        var expertiseNumber = $(this).closest("tr").find(".number").text();
        var startDate = $(this).closest("tr").find(".start-date").text();
        var endDate = $(this).find(".form-control").val();
        $.ajax({
            type: "post",
            url: "finish-experise.htm",
            data: JSON.stringify({number: expertiseNumber, startDate:startDate, endDate: endDate}),
            contentType: "application/json"
        });
        $(this).datepicker("hide");
        $(this).closest(".end-date").text($(this).find(".form-control").val());
    });

});