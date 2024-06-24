import storage from './storage';
import menu from './menu';
/**
 * 是否有权限
 * @param {*} key
 */
export function isAuth(tableName,key) {
    let role = storage.get("role");
    if(!role){
        role = '管理员';
    }
    let menus = menu.list();
    for(let i=0;i<menus.length;i++){
        if(menus[i].roleName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    // for(let i=0;i<menus.length;i++){
    //     if(menus[i].roleName==role){
    //         for(let j=0;j<menus[i].backMenu.length;j++){
    //             if(menus[i].backMenu[j].tableName==tableName){
    //                 let buttons = menus[i].backMenu[j].child[0].buttons.join(',');
    //                 return buttons.indexOf(key) !== -1 || false
    //             }
    //         }
    //     }
    // }
    return false;
}

//获取当前日期或时间（yyyy-MM-dd 或 yyyy-MM-dd hh:mm:ss）
export function getCurrentTime(type) {
    let date = new Date();
    let year = date.getFullYear();
    /* 在日期格式中，月份是从0开始的，因此要加0
    * 使用三元表达式在小于10的前面加0，以达到格式统一  如 09:11:05
    * */
    let month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
    let day = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
    let hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
    let minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
    let seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
    if (type && type == 1) {
        // 拼接
        return year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
    } else {
        return year + "-" + month + "-" + day
    }
}

