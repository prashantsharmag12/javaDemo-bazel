load("@rules_java//java:defs.bzl", "java_binary")







java_library(
    name = "servlet",
    visibility = ["//src/net/javaguides/todoapp/controller:__pkg__"],
    exports = [
        "@maven//:javax_servlet_javax_servlet_api",
    ],
    
)

java_library(
    name = "bson",
    visibility = ["//src/net/javaguides/todoapp/utils:__pkg__","//src/net/javaguides/todoapp/dao:__pkg__"],
    exports = [
        "@maven//:org_mongodb_bson",
    ],
    
)

java_library(
    name = "mongodbDriver",
    visibility = ["//src/net/javaguides/todoapp/utils:__pkg__","//src/net/javaguides/todoapp/dao:__pkg__"],
    exports = [
        "@maven//:org_mongodb_mongodb_driver_core",
    ],
    
)
java_library(
    name = "mongodbjavaDriver",
    visibility = ["//src/net/javaguides/todoapp/utils:__pkg__","//src/net/javaguides/todoapp/dao:__pkg__"],
    exports = [
        "@maven//:org_mongodb_mongo_java_driver",
    ],
    
)







 





