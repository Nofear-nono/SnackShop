const base = {
    get() {
        return {
            url: "http://localhost:8080/springbootzongse/",
            name: "dyspringboot",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootzongse/front/dist/index.html'
        };
    },
    getProjectName() {
        return {
            projectName: "零食购物网站管理后台"
        }
    },
    getUsersTypes(){
        return [{ value: '0', label: '管理员' }, { value: '2', label: '用户' }]
    }
}
export default base
