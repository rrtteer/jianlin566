function searchSaleChance() {
    $("#dg").datagrid('load',{
        "customerName":$("#s_customerName").val(),
        "overView":$("#s_overview").val(),
        "devResult":$("#s_devResult").combobox("getValue")
    });
}

function formatAssignTime(val, row) {
    if (val == null) {
        return '';
    }
    return new Date(val).format('yyyy-MM-dd hh:mm:ss');
}

function formatDevResult(val,row) {
    if(val==0) {
        return "未开发";
    } else if (val == 1) {
        return "开发中";
    } else if (val == 2) {
        return "开发成功";
    }else if(val == 3) {
        return "开发失败";
    }
}

// 客户开发计划项管理
function openCusDevPlanTab(id){
    window.parent.openTab('客户开发计划项管理','sale_chance/detail?saleChanceId=' + id + '&show=0', 'icon-khkfjh');
}

// 查看客户开发计划项
function openCusDevPlanTab2(id){
    window.parent.openTab('查看客户开发计划项','sale_chance/detail?saleChanceId=' + id + '&show=1', 'icon-khkfjh');
}

function formatAction(val, row) {
    if(row.devResult == 0 || row.devResult == 1 ) {
        return "<a href='javascript:openCusDevPlanTab(" + row.id + ")'>开发</a>";
    }else{
        return "<a href='javascript:openCusDevPlanTab2(" + row.id + ")'>查看详细信息</a>";
    }
}
