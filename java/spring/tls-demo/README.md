# 스프링 부트 프로젝트에 TLS 적용

## 인증서 생성

``` bash
$ keytool -genkey -keyalg RSA -keystore server.jks -validity <days> -keysize 2048

$ keytool -importkeystore -srckeystore server.jks -destkeystore server.jks -deststoretype pkcs12
```

## 인증서 정보 확인

```bash
$ keytool -list -v -keystore selfsigned.jks
```