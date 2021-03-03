<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">×</span>
    </button>
    <div class="modal-title">菜单上传</div>
</div>
<div class="modal-body">
    <div>
        <form id="menu_add_form" role="form" class="form-horizontal" action="/admin/menu/add" method="post">
            <div class="row form-group">
                <div class="col-md-2 control-label">
                    <label>菜单业务主键</label>
                </div>
                <div class="col-md-9 controls">
                    <input class="form-control validate" name="workId" type="text" placeholder="请输入菜单业务主键"
                           data-options="required:true,messages:{required:'请输入菜单业务主键'}">
                </div>
            </div>
            <div class="row form-group">
                <div class="col-md-2 control-label">
                    <label>菜单标题</label>
                </div>
                <div class="col-md-9 controls">
                    <input class="form-control validate" name="cnName" type="text" placeholder="请输入菜单标题"
                           data-options="required:true,messages:{required:'请输入菜单标题'}">
                </div>
            </div>
            <div class="row form-group">
                <div class="col-md-2 control-label">
                    <label>菜单名称</label>
                </div>
                <div class="col-md-9 controls">
                    <input class="form-control validate" name="name" type="text" placeholder="请输入菜单名称"
                           data-options="required:true,messages:{required:'请输入菜单名称'}">
                </div>
            </div>
            <div class="row form-group">
                <div class="col-md-2 control-label">
                    <label>菜单描述</label>
                </div>
                <div class="col-md-9 controls">
                    <input class="form-control validate" name="remark" type="text" placeholder="请输入菜单描述"
                           data-options="required:true,messages:{required:'请输入菜单描述'}">
                </div>
            </div>
            <#if menuModel.parentId != 0>
                <div class="row form-group">
                    <div class="col-md-2 control-label">
                        <label>菜单父节点</label>
                    </div>
                    <div class="col-md-9 controls">
                        <select name="parentId" id="parentId" class="form-control validate">
                            <option value="" selected>请选择菜单父节点</option>
                            <#list parentIds as parentId>
                                <#if parentId.workId == menuModel.parentId>
                                    <option value="${parentId.workId}">${parentId.cnName}</option>
                                <#else>
                                    <option value="${parentId.workId}">${parentId.cnName}</option>
                                </#if>
                            </#list>
                            <input name="parentName" id="parentName" type="text" style="display: none" value="">
                        </select>
                    </div>
                </div>
            </#if>
            <div class="row form-group">
                <div class="col-md-2 control-label">
                    <label>菜单排序</label>
                </div>
                <div class="col-md-9 controls">
                    <input class="form-control validate" name="orderId" type="text" placeholder="数值越大菜单位置越靠前"
                           data-options="required:true,messages:{required:'请输入排序序号'}" value="${menuModel.orderId}">
                </div>
            </div>
            <div class="row form-group">
                <div class="col-md-2 control-label">
                    <label>菜单链接</label>
                </div>
                <div class="col-md-9 controls">
                    <input class="form-control validate" name="menuUrl" type="text"
                           data-options="required:true,messages:{required:'请输入菜单链接'}" value="${menuModel.menuUrl}">
                </div>
            </div>
        </form>
    </div>
</div>
<div class="modal-footer">
    <div class="pull-right">
        <button class="btn btn-primary " onclick="validateAndSubmitForm('menu_add_form', this);">保存</button>
        <button class="btn btn-default" type="button" data-dismiss="modal">取消</button>
    </div>
</div>
<script src="/static/lib/wangeditor/wangEditor.js"></script>
<script type="text/javascript">
    $("#parentId").change(function () {
        var parentIdName = $("#parentId").find("option:selected").text();
        console.info("parentIdName" + parentIdName)
        $("#parentName").attr("value", parentIdName);
    });
</script>
