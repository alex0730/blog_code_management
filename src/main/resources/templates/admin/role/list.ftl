<#include "admin/common/_head.ftl">
<#include "admin/common/_left.ftl">
<div class="main-content">
    <div class="row">
        <div class="col-sm-12">
            <div class="main-content-header">
                <div class="pull-left header-title">
                    <h4>菜单管理</h4>
                    <div class="small-title">菜单列表</div>
                </div>
            </div>
        </div>
    </div>
    <div class="row list-search-row">
        <div class="col-sm-12">
            <div class="pull-left">
                <button class="btn list-btn btn-danger " type="button"
                        onclick="deleteBatch(menu_list_delete_url,  menu_list_table_id )">
                    <i class="fa fa-fw fa-times"></i>删除菜单
                </button>
            </div>
            <div class="pull-right">
                <form id="menu_list_searchForm" name="menu_list_searchForm" class="form-inline list-search"
                      onsubmit="return false">
                    <div class="form-group">
                        <select class="form-control" id="search_type" name="search_type">
                            <option value="cn_name" selected>菜单名称</option>
                            <option value="status">菜单状态</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="cn_name" name="search_value" placeholder="搜索相关数据"/>
                    </div>
                    <select class="form-control" style="display: none;" id="status">
                        <option value="0" selected>启用</option>
                        <option value="1">停用</option>
                    </select>
                    <div class="form-group">
                        <a class="btn list-btn btn-info " onClick="menu_list_search();"><i
                                    class="fa fa-search fa-fw"></i>查询</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <table class="table table-striped table-hover table-no-bordered " id="menu_list_table"></table>
        </div>
    </div>
    <!-- 注册modal -->
    <div class="modal modal-top fade" id="menu_create_modal" tabindex="-1">
        <div class="modal-dialog modal-primary" style="width: 70%">
            <div class="modal-content"></div>
        </div>
    </div>

    <!-- 修改查看modal -->
    <div id="menu_listUpdateModal" class="modal modal-top fade" tabindex="1">
        <div class="modal-dialog modal-primary" style="width: 70%">
            <div class="modal-content"></div>
        </div>
    </div>

</div>
</div>
<!-- /#wrapper -->
<#include "admin/common/_js.ftl">
<script>
    $("#search_type").change(function () {
        var searchType = $(this);
        var selectedOption = searchType.find('option:selected');
        selectedOption.siblings().removeAttr('selected');
        selectedOption.attr('selected', true);
        var searchTypeVal = $(this).val();
        if (searchTypeVal === "status") {
            $("#cn_name").hide();
            $("#status").show();
            $("#cn_name").removeAttr('name')
            $("#status").attr("name", "search_value");
        } else if (searchTypeVal === "cn_name") {
            $("#status").hide();
            $("#cn_name").show();
            $("#status").removeAttr("name")
            $("#cn_name").attr("name", "search_value");
        }
    });

    var menu_insert_modal_url = '/admin/menu/add'; //新增注册url
    var menu_list_use_url = '/admin/menu/use/';
    var menu_list_update_url = '/admin/menu/update/'; //更新信息URL
    var menu_list_delete_url = '/admin/menu/delete'; //删除URL

    var menu_list_table; //用户表对象
    var menu_list_table_id = 'menu_list_table'; //用户表id

    $(function () {
        selectMenuByID("admin_menu");
        menu_list_loadData();
    });
    //显示列
    var menu_list_table_columns = [
        {
            field: 'checkbox',
            title: 'check',
            checkbox: true,
            hidden: true,
            align: "center",//水平
            valign: "middle"//垂直
        },
        {
            field: 'index',
            title: '序号',
            width: 50,//宽度
            align: "center",//水平
            valign: "middle",//垂直
            formatter: function (value, row, index) {
                return index + 1;
            }
        },
        {
            field: 'cn_name',
            title: '菜单名称'
        },
        {
            field: 'remark',
            title: '描述'
        },
        {
            field: 'parent_name',
            width: 150,
            title: '父菜单'
        },
        {
            field: 'order_id',
            width: 150,//宽度
            title: '排序'
        },
        {
            field: 'status',
            title: '状态',
            formatter: function (value, row, index) {
                var content = "启用";
                if (row.status === 1) {
                    content = "停用";
                }
                return content;
            }
        },
        {
            field: 'action',
            title: '操作',
            formatter: function (value, row, index) {
                var result = '';
                if (row.status === 1) {
                    result += '<button class="btn btn-xs btn-primary" onclick="openOrCloseConfirm(\'确认要启用菜单吗？\',\'' + menu_list_use_url + '\',\'' + row.id + '\',\'' + menu_list_table_id + '\',\'true\')">启用</button>&nbsp;';
                } else {
                    result += '<button class="btn btn-xs btn-primary" onclick="openOrCloseConfirm(\'确认要停用菜单吗？\',\'' + menu_list_use_url + '\',\'' + row.id + '\',\'' + menu_list_table_id + '\',\'false\')">停用</button>&nbsp;';
                }
                return result;
            }
            //格式化
        }];

    function menu_list_loadData() {
        menu_list_table = $('#' + menu_list_table_id).bootstrapTable({
            method: 'post',
            columns: menu_list_table_columns,
            url: "/admin/menu/findList",
            pagination: true,
            search: false,
            showRefresh: false,
            showToggle: false,
            showColumns: false,
            paginationLoop: false,
            paginationPreText: '上一页',
            paginationNextText: '下一页',
            queryParams: queryParams,
            sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1, //初始化加载第一页，默认第一页
            pageSize: 10, //每页的记录行数（*）
            pageList: [10, 20, 50], //可供选择的每页的行数（*）
            uniqueId: "id", //每一行的唯一标识，一般为主键列
            onLoadSuccess: function (data) { //加载成功时执行
                $(".menu-top").click(function () {
                    var msg = '';
                    var id = $(this).attr("dataid");
                    var istop = $(this).attr("istop");
                    if (istop == 1) {
                        msg = '确定取消推荐本条菜单吗?';
                    } else {
                        msg = '确定推荐本条菜单吗?';
                    }
                    layer.confirm(msg, {
                        title: '推荐操作',
                        icon: 3
                    }, function (index) {
                        layer.close(index);
                        $.ajax({
                            url: '/admin/menu/top',
                            type: 'post',
                            data: {id: id, istop: istop},
                            dataType: 'json',
                            success: function (data) {
                                menu_list_table.bootstrapTable('refresh');
                                layer.msg(data.message, {time: 2000});
                            }
                        });
                    })
                    return false;
                });
            }
        });
    }

    //刷新查询
    function menu_list_search() {
        menu_list_table.bootstrapTable('refreshOptions', {
            pageNumber: 1
        });
        return false;
    }

    //查询参数
    function queryParams(params) {
        params.search = searchDataInit("menu_list_searchForm");
        return params;
    }
</script>
</body>
</html>
