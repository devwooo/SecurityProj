

const $formObj = $("#loginFrm");

// $(document).ready(()=>{
//
// });

// id Event

// class Event

// immediatly

// 즉시실행 함수
(function() {

    cmmCtrl.aaa();
    console.log(cmmCtrl.prop);


    $("#loginFrm").validate({
        errorPlacement: $.noop,
        invalidHandler: function(form, validator) {
            $(form.target).find("input").each((idx, ele)=>{
                debugger;
            })
        },
        submitHandler: function(){
            debugger;
        }
    });
})();