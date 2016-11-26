$(function() {
    var cusId = $("#cusId").val();
    $.post(ctx + "/customer/detail",{id:cusId}, function(result) {
        $("#khno").val(result.khno);
        $("#name").val(result.name);
    });

    $("#dg").edatagrid({
        url:ctx + '/link_man/list?cusId=' + cusId,
        saveUrl:ctx + '/link_man/add_update?cusId='+ cusId,
        updateUrl:ctx + '/link_man/add_update',
        destroyUrl:ctx + '/link_man/delete',
        pagination: true,
        pageSize: 10

    });
});