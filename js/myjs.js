/**
 * Created by wangjianfeng on 2016/5/31 0031.
 */

// 验证手机号码的正确性
// usage:可以根据返回值判断手机号码的正确性
// 当手机号码输入正确时，返回空字符串
function vailPhone(phone){

    // 可以根据需要修改
    var reg = /^(((13[0-9]{1})|(14[0-9]{1})|(17[0]{1})|(15[0-3]{1})|(15[5-9]{1})|(18[0-9]{1}))+\d{8})$/;

    var message = "";

    if (phone.trim() == ''){
        message = "手机号码不能为空";
    } else if(phone.length != 11){
        message = "请输入有效的手机号码"
    } else if(!reg.test(phone)){
        message = "请输入有效的手机号码"
    }

    return message;
}
