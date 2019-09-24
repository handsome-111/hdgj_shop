// pages/newAddress/newAddress.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    address:null,
    checked:2,
    region: [],
    customItem: '其他'
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  }, 

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  /**
   * 删除
   */
  deleteAddress:function(){
    wx.request({
      url: app.globalData.serverHost + '/address/deleteAddress?id=' + 9,
      success:function(res){
        var status = res.data.data
        if(status == 1){
          wx.showToast({
            title: '删除成功',
            icon:'success',
            duration: 1500,
            success:function(){
              wx.navigateBack()
              return 
            }
          })
        }

        if(status == 0){
          wx.showToast({
            title: '操作失败',
            icon: 'none',
            duration: 1500
          })
        }
        
      }
    })
  },

  bindRegionChange:function(e){
    var region = e.detail.value
    this.setData({
      region:region
    })
  },

  /**
   * 表单提交
   */
  formSubmit:function(e){
    var address = this.formatToAddress(e.detail.value)
    this.setData({
      address : address
    })
    console.log(address)
    wx.request({
      url: app.globalData.serverHost + '/address/updateAddress', 
      method:'post',
      data:{
        requestParam:{
          address:address,
        }
      },
      header: { 
        //"Content-Type": "application/x-www-form-urlencoded"
        "Content-Type": "application/json" 
      },
      success:function(res){
        console.log(res.data) 
      }  
    })
  },    
  /**
   * 格式化
   */
  formatToAddress:function(object){
    var region = object.region.toString()
    if(object == null){
      return null
    }
    region = region.split('，')

    var address = {
      name: object.name,
      phone: object.phone,
      post: object.post,
      province: region[0],   //省
      city: region[1],       //城市
      region: region[2],     //区
      isDefault : object.isDefault.length == 0 ? 2 : 1    //是否为默认地址
    }
    return address
  },

  aaa:function(e){
    console.log(e.detail + ","  +e.target)
  } 
})