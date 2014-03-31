$(document).ready(function () {
    $.fn.editable.defaults.mode = "inline";
    $("[data-url='profile-inline-editing.htm']").each(function () {
        $(this).editable({
            ajaxOptions: {contentType: 'application/json', dataType: 'json' },
            params: function (params) {
                return JSON.stringify(params);
            },
            success: function(param){
                $(this).val(param);
            }
        });
    });
});