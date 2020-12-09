### 第 1：Authorization Code Grant

#### 第一步：Authorization Request
```
http://localhost:8080/authServer/oauth/authorize?response_type=code&client_id=client-01&redirect_uri=http://localhost:8081/auth/callback&scope=all&state=123

```

```
http://localhost:8080/authServer/oauth/authorize?response_type=code&client_id=client-02&redirect_uri=http://localhost:8082/auth/callback&scope=all&state=123

```
