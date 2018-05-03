var ioc = {
            upload : {
                  type : "org.nutz.mvc.upload.UploadAdaptor",
                  args : [{refer : "uploadCtx"}],
                  singleton:false
            },
            uploadCtx : {
                  type : "org.nutz.mvc.upload.UploadingContext",
                  singleton : false,
                  args : [ { refer : 'tmpFilePool' } ],
                  fields : {
                        ignoreNull : true,// 是否忽略空文件, 默认为 false
                        // 正则表达式匹配可以支持的文件名nameFilter : '^(.+[.])(gif|jpg|png)$'
                        nameFilter : ".+(jpg|gif|png|jpeg|doc|docx|xls|xlsx|ppt|pptx|wps|pdf|txt|mp3|mp4|3gp|rm|swf|flv|asf|wmv|wma|avi|7z|zip|rar)"
                  }
            },         
            tmpFilePool : {  
                  type : 'org.nutz.filepool.NutFilePool',
                  args : [ "~/tmp", 20 ]  // 临时文件最大个数为 20 个
            }
};