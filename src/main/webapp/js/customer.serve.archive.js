function searchCustomerService() {
    console.log($("#s_customer").val());
    $("#dg").datagrid('load',{
        "customer" : $("#s_customer").val() ,
        "overview" : $("#s_overview").val(),
        "serveType" : $("#s_serveType").combobox("getValue"),
        "createTimefrom" : $("#s_createDatefrom").datebox("getValue") + " 00:00:00",
        "createTimeeto" : $("#s_createDateto").datebox("getValue") + " 23:59:59"
    });
}

function openCustomerServiceFileDialog() {
    var selectedRows = $("#dg").datagrid("getSelections");
    if(selectedRows.length != 1) {
        $.messager.alert("系统提示","请选择一条要查看的客户服务数据！");
        return;
    }
    var row=selectedRows[0];
    $("#dlg").dialog("open").dialog("setTitle","客服服务详情");
    $("#fm").form("load",row);
    url="../add_update?id=" + row.id;
}

function closeCustomerFileDialog(){
    $("#dlg").dialog("close");
}

