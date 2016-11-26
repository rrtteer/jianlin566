// 搜索
function searchRole() {
    $("#dg").datagrid('load', {
        "roleName" : $("#s_roleName").val(),
    });
}

//打开添加窗口
function openRoleAddDialog() {
    $.messager.prompt('角色名称', '请输入角色名称：', function(r) {
        if (r) {
            $.post( ctx + "/role/add",{roleName: r}, function(result) {
                if(result.resultCode == 1) {
                    $.messager.alert("系统提示","执行成功！");
                    $("#dg").datagrid("reload");
                }else{
                    $.messager.alert("系统提示", "执行失败！");
                }
            });
        }
    });
    
}

// 关闭窗体
function closeRole(){
    $("#dlg").dialog("close");
}

// 打开添加权限窗口
function openRoleRelatePermissionDialog() {
    var selectedRows = $("#dg").datagrid("getSelections");
    if(selectedRows.length != 1) {
        $.messager.alert("系统提示", "请选择一条要编辑的数据！");
        return;
    }
    var row = selectedRows[0];
   // TODO 
}

function deleteRole(){
    var selectedRows=$("#dg").datagrid("getSelections");
    if(selectedRows.length==0) {
        $.messager.alert("系统提示","请选择要删除的数据！");
        return;
    }
    var strIds=[];
    for(var i=0;i<selectedRows.length;i++){
        strIds.push(selectedRows[i].roleId);
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