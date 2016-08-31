$(function () {
    
    $("#check-all").find(":checkbox").click(function () {
        //全选框单击
        if ($(this).hasClass("check-all")) {
            var checked = $(this).prop("checked");
            $(cartTable).find(".check-one").prop("checked", checked);
        }
    })
    
})