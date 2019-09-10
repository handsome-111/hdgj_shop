//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs) 
    wx.showLoading({
      title: '加载中',
    })
    this.login(this.globalData.userInfo).then()
    console.log('APP准备完毕')
  }, 
  globalData: {  
    userInfo: null,             //用户信息
    serverHost:'http://localhost',     //服务器地址
    isLogin:false,              //是否登陆
    appLoading:true           //App是否还在加载
  },
  /**
   * 用户登陆
   */
  login: function(userInfo){ 
    var app = this

    return new Promise((resolve,reject) => {
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
              userinfo: userInfo
            },
            success: function (response) {
              var resUser = response.data.userInfo
              /**
               * 将用户信息存储在客户端内存中
               */
              if (resUser != null) {
                app.globalData.isLogin = true
                app.globalData.userInfo = resUser

                var util = require("/utils/util.js")
                var birthday = util.timestampToString(app.globalData.userInfo.birthday, 'l')
                console.log(birthday)
                app.globalData.userInfo.birthday = birthday
                console.log("登陆响应的user:" + app.globalData.userInfo)
              }
            },
            complete: function () {
              app.globalData.appLoading = false
              wx.hideLoading()
              resolve()
            }
          })
        }
      }) 
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