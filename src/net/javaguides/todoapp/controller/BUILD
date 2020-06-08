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


java_binary(
    name = "todoController",
    srcs = ["TodoController.java"],
    main_class = "net.javaguides.todoapp.controller.TodoController",
    deps = ["//:servlet",
    "//src/net/javaguides/todoapp/dao:todoDao",
    "//src/net/javaguides/todoapp/model:todo",
    "//src/net/javaguides/todoapp/model:loginBean",
     "//src/net/javaguides/todoapp/dao:todoImpl",
    
    
    
    
    ],
    
)