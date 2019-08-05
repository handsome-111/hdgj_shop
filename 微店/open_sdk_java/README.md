#微店开放平台sdk java版

##当前版本信息

    当前版本： V1.0
    发布日期： 2015-11-10

##修改历史
 
    V1.0  2015-11-10  版本发布。

##文件结构信息

    src/main/java
    	AbstractWeidianClient.java	客户端抽象接口，客户端通过该类进行api调用
    	DefaultWeidianClient.java	客户端默认实现类
    	request包					请求信息（接口地址、参数）封装
    	response包					响应数据封装
    	oauth包						用户授权（token获取）
    	http包						http调用实现
    src/test/java
    	TestCpsApi.java				cps相关接口测试代码
    	TestOAuth.java				oauth相关接口测试代码
    	TestOrderApi.java			订单相关接口测试代码
    	TestProductApi.java			商品相关接口测试代码
    src/test/resources
    	log4j2.xml					log4j2参考配置（也可使用其他log系统）
    	weidian_open.properties		sdk配置文件（重要：实际使用时请对此文件中信息按照实际情况进行配置，之后将配置好的文件放到classpath下）
    lib								依赖库目录
    lib/required					必需依赖库目录
    lib/optional					可选依赖库目录
    lib/optional/httpclient-4.5		httpclient-4.5可选依赖库
    lib/optional/log4j-2.3			log4j-2.3可选依赖库
  
    微店开放平台api还在不断增加中，详见： http://wiki.open.weidian.com/
    
##使用示例说明

1.首先需要将lib/required目录下jar包拷贝至您的classpath

2.sdk提供了默认的http调用实现，底层依赖于httpclient-4.5，如需使用默认实现请将lib/optional/httpclient-4.5目录下jar包拷贝至您的classpath<br/>
注：由于httpclient版本众多且兼容性较差，如果您不计划使用httpclient或者正在使用的httpclient版本与4.5版本不兼容，为了避免更换jar包引起过大的代码修改，我们提供了com.weidian.open.sdk.http.HttpService接口，您可以通过implements该接口实现自己的http调用，并在使用DefaultWeidianClient与OAuth时通过setHttpService(HttpService httpService)方法将自己的http调用实现注入给sdk

3.将src/test/resources下weidian_open.properties文件拷贝至您的classpath。修改配置内容：appkey及secret（对应自己应用的appkey及secret）为必填，http_前缀配置选项为http相关配置（选填，请根据实际情况进行配置）

4.sdk使用slf4j进行日志记录，如需记录日志，需自行添加相关日志实现jar包至classpath（如需使用log4j2，请将lib/optional/log4j-2.3目录下jar包拷贝至您的classpath，配置请参考src/test/resources下log4j2.xml）

具体接口使用示例请参考test中的auth,cps,order,product中的对应使用示例。  
基本使用方式有两种，以获取单个商品(vdian.item.get)为例:  
   
	调用方式一
    AbstractWeidianClient client = DefaultWeidianClient.getInstance();
    // 使用非sdk默认http调用时，通过以下方式将自己的http调用实现注入给sdk
    // client.setHttpService(xxxHttpServiceImpl);
    VdianItemGetRequest request = new VdianItemGetRequest(token, "48950776");
    try {
    	CommonItemResponse response = client.executePost(request);
    	String itemName = response.getResult().getItemName();
    } catch (OpenException e) {
    	// handle exception
    }
      
client为单例模式，在spring环境中可以通过默认构造器创建实例；token可通过oauth相关api获取；"48950776"为该接口所需参数（不同接口参数不同，通过不同的request类构建，每个接口对应一个单独的request类）

    调用方式二
    有时由于服务端接口更新（比如新增字段），将导致sdk的response对象中相应字段缺失，可以通过sdk返回json字符串的方式获取最新接口信息（此时需要sdk使用者自行解析json数据）
    AbstractWeidianClient client = DefaultWeidianClient.getInstance();
    // 使用非sdk默认http调用时，通过以下方式将自己的http调用实现注入给sdk
    // client.setHttpService(xxxHttpServiceImpl);
    VdianItemGetRequest request = new VdianItemGetRequest(token, "48950776");
    try {
    	String response = client.executePostForString(request);
    	// parse json
    } catch (OpenException e) {
    	// handle exception
    }
    
##联系我们
    微店开放平台官网：https://web.open.weidian.com/index
    可以访问我们的资料库获得详尽的技术文档：https://wiki.open.weidian.com/
    在线接口测试工具： https://web.open.weidian.com/playground/index
    此外，您可以通过企业QQ群 (577531386) 直接咨询