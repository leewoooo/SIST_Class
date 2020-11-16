Set
===
* 일차원 배열의 구조를 가진다.

* **중복 Data를 허용하지 않으며 검색의 기능을 지원하지 않음(LIST와 대비)**

* 상속도
    1. Set.Hashset

* java에서 발생하는 모든 Data type을 저장 할 수 있다.

* `값이 순차적을 입력되지 않는다.` 

---

### 사용방법

* code

    1. 생성
        ```java
        HashSet\<E> hs = new HashSet\<E>(); //자식 class를 이용한 Instance화

        Set<E> set = new HashSet\<E>(); //Is- A 관꼐를 이용한 Instance화
        ```

    2. 값 추가
        * `입력되는 값은 순차적으로 들어가지 않는다.`
        ```java
        set.add(값); //Generic이 기본형이면 autoboxing이 일어난다.
        ```
    3. 방의 크기
        ```java
        set.size();
        ```
    4. 값 삭제
        ```java
        //방 하나의 값을 삭제할 때 index로 값을 삭제 할수 없다.
        //(값이 순차적 입력이 아니기 때문에)
        set.remove(Object);
        
        //모든 방의 값을 삭제할 때
        set.clear();
        ```
    5. 값 얻기 (검색기능이 없기 때문에 다른 Instance의 도움을 받는다.)
        >`값을 얻으려면 java.util.Iterator를 사용.`<br>
        Iterator = 입력되는 값의 제어권을 얻어 Pointer를 움직여 값을 얻는 Interface
    
        ```java
        Iterator<set의 Generic> ita = set.iterator();
        ```
    
    6. 값이 존재하는지?
        ```java
        while(ita.hasnext()){ //요소가 존재하면 hasnext method가 true를 반환한다.
        }//end while
        ```

    7. 값 얻기
        ```java
        ita.next(); //값을 얻고 Pointer를 다음으로 이동시킨다.
        ```

    8. whil문 완성
        ```java
        while(ita.hasnext()){
            ita.next
        }//end while
        ```