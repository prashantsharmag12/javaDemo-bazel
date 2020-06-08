load("@rules_java//java:defs.bzl", "java_binary")

java_binary(
    name = "jdbcUtils",
    srcs = ["JDBCUtils.java"],
    main_class = "net.javaguides.todoapp.utils.JDBCUtils",
    visibility = ["//src/net/javaguides/todoapp/dao:__pkg__"],
    deps = ["//:bson","//:mongodbDriver","//:mongodbjavaDriver"]
   
    
)
