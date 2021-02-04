<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">×</span>
    </button>
    <div class="modal-title">图片上传</div>
</div>
<div class="modal-body">
    <div>
        <form id="pic_add_form" role="form" class="form-horizontal" action="/admin/pic/add" method="post">
            <div class="row form-group">
                <div class="col-md-2 control-label">
                    <label>图片标题</label>
                </div>
                <div class="col-md-9 controls">
                    <input class="form-control validate" name="title" type="text" placeholder="请输入图片标题"
                           data-options="required:true,messages:{required:'请输入图片标题'}">
                </div>
            </div>
            <div class="row form-group">
                <div class="col-md-2 control-label">
                    <label>图片描述</label>
                </div>
                <div class="col-md-9 controls">
                    <input class="form-control validate" name="instructions" type="text" placeholder="请输入图片描述"
                           data-options="required:true,messages:{required:'请输入图片描述'}">
                </div>
            </div>
            <div class="row form-group">
                <div class="col-md-2 control-label">
                    <label>图片备注</label>
                </div>
                <div class="col-md-9 controls">
                    <input class="form-control validate" name="remark" type="text" placeholder="请输入图片备注"
                           data-options="required:true,messages:{required:'请输入图片备注'}">
                </div>
            </div>
            <div class="row form-group">
                <div class="col-md-2 control-label">
                    <label>图片标签</label>
                </div>
                <div class="col-md-9 controls">
                    <select name="tags" class="form-control validate"
                            data-options="required:true,messages:{required:'请选择一个图片标签'}">
                        <option value="">图片标签</option>
                        <#list pictureTagInfos as pictureTagInfo>
                            <option value="${pictureTagInfo.tagCnName}">${pictureTagInfo.tagCnName}</option>
                        </#list>
                    </select>
                </div>
            </div>
            <div class="row form-group">
                <div class="col-md-2 control-label">
                    <label>图片排序</label>
                </div>
                <div class="col-md-9 controls">
                    <input class="form-control validate" name="sort" type="text" placeholder="数值越大图片位置越靠前"
                           data-options="required:true,messages:{required:'请输入排序序号'}">
                </div>
            </div>
            <div class="row form-group">
                <div class="col-md-2 control-label">
                    <label>是否推荐</label>
                </div>
                <div class="col-md-9 controls">
                    <div class="checkbox">
                        <label class="control-label"> <input type="checkbox" name="isRecommend" value="1">推荐</label>
                    </div>
                </div>
            </div>
            <div class="row form-group">
                <div class="col-md-2 control-label">
                    <label>图片上传</label>
                </div>
                <input class="control-label" type="file" name="file" id="upload"
                       data-options="prompt:'Choose a file...'"
                       style="width:80%"/>
            </div>
            <div class="row form-group">
                <div class="col-md-2 control-label">
                    <label>图片预览</label>
                </div>
                <img id="preview" src="" align="center" onload="DrawImage(this,200,200)">
            </div>
            <input name="picUrl" id="picUrl" value="" hidden/>
            <input name="thumbnailUrl" id="thumbnailUrl" value="" hidden/>
        </form>
    </div>
</div>
<div class="modal-footer">
    <div class="pull-right">
        <button class="btn btn-primary " onclick="validateAndSubmitForm('pic_add_form', this);">保存</button>
        <button class="btn btn-default" type="button" data-dismiss="modal">取消</button>
    </div>
</div>
<script src="/static/lib/wangeditor/wangEditor.js"></script>
<script type="text/javascript">
    function DrawImage(ImgD, width_s, height_s) {
        var image = new Image();
        image.src = ImgD.src;
        if (image.width > 0 && image.height > 0) {
            flag = true;
            if (image.width / image.height >= width_s / height_s) {
                if (image.width > width_s) {
                    ImgD.width = width_s;
                    ImgD.height = (image.height * width_s) / image.width;
                } else {
                    ImgD.width = image.width;
                    ImgD.height = image.height;
                }
            } else {
                if (image.height > height_s) {
                    ImgD.height = height_s;
                    ImgD.width = (image.width * height_s) / image.height;
                } else {
                    ImgD.width = image.width;
                    ImgD.height = image.height;
                }
            }
        }
    }

    function validateAndSubmitForm(formId, btnThis, eventName) {
        var formSelector = $("#" + formId);
        var isValid = validateForm(formId);	//验证表单 
        if (isValid) {
            $.ajax({
                cache: true,
                type: 'POST',
                url: formSelector.attr("action"),  	//默认使用form的action
                data: formSelector.serialize(),	//序列化表单
                async: true,
                dataType: "json",
                success: function (data) {
                    if (data.success) {
                        //根据按钮id获取modal的id
                        var modalId = $(btnThis).parents().filter(".modal:first").attr("id");
                        console.info("modalId：" + modalId);
                        $("#" + modalId).modal("hide");	//隐藏modal
                        //$('#' + tableName).bootstrapTable('refresh');	//modal的form提交只提供formid以及modalId即可，刷新table放到modal关闭事件中
                    }
                    showMsg(data.message);
                    // validateAndSubmitFormCallBack存在且是function
                    if (typeof validateAndSubmitFormCallBack === 'function') {
                        validateAndSubmitFormCallBack(data);
                    }
                    //触发的回调函数
                    if (eventName != null && eventName != '') {
                        eval(eventName + '(data)');
                    }
                },
                error: function (XmlHttpRequest, textStatus, errorThrown) {
                    alert("提交失败");
                }
            });
        }
    }

    /**
     * 上传图片
     * @param file
     */
    $("#upload").click(function () {
        // $("#upload").click(); //隐藏了input:file样式后，点击头像就可以本地上传
        $("#upload").on("change", function () {
            var objUrl = getObjectURL(this.files[0]); //获取图片的路径，该路径不是图片在本地的路径
            console.info("objUrl：" + objUrl);
            if (objUrl) {
                $("#preview").attr("src", objUrl); //将图片路径存入src中，显示出图片
                upload();
            }
        });
    });

    function getObjectURL(file) {
        var url = null;
        if (window.createObjectURL != undefined) { // basic
            url = window.createObjectURL(file);
        } else if (window.URL != undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }

    function upload() {
        var file = new FormData();
        var pic = $('#upload')[0].files[0];
        file.append('file', pic);
        $.ajax({
            url: "/admin/pic/upload",
            type: "post",
            data: file,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                $("#picUrl").attr("value", data.picUrl);
                $("#thumbnailUrl").attr("value", data.thumbnailUrl);
            }
        });
    }

</script>
