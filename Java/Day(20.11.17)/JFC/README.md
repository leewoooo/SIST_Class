JFC (Java Foundation Class)
===

* 수업에서 배우는 이유는 조를 생성에 처음 project를 진행하며 서로를 알아가기 위해
* 상속관계를 이해하고 Programing의 구조를 이해하기 위해서 배운다.

<br>

JFC의 특징 

---

* window 용 Application 만들 때 사용하는 class들 

* AWT (Abstaract Window Toolkit)와 Swing
    
    1. AWT    
        * 간단한 Window Program을 만들 때 사용
        * 이미지를 다루기 어렵고 Error가 많다.
        * 속도가 느리지만 만들기 쉽다는 장점을 가지고 있다.
    2. Swing (AWT 2)
        * 디자인이 강조된 Window Program을 만들 때 사용한다.
        * 이미지가 다루기 쉽고 Error가 적다.
        * 속도가 AWT에 비해 빠르고 AWT에 비해 만들기 어렵다.<br>
        (MVC Pattern이 적용된 Component가 존재)
            >M = MODEL (애플리케이션의 정보, 데이타를 나타냅니다.)<br>
            V = VIEW (input 텍스트, 체크박스 항목 등과 같은 사용자 인터페이스 요소를 나타냅니다.)<br>
            C = CONTROLLER (데이터와 사용자인터페이스 요소들을 잇는 다리역할을 합니다.)

* AWT , Swing를 Component Programming이라고 한다.
    > Component = 기능을 가진 최소한의 단위를 말한다. (보여주거나 일을 수행할 수 있는 단위)

---

* 단점

    * AWT , Swing의 단점으로는 window용 exe 파일을 만들수 없다.

    * 그래픽 성능이 좋지 않다.
