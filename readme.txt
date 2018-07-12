jdbc练习：客户管理的增、删、改、查。
测试测试
步骤：
    1.创建数据库和表：
    create database customerManager;
    use customerManager;
    create table customer(
        id varchar(30) primary key,
        customerName varchar(50) not null,
        sex varchar(20) not null,
        birthday date,
        email varchar(50) not null,
        hobbies varchar(50),
        type varchar(20) not null,
        remark varchar(255)
    );
    2.创建实体和包的目录结构,导入beanutils.jar mysql.jar
    cn.customer.controller
    cn.customer.service
    cn.customer.servilce.impl
    cn.customer.dao
    cn.customer.dao.impl
    cn.customer.domain
    cn.customer.utils
    cn.customer.test
    cn.customer.exception
    3.开发dao层
    4.开发service层
    5.开发controller层
    
    WEB-INF/page/index.jsp、addCustomer.jsp、findCustomer.jsp、message.jsp
	测试更新  猪肝测试1111