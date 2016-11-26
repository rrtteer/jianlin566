// 客户贡献查询
function searchFhgxfx(){
    $("#dg").datagrid('load',{
        "name":$("#s_name").val()
    });
}

// 客户流程
function searchCustomerLoss(){
    $("#dg").datagrid('load',{
        "cusName":$("#s_cusName").val(),
        "cusManager":$("#s_cusManager").val()
    });
}

// 客户关系构成
function findCustomerGc() {
    var chart = new Highcharts.Chart({
        chart: {
            renderTo: 'container',
            type: 'column',
            events:{
                load: function(event) {
                    // ajax请求后台加载数据
                    $.post("khgcfx", {}, function(result) {
                        var xArr=new Array();
                        var yArr=new Array();
                        for(var i = 0;i< result.length; i++) {
                            xArr.push(result[i].customerLevel);
                            yArr.push(result[i].customerNum);
                            chart.xAxis[0].categories=xArr;
                            chart.series[0].setData(yArr);
                        }
                    },"json");
                }
            }
        },
        title: {
            text: '客户构成分析'
        },
        xAxis: {
            title:'客户等级',
            categories: [
                'A',
                'B',
                'C'
            ]
        },
        yAxis: {
            title: {
                text: '客户数量'
            }
        },
        series: [{
            name: '客户',
            data: [1,2,3]
        }]
    });
}

// 客户服务分析
function findCustomerFw() {
    var chart=new Highcharts.Chart({
        chart: {
            renderTo: 'container',
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            events:{
                load:function(event) {
                    var series=this.series[0];
                    // ajax请求后台加载数据
                    $.post("khfwfx", {}, function(result) {
                        var xArr=new Array();
                        for(var i=0; i < result.length; i++) {
                            xArr[i] = new Array();
                            xArr[i][0] = result[i].serveType;
                            xArr[i][1] = result[i].num;
                        }
                        series.setData(xArr);
                    },"json");
                }
            }
        },
        title: {
            text: '客服服务分析'
        },
        tooltip: {
            formatter:function(){
                return '<b>'+this.point.name+'</b>:'+Highcharts.numberFormat(this.percentage,1)+'% ('+this.y+'个)'
            }
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        },
        series: [{
            type: 'pie',
            name: '比例',
            data: [

            ]
        }]
    });
}