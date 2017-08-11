### 自己写的小应用--天气预报

- 目的是学习 Android 技术
- 抵制那些加广告的天气预报应用

#### 购买数据
- 聚合数据：天气预报接口。
- appkey：5bbdd4c61885e51fc50c58347601c5f4

#### 参考地址
- 免费接口参考：http://blog.csdn.net/fancylovejava/article/details/26102635
- XML 转 JSON 参考：
    1. http://blog.sina.com.cn/s/blog_65f2b5c80101pth2.html 这个一开始可以用，后来一直报错。放弃这个。
    
    2. https://github.com/smart-fun/XmlToJson 这个非常好，一开始不知道在项目下的 build.gradle allprojects 标签下的 repositories 标签下要加 maven { url "https://jitpack.io" }。