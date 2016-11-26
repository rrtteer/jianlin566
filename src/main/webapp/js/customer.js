var url;
function searchCustomer() {
    $("#dg").datagrid('load', {
        "khno":$("#s_khno").val(),
        "name":$("#s_name").val()
    });
}

function openCustomerAddDialog() {
    $("#dlg").dialog("open").dialog("setTitle","添加客户信息");
}

function openCustomerModifyDialog() {
    var selectedRows = $("#dg").datagrid("getSelections");
    if(selectedRows.length!=1) {
        $.messager.alert("系统提示","请选择一条要编辑的数据！");
        return;
    }
    var row = selectedRows[0];
    $("#dlg").dialog("open").dialog("setTitle","编辑客户信息");
    $("#fm").form("load",row);
    $("#customerId").val(row.id);
}

function saveCustomer() {
    $("#fm").form("submit",{
        url:"add_update",
        onSubmit : function() {
            if($("#area").combobox("getValue") == "") {
                $.messager.alert("系统提示","请选择客户地区！");
                return false;
            }
            if($("#cusManager").combobox("getValue") == "") {
                $.messager.alert("系统提示","请选择客户经理！");
                return false;
            }
            if($("#level").combobox("getValue")=="") {
                $.messager.alert("系统提示","请选择客户等级！");
                return false;
            }
            if($("#myd").combobox("getValue")=="") {
                $.messager.alert("系统提示","请选择客户满意度！");
                return false;
            }
            if($("#xyd").combobox("getValue")=="") {
                $.messager.alert("系统提示","请选择客户信用度！");
                return false;
            }
            return $(this).form("validate");
        },
        success : function(result) {
            result = JSON.parse(result);
            if(result.resultCode == 1) {
                $.messager.alert("系统提示","保存成功！");
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

function resetValue() {
    $("#customerId").val('');
    $("#name").val("");
    $("#area").combobox("setValue","");
    $("#cusManager").combobox("setValue","");
    $("#level").combobox("setValue","");
    $("#myd").combobox("setValue","");
    $("#xyd").combobox("setValue","");
    $("#address").val("");
    $("#postCode").val("");
    $("#phone").val("");
    $("#fax").val("");
    $("#webSite").val("");
    $("#yyzzzch").val("");
    $("#fr").val("");
    $("#zczj").val("");
    $("#nyye").val("");
    $("#khyh").val("");
    $("#khzh").val("");
    $("#dsdjh").val("");
    $("#gsdjh").val("");
}

function closeCustomerDialog(){
    $("#dlg").dialog("close");
    resetValue();
}

function deleteCustomer() {
    var selectedRows=$("#dg").datagrid("getSelections");
    if(selectedRows.length==0) {
        $.messager.alert("系统提示","请选择要删除的数据！");
        return;
    }
    var strIds=[];
    for(var i=0;i<selectedRows.length;i++) {
        strIds.push(selectedRows[i].id);
    }
    var ids=strIds.join(",");
    $.messager.confirm("系统提示","您确定要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？", function(r) {
        if(r){
            $.post("\delete",{ids:ids},function(result){
                if(result.resultCode == 1) {
                    $.messager.alert("系统提示","数据已成功删除！");
                    $("#dg").datagrid("reload");
                }else{
                    $.messager.alert("系统提示","数据删除失败，请联系系统管理员！");
                }
            });
        }
    });
}

function openCustomerLinkMan() {
    var selectedRows=$("#dg").datagrid("getSelections");
    if(selectedRows.length != 1) {
        $.messager.alert("系统提示","请选择一条要管理的数据！");
        return;
    }
    window.parent.openTab('客户联系人管理','../link_man/index?cusId=' + selectedRows[0].id,'icon-lxr');
}

function openCustomerContact() {
    var selectedRows = $("#dg").datagrid("getSelections");
    if(selectedRows.length != 1) {
        $.messager.alert("系统提示","请选择一条要管理的数据！");
        return;
    }
    window.parent.openTab('客户交往记录管理','../contact/index?cusId='+selectedRows[0].id,'icon-jwjl');
}

function openCustomerOrder() {
    var selectedRows = $("#dg").datagrid("getSelections");
    if(selectedRows.length != 1) {
        $.messager.alert("系统提示","请选择一条要管理的数据！");
        return;
    }
    window.parent.openTab('客户历史订单查询','order/index?cusId=' + selectedRows[0].id, 'icon-lsdd');
}