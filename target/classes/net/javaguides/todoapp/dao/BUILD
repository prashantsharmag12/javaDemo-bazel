load("@rules_java//java:defs.bzl", "java_binary")

java_binary(
    name = "loginDao",
    srcs = ["LoginDao.java"],
    main_class = "net.javaguides.todoapp.dao.LoginDao",
    visibility = ["//src/net/javaguides/todoapp/controller:__pkg__"],
     deps = ["//:bson", "//:mongodbDriver","//:mongodbjavaDriver" ,"//src/net/javaguides/todoapp/model:loginBean","//src/net/javaguides/todoapp/utils:jdbcUtils"],
    
)



java_binary(
    name = "userDao",
    srcs = ["UserDao.java"],
    main_class = "net.javaguides.todoapp.dao.UserDao",
    visibility = ["//src/net/javaguides/todoapp/controller:__pkg__"],
     deps = ["//:bson", "//:mongodbDriver","//:mongodbjavaDriver" ,"//src/net/javaguides/todoapp/model:user","//src/net/javaguides/todoapp/utils:jdbcUtils"],
    
)