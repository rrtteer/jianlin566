$(function() {
    var cusId = $("#cusId").val();
    $.post(ctx + "/customer/detail",{id:cusId}, function(result) {
        $("#khno").val(result.khno);
        $("#name").val(result.name);
    });

    $("#dg").edatagrid({
        url:ctx + '/contact/list?cusId=' + cusId,
        saveUrl:ctx + '/contact/add_update?cusId='+ cusId,
        updateUrl:ctx + '/contact/add_update',
        destroyUrl:ctx + '/contact/delete',
        pagination: true,
        pageSize: 10

    });
});