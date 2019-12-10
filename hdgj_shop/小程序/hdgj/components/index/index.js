// components/index/index.js
const app = getApp();

Component({
  created: function (){
  },
  pageLifetimes: {
    show() {
      // if (typeof this.getTabBar === 'function' && this.getTabBar()) {
      //   this.getTabBar().setData({
      //     selected: 0
      //   }) 
      // } 
      this.getSwiperHeight();
      this.getShopProduct(1);
    }
  },
  /**
   * 组件的属性列表
   */
  properties: { 

  },

  /**
   * 组件的初始数据
   */
  data: {
    swiperHeight: 0,
    images: {
      url: 'http://img1.imgtn.bdimg.com/it/u=735014917,976731480&fm=26&gp=0.jpg',
    },
    
    swiper_block:[
      { imageSrc:'/images/index/1.jpg' , url:''},
      { imageSrc: '/images/index/1.jpg', url: '' }
    ],
    list:''
  },

  /**
   * 组件的方法列表
   */
  methods: {
    /*获取轮播图片高度*/ 
    getSwiperHeight: function (){
      const query = wx.createSelectorQuery();
      var element = query.select('#the-id');
      element.fields({
        size: true
      },function (res){
        return res.height;
      });
    },
    getShopProduct:function(page){
      var that = this
      wx.request({
        url: app.globalData.serverHost + '/shopProduct/getShopProducts',
        data:{
          page:page,
          size:30
        }, 
        success:function(data){
          var array = data.data.data
          
          for(var i = 0; i < array.length; i++){
            array[i] = JSON.parse(array[i])
          }

          console.log(array)
          that.setData({
            list:data.data.data
          })
        }
      }) 
    }
  }
  
})
