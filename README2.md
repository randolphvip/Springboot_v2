
###  
### Stricture

```
Springboot
├─doc  项目SQL语句以及文档
│
├─common 公共模块
│  ├─base Base继承通用类
│  ├─conf springBoot所有配置
│  ├─domain 前台返回包
│  ├─druid druid连接池
│  ├─exception 异常处理包
│  ├─file 文件上传
│  ├─interceptor 拦截器
│  ├─log 日志记录AOP
│  ├─domain 前台返回包
│  ├─quartz Spring定时器
│  └─support 工具包
│
├─controller 请求访问模块
│  ├─admin 模版后台请求包
│  ├─websocket websoket消息请求
│  └─HomeController.java 首页访问类
│
├─Mapper Dao模块
│  ├─auto mybatis-generator.xml自动生成Dao
│  └─custom 自定义Dao
│
├─Model 实体类模块
│  ├─auto mybatis-generator.xml自动生成实体包
│  └─custom 自定义实体
│
├─Service 服务层模块[没写抽象模块，因为我觉得没什么用，可能我能力不足]
│
├─shiro 权限模块
│  ├─config shiro配置
│  ├─service shiro服务层
│  └─util shiro通用方法
│
├─util 工具模块
│
├─SpringbootSwagger2Application 启动类
│ 
├─SpringbootWebInitializer tomcat启动类
│
├─test 测试类
│
├─resources 配置文件夹
│  ├─ehcache shiro权限缓存配置
│  ├─generator 自动生成模板以及配置目录
│  │   ├─MyBatisGenerator mybates半自动生成工具
│  │   │   ├─1.bat 执行批处理
│  │   │   ├─generator.xml generator配置文件
│  │   │   ├─mybatis-generator-core-1.3.2.jar generator1.3.2版本
│  │   │   ├─mybatis-generator-core-1.3.7.jar generator1.3.7版本【默认】
│  │   │   └─mysqldriver.jar mysql驱动【该驱动为8.0一下的版本不支持8.0自行替换】
│  │   │
│  │   ├─template 模板文件假
│  │   │   ├─controller anction模板
│  │   │   ├─html html页面模板
│  │   │   ├─mapper dao模板
│  │   │   ├─mapperxml daoxml模板
│  │   │   ├─model 实体模板
│  │   │   ├─service service模板
│  │   │   └─sql sql模板
│  │   │
│  │   └─generator.properties 自动生成配置文件
│  │
│  ├─mybatis mybatis Mapper.xml生成文件夹
│  │   ├─auto自动生成的Mapper.xml文件夹
│  │   └─custom 手写Mapper.xml文件夹
│  │
│  ├─static 静态文件存放文件夹[后台模版就放在此文件夹下面。所有的模版页面都在下面]
│  │   ├─admin 后台目录存放
│  │   │  ├─assets js、css存放路径
│  │   │  ├─assets js、css存放路径
│  │   │  └─bootstarp 后台模板存放路径
│  │   ├─js js存放
│  │   └─login 登录页面js、css、image
│  │
│  ├─templates 前台HTML存放文件夹
│  │   ├─admin 动态后台html模板
│  │   ├─error 错误页面html模板
│  │   └─login.html 登录html页面
│  │
│  ├─application-dev.yml 开发环境配置
│  ├─application-prod.yml 生产环境配置
│  ├─application.yml springboot配置
│  ├─banner1.txt springboot 启动动画
│  ├─logback.xml log4j配置文件
│  └─mybatis-generator.xml mybates自动生成 xml、dao、model
│  
└─pom.xml   maven.xml


```

### Back-end

技术|名称|官网|备注
---|---|---|---
springboot|springboot框架 ||
Apache Shiro|权限框架||
MyBatis Generator|代码生成||
PageHelper|MyBatis物理分页插件||
hikari|数据库连接池||
Thymeleaf|模板引擎||
Log4J|日志组件||
Swagger2|接口测试框架||
Maven|项目构建管理||
Websocket|websocket消息通知||
velocity|模板引擎||
kaptcha|google验证码||
devtools|热部署||
GSON|谷歌json||
druid|阿里连接池||
quartz|定时框架||




### Front-end
技术|名称|官网|备注
---|---|---|---
jQuery|函式库 || 
bootstrap|前端页面框架||
Font-awesome|字体图标||
jquery.validate|jquery验证插件||
                           |                ||
ladda.min.js|按钮加载js||
bootstrap-table|表格组件||
layer.js|弹窗组件||
jquery.blockUI.js|遮蔽层组件||
bootstrap-table-export.js|前台导出组件||
bootstrap-treeview|树结构组件||
bootstrap-colorpicker|颜色组件||
dropzone|文件上传||
bootstrap-wysihtml5|富文本||
bootstrap-switch|开关按钮||
UEditor|百度富文本||

### jar版本

| 名称       | 版本          | 备注 |
|------------|---------------|------|
| springBoot | 2.0.0.RELEASE |      |
| mybatis-spring 1.3.2 | 1.3.2         |      |
| swagger2   | 2.7.0         |      |
| swagger-ui | 2.7.0         |      |
| gson       | 2.8.2         |      |
| pagehelper | 4.1.4         |      |
| mysql|5.1.40 OR   8.0.11      |      |
| shiro|1.4.0         |      |
| thymeleaf-extras-shiro|2.0.0         |      |
| thymeleaf|2.0.0.RELEASE         |      |
| commons-lang3|  3.7       |      |
| commons-lang|2.4         |      |
| commons-io|2.5         |      |
| commons-fileupload|1.3.3         |      |
| spring-boot-devtools|2.0.0.RELEASE         |      |
| hutool| 4.1.10        |      |
| druid| 1.1.10        |      |
| kaptcha| 2.3.2        |      |
| velocity| 1.7        |      |

### TOOLS
- JDK8.0
- mysql8
- eclipse



- JDK8
- Maven

### Database Model




|      |      |      |      |
| ----------- | ----------------------- | ------------------ | -------------------------------------- |
|      |      |      |      |
|      |      |      |      |
|      |      |      |      |
|      |      |      |      |
|      |      |      |      |
|      |      |      |      |
|      |      |      |                                        |
