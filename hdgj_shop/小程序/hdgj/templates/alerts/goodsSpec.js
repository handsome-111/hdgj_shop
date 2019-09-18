var temp = {
  /**
     * 选择指定规格
     */
  selectedTitle :function (index) {
    console.log("当前选择的是第" + index)
    this.setData({
      selectedTitle: index
    })
  }
}

export default temp
