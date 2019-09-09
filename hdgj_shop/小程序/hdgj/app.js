//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs) 
    console.log('出发lauch')
    this.login(this.globalData.userInfo)

  }, 
  onShow:function(){
    console.log('触发登录')
  },
  globalData: {  
    userInfo: null,             //用户信息
    serverHost:'localhost',     //服务器地址
    isLogin:false       //是否登陆
  },
  /**
   * 用户登陆
   */
  login: function(userInfo){ 
    var app = this

    // var promise = new Promise((resolve, reject) =>{
      
    // })

    wx.login({
      success: function (res) {  
        /** 
         * 发出请求授权登陆    
         **/   
        wx.request({ 
          url: 'http://127.0.0.1/wxLogin',    
          data: {
            //用户登录凭证（有效期五分钟）。开发者需要在开发者服务器后台调用 auth.code2Session，使用 code 换取 openid 和 session_key 等信息
            js_code: res.code,  
            userinfo:userInfo
          },  
          success: function (response) {
            var resUser = response.data.userInfo
            /**
             * 将用户信息存储在客户端内存中
             */
            if(resUser != null){
              app.globalData.isLogin = true
              app.globalData.userInfo = resUser
            }
            console.log(app.globalData.userInfo) 
          }  
        })    
      }   
    })     
  },
  /** 
   * checkSession 
   */
  checkSession:function(){
    wx.checkSession({ 
      success: () => { 
 
      },  
      fail: () => {
        app.login();
      }
    })
  },

  wxPromisify:function(fn){
    return new Promise((resolve, reject) => {
    })
  }
})