# Retrofit_analysis

Retrofit 使用以及源码分析

参考 
    https://blog.csdn.net/carson_ho/article/details/73732076
    https://www.jianshu.com/p/a3e162261ab6
    https://www.jianshu.com/p/0c055ad46b6c






总结
Retrofit 是一个 restful 的 HTTP 网络请求框架的封装。
网络请求的工作本质上是 OkHttp 完成，而 Retrofit 仅负责 网络请求接口的封装
App应用程序通过 Retrofit 请求网络，实际上是使用 Retrofit 接口层封装请求参数、Header、Url 等信息，之后由 OkHttp 完成后续的请求操作
在服务端返回数据之后，OkHttp 将原始的结果交给 Retrofit，Retrofit根据用户的需求对结果进行解析
相对其他开源库而言代码简洁使用更加方便.



