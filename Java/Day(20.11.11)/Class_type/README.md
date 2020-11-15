# Class Type
- class
- abstract
- interface
- inner class(이벤트 처리용)
    - inner class
    - nested class
    - local class
    - anonymous innerclass

## inner class
> 안긴 클래스: 클래스에 클래스를 정의
- 이벤트 처리용으로 개발
- 이벤트를 객체마다 따로 처리해야 할 때
- 안쪽 클래스를 인스턴스 변수처럼 사용할 때
- 컴파일되면 bytecode가 두개 생성됨
    - 바깥클래스명.class
    - 바깥클래스명$안쪽클래스명.class
    - 파일명에$가 붙어있으면 inner class임을 알 수 있음(os에 파일 확장자와 구분 class에서 $로 구분)

<img src="https://user-images.githubusercontent.com/69107255/98769132-70cefa00-2423-11eb-9d16-e5b0a8d82d38.JPG" width="350" >

- 안쪽클래스인 **Inner class** 에서는 바깥쪽 클래스인 **Outer class**의 자원을 마음대로 사용할 수 있음
- 바깥쪽 클래스인 **Outer class**에서 안쪽 클래스인 **Inner class**의 자원을 사용하려면 `반드시 객체화`를 하여 사용

**객체화 방법**
1. 외부클래스의 객체화
```java
    바깥클래스명 객체명 = new 바깥클래스의 생성자();
    Outer out = new Outer();
```
2. 내부클래스의 객체화
```java
    바깥클래스명.안쪽클래스 객체명 = 바깥클래스객체명.new 안쪽클래스의 생성자();
    Outer.Inner in = out.new Inner();
```
3. 내부클래스의 자원을 사용
```java
    내부클래스객체명.변수명 / 내부클래스객체명.method명
``` 

## nested class
- 내부 클래스를 static 변수처럼 사용
- 객체화 없이 사용하는 것을 권장

```java
    클래스명.변수명
    클래스명.method();
```

## local class
> 클래스를 지역변수처럼 사용
- method안에서만 사용되는 클래스

- local클래스 안에서는 method안에 Outer에 변수를 쓸 수 있음
- local클래스에서 지역변수나, parameter는 `final`이 붙은 변수만 사용할 수 있음
- JDK 1.7에서 부터는 `final`이 붙지 않은 변수나 `parameter`를 사용할 수 있음 단, 값을 사용 할 수 있으나 할당은 안됨

**UseLocalOuter$1Local.class**
- class파일명 $ 1뒤에는 method명이 온다.

## anonymous inner class
> class를 Arguments로 사용 할 때
- Arguments=> method parameter에 전달 하는 값
- method의 매개변수로 class나 interface가 사용 되었을 때 주로 사용

```java
    class Test {

        public void method(Fly f){
            f.method();
        }
    }
```

1. 인터페이스를 구현한 클래스 작성
```java
    class Temp implements Fly {
        //추상 method override
    }
```

2. 객체화
```java
    Test t = new Test();
    Fly f = new Temp();
```

3. method 호출
```java
    t.method(f);
```

**anonymous inner class 작성법**
```java
            //이름없는 클래스가 부모가될 클래스를 부모로하여 생성 됨
    method(new 부모가 될 클래스/인터페이스의 생성자() {
        //생성자 부터 닫는 중괄호 영역이 anonymous inner class 영역
        //method 선언
        //Override
    
        구현인터페이스명 객체명 = new 부모클래스명(); 
        부모클래스명 객체명 = new 부모클래스명();
                                //method선언
                                //Override선언
    }
```

