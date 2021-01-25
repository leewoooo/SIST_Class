JSON
===

JSON(JavaScript Object Notation)은 **클라이언트와 서버 간에는 데이터 교환이 필요할 때 클라이언트와 서버 간 데이터 교환을 위한 규칙이다.**<br>

JSON은 일반 텍스트 포맷보다 효과적인 데이터 구조화가 가능하며 XML 포맷보다 가볍고 간편하며 가독성이 좋다. <br>


자바스크립트 객체를 사용한 데이터 표현 방법이다. JSON은 제약사항을 몇가지 가지고 있다.

1. 문자열은 큰 따옴표로 만든다.
2. 모든 키는 큰 따옴표로 감싸야 한다.
3. 값에는 숫자,문자열,불 자료형만 사용할 수 있다.

<br>

JSON은 2개의 method를 지원하는데 하나는 stringify와 parse를 지원한다.

<br>

### stringify
```JavaScript
const o = { name: 'Lee', gender: 'male', age: 26 };

//객체를 JSON의 형식의 문자열로 바꾸기
const strObj =  JSON.stringify(o);
console.log(typeof strObj, strObj);
// 결과로는
// string, {"name":"Lee","gender":"male","age":26} 으로 반환된다.
```

<br>

이와같이 객체를 문자열로 바꾸는 이유는 sever단에 object형태로 저장하는 것이 아닌 문자열로 저장하기 위함이다.

<br>

### parse

서버로부터 브라우저로 전송된 JSON은 문자열이다 이 문자열을 객체로 사용하기 위해서는 객체화를 해야한다.(역직렬화)  역직렬화를 위해서 내장 객체 JSON의 method인 parse를 이용한다.
```JavaScript
const o = { name: 'Lee', gender: 'male', age: 26 };

//객체를 JSON의 형식의 문자열로 바꾸기
const strObj =  JSON.stringify(o);
console.log(typeof strObj, strObj);
// 결과로는
// string, {"name":"Lee","gender":"male","age":26} 으로 반환된다.

//문자열을 객체 형식으로 바꾸기.
const obj = JSON.parse(strobj);
console.log(typeof obj,obj);
//결과로는
//object {name:'Lee', gender:'male',age:26} 으로 반환된다.
```

<br>
