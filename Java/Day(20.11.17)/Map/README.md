Map
===

### Map의 특징

* 이차원 배열의 구조를 가진다.

* 가변 길이형의 특징을 갖지만 열의 길이는 2열로 고정이고 행의 길이가 가변적이다.
    > **`열은 항상 key , value 를 갖습니다.`**

* **`map은 key와 값을 Value입니다.(key와 value의 한 쌍을 entry라고 한다)`**

* key를 가지고 값을 검색을 한다. (key의 값을 넣어 값을 얻어낸다.)
    > -key는 **`중복될수 없으며 유일하다`** <br>
    -`값은 중복될 수 있다`.<br>
    -**`만약 동일한 key로 value값을 넣으면 덮어 쓰여진다.`**

* map의 상속도
    1. Map.Hashtable
        >-동기화가 되어 있다, Multi Thread 지원 X <br>
        -기본 생성자로 생성하면 `11개의 행`이 생성된다.
    2. Map.Hashmap
        >-동기화가 되어있지 않다, Multi Thread 지원 O <br>
        -기본 생성자로 생성하면 `16개의 행`이 생성된다.

    * 공통적인 특징
        >전체 크기의 행에서 약 75%의 DATA가 채워졌을 때 가장 빠르게 검색한다. (70%~80%)

* java에서 발생하는 모든 Data type을 저장 할 수 있다.

---

### 사용방법

* HashMap으로 예제 (둘다 같은 부모를 상속 받기에 사용은 비슷하다.)

1. 생성
    ```java
    Map<k,V> map = new HashMap<K,V>();
    //K = key에 대한 Generic
    //V = Value에 대한 Generic
    ex)
    Map<String,String> map = new HashMap<String,String>(); //16개의 행이 생성
    ```
2. 값 넣기 (값은 순차적으로 들어가지 않는다.)
    ```java
     map.put(K,V);

     ex)
     map.put("Java","완벽한 OOP언어");
     map.put("OraCle","대용량 데이터");
     map.put("JDBC","java DB연동");
     map.put("HTML","웹의 구조를 담당");
     /*
     memory구조
     heap에는 key가 저장되는 key table과 value를 관리하는 value table로 구성된다.
     */
     ```

3. 행의 크기 얻기
    ```java
    map.size(); //int 형으로 반환
    ```
4. 값 얻기 (key에 대한 값을 얻는다.)
    * get(key) method를 이용하여 Value를 얻는다.
    ```java
    map.get(key의 명); //key에 합당한 Value 값이 반환된다.
    ```
5. key가 존재하는지 
    ```java
    map.containsKey(key의 명); //반환 값은 불린
    ```
6. 값을 삭제
    ```java
    map.remove(key); //key에 해당하는 Value와 함께 삭제된다. (레코드가 삭제된다)
    ```
7. 모든 값 삭제(모든 레코드 삭제)
    ```java
    map.clear();
    ```
8. 모든 키 얻기 (map이 어떠한 값을 가지고 있는지 검증할 때 사용)
    ```java
    Set<E> set = map.keySet(); //map에 해당한 key를 set으로 집어 넣는다.
    
    //반복을 시키기 위해 Iterator을 사용
    Iterator<E> ita = set.Iterator(); 
    //Iterator는 set의 가장 처음으로 pointer을 이동

    while(ita.hasNext()){
        map.get(ita.next()); //모든 key에 대한 값을 얻을 수 있다.
    }//while
    ```

---