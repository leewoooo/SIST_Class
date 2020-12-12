JCF (Java Collection Framework)
===
* 자료구조
    > Data를 `상황에 따라 편하게 처리하기 위해 제공하는 객체들` <br>
    즉 자료구조는 Data의 처리를 의미한다.

* Collection 계열 과 map계열로 구분된다.
    >-Commlection 계열 = List , set <br>
    -map계열 = map

* JDK1.5에서 부터 Generic, Autoboxing, Unboxing을 지원해준다.

* java.util package에 존재합니다. (import를 받아서 사용.)

* image

    <img src="https://user-images.githubusercontent.com/74294325/99239465-71f69180-283e-11eb-8da3-971819276d2a.PNG" width="700" height="400">


<br>


- Generic 사용예제 [code](https://github.com/LeeWoooo/SIST_Class/blob/master/Java/Day(20.11.16)/UnusedGeneric.java)

    * Generic을 사용하지 않았을 때 (\<E> 를사용 X) => 모든 객체를 저장 가능 (warning)
        ```java
        //ArrayList를 예제로 보자
        List list - new ArrayList();
        //값 추가
        list.add(new Integer(10));
        list.add(new Integer(20)); // 값이 추가 될 때마다 방의 갯수 증가.
        list.add(40);// 이렇게 입력하면 java가 add(new Integer(40))으로 입력해준다.
        list.add(new Integer("오늘은11/16")); // 모든 DataType을 넣을 수 있다.
        ```
        

    * Generic을 사용하지 않았을 때 모든 Datatype을 넣을 수는 있지만 <br>
    **값을 사용할 때 Datatype이 맞지 않아서 error를 발생 시킬 수 있다.**
        >**입력되는 DATA의 형 제한을 사용하기 위해 Generic을 사용합니다.**
        

    * Generic을 사용할 때

        * 문법 = \<E> 
        >-`E 에는 입력을 허용할 Datatype을 넣어준다. 허용한 Datatype의 값만 입력 가능.` <br>
        -**참조형만 가능** (기본형 datatype은 사용할 수 없다.) <br>
        -**기본형 Datatupe은 Wrapper Class를 사용** (ex int => Integer)

    
        ```java
        //ArrayList를 예제로 보자
        ArrayList<Generic> al = new ArrayList<Generic>();
        ///JDK 1.7부터는 생성자의 Generic을 생략할 수 있다.

        //ex)
        ArrayList<Integer> al1 = new ArrayList<Integer>();
        ArrayList<Integer> al2 = new ArrayList();
        ```
