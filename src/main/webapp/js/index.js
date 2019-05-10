// http://192.168.20.45:8080/leave/insert.do
// name
// url地址
// tell
// category
// IP
//description


let nowUrl = window.location.href,
    // console.log(nowUrl)
    nowIp = returnCitySN["cip"];


//一般直接写在一个js文件中
layui.use(['layer', 'form'], function () {
    var layer = layui.layer
        , form = layui.form;
    form.render();
    // 表单验证
    form.verify({
        username: [
            /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/
            , "请输入正确的姓名"
        ],
        address: value => {
            if (value.length > 10) {
                return "请输入正确的地区";
            }
        }
    });

    // 表单提交
    form.on('submit(go)', data => {
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

        axios.get("http://192.168.20.45:8080/leave/insert.do?name=" + username + "&url=" + nowUrl + "&tell=" + phone + "&category=1&ip=" + nowIp + "&description=" + address)
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
