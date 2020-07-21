function get(par){
    debugger;
    //获取当前URL
    var local_url = document.location.href;

    //截取get字符串
    var getstr = local_url.substr(local_url.indexOf('?')+1)

    //解析成get数组
    var get = getstr.split('&')

    //查找要找到参数（par）
    for(var i in get){
        if(get[i].indexOf(par+'=')>=0){
            return get[i].replace(par+'=','');
        }
    }

    //如果找不到返回false
    return false;
}