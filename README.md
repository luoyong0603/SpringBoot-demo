> 👨‍🎓作者：bug菌\
> 
> ✏️博客：CSDN、掘金、infoQ、51CTO等\
> 
> 🎉简介：CSDN|阿里云|华为云|51CTO等社区博客专家，历届博客之星Top30，掘金年度人气作者Top40，51CTO年度博主Top12，掘金 | InfoQ | 51CTO等社区优质创作者，全网粉丝合计**15w+** ；硬核微信公众号「猿圈奇妙屋」，欢迎你的加入！免费白嫖最新BAT互联网公司面试题、4000G pdf电子书籍、简历模板等海量资料。
>


## 前言

网络上关于Spring Boot杂而不精，很难系统化、全面地了解Spring Boot。如果想要对最新的技术要点进行系统的梳理、解读及应用， 推荐你看[《滚雪球学Spring Boot》](https://blog.csdn.net/weixin_43970743/category_11599389.html)

该专栏分为[【基础篇】](https://blog.csdn.net/weixin_43970743/category_11599389.html)和[【进阶篇】](https://blog.csdn.net/weixin_43970743/category_12296290.html)两个阶段；目的是为了由浅入深、循序渐进式的引导大家轻松入门Spring Boot；为了方便同学们可以吃透，bug菌特地将其理论知识与实战项目教程结合到了一起，以图文并茂的展示方式，最大程度的帮助你们弄明白。

所以，大家可以放心进行收藏&&订阅，便于同步学习；目前活动促销价9.9，活动结束后会恢复原价99；早买不会亏，投资自己学习性价比最高，一起拔高学习吧。


## SpringBoot学习路线汇总

如下我整理了Spring Boot从入门到精通的完整学习路线，其中对所有技术点都做了难易程度标识，以便于大家能精准投入对应的学习时长。
![](https://img-blog.csdnimg.cn/9e4696cb7415470ea01a8b0d5645857c.png)
​​

## 1. Spring Boot 是什么？
​        随着动态语言流行(Ruby,Scala,NodeJs等)，Java 开发变得相对笨重，配置繁琐，开发效率低下，部署流程复杂，以及第三方集成难度也相对较大，针对该环境，Spring Boot被开发出来，其使用“习惯大于配置目标”,借助Spring Boot 能够让项目快速运行起来，同时借助Spring Boot可以快速创建web 应用并独立进行部署(jar包 war 包方式，内嵌servlet 容器)，同时借助Spring Boot 在开发应用时可以不用或很少去进行相关xml环境配置，简化了开发，大大提高项目开发效率。

        Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，让Spring Boot在蓬勃发展的快速应用开发领域(rapid application development)成为领导者.

## 2. 为什么要学习Spring Boot？
        针对这个疑问，我分别从以下三个层面进行分析概述，告诉大家为什么Spring Boot 为什么非学不可！

### 2.1 从Spring官方来看
        我们打开 Spring 的官方网站，可以看到下图，你们能看到什么？


        表明官方对 Spring Boot 的定位是 ：Build Anything， Build任何东西。Spring Boot旨在尽可能快地启动和运行，并且只需最少的 Spring 前期配置。 同时我们也来看一下官方对后面两个的定位：

SpringCloud：Coordinate Anything，协调任何事情。
SpringCloud Data Flow：Connect everything，连接任何东西。
        仔细品味一下，Spring 官网对 Spring Boot、SpringCloud 和 SpringCloud Data Flow三者定位的措辞非常有味道，同时也可以看出，Spring 官方对这三个技术非常重视，是现在以及今后学习的重点（SpringCloud 相关达人课课程届时也会上线）。

### 2.2 从Spring Boot框架特点来看
        可创建独立Spring应用程序、嵌入式Tomcat，Jetty容器、无需部署WAR包、简化Maven及Gradle配置、尽可能自动化配置Spring、直接植入产品环境下的实用功能，比如度量指标、健康检查及扩展配置、无需代码生成及XML配置等，同时Spring Boot不仅对web应用程序做了简化，还提供一系列的依赖包来把其它一些工作做成开箱即用，让大家更加专注于业务逻辑。同时博主趁着周末也为大家收集整理了 SpringBoot 的思维导图学习路线，文末获取电子版思维导图。


### 2.3 从未来的发展趋势来看
        微服务是未来发展的趋势，项目会从传统架构慢慢转向微服务架构，因为微服务可以使不同的团队专注于更小范围的工作职责、使用独立的技术、更安全更频繁地部署。而 继承了 Spring 的优良特性，与 Spring 一脉相承，而且 支持各种REST API 的实现方式。Spring Boot 也是官方大力推荐的技术，可以看出，Spring Boot 是未来发展的一个大趋势。

        并且从 Vaadin 最近发布的一份有关企业中 Java 现状的研究报告也表明了，Spring Boot 已经超越 Spring 成为最受欢迎的 Java 后端框架：


        总而言之：既然市面上 Spring Boot 代表了企业的真实需求，那么，它就会表现在 Java 工程师、架构师的 求职面试技能清单上，Spring Boot 几乎是必备技能，所以，要成为合格的 Java 程序员，要学习 Spring 全家桶，Spring Boot 则是必经之路。

## 3. 专栏定位
        网络上关于Spring Boot杂而不精，很难系统化、全面地了解Spring Boot。如果想要对最新的技术要点进行系统的梳理、解读及应用， 一是根据官网的最新内容进行学习（需要精通英文且学习曲线比较陡峭），二就是阅读系统学习专栏或者其他相关资料。 于是乎，《滚雪球学Spring Boot》教程专栏横空出世啦。 

        为了写成此栏，bug菌是花费了近一年的巨量时间，以数年实际项目开发作为出发点，在其基础上再进行深度打磨、加强和完善， 并新增了 90% 以上的新内容，栏目发布后再核对修正，最后形成了本栏的大纲和学习体系。 

        本栏的内容规划是一个从零基础入门到进阶循序渐进的过程，即从 0 到 1。所以只要你是 Java 程序员就学习它，即使是没有任何 Spring Boot 使用经验的人，或者想系统学习 Spring Boot 技术的人，都推荐上手系统学习。 

## 4. 专栏目标
        该专栏会一直不断更新迭代，致力打造全网最新最全最有价值最详细最透彻的Spring Boot 学习教程，让学习者能从入门到精通，欢迎大家持续关注。

## 5. 本专栏能学到什么？
        本课程使用的是 Spring Boot 的 2.3.1 RELEASE 版本，课程文章均为作者在实际项目中剥离出来的场景和demo，目标是带领学习者快速上手 Spring Boot，将 Spring Boot 相关技术点快速运用在企业/微服务项目中。

全栏教学会分为两个阶段：[【基础篇】](https://blog.csdn.net/weixin_43970743/category_11599389.html)与[【进阶篇】](https://blog.csdn.net/weixin_43970743/category_12296290.html)

        [【基础篇】](https://blog.csdn.net/weixin_43970743/category_11599389.html)主要介绍 SpringBoot 在项目中最常使用的一些功能点，旨在带领学习者快速掌握 Spring Boot 在开发时需要的知识点，能够把 Spring Boot 相关技术运用到实际项目架构中去。该部分以 Spring Boot 框架为主线，内容包括Json数据封装、日志记录、属性配置、MVC支持、在线文档、模板引擎、异常处理、AOP 处理、持久层集成、事务等等。

        [【进阶篇】](https://blog.csdn.net/weixin_43970743/category_12296290.html)主要是介绍 SpringBoot 在项目中拔高一些的技术点，包括集成的一些组件，旨在带领学习者在项目中遇到具体的场景时能够快速集成，完成对应的功能。该部分以 Spring Boot 框架为主线，内容包括拦截器、监听器、缓存、安全认证、分词插件、消息队列等等。

        认真读完该系列文章之后，学习者会快速了解并掌握 Spring Boot 在项目中最常用的技术点，作者课程的最后，会基于课程内容搭建一个 Spring Boot 项目的空架构，该架构也是从实际项目中剥离出来，学习者可以运用该架构于实际项目中，具备使用 Spring Boot 进行实际项目开发的能力。

## 6. 适合阅读人群
本专栏教程适合以下人群阅读：

有一定的Java语言基础，了解Spring、Maven的在校学生或自学者。
有传统项目经验，想往微服务方向发展的工作人员。
热衷于新技术并对 Spring Boot 感兴趣的人员，尤其是初学 Spring Boot 和需要从传统 Spring 转向 Spring Boot 开发的技术人员。
希望了解 Spring Boot 2.x 的研究人员。
        所以，只要是 Java 程序员就适合，即使是没有任何 Spring Boot 使用经验的人，或者想系统学习 Spring Boot 技术的人，都推荐上手系统学习。 

## 7. Spring Boot学习文章汇总
        为了便于同学快速定位文章学习，熬夜几天整理出了[【基础篇】](https://blog.csdn.net/weixin_43970743/category_11599389.html)专栏的文章及有效地址，同学们敬请吩咐bug菌吧，[【进阶篇】](https://blog.csdn.net/weixin_43970743/category_12296290.html)目前还在梳理中，请耐心等待。

### 7.1 Spring Boot【基础篇】
​[导读：SpringBoot 学习指南(附思维导图)](https://luoyong.blog.csdn.net/article/details/130272237)

[Spring Boot入门(01)：Spring Boot的奋斗成长史](https://luoyong.blog.csdn.net/article/details/126618371)

[Spring Boot入门(02)：快速开发环境搭建和项目启动](https://luoyong.blog.csdn.net/article/details/125639200)

[Spring Boot入门(03)： yaml、properties配置文件介绍及使用](https://luoyong.blog.csdn.net/article/details/125678725)

[Spring Boot入门(04)：多环境切换，实例演示](https://luoyong.blog.csdn.net/article/details/125721763)

[Spring Boot入门(05)：starter基础入门](https://luoyong.blog.csdn.net/article/details/125808010)

[Spring Boot入门(06)：Spring Boot常用注解大全](https://luoyong.blog.csdn.net/article/details/125844323)

[Spring Boot入门(07)：整合 MySQL 和 Druid数据源(两万字教学)](https://luoyong.blog.csdn.net/article/details/125888409)

[Spring Boot入门(08)：整合Mybatis访问MySQL实现增删改查](https://luoyong.blog.csdn.net/article/details/125888409)

[Spring Boot入门(09)：使用MyBatis的XML配置方式访问MySQL实现增删改查](https://luoyong.blog.csdn.net/article/details/125845236)

[Spring Boot入门(10)： mybatis之xml映射文件＞、＜=等特殊符号写法](https://luoyong.blog.csdn.net/article/details/125886471)

[Spring Boot入门(11)：Spring Boot 整合 JPA](https://luoyong.blog.csdn.net/article/details/130204977)

[Spring Boot入门(12)：整合Mybatis-Plus mybatis-plus实现接口增删改查](https://luoyong.blog.csdn.net/article/details/125845236)

[Spring Boot入门(13)： Mybatis-Plus之条件构造器使用手册](https://blog.csdn.net/weixin_43970743/article/details/125846402)

[Spring Boot入门(14)： mybatis-plus之如何自定义sql](https://blog.csdn.net/weixin_43970743/article/details/125849168)

[Spring Boot入门(15)：Spring Boot 整合 MyBatis-Plus AutoGenerator 自动生成项目骨架代码](https://luoyong.blog.csdn.net/article/details/130561646)

[Spring Boot入门(16)：Spring Boot整合Swagger-UI实现在线API文档](https://luoyong.blog.csdn.net/article/details/130561701)

[Spring Boot入门(17)：Spring Boot整合Knife4j，美化强化丑陋的Swagger](https://luoyong.blog.csdn.net/article/details/130561847)

[Spring Boot入门(18)：Spring Boot静态资源映射](https://luoyong.blog.csdn.net/article/details/130346836)

[Spring Boot入门(19)：Spring Boot 整合 Thymeleaf 模板引擎，开发Web页面](https://luoyong.blog.csdn.net/article/details/126145700)

[Spring Boot入门(20)：实现多数据源配置，开箱即用](https://luoyong.blog.csdn.net/article/details/125886864)

[Spring Boot入门(21)：整合Log4j2以及配置详解](https://blog.csdn.net/weixin_43970743/article/details/125888965)

[Spring Boot入门(22)：整合LogBack 实现日志文件本地保存](https://blog.csdn.net/weixin_43970743/article/details/129424477)

[Spring Boot入门(23)：Spring Boot基于AOP拦截日志](https://blog.csdn.net/weixin_43970743/article/details/125896253)

[Spring Boot入门(24)：Spring Boot事务](https://blog.csdn.net/weixin_43970743/article/details/125889361)

[Spring Boot入门(25)：过滤器、拦截器、监听器对比及使用场景](https://luoyong.blog.csdn.net/article/details/125888751)

[Spring Boot入门(26)：实现邮件发送简单邮件、附件邮件、嵌入资源(图片)邮件、模板邮件等](https://luoyong.blog.csdn.net/article/details/125888177)

[Spring Boot入门(27)：war包部](https://blog.csdn.net/weixin_43970743/article/details/130204392)

[Spring Boot入门(28)：jar包部署](https://blog.csdn.net/weixin_43970743/article/details/109246305)

[Spring Boot入门(29)：如何实现热部署](https://blog.csdn.net/weixin_43970743/article/details/129425031)

[Spring Boot入门(30)：Windows安装Redis客户端？你玩过么](https://blog.csdn.net/weixin_43970743/article/details/125894591)
​

... ...

若想学习更多，这边请👉👉👉[《滚雪球学Spring Boot》](https://blog.csdn.net/weixin_43970743/category_11599389.html)👈👈👈

### 7.2 Spring Boot【进阶篇】
[Spring Boot进阶(01)：Spring Boot 集成 Redis，实现缓存自由](https://blog.csdn.net/weixin_43970743/article/details/125895363)

Spring Boot进阶(02)：使用Validation进行参数校验

Spring Boot进阶(03)：如何使用MyBatis-Plus实现字段的自动填充

Spring Boot进阶(04)：如何使用MyBatis-Plus快速实现自定义sql分页

Spring Boot进阶(05)：Spring Boot 整合RabbitMq，实现消息队列服务

Spring Boot进阶(06)：Windows10系统搭建 RabbitMq Server 服务端

Spring Boot进阶(07)：集成EasyPoi，实现Excel/Word的导入导出

Spring Boot进阶(08)：集成EasyPoi，实现Excel/Word携带图片导出

Spring Boot进阶(09)：集成EasyPoi，实现Excel文件多sheet导入导出

Spring Boot进阶(10)：集成EasyPoi，实现Excel模板导出成PDF文件

Spring Boot进阶(11)：Spring Boot 如何实现纯文本转成.csv格式文件？

Spring Boot进阶(12)：Spring Boot 如何获取Excel sheet页的数量？

Spring Boot进阶(13)：Spring Boot 如何获取@ApiModelProperty(value = “序列号“, name = “uuid“)中的value值name值？

Spring Boot进阶(14)：Spring Boot 如何手动连接库并获取指定表结构？一文教会你

Spring Boot进阶(15)：根据数据库连接信息指定分页查询表结构信息

Spring Boot进阶(16)：Spring Boot 如何通过Redis实现手机号验证码功能？

Spring Boot进阶(17)：Spring Boot如何在swagger2中配置header请求头等参数信息

Spring Boot进阶(18)：SpringBoot如何使用@Scheduled创建定时任务？

Spring Boot进阶(19)：Spring Boot 整合ElasticSearch

Spring Boot进阶(20)：配置Jetty容器

Spring Boot进阶(21)：配置Undertow容器

Spring Boot进阶(22)：Tomcat与Undertow容器性能对比分析

Spring Boot进阶(23)：实现文件上传

Spring Boot进阶(24)：如何快速实现多文件上传？

Spring Boot进阶(25)：文件上传的单元测试怎么写?

Spring Boot进阶(26)：Mybatis 中 resultType、resultMap详解及实战教学

Spring Boot进阶(27)：Spring Boot 整合 kafka(环境搭建+演示)

Spring Boot进阶(28)：Jar包Linux后台启动部署及滚动日志查看，日志输出至实体文件保存

Spring Boot进阶(29)：如何正确使用@PathVariable，@RequestParam、@RequestBody等注解？不会我教你，结合Postman演示

Spring Boot进阶(30)：@RestController和@Controller 注解使用区别，实战演示

... ...

若想学习更多，这边请👉👉👉[《SpringBoot 进阶实战》](https://blog.csdn.net/weixin_43970743/category_12296290.html) 👈👈👈

## 如何获取电子版思维导图？

关注下方公号《猿圈奇妙屋》，获取最新BAT互联网公司面试题、4000G pdf电子书籍、简历模板等硬核资源，你想要的应有尽有。

![](https://img-blog.csdnimg.cn/91d9b76b91aa462ea7326c3e9e67c77a.png)
