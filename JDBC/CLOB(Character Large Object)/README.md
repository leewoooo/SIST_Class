# CLOB (Charcter Large Object)

* 4GByte의 문자열을 저장 할 때 사용한다.

* 조회 할 때 별도의 Stream을 연결하여 조회한다. (Web Server에 있는 것을 조회할 때는 Stream필수)

  * Server와 Client가 같은 local에 있을 때는 getString로 가능하지만 web에 있을 경우 불가능

* 값을 입력 할 때 내용에 ' (Single quote)를 포함해서는 안된다.

## 사용법 (순서)

0. ResultSet을 얻는다.
```java
ResultSet rs = pstmt.executeQuery();
```

1. Clob를 얻는다.
```java
Clob clob = rs.getClob("clob의 column명");
```

2. Clob에서 문자열 읽기스트림을 얻고, 줄단위로 읽어들이는 기능을 가진 Stream과 연결한다.
```java
BufferedReader br = new BufferedReader(clob.getCharacterStream());
```

3. BufferedReader에서 줄 단위로 읽는다.
```java
String str =" ";
while( (str=br.readLine()) !=null ){
  //str을 사용
}
```

4. Stream 끊기
```java
br.close();
```

## 정리된 코드 (실제 사용의 흐름)

```java
rs = pstmt.executeQuery();

Clob clob = null;
BufferedReader br = null;
String str = "";

while(rs.next()){
  clob = rs.getClob("clob컬럼명");

  try{
    br = new BufferedReader(clob.getCharacterStream());

    while( (str=br.nextLine() != null ){
      //str의 처리
    }
  catch(IOException IE){
    //IOException 처리
  } 
  }finally{
    br.close();
  }
}
```