배치관리자
===

* AWT package에서 사용하며 5가지 class를 제공한다.

    1. FlowLayout
    2. BorderLayout
    3. GridLayout
    4. GridBackLayout
    5. CardLayout

    > Container Component, Component를 지정된 위치에 편하게 붙이기 위해 제공되는 Class

* Non Visual Component이다. (사용자에게 보여지지 않습니다.)

* Window Component(JFrame)와 Container Component(JPanel, JScrollpane)에 적용하여 사용합니다.
    >일반 Component는 배치관리자를 가질 수 없다.

#### 적용방법 (Has- a 관계를 사용한다.)

```java
//1. 배치 관리자를 생성한다.

BorderLayout b = new BorderLayout();

//2. 적용
    // 1. Window Component에 적용시 : 기본 LayOut은 Border Layout
    setLayout(b);
    // 2. Container Component에 적용시 : 기본 Layout은 Flow Layout
    Jpanel jp = new JPanel(); 
    jp.setLayout(b);    
```

#### 각 배치 관리자의 특성

1. Border Layout (경계 Layout)
    * Window Component의 기본 Layout입니다.

    * 하나의 지역에는 하나의 Component만 배치된다.

    * 배치되는 Component는 고유 크기가 무시되고 배치되는 곳의 크기에 맞게 변경된다.

    * 배치되는 위치를 지정해야 한다. (배치위치를 지정하지 않으면 가운데로 배치된다.)

    * 사용방법
        ```java
        //1.레이아웃 설정
        setLayout(new BorderLayout());
        //2.배치
        add("영역",Component);
        ex)
        //문자열 상수를 사용하여 배치
        add("North", btn);
        add("Center",ta);
        //BorderLayout의 상수를 사용하여 배치
        add(BorderLayout.East,btn);
        ```
2. Flow Layout (흐름 Layout)

    * Container Component가 기본 Layout입니다.

    * 배치되는 Component는 고유크기 대로 배치된다.

    * 배치는 왼쪽에서 오른쪽의 순서로 배치된다.

    * Window의 크기를 줄였을 때 Component가 아래로 이동된다. (늘어나면 위로 이동) 

    * 사용방법
        ```java
        //1.배치관리자 생성
        FlowLayout fl = new FlowLayout();
        //2.배치관리자를 적용
        setLayout(fl);

        //1+2 (한번에 배치관리자를 생성하고 적용시킨다.)
        setLayout(new FlowLayout());

        //3.배치 (Component의 고유 크기로 추가된다.)
        //ex
        add(button);  
        add(label);
        ```

3. GRID Layout (격자 Layout)

    * 행과 열로 구성되어 있는 Layout이다.

    * Component의 크기가 동일하게 배치되는 Layout

    * Component는 배치하는 순서대로 왼쪽에서 오른쪽 순으로 배치된다.

    * 사용방법
        ```java
        //1.배치관리자 생성
        GridLayout gl = new GridLayout(Low(행), colum(열));
        //2.배치관리자를 적용
        setLayout(gl);

        //1+2 
        setLayout(new GridLayout());

        //3.배치
         //ex
        add(button);  
        add(label);
        ```