/*
* 댓글
* */

let replyService = (function () {

    function add(reply, callback, error){
        $.ajax({
            url: "/reply/new",
            type: "post",
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function(result){
                if(callback){
                    callback(result);
                }
            },
            error: function(err){
                if(error){
                    error(err);
                }
            }
        });
    }

    function getList(param, callback, error) {
        $.ajax({
            url:"/reply/list/" + boardNumber,
            type:"get",
            success: function(replyVO){
                if(callback){
                    callback(replyVO);
                }
            },
            error: function(err){
                if(error){
                    error(err);
                }
            }
        })
    }

    return {add: add, getList: getList}
})();