함수
===

함수는 어떤 작업을 수행하기 위해 필요한 코드들의 집합을 정의한 코드 블록이다. 함수는 이름과 매개변수를 갖으며 필요한때에 호출하여 안에 담겨있는 코드들을 실행한다. <br>

함수의 기본 형식
```javascript
function 함수명(매개변수){
    //함수가 호출되었을 때 실행 될 코드들
}

//호출
함수명();
```

<br>

함수는 주로 동일한 작업을 반복적으로 수행해야 할 때 함수 안에 미리 코드들을 정의하고 함수를 호출해서 사용하는 것이 효율적이다. 이러한 특성은 코드의 재사용이라는 측면에서 매우 유용하다. <br>

자바의 method와 동일한 성격을 가지고 있으며 자바 스크립트의 경우 변수에 함수를 넣어서 사용할 수 있다. <br>

코드에서 확인해보자

```javascript
let 함수명 = function(매개변수){
    //함수가 호출 되었을 때 실행 될 코드들
}

//호출 방법
함수명();
```

<br>

**하지만 이러한 경우 함수명에 다른 함수를 재할당 하게 된다면 마지막에 할당해준 함수로 덮어 쓰여진다.**

<br>

ECMAScript6부터는 함수를 선언할 때 function을 생략하고 화살표를 이용해 화살표 함수를 만들 수 있다.<br>

코드로 확인해보자

```javascript
let 함수명 = (매개변수) => {
    //함수가 호출될 때 실행 될 코드들
}

//호출
함수명();
```
<br>

자바스크립트의 경우 함수의 return값의 자료형을 따로 선언해주지 않고 함수 내에서 return이라는 키워드를 사용한다. 자바와 같이 void나 자료형을 method선언 시 명시해주지 않는다는 것이다.<br>

코드로 확인해보자.

```javascript
let 함수명 = function(매개변수){
    //함수가 호출 될 때 실행 될 코드들
    return return될 값.
}
```

<br>

---

<br>

## 표준 내장 함수

### 숫자 변환 함수

자바 스크립트 중 숫자형식의 다른 자료형의 값을 숫자로 변환하는 함수를 내장하고 있다.

1. parseInt() : 문자열을 정수로 변환한다.

2. parseFloat() : 문자열을 실수로 변환한다.

<br>

코드로 확인해보자.

```javascript
const str = "123";
const str2= "12.3";

const num = parseInt(str); //정수 123으로 변환된다.
const float = parseFloat(str2); //실수 12.3으로 변환된다. 
```

<br> 

### 타이머 함수

특정 시간 후에 또는 특정 시간 마다 어떤 일을 할 때 사용한다. 시간을 ms를 지정해주어야 하며 1초를 나타내려면 1000을 입력해야 한다.

1. setTimeout(실행할 함수, 시간) : 특정 시간 후에 함수를 실행한다.

2. setInterval(실행할 함수, 시간) : 특정 시간 마다 함수를 실행한다.

<br>

코드로 확인해보자.

```javascript
function date(){
    const date = new Date();
    date.getSeconds;
}

setInterval(date,1000); //날짜를 1초마다 얻어와 초 를 얻어낸다.
```

<br>

setInterval은 종료를 지정해주기 전까지는 계속 실행되기 때문에 이때 종료를 명시적으로 해주어야 한다. <br>

3. clearInterval()  : 특정 시간마다 실행되던 함수 호출을 종료

```javascript
function date(){
    const date = new Date();
    date.getSeconds;
}

let interval = setInterval(date,1000); //날짜를 1초마다 얻어와 초 를 얻어낸다.

clearInterval(interval);
```