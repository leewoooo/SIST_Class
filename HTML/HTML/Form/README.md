## FORM

* FORM이란 사용자가 입력한 데이터를 서버에 전송하는 방법이다.

    * FORM이 사용되는 영역

        1. 로그인을 위해서 아이디/비밀번호를 입력할 때
        2. 회원가입을 하기 위해서 개인정보를 입력할 때
        3. 블로그나 게시판에 글을 작성하거나, 파일을 전송할 때

* 사용자가 **control(텍스트 필드,라디오 버튼,체크박스,,,)을 조작해 정보를 전송(submit)하면 form의 action에 기술된 URL로 사용자가 조작한 정보를 전송**한다.

* 서버는 **정보를 받아서 저장하거나, 계산된 결과를 보여주는 작업 등을 수행**하게 된다.

* **하나의 페이지에는 여러개의 FORM이 올 수 있고 각각의 FORM은 독립적으로 Data를 전송한다.**

* 문법
    ```html
    <form id="아이디" action="서버로 전송할 데이터를 수신할 URL" method="데이터를 전송하는방법 enctype="전송방식">
        텍스트필드,라디오버튼,체크박스와같은 컨트롤을 생성하는 태그
    </form>
    ```

    * action : 사용자가 입력한 데이터를 전송할 서버의 URL
        * a.jsp , servlet-mapping명 : HTML FORM Control의 값을 받는 페이지
    * method : 사용자가 입력한 데이터를 전송하는 방법
        * get : action에 입력한 URL에 피라미터의 형태로 전송
        * post : header의 body에 포함해서 전송
    * enctype "전송방식" 
        * parameter전송방식 : (application/x-www-form-urlencoded)이 기본으로 설정되어 있다.
        * 파일 전송방식 : (multipart/form-data)
    

### POST

* **header의 body에 담겨서 전송이된다.**(URL에 사용자가 전송한 Data가 표시되지 않는다.)

* URL상에 전달한 정보가 표시되지 않는다.

* GET에 비해서 보아상 약간의 우위에 있다(사실상 동등,값이 직관적으로 노출되지 않기 때문)

* **전송할 수 있는 데이터의 길이 제한이 없다.**

* 크롬 개발자 도구 Network메뉴에서 사용자가 입력한 Data를 알 수 있다.

### GET

* **URL에 정보가 담겨서 전송된다.**(사용자가 전송한 Data가 URL상에 표현된다. ?로 Parameter를 구분한다.)

* 전송할 수 있는 정보의 길이가 제한되어 있다.(URL의 길이는 무한하지 않기 때문에 제한되는 길이를 넘을 수 없다. 256자 이하)

* 퍼머링크로 사용될 수 있다.(퍼머링크란 어떠한 정보를 식별하는 고유한 주소체계를 의미한다.)

### POST,GET의 사용

* GET방식은 북마크와 같은 기능,정보를 가져올 때 정보에 접근하는 URL로 사용

* POST방식은 SERVER쪽에 어떠한 작업을 수행할 때 사용(DATA를 기록하거나 수정할 때)

* 예를 들어 id를 넘겨서 게시판의 리스트를 가져온다면 GET방식을 사용할 것이고 글을 작성한다고 하면 POST를 쓰는 것이 일반적이다.

* **즉 GET은 가져오는 것이고 POST는 수행하는 것이다**

    * get은 SELECT적인 성향을 가지고 있다. **get은 서버의 어떠한 데이터를 가져와서 보여주는 용도로 대부분 쓰이지 서버의 값이나 상태등을 바꾸지 않는다.**<br>
    (게시판의 리스트라던지 글보기 기능 등등,,,)

    * POST는 **서버의 값이나 상태를 바꾸기 위해서 사용한다.**

<br>

---

<br>

## label

* 이름표를 표현할 때 사용하는 태그

* label 태그를 사용하면 form요소와 연결하여 사용할 수 있다.

* 문법

    ```html
    <label 속성="속성값">label의 값 <input ,,,></label>

    <label for ="id">label의 값<label>
    <input id = "id" type.....>
    ```

<br>

---

<br>

## fieldset

* fieldset 요소는 form요소와 관련된 data를 하나로 묶어줄 때 사용할 수 있다.

    * form안에서 사용

* legend 요소는 fildset 요소 안에서만 사용할 수 있으며 fieldset 요소의 제목을 나타낸다.

* 예제
    ```html
        <form action="서버 URL">
            <fieldset>
                <legend>입력 양식</legend>
                이름 : <br>
                <input type="text" name="username"><br>
                이메일 : <br>
                <input type="text" name="email"><br><br>
                <input type="submit" value="전송">
            </fieldset>
        </form>
    ```

    <form action="서버 URL">
            <fieldset>
                <legend>입력 양식</legend>
                이름 : <br>
                <input type="text" name="username"><br>
                이메일 : <br>
                <input type="text" name="email"><br><br>
                <input type="submit" value="전송">
            </fieldset>
        </form>

<br>

---

<br>

## INPUT TEXT

* 문법
    ```html
    <input type="text" name="값의 이름" value="값" disabled="disabled" readonly="readonly" placeholder="" autofocus="" />
    ```
    * type: text를 입력해야 텍스트 필드가 된다. (email을 받을 때는 type을 eamil로 지정)
    * name: 입력한 데이터의 이름
    * value: 데이터의 값, 입력한 데이터의 기본값으로 이 값이 기본적으로 텍스트 필드에 표시.
    * disabled: 값으로 disabled을 지정하면 텍스트 필드가 비활성화 된다. **서버로 전송을 해도 이 속성이 설정되어 있으면 전송이 되지 않는다.**
    * readonly: 값으로 readonly를 지정하게 되면 사용자가 조작할 수 없고 읽기만 가능, **서버로는 데이터가 전송이 된다.**
    * placeholder: 입력할 예시나 내용들을 설명해 줄 수있다.
    * autofocus: HTML문서가 열리면 커서를 입력창으로 요청

* 사용자가 데이터를 입력하면 name에 설정된 이름으로 입력된 값이 서버로 넘어간다.

<br>

---

<br>

## 비밀번호 입력

* 문법
    ```html
    <input type="password" name="값의 이름" />

    <!--ex-->
    사용자 : <br><input type="text" name="username"><br>
    비밀번호 : <br><input type="password" name="password">
    ```

    사용자 : <br><input type="text" name="username"><br>
    비밀번호 : <br><input type="password" name="password">

<br>

---

<br>

## hidden data

* 화면상에 표시되지 않는 control을 생성한다.
* **서버로 전달할 데이터 이지만 사용자에게 노출 될 필요가 없는 경우에 사용**
* 사용자가 여러 페이지를 통해 데이터를 입력할 때 각각의 페이지의 상태를 알아야 할 때(한 페이지에서 입력된 데이터를 다음페이지에 넘길때)
* 문법
    ```html
    <input type="hidden" name="값의 이름" value="값">
    ```

<br>

---

<br>

## 체크박스

* 여러개의 값을 같은이름으로 서버에 전송해야 할 때 사용
* **체크박스로 그룹화 하려면 name의 값이 동일해야 한다.**
* name의 값에 []를 붙이면 server에서는 값을 배열로 인식한다.

* 문법
    ```html
    <input type="checkbox" name="값의이름[]" value="값1" checked="checked"/> 사용자에게 보여줄 값
    <input type="checkbox" name="값의이름[]" value="값2" /> 사용자에게 보여줄 값
    <input type="checkbox" name="값의이름[]" value="값3" /> 사용자에게 보여줄 값

    <!--ex-->
    <input type="checkbox" name="lecture" value="html" checked> HTML <br>
    <input type="checkbox" name="lecture" value="css"> CSS <br>
    <input type="checkbox" name="lecture" value="java"> JAVA <br>
    <input type="checkbox" name="lecture" value="cpp" disabled> C++
    ```
    <input type="checkbox" name="lecture" value="html" checked> HTML <br>
    <input type="checkbox" name="lecture" value="css"> CSS <br>
    <input type="checkbox" name="lecture" value="java"> JAVA <br>
    <input type="checkbox" name="lecture" value="cpp"  checked disabled> C++

    * readonly, disabled를 option으로도 사용할 수 있다.

* 라디오 버튼과 달리 checked의 옵션을 여러번 사용할 수 있다.

<br>

---

<br>

## 버튼

* 버튼의 형태를 가지고 있으며 기능은 가지고 있지 않기 때문에 스크립트 함수 등을 연결하여 사용한다

* 문법
    ```html
    <input type="button" value="버튼에 표시될 text">
    ```
    <input type="button" value="button">

<br>

---

<br>

## 전송 , 리셋

* submit을 사용하여 사용자로 부터 입력받은 데이터를 서버로 전송하는 버튼을 만들 수 있다.

    * submit type 대신 image type를 이용해서도 사용이 가능하다.

    * **submit이나 image를 클릭하면 JavaScript에서 유효성 검증이 실패 하더라도 전송이 된다.** 

        * 주로 input의 button을 이용하여 JavaScript에서 검증을 한 후 JavaScript에서 전송을 하도록 한다.

* reset을 이용하여 HTML의 초기 로딩 화면으로 HTML Form control을 reset할 수 있다,

* 문법
    ```html
    <!--submit-->
    <input type="submit" value="버튼에 표시될 text">
    ```
    <input type="submit" value="submit">
    
    
    ```html
    <!--reset-->
    <input type="reset" value="버튼에 표시될 text">
    ```
    <input type="reset" value="reset">


<br>

---

<br>


## 파일전송

* 사용자는 파일을 선택할 수 있는 control이 필요, server에서는 전송받은 파일을 받아서 처리하는 로직 필요

* JavaScript 또는 JSP에서 값을 설정할 수 없다.

* 문법
    ```html
    <input type="file" name="서버쪽에서 파일을 식별하기 위한 이름" />

    <!--ex-->
    <form action="서버로 전송할 데이터를 수신할 URL" method="POST" enctype="multipart/from-date">
        <input type="file" name="ex" />
        <input type="submit" />
    </form>
    ```
    <input type="file" name="서버쪽에서 파일을 식별하기 위한 이름" />

<br>

---

<br>

## Select

* 기능은 라디오 버튼과 동일하지만 표현되는 디자인이 다르다.

* 문법
    ```html
    <select name="값의 이름" multiple="multiple" size="보여질 option의 갯수">
        <option value="값" selected="selected">콤보박스에 표시될 내용</option>
        <option value="값">콤보박스에 표시될 내용</option>
        <option value="값">콤보박스에 표시될 내용</option>
    </select>

    <!--ex-->
    <select name="fruit" size="3">
        <option value="apple"> 사과
        <option value="orange" selected> 귤
        <option value="strawberry"> 딸기
        <option value="peach"> 복숭아
    </select>
    ```

    * selected: 옵션을 설정하면 콤보박스의 기본값이 selected사용된 option으로 설정
    * multiple: 사용할 경우 여러개의 항복을 선택할 수 있다. (Ctrl 사용)

<br>

---

<br>

## TextArea

* 여러줄의 텍스트를 입력할 때 사용

* 문법
    ```html
    <textarea name="값의 이름" rows="행의 수" cols="열의 수" disabled="disabled"            readonly="readonly">값 </textarea>
    ```


    <textarea name="textarea" rows="6" cols="10">
    안녕하세요
    </textarea>

    * rows: 입력한 행의 수 만큼 높이가 정해진다.
    * cols: 입력한 열의 수만큼 폭이 정해진다.(charset마다 다를 수 있다.)
    
* submit을 하면 입력된 값이 server로 전달된다.

<br>

---