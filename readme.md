# https 하는 방법

## java bin 가서 파일 생성

.\keytool -genkey -alias bootsecurity -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore bootsecurity.p12 -validity 3650

이후에 알아서 설정

'Not secure' 경고가 발생 하는데
이유는 Self Signed SSL Certificate를 사용했기 때문
실제 운영환경에서 사용하는 정식 SSL Certificate를 사용할 경우 위의 경고는 없어짐
