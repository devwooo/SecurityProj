var cmmCtrl = (function() {


    const validArr = ["idChk", "pwdChk"];
    var privateVar = 'private';
    var callAlert = function() {

    };

    var findRegx = function(cls) {
        let obj;
        if (cls.hasClass("idChk")) {
            obj = {
                regex : /^(?!(?:[0-9]+)$)([a-zA-Z]|[0-9a-zA-Z]){6,12}$/g,
                msg : "영문, 영문 + 숫자를 포함한 6~12 글자를 입력하세요."
            };	// 영문 or 영문 + 숫자 검사
        } else if (cls.hasClass("pwdChk")) {
            obj = {
                regex: /^(?=.*[a-zA-Z])(?=.*[!@#^&*%$()~`])(?=.*[0-9]).{8,15}$/g,
                msg: "영문, 특수문자를 포함함 8~15 글자를 입력하세요."
            }
        } else {
            obj = {
                regex : /^.*$/g,
                msg: "pass"
            }

        }

        return obj;
    }

    var regexMatch = function(obj) {
        if (obj == null || obj.attr("class") === "") {
            return false;
        }
        let regObj = findRegx(obj);
        regObj.pass = regObj.regex.test(obj.val());
        return regObj;
    }


    return {
        prop : privateVar,
        aaa : callAlert,
        validate : regexMatch
    };
}());
