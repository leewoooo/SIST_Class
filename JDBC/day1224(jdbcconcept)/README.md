# JDBC (Java Database Connectivity)

* Java에서 DBMS를 사용(연동)하기 위한 방법을 제공하는 저수준의 API.

* Driver Loading방식을 사용하여 Driver만 제공된다면 모든 DBMS와 연결이 가능하다.(확장성이 좋다.)
* Driver는 Java에서 제작 배포하는 것이 아닌 DB제조사에서 Driver를 제작하여 배포한다.

* Java의 sql Package에서 관련 class들을 제공한다.

* Driver는 4가지 형으로 제공한다.

  * JDBC-ODBC Bridge Driver (Type1)
    *  windows운영체제만 사용되는 Driver이다. (DB연동 관리를 OS의 ODBC에서 수행하고 Java는 ODBC와 연결) ,속도가 느리다.

  

  * Native Driver (Type2 : OCI Driver)
    * 모든 운영체제에서 사용이 가능하다.
    * DB쪽의 연결 언어가 Java언어가 아닌 언어로 개발된 Driver. (언어간의 충돌에 대한 issue가 발생 할 수 있다.)

  

  * Network Protocol Driver (Type3)
    * Middle ware에서 사용하는 Driver

  

  * Native Protocol Driver  (Type4 : Thin)
    * 모든 운영체제에서 사용이 가능하다.
    * 연결에 필요한 모든 부분이 Java 로 개발 된 Driver

---

## JDBC연동 순서

1. 드라이버 로딩(build path를 설정하여 jar file을 가져온다.)

2. 로딩된 드라이버를 사용하여 DB와 연결을 얻는다.

3. query 생성 객체 얻기

4. query 수행 후 결과 얻기

5. 연결 끊기

   <img src = https://user-images.githubusercontent.com/74294325/103075729-8d0faa80-460f-11eb-9a5c-a96e2d6f9f1e.PNG>