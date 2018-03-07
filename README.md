# CORS与Spring Boot集成

[![MIT Licence](https://badges.frapsoft.com/os/mit/mit.svg?v=103)](https://opensource.org/licenses/mit-license.php)
![GitHub release](https://img.shields.io/github/release/windhc/cors-spring-boot-starter.svg)

### 使用方法
- 支持 Spring Boot 2 以上
- 添加依赖

```groovy
compile group: "com.windhc", name: "cors-spring-boot-starter", version: "1.1.0"
```

### 配置
```
# 必选。启用cors，值是一个布尔值
cors.enabled=
# 可选。设置允许跨域的接口地址，/**代表所有地址，默认/**
cors.mapping-path-pattern=
# 可选。"*"，表示接受任意域名的请求, 默认是"*"
cors.allowed-origins=
# 可选。(重要)设置允许跨域的请求方式，例如:GET,POST,PUT等，多个以逗号分隔，"*"代表允许所有的请求方法，默认：GET,HEAD,POST
cors.allowed-methods=
# 可选。配置Access-Control-Allow-Headers, "*"代表允许所有的头，默认允许所有的头
cors.allowed-headers=
# 可选。配置Access-Control-Expose-Headers, 此属性不支持"*"，默认不设置
cors.exposed-headers=
# 可选。配置Access-Control-Max-Age, 默认1800秒
cors.max-age=
# 可选。配置Access-Control-Allow-Credentials, 默认true
cors.allow-credentials=
```

### 参考资料
- CORS http://www.ruanyifeng.com/blog/2016/04/cors.html
