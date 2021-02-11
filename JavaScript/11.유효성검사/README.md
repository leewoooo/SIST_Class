유효성 검사
===

사용자가 form 페이지에서 입력한 데이터 값이 서버로 전송되기 전에 특정 규칙에 맞게 입력되었는지 검증하는 것이다. <br>

사용자가 실수로 유효하지 않은 데이터 값을 입력하면 부적합하다고 판단하여 다시 form페이지로 되돌려보내 사용자가 옳바른 값을 입력하도록 강제할 수 있다. <br>

주로 회원가입할 때 id,비밀번호,이메일등을 검사한다. (null값을 입력하였는지, 입력형식에 맞게 입력을 했는지, 데이터의 크기에 맞게 잘 입력했는지 등이 있다.) <br>


## 유효성 검사를 위해 핸들러 함수를 만들기

주로 form태그에 name 속성을 부여하고 form태그안에 submit대신 button을 사용하여 버튼이 클릭되면 미리 정의해둔 function이 실행되고 실행된 function에서 유효성을 검사한다. <br>

js에서 form태그의 값을 가져오기 위해 id값과 name속성을 이용한다. <br>

```javascript
const temp = document.querySelector("#id값");

//input에 입력된 값 가져오기
const tempValue = temp.value;

//input에 입력된 값의 길이 가져오기
const tempLength = temp.value.length;

//숫자인지 아닌지 확인하기
isNaN() //값이 숫자이면 false, 값이 숫자가 아니면 true
```

<br>

이렇게 가져온 값을 가지고 function을 통해 유효성 검사를 한다. <br>

```javascript
function validation(){
	if(tempValue == ""){
		alert('값을 입력해주세요.');
		temp.focus;
		return false;
	}

	if(tempLength > 4 || tempLength <12){
		alert('값을 5글자 이상 12글자 이하로 입력해주세요.');
		temp.focus;
		return false;
	}

	if(tempValue.isNaN()){
		alert('값을 숫자로만 입력해주세요.');
		temp.focus;
		return false;
	}

	document.form태그 name속성 값.submit();
}
```
<br>

간단하게 이렇게 값을 입력하지 않았을 때나 정해놓은 크기를 벗어났을 때 return을 시키고 아닐 경우 submit을 하여 넘어온 데이터를 처리한다.<br>

<br>

---

<br>

## 정규식 표현식 사용하기

정규식이란 특정한 규칙을 가진 문자열의 집합을 표현하는데 사용하는 형식언어이다. 문자열의 특정 형태를 찾아내기 위해 패턴으로 표현한 수식이다. 주로 주민등록번호나 전화번호, 이메일과 같이 데이터 형식의 패턴이 일정한 데이터를 검사할 때 사용한다.<br>

주로 test()함수를 많이 사용하며 test함수에 매개변수로는 검증할 값을 받는다. 값이 정규식에 부합하면 true 아니면 false를 반환한다.  예제로 확인해보자. <Br>

```javascript

const regExp = /^\d+(?:[.]?[\d]?[\d])?$/; //소수점 2자리까지만 표현할 수 있도록 하는 정규식
const temp = 10.23
const temp2 = 10.234

if(regExp.test(temp)){ //현재는 true값을 반환한다.
	alert('정규식에 부합한 값이다.');
}

if(!regExp.test(temp2)){ //현재는 false값을 반환한다.
	alert('정규식에 부합하지 않은 값입니다..')
}
```
<br>

주로 이렇게 값을 검증하고 따로 function을 만들어서 매개변수로 정규표현식과 값, msg를 받아서 값을 검증한 결과를 도출한다. <br>

```javascript
 //매개변수로 정규식,값,false일때 보여줄 메세지를 매개변수로 받는다
function check(regExp,e,msg){
	if(regExp.test(e.value)){ //값을 검증한 후 부합하면 true를 반환
		return true;
	}
	alert(msg); //부합하지 안으면 msg를 보여주고 false를 반환
	e.select();
	e.focus();
	return false;
}
```

<br>