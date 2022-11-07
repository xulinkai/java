

步骤：
1、创建一个标签解析类parser
2、创建一个解析器处理类 handler，在init方法中添加parser类
3、创建一个spring.handlers配置文件，让spring能够完成加载工作




坑
1、spring.handler 和 spring.schemas 文件如果名字首字母小写的话 发现这两个文件无法正常加载。首字母大写则可以正常加载
解决：在gradle.docs.gradle文件的194行 需要注释掉