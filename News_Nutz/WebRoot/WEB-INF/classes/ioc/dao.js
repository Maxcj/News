/**
 * 
 */
var ioc = {
    //对象名称
        dataSource : {
       //对象的Java类型
            type : "com.alibaba.druid.pool.DruidDataSource",
       //这里声明对象的事件。事件的处理函数可以是一个接口，也可以是自身的一个方法
            events : {
        //当这个对象被创建后，会调用这个接口的唯一方法
                create : "init",
        // 当对象被容器销毁时触发。
                depose : 'close'
            },
      //详细声明每个字段的值
            fields : {
                url : "jdbc:mysql://127.0.0.1:3306/examonline?useSSL=false & serverTimezone=Hongkong",
                username : "root",
                password : "admin",
                testWhileIdle : true,
                validationQuery : "select 1" ,
                maxActive : 100
            }
        },
        dao : {
            type : "org.nutz.dao.impl.NutDao",
      //构造函数参数，即对象要有对应的构造函数，否则抛错
            args : [{refer:"dataSource"}]
        }
};