//app.js
App({
  onLaunch: function () {
    // 展示本地存储能力
    var logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs) 
     
  }, 
  globalData: {  
    userInfo: null,
    serverHost:'localhost'
  },
  /**
   * 用户登陆
   */
  login: function(userInfo){ 
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
             console.log(response)  
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

  
})