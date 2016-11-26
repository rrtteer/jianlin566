// 搜索
function searchSaleChance() {
    $("#dg").datagrid('load', {
        "customerName" : $("#s_customerName").val(),
        "overview" : $("#s_overView").val(),
        "createMan" : $("#s_createMan").val(),
        "state" : $("#s_state").combobox("getValue")
    });
}
// 格式化状态
function formatState(val, row){
    if(val == 1) {
        return "已分配";
    } else {
        return "未分配";
    }
}
// 主键id
// 打开添加窗口
function openSaleChanceAddDialog() {
    $("#dlg").dialog("open").dialog("setTitle", "添加销售机会信息");
    $("#createMan").val($.cookie('userName'));
    $("#id").val();
}

// 打开修改窗口
function openSaleChanceModifyDialog() {
    var selectedRows = $("#dg").datagrid("getSelections");
    if(selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一条要编辑的数据！");
        return;
    }
    var row = selectedRows[0];
    $("#dlg").dialog("open").dialog("setTitle", "编辑销售机会信息");
    $("#fm").form("load", row);
    $("#id").val(row.id);
}

function saveSaleChance() {
    var url = "add_update";
    var customerName = $('#customerId').combobox('getText');
    if (isEmpty(customerName)) {
    	$.messager.alert("系统提示","请选择客户名称！");
    }
    $("#customerName").val(customerName);
    $("#fm").form("submit",{
        url:url,
        onSubmit: function() {
            return $(this).form("validate");
        },
        success:function(result) {
            result = JSON.parse(result);
            if(result.resultCode == 1) {
                $.messager.alert("系统提示", "保存成功！");
                resetValue();
                $("#dlg").dialog("close");
                $("#dg").datagrid("reload");
            }else{
                $.messager.alert("系统提示","保存失败！");
                return;
            }
        }
    });
}

function resetValue(){
	$("#customerId").val("");
    $("#customerName").val("");
    $("#chanceSource").val("");
    $("#linkMan").val("");
    $("#linkPhone").val("");
    $("#cgjl").numberbox('setValue',"");
    $("#overview").val("");
    $("#description").val("");
    $("#assignMan").combobox("setValue","");
}

function closeSaleChanceDialog(){
    $("#dlg").dialog("close");
    resetValue();
}

function deleteSaleChance(){
    var selectedRows=$("#dg").datagrid("getSelections");
    if(selectedRows.length==0){
        $.messager.alert("系统提示","请选择要删除的数据！");
        return;
    }
    var strIds=[];
    for(var i=0;i<selectedRows.length;i++){
        strIds.push(selectedRows[i].id);
    }
    var ids=strIds.join(",");
    $.messager.confirm("系统提示","您确定要删除这<font color=red>" + selectedRows.length + "</font>条数据吗？", function(r){
        if(r) {
            $.post("delete",{ids: ids}, function(result) {
                if(result.resultCode == 1) {
                    $.messager.alert("系统提示", "数据已成功删除！");
                    $("#dg").datagrid("reload");
                }else{
                    $.messager.alert("系统提示", "数据删除失败，请联系系统管理员！");
                }
            });
        }
    });
}