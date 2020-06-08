load("@rules_java//java:defs.bzl", "java_binary")

java_binary(
    name = "loginController",
    srcs = ["LoginController.java"],
    main_class = "net.javaguides.todoapp.controller.LoginController",
    deps = ["//:servlet","//src/net/javaguides/todoapp/dao:loginDao","//src/net/javaguides/todoapp/model:loginBean"],
    
)


java_binary(
    name = "userController",
    srcs = ["UserController.java"],
    main_class = "net.javaguides.todoapp.controller.UserController",
    deps = ["//:servlet","//src/net/javaguides/todoapp/dao:userDao","//src/net/javaguides/todoapp/model:user"],
    
)