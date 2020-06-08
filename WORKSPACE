load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

RULES_JVM_EXTERNAL_TAG = "2.8"
RULES_JVM_EXTERNAL_SHA = "79c9850690d7614ecdb72d68394f994fef7534b292c4867ce5e7dec0aa7bdfad"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")
maven_install(
    artifacts = [
    	
        "javax.servlet:javax.servlet-api:3.1.0",
        "org.mongodb:bson:3.0.1",
        "org.mongodb:mongodb-driver-core:3.0.1",
        "org.mongodb:mongo-java-driver:3.0.1",
        
        
    ],
    repositories = [
         "https://repo1.maven.org/maven2/",
         
         "https://repo1.maven.org/maven2/",
         
         "https://repo1.maven.org/maven2/",
         
         "https://repo1.maven.org/maven2/",
         
    ]
)









