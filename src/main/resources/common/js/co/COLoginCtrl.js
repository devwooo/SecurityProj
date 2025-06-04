

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
                let val = $(ele).val();
                if (!val) {
                    $(ele).focus();
                    alert($(ele).attr("title") + "를 입력해 주세요.");
                    return false;
                }
            })
        },
        submitHandler: function(form,event){
            event.preventDefault();
            $(form).find("input").each((idx, ele)=>{
                let require = $(ele).prop("required");
                if (!require) {
                    let validateObj = cmmCtrl.validate($(ele));
                    if (!validateObj.pass) {
                        alert(validateObj.msg);
                        return false;
                    }
                }
            })
            console.log("happy day");
        }
    });
})();