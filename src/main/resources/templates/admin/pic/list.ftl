<#include "admin/common/_head.ftl">
<#include "admin/common/_left.ftl">
<div class="main-content">
    <div class="row">
        <div class="col-sm-12">
            <div class="main-content-header">
                <div class="pull-left header-title">
                    <h4>图片管理</h4>
                    <div class="small-title">图片列表</div>
                </div>
            </div>
        </div>
    </div>
    <div class="row list-search-row">
        <div class="col-sm-12">
            <div class="pull-left">
                <button class="btn list-btn btn-primary " type="button"
                        onclick="openModal(pic_insert_modal_url, 'pic_create_modal', pic_list_table_id )">
                    <i class="fa fa-fw fa-plus"></i>上传图片
                </button>
                <button class="btn list-btn btn-danger " type="button"
                        onclick="deleteBatch(pic_list_delete_url,  pic_list_table_id )">
                    <i class="fa fa-fw fa-times"></i>删除图片
                </button>
            </div>
            <div class="pull-right">
                <form id="cate_list_searchForm" name="cate_list_searchForm" class="form-inline list-search"
                      onsubmit="return false">
                    <div class="form-group">
                        <select class="form-control" name="search_type">
                            <option value="title" selected>图片标题</option>
                            <option value="tagCnName">图片标签</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="search_value" placeholder="搜索相关数据"/>
                    </div>
                    <div class="form-group">
                        <a class="btn list-btn btn-info " onClick="cate_list_search();"><i
                                    class="fa fa-search fa-fw"></i>查询</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <table class="table table-striped table-hover table-no-bordered " id="pic_list_table"></table>
        </div>
    </div>
    <!-- 图片上传modal -->
    <div class="modal modal-top fade" id="pic_create_modal" tabindex="-1">
        <div class="modal-dialog modal-primary">
            <div class="modal-content"></div>
        </div>
    </div>

    <!-- 修改查看modal -->
    <div id="cate_listUpdateModal" class="modal modal-top fade" tabindex="1">
        <div class="modal-dialog modal-primary">
            <div class="modal-content"></div>
        </div>
    </div>

</div>
</div>
<!-- /#wrapper -->
<#include "admin/common/_js.ftl">
<script>
    var pic_insert_modal_url = '/admin/pic/add'; //新增注册url
    var pic_list_update_url = '/admin/pic/update/'; //更新信息URL
    var pic_list_use_url = '/admin/pic/use/'; //更新信息URL
    var pic_list_delete_url = '/admin/pic/delete'; //删除URL
    var pic_list_table; //用户表对象
    var pic_list_table_id = 'pic_list_table'; //用户表id
    $(function () {
        selectMenuByID("admin_pic");
        pic_list_loadData();
    });
    //显示列
    var pic_list_table_columns = [
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
            field: 'pic_url',
            width: 150,//宽度
            title: '缩略图',
            formatter: function (value, row, index) {
                var content = '<a href="#" class="dropdown-toggle" data-toggle="dropdown"><img alt="" src="http://192.168.80.128/' + row.thumbnailUrl + '" class="user-image"></a>';
                // var content = '<a href="#" class="dropdown-toggle" data-toggle="dropdown"><img alt="" src="/static/admin/images/avator.jpg" class="user-image"></a>';
                return content;
            }
        },
        {
            field: 'title',
            width: 150,//宽度
            title: '图片标题'
        },
        {
            field: 'picUrl',
            width: 450,//宽度
            title: '图片地址'
        },
        {
            field: 'tags',
            title: '图片标签'
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
            field: 'sort',
            width: 150,//宽度
            title: '排序',
            formatter: function (value, row, index) {
                var content = '<input type="text" size="2" value="' + row.sort + '" name="cate_sort" dataid="' + row.id + '">';
                return content;
            }
        },
        {
            field: 'action',
            title: '操作',
            formatter: function (value, row, index) {
                var result = '';
                if (row.status === 1) {
                    result += '<button class="btn btn-xs btn-primary" onclick="openOrCloseConfirm(\'确认要启用照片吗？\',\'' + pic_list_use_url + '\',\'' + row.id + '\',\'' + pic_list_table_id + '\',\'true\')">启用</button>&nbsp;';
                } else {
                    result += '<button class="btn btn-xs btn-primary" onclick="openOrCloseConfirm(\'确认要停用照片吗？\',\'' + pic_list_use_url + '\',\'' + row.id + '\',\'' + pic_list_table_id + '\',\'false\')">停用</button>&nbsp;';
                }
                result += '<button class="btn btn-xs btn-danger" onclick="deleteConfirm(\''
                    + pic_list_delete_url
                    + '\',\'' + row.id + '\',\'' + pic_list_table_id + '\');">删除</button>';
                return result;
            }
            //格式化
        }];

    function pic_list_loadData() {
        pic_list_table = $('#' + pic_list_table_id).bootstrapTable({
            method: 'post',
            columns: pic_list_table_columns,
            url: "/admin/pic/findList",
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
            pageSize: 5, //每页的记录行数（*）
            pageList: [10, 20, 50], //可供选择的每页的行数（*）
            uniqueId: "id", //每一行的唯一标识，一般为主键列
            onLoadSuccess: function (data) { //加载成功时执行
                $("input[name='cate_sort']").change(function () {
                    var id = $(this).attr("dataid");
                    var sort = $(this).val();
                    if (isDigits(sort)) {
                        $.ajax({
                            url: '/admin/pic/sort',
                            type: 'post',
                            data: {id: id, sort: sort},
                            dataType: 'json',
                            success: function (data) {
                                layer.msg(data.message, {
                                    time: 2000
                                });
                                pic_list_table.bootstrapTable('refresh');
                            }
                        });
                    } else {
                        layer.msg('排序请输入正整数', {
                            time: 2000
                        });
                        $(this)[0].focus();
                    }

                });
            }
        });
    }

    //刷新查询
    function cate_list_search() {
        pic_list_table.bootstrapTable('refreshOptions', {
            pageNumber: 1
        });
        return false;
    }

    //查询参数
    function queryParams(params) {
        params.search = searchDataInit("cate_list_searchForm");
        return params;
    }
</script>
</body>
</html>
