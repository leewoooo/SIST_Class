변수
===

# GOAL

* 자바스크립트에서 사용하는 기본용어 이해

* 자료형에 대한 이해

* 자료형 변환에 대한 이해

<br>

---

<br>

## 식별자

변수명, 함수의 이름을 붙일때 규칙

* JS의 예약어는 사용할 수 없다.

* 특수문자는 _와 $ 만 혀용된다.

* 숫자로 시작할 수 없다.

* 공백 입력을 허용하지 않는다.

* 생성자의 이름은 항상 대문자로 시작한다.

* 생성자 이외의 이름의 시작은 소문자로 한다.

* 여러 단어가 합쳐진 이름은 각 단어의 첫글자를 대문자로 하여 낙타체로 작성


<br>

---

<br>

## 주석

* 프로그램의 진행에 영향을 주지 않는 코드를 의미하며 작성법은 자바와 동일하다.

```java
//한줄 코드

/*
여러줄 코드
*/
```

<br>

---

<br>



## 출력 method

JS의 내장 객체인 console의 log() method를 사용한다.

```html
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
		</head>
		<body>
			<script type="text/javascript">
				console.log("Hello JS:)");
			</script>
		</body>
</html>
```

<br>

---

<br>

## 변수

자바스크립트에서 변수를  할당할 수 있는 키워드는 let,const,var가 있다. ES5까지 변수를 선언할 수 있는 유일한 방법은 var 뿐이였지만 ES6에서는 var가 가지고있는 단점을 보완하기 위해 let과 const를 도입하였다. <br>

var를 사용하여도 크게 문제되는 것은 없다. 하지만 var는 const의 성격을 가질 수 없기 때문에 상수와 일반 변수를 구분해서 사용하고자 한다면 let과 const를 사용하는것이 좋다.<br>

**let은 재할당이 자유롭지만 const는 재할당이 금지된다(상수이기 때문이다.)** const는 또한 반드시 선언과 동시에 값이 할당되어야만 한다.(자바와 비교하자면 const는 final을 지정해 선언한 변수와 같다.)<br>

주로 const를 자주 사용하며 필요한 경우에만 let을 사용한다.

<br>

```javascript
//let의 사용
let a = 100;
b = a - 50;
a = 30;
console.log(a , b); //결과로는 a=30, b=50

//const의 사용
const a = 100;
b = a - 50;
a = 30;
console.log(a , b); //결과로는 ERROR (상수 변수에 대한 대입)

//var
var num = 50;
var num = 60; 
```

<br>

위의 코드에서 var를 사용하면 변수 num에 대하여 중복 선언이 가능하다. 중복선언을 하게되면 에러없이 이전 변수의 값을 덮어쓴다. **만약 동일한 변수명이 선언되어 있는 것을 모르고 변수를 중복 선언하였다면 변수의 값이 변경되는 상황이 벌어진다. 따라서 중복 선언은 문법적으로 허용하지만 사용하지 않는 것이 좋다(var는 되도록이면 사용하지 말자.)**


<br>

### 변수의 타입 확인하기


자바스크립트는 동적 타입의 언어이기 때문에 변수를 선언할 때 별도의 타입을 지정하지 않고 선언을 한다. **입력되는 값에 따라 타입이 자동으로 결정된다는 것이다.** 

```javascript
let ex;

console.log(typeof ex); //undefined

ex = null;

console.log(typeof ex); //object

ex= {};

console.log(typeof ex); //object

ex = 3;

console.log(typeof ex); //Number

ex = 'Hello';

console.log(typeof ex); //String
```


<br>

---

<br>

## 자료형

자바스크립트에서 사용할 수 있는 자료형은 String, boolean, Number, float 등이 있다.

```javascript
//String
const whatString = "문자열입니다."

//boolean
const whatBoolean = true;
const whatBoolean = false;

//Numbeer(정수)
const whatNumber = 123;

//float(실수)
const whatFloat = 12.3;
```

<br>

추가로 값을 할당하지 않은 변수가 가지는 "undefined"와 배열, Object 등이 더 있다.

<br>

### NUMBER

Java의 경우 정수와 실수를 구분하여 int,long,float,double와 같은 다양한 숫자 타입이 존재한다. 하지만 자바스크립트는 하나의 숫자타입만 가지고 있다. <br>

```javascript
const integer = 10;     //정수
const double = 10.1234; //실수
const negative = -20;   //음의 정수
const binary = 0b10001; //2진수
```

<br>

### String

문자열 타입은 텍스트를 나타내는데 사용한다. 자바의 경우 char는 '를 사용하고 문자열의 경우 "를 사용하였지만 자바스크립트 경우 **'와 "를 둘다 사용해도 관계 없지만 일반적으로는 '를 넣어 사용한다.**

```javascript
const str = "String";
const str = 'String2';

let string = 'Hello';
string = 'World';
```

<br>

위의 코드에서 let string = 'Hello' 이 실행되면 <strong>Hello가 메모리에 생성되고 string는 메모리에 생성된 문자열의 주소를 가리킨다.</strong> 그리고 string = 'World'이 실행되면 <strong>이전 문자열인 Hello가 수정되는 것이 아니라 메모리에 새로운 문자열 World를 생성해서 string가 가리키는 주소만 변경되는 것이다.</string>

<br>

또한 문자열은 유사배열이라 한다. index를 사용할 수 있으며 index에 해당하는 값을얻어올 수 있다.

```JavaScript
consolelog(string[0]); //결과로 H가 반환된다.
```

<br>

### boolean

논리의 참과 것짓을 나타내는 자료형으로 값은 true와 false 뿐이다.

```javascript
const flag1 = true;
const flag2 = false;

//typeof 연산자는 타입을 나타내는 문자열을 반환한다.
console.log(typeof flag1); //boolean을 반환한다.
```

<br>

### undefined

undefined 타입의 값은 undefined가 유일하다. **선언 이후 값을 할당하지 않은 변수는 undefined 값을 가진다.** 즉 선언은 되었지만 값을 할당하지 않은 변수에 접근하거나 존재하지 않은 객체 프로퍼티에 접근할 경우 undefined가 반환된다. <br>

이는 변수 선언에 의해 확보된 메모리 공간을 처음 할당이 이루어질 때까지 빈 상태(사용하지 못하는 쓰레기 값)이 들어있는 것이 아니라 자바스크립트 엔진이 undefined으로 초기화 한다.

```javascript
const un;
console.log(un); //undefined
```

<br>

### null

null 타입의 값은 null이 유일하다. 프로그래밍에서 의도적으로 변수에 값이 없다는 것을 명시할 때 사용한다. **이는 변수가 기억하는 메모리 주소 정보를 제거하는 것을 의마한다.**

```javascript
const nu = 'Lee';
nu = null; //참조 되고 있던 Lee의 문자열 주소가 제거된다.
```

<br>


### 탬플릿 문자열

` 백틱을 사용하여 문자열과 변수를 같이 사용할 수 있다. 기능은 자바의 printf와 비슷하다. 자바의 printf는 "%d"와 같은 문법을 가지고 있지만 탬플릿 문자열에서 변수의 값을 삽입할 때에는 ${}를 사용한다. <br>

코드를 통해 확인해보자.<br>

탬플릿 문자열을 사용하기 전
```javascript
const num1 = 10;
const num2 = 20;

console.log(num1+"+"+num2"="+(num1+num2)+"입니다");
---
```

<br>

탬플릿 문자열을 사용한 후

```javascript
const num1 = 10;
const num2 = 20;

console.log(`${num1} + ${num2} = ${num1+num2}`);
---
```

<br>

이처럼 문자열 사이에 변수만 따로 구분할 수 있게 해서 조금 더 직관적인 코드가 될 수 있다.

<br>

---

<br>

## 형 변환

자바에서 casting 할 때 변수 앞에 형을 변환할 자료형을 명시해주듯 자바스크립트에서도 casting이 가능하다. 3가지의 함수를 지원해준다.

1. Number()

Number 자료형으로 변환할 수 있는 다른 자료형들을 Number()에 넣으면 Number의 자료형으로 변환하여 준다. 하지만 Number로 변환할 수 없는 자료형을 넣으면 NaN(Not a Number)을 반환한다.

* NaN

    * NaN의 특징은 무조건 적으로 서로 다르다.

    * 변수에 할당되어 있는 값이NaN인지 확인하려면 isNaN() 함수를 사용한다.

```javascript
let ex = '10';

Number(ex); // Number자료형으로 반환

ex = true;
Number(ex); //boolean의 true값은 1 false는 0

ex = Number('안녕하세요'); //숫자로 변경될 수 없기 때문에 Nan을 반환
```

<br>

2. String()

문자열로 자료형을 반환하는 함수로 문자열로 형변환을 시킬 때 주로 +를 이용하여 변환한다.

```javascript
const year="2021"

console.log(year+1); //20211이 출력
console.log(year-1); //2020이 출력
```

<br>

이와 같이 +를 사용하면 문자열과 문자열이 아닌 자료형을 합쳐서 문자열을 만들 수 있다. **하지만 + 이외 다른 산술 연산자를 문자열과 숫자 사이에 사용한다면 문자열이 숫자로 변환이 가능한 경우 자동 casting이 되어서 연산이 되어 결과가 나온다.**

<br>

3. Boolean()

boolean으로 형변환을 시켜주는 함수이다. ! 연산자 두번을 사용해 Boolean() 함수를 사용하는 것과 같은 효과를 볼 수 있다.

```javascript
let nan = Number("안녕하세요");

console.log(!!nan); //false
console.log(!!0); //false
```


<br>

---

<br>

## 연산자.

대부분의 자바스크립트 연산자는 자바와 동일하다 하지만 조금 다른 부분이 있다면 비교연산자 부분이 다르다.

### 비교 연산자.

좌항과 우항의 피연산자를 비교하여 boolean의 값을 반환하거나 조건문에서 제어문의 조건식에서 주로 사용한다. 자바와 다른점은 자바스크립트에서는 ==와 ===가 존재한다는 것이다.

| 비교연산자 | 의미 | 사례 | 설명 |
| :---: | :---: | :---: | :---: |
| == | 동등 비교 | x == y | x와 y의 값이 같음 |
| === | 일치 비교 | x === y | x와 y의 타입과 값이 같음 |
| != | 부등 비교 | x != y | x와 y의 값이 다름 |
| !== | 불일치 비교 | x!==y | x와 y의 값과 타입이 다름 | 

<br>

더 구체적으로 확인해 보기 위해 코드로 보자

```javascript
//동등 비교
5 == 5 //true

//타입은 다르지만 암묵적 타입 변환을 통해 타입을 일치시키면 값은 같다.
5 == '5' //true
5 == 8   //false


//일치 비교
5 === 5 //true
5 === '5' //false
```

<br>

---

<br>

