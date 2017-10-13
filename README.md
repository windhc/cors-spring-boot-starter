# CORS与Spring Boot集成

### 使用方法
- 添加依赖

```groovy
compile group: "com.windhc", name: "cors-spring-boot-starter", version: "1.0.0"
```

### 配置
```
# 必选。启用cors，值是一个布尔值
cors.enabled=
# 必选。它的值要么是请求时Origin字段的值，要么是一个*，表示接受任意域名的请求
cors.allow-origin=
# 可选。配置Access-Control-Allow-Headers/Access-Control-Expose-Headers
cors.allow-headers=
# 可选。配置Access-Control-Allow-Credentials，默认值false，表示是否允许发送Cookie
cors.allow-credentials=
```
