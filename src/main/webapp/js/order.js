$(function(){
    var cusId = $("#cusId").val();
    $.post(ctx + "/customer/detail.do",{id: cusId},function(result) {
        $("#khno").val(result.khno);
        $("#name").val(result.name);
    });
});

function formatState(val, row){
    if(val == 1) {
        return "已回款";
    } else {
        return "未回款";
    }
}

function formatAction(val, row) {
    return "<a href='javascript:openOrderDetailsDialog(" + row.id + ")'>查看订单明细</a>"
}

function openOrderDetailsDialog(orderId) {
    $.post("detail", {id : orderId},function(result) {
        $("#fm").form('load', result);
        if(result.state == 0 ) {
            $("#state").val("未回款");
        } else if(result.state == 1) {
            $("#state").val("已回款");
        }
    });

    $.post(ctx + "/order_details/getTotalPrice", {orderId : orderId}, function(result) {
        $("#totalMoney").val(result.result);
    });

    $("#dg2").datagrid('load',{
        "orderId":orderId
    });
    $("#dlg").dialog("open").dialog("setTitle","订单明细");
}

function closeOrderDetailsDialog(){
    $("#dlg").dialog("close");
}