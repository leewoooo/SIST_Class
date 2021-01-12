CSS (Cascading Style Sheet)
===

* Web page에서 통일성 있는 디자인을 하기위해 만들어졌다.

* inline방식,embed방식,external file 3가지 방식으로 CSS를 적용시킨다.

* selector(선택자)를 사용하여 디자인을 적용 받을 tag를 설정한다.

* 작성일 기준(2021/01) CSS3가 최신표준으로 W3C에서 발표되었다.

## 사용방법

1. inline 방식 (태그에 직접 기입)

    * 적용의 우선순위가 가장 높다.
    * 중복 디자인 코드를 태그마다 정의해야 하기 때문에 코드의 중복이 일어나는 단점이 있다.
    * selector(선택자)를 사용하지 않는다.
    
    ```html
    <태그명 style="속성:값; 속성:값; ,,,">
    ```
<br>

2. embed 방식 (HTML head 안에서 style를 사용)

    * &lt;head&gt;태그 사이에 &lt;style;&gt;태그를 정의하는 방식.

    * 한 페이지에서 사용되는 디자인을 모아서 정의하는 방식.(HTML과 CSS를 하나의 HTML에서 처리한다.)

    * selector(선택자)를 사용하여 정의한다.

    ```html
    <style type="text/css">
        selector {
            속성:값;
            속성:값;
            ,,,
        }
    </style>
    ```
<br>

3. external file 방식 (외부 css파일을 HTML에 linking하여 사용)

    * CSS를 정의하는 stylesheet를 따로 정의한 후 CSS를 필요로 하는 HTMl에서 참조하여 사용하는 방식.
    * 다지안 코드의 중복이 가장 적다.
    * 다지인의 적용 우선순위가 가장 낮다.
    * 확장자가 .css인 파일을 생성하여 정의한다.
    * 참조하는 HTML의 CharSet과 CSS의 CharSet은 일치하여야 한다.

    ```html
    <!--html-->
    <html>
        <head>
            <link rel="stylesheet" type="text/css" href="CSS파일의 경로">
        </head>
    </html>
    ```
    ```css
    /*css*/
     selector {
            속성:값;
            속성:값;
            ,,,
        }
    ```

<br>

### 사용 방법의 비교

* 우선 순위 : inline > embed > external

* 참조 속도 : inline > embed > external

* 코드 중복 : inline > embed > external

<br>

---

<br>

# 선택자

* embed방식과 외부파일방식에 디자인을 적용 받을 태그를 선택하는 것.

* 선택자 종류: id selector, class selector, tag selector, sub selector, behavior selector 

<br>

## id selector

* 디자인을 적용받을 **태그가 유일할 때 사용한다.** (하나의 태그만 디자인을 적용할 때)

* **하나의 아이디명은 해당 페이지에서 중복이 되어서는 안된다.**

* 문법

    ```css
    /*css*/
    #id명 {
        속성:값;
        속성:값;
        ,,,
    }
    ```
    ```html
    <!--html-->
    <태그명 id="id명">
    ```

<br>

## class selector

* 정의된 디자인을 특정 여러 태그들에서 사용할 때.

* 문법

    ```css
    /*css*/
    .class명 {
        속성:값;
        속성:값;
        ,,,
    }
    ```
    ```html
    <!--html-->
    <태그명 class="class명">
    ```

<br>

## tag selector

* 지정된 모든 태그가 디자인을 적용받아야 할 때.

* 문법

    ```css
    /*css*/
    태그명 {
        속성:값;
        속성:값;
        ,,,
    }
    ```
    ```html
    <!--html-->
    <태그명 속성="속성값">
    ```

<br>

## multiple selector

* 같은 디자인을 적용할 때 ,를 이용하여 여러 선택자에가 적용

* 문법

    ```css
    #id명, #id명 {
        속성:값;
    }
    .class명, .class명{
        속성:값;
    }
    태그명, 태그명 {
        속성:값;
    }
    ```

<br>

## sub selector

* 특정 태그의 하위 태그만 디자인을 적용 받아야 할때

* 문법

    ```css
    태그명 > 자식 태그명{
        속성:값;
    }
    ```
    ```html
    <!--html-->
    <태그명 속성="속성값">
        <자식 태그명 속성="속성값">
    ```

<br>

## behavior selector

* 사용자의 동작이 있을 때에만 디자인을 적용해야 할 때. (주로 a 태그에 사용한다.)

* 문법

    ```css
    /*css*/
    태그명 : HOVER {
        속성:값;
    }
    ```
    ```html
    <!--html-->
    <태그명 속성="속성값">
    ```

<br>

---

<br>

# CSS의 속성

## 서식

<br>

### 글꼴 변경

* font-family를 지정해서 글꼴을 설정해준다.(저작권 주의)

* 적용할 글꼴이 적용되지 않을 것을 대비하여 한가지의 글꼴만 지정하는 것이 아니라 여러개의 글꼴을 지정해준다. (마지막에는 대부분 OS에서 지원하는 글꼴을 지정해준다.)

* 문법

    ```css
    선택자 {
        font-family:적용글꼴,적용글꼴,,,;
    }
    ```

### 글자 두께

* font-weight

* 문법

    ```css
    선택자 {
        font-weight:bold | normal | ,,,;
    }
    ```

### 글자 색

* color

* rgb 값을 입력해 사용하거나 영어단어로 사용가능.

* 문법

   ```css
    선택자 {
        color: 색을 지정하는 속성값;
    }
    ``` 
### 글자에 선을 추가

* text-decoration

* 문법

    ```css
    선택자 {
        text-decoration: underline; | overline; | line-through; | none;
    }
    ```

### 글자 크기

* font-size

* 단위: px(고정), %(가변), em(가변)

* 문법

    ```css
    선택자 {
        font-size: fontsize;
    }
    ```

### 문자 정렬

* text-align ( 수평정렬 )

* 문법

    ```css
    선택자 {
        text-align: right; | left; | center;
    }
    ```

* vertical-align ( 수직정렬 )

* 문법

    ```css
    선택자 {
        vertical-align: top; center; bottom;
    }
    ```


<br>

---

<br>

## 요소를 어떻게 보여줄 지 결정하는 속성

* 속성값
    1. block : 요소를 block level로 바꾸어 준다. 앞뒤 줄바꿈
    2. inline : 요소를 inline level로 바꾸여 준다. 앞뒤 줄바꿈 없음.
    3. inline-block : inline,block를 합쳐놓은 것으로 content가 있는 영역만 사용하지만 그 영역 안에 block이 들어있다.
    4. none : 요소를 보이지 않게한다.

* 문법

    ```css
    선택자 {
        display: 속성값;
    }
    ```

<br>

---

<br>

## list-style

* ul, ol의 스타일을 바꿀 수 있으며 주로 list의 기호를 없앨 때 사용한다.

* 문법

    ```css
    선택자 {
        list.style:none;
    }
    ```

<br>

---

<br>

## 크기 조정

* width, height의 이용하여 크기를 준다.

* 만약 block level의 요소에 크기를 조절하게 된다면 block의 속성은 사라진다.

* 문법

    ```css
    선택자 {
        width:넓이 값;
        height:높이 값;
    }
    ```
<br>

---

## 배경 색, 배경 이미지

### background-color을 이용하여 배경 색을 지정한다.

* 문법
    ```css
    선택자 {
       background-color:색을 지정하는 속성값;
    }
    ```

### background를 이용하여 배경에 삽입할 이미지를 지정한다.

* 문법

    ```css
    선택자 {
        background: 배경색 url('배경에 들어갈 이미지 경로') 반복여부;
    }
    ```

    * 반복설정: norepeat(반복안함), repeat-x(x좌표 반복), repeat-y(y좌표 반복)



