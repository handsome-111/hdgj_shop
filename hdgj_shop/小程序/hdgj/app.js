//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs) 
    this.login(this.userInfo)
    console.log('APP准备完毕')
  }, 
  globalData: {  
    userInfo: null,             //用户信息
    serverHost:'localhost',     //服务器地址
    isLogin:false,              //是否登陆
    appLoading:true           //App是否还在加载
  },
  /**
   * 用户登陆
   */
  login: function(userInfo){ 
    var app = this

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
            userinfo: null
          },
          success: function (response) {
            var resUser = response.data.userInfo
            /**
             * 将用户信息存储在客户端内存中
             */
            if (resUser != null) {
              app.globalData.isLogin = true
              app.globalData.userInfo = resUser
            }
          },
          complete:function(){
            app.globalData.appLoading = false
            console.log('加载完成')
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
        app.login(app.globalData.userInfo);
      }
    })
  },


})