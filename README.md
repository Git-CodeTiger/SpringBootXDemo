###基于springboot mybatis的demo
- logback
- aop
- 统一异常处理
- spring-security

如上四点都有涉及，这个demo就是为了学习上面那些knowledge所写的，这个东西尽管很低级，但是本着靠谱的原则，给像我一样的初学者提供一种实例吧。

###环境要求
- JDK 1.8
- Gradle 2.3+

###数据库设计
项目配置`username==root, password==123456`，若跟不一致，请自行更改。事先将项目根目录下的springbootdemo.sql导入数据库项目默认导入流程：
- 创建springbootdemo数据库 `create database springbootdemo default charset utf8;`
- 进入项目的根目录：`mysqldump -u root -p spirngbootdemo > springbootdemo.sql`
- 输入你的数据库密码即可。

导入数据库中请查看内部结构，以便了解此demo.
###运行
环境，数据库都搞好后，在项目的根目录下运行`gradle bootRun`

###API
此demo就两个接口
- localhost:8000/
- localhost:8000/login
都是GET 请求，没有请求参数。　运行起来demo时，在地址栏上输入`localhost:8000/` 由于没有登陆的缘故会自动跳到　`localhost:8000/login`让用户登陆，数据库里存有普通用户---账号:xzh 密码:xzh;管理员---账号:wisely,密码:wisely. 用不同的身份登陆会有不同的显示效果。 
