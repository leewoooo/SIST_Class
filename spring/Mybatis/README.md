Springboot환경에서 MyBatis 연동하기
===

## 마이바티스란?

객체 지향 언어인 자바의 관계형 데이터베이스 프로그래밍을 좀 더 쉽게 할 수 있게 도와 주는 개발 프레임 워크로서 JDBC를 통해 데이터베이스에 엑세스하는 작업을 캡슐화하고 일반 SQL 쿼리, 저장 프로 시저 및 고급 매핑을 지원하며 모든 JDBC 코드 및 매개 변수의 중복작업을 제거 합니다. Mybatis에서는 프로그램에 있는 SQL쿼리들을 한 구성파일에 구성하여 프로그램 코드와 SQL을 분리할 수 있는 장점을 가지고 있습니다. <br>

간단하게 정리하자면 한 두줄의 자바코드로 DB와 연동할 수 있으며 SQL명령어를 자바코드에서 분리하여 XML파일에 따로 관리할 수 있는 장점을 가지고 있습니다.

## 마이바티스의 구조

* 구조

    <img src = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile2.uf.tistory.com%2Fimage%2F99E306495A4CCD831EE1A6">

    <참조 : https://sjh836.tistory.com/127 >

<br>

mybatis-config는 mybatis의 메인 환경설정 파일이다. 어떤 DBMS와 커넥션을 맺을지, 어떠한 mapper파일들이 있는지 알 수 있습니다. 

<br>

---

<br>

## 사용하기

0. 의존성 주입해주기

    MyBatis를 사용하기 위해 현재 실습환경(maven)에서 의존성을 추가해준다. pom.xml
    ```
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>2.1.4</version>
    </dependency>
    ```

<Br>

1. mybatis-config 만들기

    먼저 [mybatis-공식-홈페이지](https://mybatis.org/mybatis-3/ko/index.html)에 접속을 합니다. 접속을 하게되면 참고할 수 있는 레퍼런스가 존재하는데 mybatis-config는 다음과 같이 작성하도록 제공해주고 있다. 이 곳에 db정보인 드라이버,url,username,password를 입력하여 DB와 커넥션을 맺습니다. 그 후 mappers의 하위 노드에 mapper파일들을 추가합니다.

    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE configuration
    PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-config.dtd">
    <configuration>
    <environments default="development">
        <environment id="development">
        <transactionManager type="JDBC"/>
        <dataSource type="POOLED">
            <property name="driver" value="${driver}"/>
            <property name="url" value="${url}"/>
            <property name="username" value="${username}"/>
            <property name="password" value="${password}"/>
        </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="com/goodfile/db/goodsMapper.xml"/>
    </mappers>
    </configuration>
    ```

    또한 다음과 같이 alias설정이 가능하다 아래의 예제코드를 확인하면 com.goodfile.vo.GoodVO를 goodVO로 줄여쓸 수 있도록 alias설정을 해서 mapper 파일에서 alias를 사용할 수 있게 됩니다.
    ```xml
    <typeAliases>
  	    <typeAlias type="com.goodfile.vo.GoodVO" alias="goodVO"/>
    </typeAliases>
    ```

<br>

2. mapper xml 작성하기

    mapper xml은 실제 query문이 작성되는 공간이며 mapper xml은 mybatis-config에 추가됩니다. 위의 mybatis-config예제 코드에서 사용된 goodsMapper.xml를 살펴보며 확인해보자면 아래와 같이 작성을 하게되는데 이또한 작성form은 [mybatis-공식-홈페이지](https://mybatis.org/mybatis-3/ko/index.html)에서 제공을 해주고 있습니다.

    ```xml
    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
        <mapper namespace="GoodsMapper">
        <select id="findAll" resultType="goodVO">
            SELECT * FROM GOODS
        </select>
        
        <select id="findByNo" resultType="goodVO" parameterType="int">
            SELECT * FROM GOODS WHERE NO=#{no}
        </select>
        
        <insert id="save">
            INSERT INTO GOODS VALUES(#{no},#{name},#{qty},#{price},#{fname})
        </insert>
        
        <delete id="deleteByNo">
            DELETE FROM GOODS WHERE NO=#{no}
        </delete>
        
        <update id="update">
            UPDATE GOODS SET NAME=#{name},QTY=#{qty},PRICE=#{price},FNAME=#{fname} WHERE NO=#{no}
        </update>
    </mapper>
    ```

    넘어오는 값을 #{}로 받을수 있으며 VO(DTO)가 넘어온다면 ${}안에 필드명을 넣어주어 받을 수 있게 된다.

<br>

3. SqlSessionFactory class 만들기

    * SqlSessionFactoryBuilder 클래스 : build() 메소드를 통해 mybatis-config를 로딩하여 SqlSessionFactory 객체를 생성합니다.

    * SqlSessionFactory 클래스 : SqlSession 객체에 대한 팩토리 객체다. 이 객체의 openSession() 이라는 메소드를 통해 SqlSession 객체를 얻을 수 있습니다.

    * SqlSession 클래스 : Mapper XML 에 등록된 SQL을 실행하기 위해 API 를 제공

        - public Object selectOne(String stmt, Object param) : 하나의 데이터를 검색, 두개 이상 리턴되면 예외 발생

        - public List selectList(String stmt, Object param) : 여러 개의 데이터를 검색

        - public int insert(String stmt, Object param) : 몇 건 삽입했는지 리턴

        - public int update(String stmt, Object param) : 몇 건 갱신했는지 리턴

        - public int delete(String stmt, Object param) : 몇 건 삭제했는지 리턴

    ```java
    public class SqlSessionFactoryBeen {

        private static SqlSessionFactory sessionFactory = null;
        static {
            if(sessionFactory == null) {
                try(Reader reader = Resources.getResourceAsReader("com/goodfile/db/dbConfig.xml")){
                    
                    sessionFactory = new SqlSessionFactoryBuilder().build(reader);
                    
                }catch (IOException e) {
                    e.printStackTrace();
                }//end try
            }//end if
        }//end static 
        public static SqlSession getSqlSession() {
            //openSession를 얻을 때 매개변수로 true를 넣어주면 autocommit이다 기본값은 false
            return sessionFactory.openSession();
        }
    }
    ```

    위의 코드와 같이 SqlSession을 생성하여 DAO에서 사용을 하게 됩니다. 이제 DAO에서 어떻게 사용하는지 확인해보겠습니다. (SqlSession을을 openSession()으로 얻어올 때 매개변수로 boolean으로 true를 넣어주게 되면 AutoCommit를 이용할 수 있다. 기본값은 false입니다.)

<br>

4. DAO

    ```java
    public class GoodDAO {
        
        private SqlSession session;
        
        public GoodDAO() {
            session = SqlSessionFactoryBeen.getSqlSession();
        }
        
        public List<GoodVO> findAll(){
            return session.selectList("GoodsMapper.findAll");
        }

        public int save(GoodVO goodVO) {
            return session.insert("GoodsMapper.save", goodVO);
        }
        
        public GoodVO findByNo(int no) {
            return session.selectOne("GoodsMapper.findByNo", no);
        }
        
        public int deleteByNo(int no) {
            return session.delete("GoodsMapper.deleteByNo", no);
        }
        
        public int update(GoodVO goodVO) {
            return session.update("GoodsMapper.update", goodVO);
        }
        
        public void commit() {
            session.commit();
        }
        
        public void rollback(){
            session.rollback();
        }
    }
    ```

    DAO에서 SqlSession을 얻어와서 이전 mapper xml에서 생성해 두었던 query문을 사용하여 DB에 접근하고 데이터를 처리합니다. SqlSession을 얻을 때 Autocommit를 설정하지 않아 아래에 commit와 rollback의 method를 생성하여 트랜잭션 이후 결과를 처리할 수 있도록 해주었습니다.

<br>

이렇게 DAO까지 작성을 하게 되면 Controller에서 DAO를 DI로 주입받아서 DAO의 method를 이용하여 데이터를 처리하고 처리한 데이터를 Model에 실어서 view로 전달을 해주게 되는것이다.

<br>

이제 Mybatis설정이 끝났으니 스프링에게도 어떠한 DB에 연결을 할지 Driver,URL,USER,Password와 같은 것을 application.properties에 설정을 해주어야 한다.

```
spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
spring.datasource.data-username=scott
spring.datasource.data-password=tiger
```

또한 현재 실습에는 Oracle을 사용하기 때문에 의존성으로 드라이버 라이브러리를 추가해준다.

```
<dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
    <scope>runtime</scope>
</dependency>
```