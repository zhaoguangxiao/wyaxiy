var userEqt = ""

// 判断设备
function browserRedirect() {
    var sUserAgent = navigator.userAgent.toLowerCase();
    var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
    var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
    var bIsMidp = sUserAgent.match(/midp/i) == "midp";
    var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
    var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
    var bIsAndroid = sUserAgent.match(/android/i) == "android";
    var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
    var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
    if (bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM) {
        // document.write("mobile")
        return 1
    } else {
        // document.write("pc")
        return 0

    }

}

userEqt = browserRedirect()
console.log(userEqt)


// http://192.168.20.45:8080/leave/insert.do
// name
// url地址
// tell
// category
// IP
//description


let nowUrl = window.location.href;
// console.log(nowUrl)
let nowIp = returnCitySN["cip"];

layui.use(['layer', 'form'], function () {
    // console.log(userEqt)
    var layer = layui.layer
        , form = layui.form;
    form.render();
    // 表单验证
    form.verify({
        username: val => {
            if (val.length > 1000) {
                return "请输入正确的姓名"
            }
        },
        address: value => {
            if (value.length > 1000) {
                return "请输入正确的地区";
            }
        }
    });

    // 表单提交
    form.on('submit(go)', data => {
        // console.log(123)
        var goForm = data.field;
        let {username, phone, address} = goForm
        // console.log(username, phone, address)

        // layer.msg(JSON.stringify(data.field))

        // localStorage.setItem("userMsg", JSON.stringify(goForm))
        // console.log(window.localStorage.userMsg)
        //
        // if(window.localStorage.userMsg.un === username){
        //     console.log(1)
        // }
        // let un = localStorage.getItem("un"),
        //     ph = localStorage.getItem("ph"),
        //     ad = localStorage.getItem("ad");
        // if () {
        //     layer.msg("发送成功，我们会尽快与您联系")
        // } else {
        // localStorage.setItem("un", username)
        // localStorage.setItem("ph", phone)
        // localStorage.setItem("ad", address)


        console.log(nowIp)

        axios.post("http://192.168.20.45:8080/leave/insert.do?name=" + username + "&url=" + nowUrl + "&tell=" + phone + "&category=1&ip=" + nowIp + "&description=" + address + "&hasComputer=" + userEqt)
        // axios.post("http://47.103.16.140/leave/insert.do?name=" + username + "&url=" + nowUrl + "&tell=" + phone + "&category=1&ip=" + nowIp + "&description=" + address + "&isComputer=" + userEqt)
            .then(res => {
                console.log(res)
                if (res.data) {
                    layer.msg("发送成功，我们会尽快与您联系")
                }
                // layer.msg("发送成功，我们会尽快与您联系")
                let inps = document.querySelectorAll("input")
                inps.forEach(item => {
                    item.value = ""
                })
            })
            .catch(err => {
                layer.msg("错误，请重试")
            })
        return false
    });
});
