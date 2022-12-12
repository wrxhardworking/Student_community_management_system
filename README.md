#  基于java swing框架+mysql实现的学生社团管理系统
##  项目内容：
**项目基于java swing 实现了一个社团管理系统** 
**项目提取点：https://github.com/wrxhardworking/Student-community-management-system**
## 项目演示
###  登陆界面
![在这里插入图片描述](https://img-blog.csdnimg.cn/f2ee98e2673643ffb52b793c33c55cd6.png)
###  管理界面
![在这里插入图片描述](https://img-blog.csdnimg.cn/24562c4fafd0418bab6fcc36b5bb58b1.png)
###  社团成员信息界面
![在这里插入图片描述](https://img-blog.csdnimg.cn/1dc807706e0c4848a10ad61760215917.png)

每一个功能基本上都有一个界面，这里就不一一展示。
##  项目功能介绍

 1. 对社团的增删改查
 2. 对成员的增删改查
 3. 通过一个社团查到对应的所有成员
 4. 通过一个成员能查看其参加的所有社团
 5. 展示社团和成员的基本属性
 6. 登陆注册
## 项目技术
 1. 基于jdbc使用mysql存储所有的数据
 2. 运用到mysql了多对多关系表(使社团和成员能多对多关联)
 3. java的基本面向对象思想
 4. java多线程编程（其实不需要，在表的刷新用了，现在感觉多此一举）
 5. swing的基本使用（图片背景的实现有很多种方式）
##  补充
数据库我是建了四张表，里面涉及了联合主键等知识，实现多对多关系。
![在这里插入图片描述](https://img-blog.csdnimg.cn/b3339ab18591419a98212f1d7a29fb2a.png)
##  总结
**简单的一个课设，想写篇文章纪念一下，大伙有兴趣就去看看吧，小白一个，可能代码写的比较low。**
