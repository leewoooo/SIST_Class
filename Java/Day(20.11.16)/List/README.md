List
===

* List 예제코드 [code](https://github.com/LeeWoooo/SIST_Class/blob/master/Java/Day(20.11.16)/List/UseList.java)

* 일차원 배열의 구조를 가지고있다.
    >-일차원 배열은 고정 길이의 특징을 가지고있다. <br>
     -**List는 가변 길이의 특징을 가지고있다.(발생하는 data의 갯수를 몰라도 된다.)**

* 가변 길이
    >값을 추가하면 방의 길이가 늘어나고, 값을 삭제하면 방의 길이가 줄어든다.

* **중복데이터를 허용하며 검색의 기능을 가지고 있다.**

* 상속도
    1. List.ArrayList
    2. List.LinkedList
    3. List.Vector.Stack

* java에서 발생하는 모든 Data type을 저장 할 수 있다.

---

### 구조 및 개념

<br>

1. 자식 class로 생성하는 방법 (부모의 모든 자원, 자식의 모든 자원을 사용 할 수 있다.)

    ```java
    ArrayList<E> al = new ArrayList<E>();
    ```

2. Is-A 관계로 생성하는 방법<br> `(부모의 모든 자원을 사용할 수 있다. 자식의 자원은 사용 불가 but 자식 class에서 Override 된것은 사용이 가능.)`
    
    ```java
    List<E> list = new ArrayList<E>();
    ```
-  \<E>는 Generic을 의미합니다.    
    * JDK 1.5d에서 추가되었습니다. **기능은 입력되는 DATAtype을 제한하는 역할.**

<br>

---
### ArrayList 와 Vector의 차이 (부모가 같아 method의 사용은 동일하다.)
<br>

* 둘의 공통점은 Data의 크기를 알 수 없으며 순차적으로 Data를 추가 할 때 사용.
    ```java
    add(E , o);
    ```

1. Vector
    >-Muliti Thread에서 동시 접근 불가능 (동기화가 되어 있다.) <br>
    -Data의 안정성을 생각할 때 Vector를 사용한다.

2. ArrayList
    >-Muliti Thread에서 동시 접근 가능 (동기화가 되어 있지 않다.) <br>
    -속도를 높여서 사용해야 할 때는 ArrayList를 사용한다.

<br>

---
### ArrayLIst 사용방법
<br>

* code
    1. 생성
        ```java
        List <Generic> list = new ArrayList<Generic>();

        ex)
        List <String> list = new ArrayList<String>();
        ```

    2. 값 추가
        ```java
        list.add(E , o) // E = Generic으로 변경 o = Object 으로 변경
        list.add("오늘은");
        list.add("월요일");
        list.add("입니다");
        //중복 값을 저장할 수 있습니다.
        list.add("월요일");
        ```
    3. 방의 크기

        ```java
        list.size(); //반환형이 int형입니다. => 5
        ```

    4. 값 얻기 (검색이 가능하다는 말이다.)

        * index로 얻기
        ```java
        list.get(index); // Generic에 해당하는 Datatype의 값이 반환된다.
        ```
    
    5. list가 비어 있는지 확인

        ```java
        list.isEmpty(); //반환형은 boolean
        ```
    
    6. list 방의 값을 삭제

        * 모든 방을 삭제 할 때

        ```java
        list.clear
        ```

        * 특정 방의 값을 지울 때
        ```java
        list.remove(index);
        list.remove("객체");

        ex)
        list.remove("오늘은"); 
        //중복 Data가 있는경우에 내용을 가지고 지우면 가장 처음 일치하는 방의 값만 삭제
        //왼쪽에서 오른쪽 방향으로 지나가면서 처음 일치하는 방의 값을 찾는다.
        ```   
        >-index에 해당하는 방의 data를 지우거나 방의 내용으로 삭제할 것인지 선택 <br>
        -방의 값을 지우면 `List의 방의 길이가 줄어 듭니다.(배열과 다른점)` <br>
        -**삭제된 이 후 방들의 index는 변경된다.**

    7. 일괄처리

        ```java
        for (int i = 0 ; i < list.size ; i++){
            list get[i]; // 처음 방 부터 끝 방 까지 모든 방의 값을 얻는다.
        }//end for
        ```

    8. List의 내용을 배열로 복사
        >**List에 Generic이 사용된 경우에는 Warning이 발생**
        
        1. List의 크기대로 배열을 생성한다.

            ```java
            Datatype[] 배열명 = new Datatype[list.size()];
            ```
        2. List의 내용을 배열로 복사한다.

            ```java
            list.toArray(배열명);
            ```   
---
### autoboxing 과 unboxing
<br>


* autoboxing
    
    * `JCF에 기본형 Datatype을 추가할 때 동작한다.`
    * `기본형 Datatype을 Wrapper Class로 감싸서(Instance를 만들어서) 입력하는 일`
    * JDK 1.8 까지는 Wrapper Class의 생성자를 사용하여 값을 얻지만 <br>
    JDK 1.9에 부터는 static method를 사용한다.

    ```java
    //JDK 1.8
    list add(10); //list add(new Integer(10));
    //JDK 1.9
    list add(10); //list add(Integer.intValue(10));
    
    //add method를 사용할때 autoboxing
    list.add(기본형Data값);

    ex)
    list.add(10); // => list.add(Integer(10));
    ```
    >-기본형 Data type의 값을 추가하면 JVM에서 기본형 Datatype과 대응되는<br>
    Wrapper Class를 사용하여 객체를 생성해준다.
 * unboxing 기능 

    * `JCF에서 입력된 기본형 Datatype을 얻을 때 동작`
    * `Wrapper Class로 입력된 Datatype을 기본형으로 풀어서 꺼내는 일 (객체 -> 기본형)`
    * JDK 1.5에서 부터 추가

    ```java
    //list의 0번 방에는 Integer(10)이 들어있다.
    int num = list.get(0); // => int num=((Integer)list.get(0)).intValue();
    ```
    >-get method의 반환형은 Integer이지만 unboxing이 동작하여 int에 저장된다.<Br><br>
    >-Wrapper Class가 Generic으로 설정되어 있을 때 기본형 Datatype으로 값을 얻으면 <br>JVM이 Wrapper Class에서 기본형으로 값을 얻어낸다.



