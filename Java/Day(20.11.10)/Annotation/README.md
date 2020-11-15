Annotation
===

* Annotation 예제코드 [code](https://github.com/LeeWoooo/SIST_Class/blob/master/Java/Day(20.11.10)/Annotation/UseAnnotation.java)

* Annotation을 사용하여 유효성 검사를 쉽게 알 수 있다.

* JDK 1.5 (javase 5) 에서 추가된 기능

* Compiler 에게 명령을 전달할 때 사용합니다.

* method 위 or method 안쪽에 위치한다.

### 사용방법

* @을 이용하여 method 위 or 변수 위에 위치시켜준다.
    ```java
    @ Annotation명 ("명령어")
    ```

### 종류

* 대표적으로 3가지를 자주 이용한다.

    1. `@Override`
        >-method 위에 사용하며 Override가 제대로 되었는지 확인(Compiler가 확인) <br>
        -method가 Override 된 method임을 알리는 역할을 한다.
        ```java
        @Override //annotations. Override를 제대로 했는지 compiler가 확인해준다.
	    public void temp() {
		    자식 class 에서 재 정의한 코드;
	    }//temp
        ```

    2. `@Deprecated`
        >-비추천을 알리는 Annotation <br>
        -동작은 하지만 이 method가 이상동작을 할수 있음을 알리는 역할을 한다.
        ```java
        @Deprecated //
	    public void test( ) {
		    System.out.println("업무코드정의");
	    }//test
        ```

        
    3. `@Suppress Wornigs`
        >-method 안 or method 위에 위치하며 컴파일 경고를 무시하도록 한다.<br>
        -주로 변수 위에 사용하며 종류는 ("unused") , ("rawtypes")가 있다.<br>
        -("unused") = 변수를 사용하지 않을때 경고를 무시한다. <br>
        -("rawtypes") = Generic을 사용하지 않을때 경고를 무시한다.

        ```java
        @SuppressWarnings({ "unused", "rawtypes" })
	    public void temp() {
		@SuppressWarnings("unused")
		int i;
		@SuppressWarnings({ "unused", "rawtypes" })
		List l = null;
	    }//temp
        ```
