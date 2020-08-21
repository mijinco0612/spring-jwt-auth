# api-auth

Spring APIの認証をJWT(JsonWebToken)で実装したサンプルです

#### 起動

```
./gradlew clean bootRun
```

#### ログイン

```
curl -v -X POST -d "{ \"loginId\" : \"test\", \"password\" : \"password\"}" -H "accept: application/json" -H "Content-Type: application/json" "http://localhost:8080/user/login" | jq .

```

##### ログイン成功時のレスポンス
```
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> POST /user/login HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.64.1
> accept: application/json
> Content-Type: application/json
> Content-Length: 46
>
} [46 bytes data]
* upload completely sent off: 46 out of 46 bytes
< HTTP/1.1 200
< X-Content-Type-Options: nosniff
< X-XSS-Protection: 1; mode=block
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-Frame-Options: DENY


***注1　↓のパラメタを保護されたAPIとの通信時のHEADERに付与して通信する　

< Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNTk3NzU3Mjg2fQ.tFzK6IejXfdvKqv00-qqWkllloLm0XhsKzQ1ifaMlr9CVuKCx7VLKUKLEaWtZwd5AMDm2PR5Yb-tAQqw2cNPvQ

< Content-Length: 0
< Date: Tue, 18 Aug 2020 05:28:06 GMT
<
100    46    0     0  100    46      0    500 --:--:-- --:--:-- --:--:--   500
* Connection #0 to host localhost left intact
* Closing connection 0
takamichi@MBA IdeaProjects %

```

#### tokenを使ったAPI実行

成功

```
注1で取得したパラメタを付与して通信すること。

curl -X GET -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNTk3NzU3Mjg2fQ.tFzK6IejXfdvKqv00-qqWkllloLm0XhsKzQ1ifaMlr9CVuKCx7VLKUKLEaWtZwd5AMDm2PR5Yb-tAQqw2cNPvQ" "http://localhost:8080/private" 
this is private
```

失敗

```
curl -X GET "http://localhost:8080/private"
{"timestamp":1516242884788,"status":403,"error":"Forbidden","message":"Access Denied","path":"/private"}


curl -X GET -H "Authorization: Bearer dummy" "http://localhost:8080/private"
{"timestamp":1516242871156,"status":500,"error":"Internal Server Error","exception":"io.jsonwebtoken.MalformedJwtException","message":"JWT strings must contain exactly 2 period characters. Found: 0","path":"/private"}
```




#### アカウント作成 
```
curl --location --request POST 'localhost:8080/user/signup' \
--header 'Content-Type: application/json' \
--data-raw '{
    "loginId":"test88",
    "password":"mogemoge"
}'
```




### 動作前提条件
以下のMySQL DataBaseが作成されていることを前提としています。

schema:app_db
```DDL
CREATE DATABASE `app_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */
```
table:peoples
```DDL
CREATE TABLE `peoples` (
  `login_id` text NOT NULL,
  `people_id` int NOT NULL AUTO_INCREMENT,
  `password` text NOT NULL,
  PRIMARY KEY (`people_id`),
  UNIQUE KEY `peoples_login_name_uindex` (`login_name`(100))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='アプリケーション利用者情報を格納するテーブル'
```
