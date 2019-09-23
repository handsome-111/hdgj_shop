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
    this.login(this.globalData.userInfo).then(() => {
      console.log('APP准备完毕') 
      console.log(this.globalData.userInfo)
    })
  }, 
  globalData: {   
    userInfo: null,             //用户信息
    serverHost:'http://localhost',     //服务器地址
    isLogin:false,              //是否登陆
    appLoading:true,           //App是否还在加载
    session_key:null           //session_key
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
            url: app.globalData.serverHost + '/wxLogin',
            data: {
              //用户登录凭证（有效期五分钟）。开发者需要在开发者服务器后台调用 auth.code2Session，使用 code 换取 openid 和 session_key 等信息
              js_code: res.code,
              userinfo: userInfo
            },
            success: function (response) {
              var resUser = response.data.userInfo
              var session_key = response.data.session_key
              /**
               * 将用户信息存储在客户端内存中
               */
              if (resUser != null) {
                app.globalData.isLogin = true
                app.globalData.userInfo = resUser

                var util = require("/utils/util.js")
                var birthday = util.timestampToString(app.globalData.userInfo.birthday, 'l')
                app.globalData.userInfo.birthday = birthday
              }
              
              app.globalData.session_key = session_key
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
   * 注销
   */
  logout:function(){
    var app = this;

    return new Promise((resolve,reject) => {
      wx.request({
        url: app.globalData.serverHost + '/wxLogout',
        data: {
          session_key:app.globalData.session_key
        },
        complete:function(){
          app.globalData.userInfo = null
          app.globalData.session_key = null
          resolve()
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

  /**
   * 登录过滤
   */
  loginFilter:function(res){ 
    var userInfo = this.globalData.userInfo
    var app = this
    if(userInfo == null){
      wx.showModal({  
        title: '登录状态',
        content: '用户未登录,是否前往登录',
        confirmText:'登陆',
        success: function(response){
          if (response.confirm) {
            app.login().then(() => {
              /**
               * 跳转到用户页面
               */
              wx.navigateTo({
                url: '/pages/login/wxLogin/wxLogin',
                //events:
              })
            })
          }

          if (response.cancel) {
            /**
             * 跳转到原页面
             */
            //wx.navigateBack()
          }
        }
      })
      
    }

    if(userInfo != null){
      var url = res.url
      console.log('用户部位空')
      console.log(url.indexOf('/components/') == 0)
      console.log(url.indexOf('/pages/') == 0)  
      if (url.indexOf('/components/') == 0){
        wx.switchTab({
          url: url
        })
      }

      if(url.indexOf('/pages/') == 0){
        wx.navigateTo({
          url: url
        })
      }

    }
  },

  /**
   * 全局过滤器
   */
  filter:function(res){
    //1.登录过滤
    this.loginFilter(res)
  }
})