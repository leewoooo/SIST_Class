객체(Object)
===

자바스크립트는 객체(Object)기반의 스크립트 언어이며 자바스크립트를 이루고 있는 거의 모든것이 객체이다. <br>

**자바스크립트의 객체는 카(key),값(value)로 구성된 프로퍼티들의 집합이다.** 프로퍼티의 값으로 자바스크립트에서 사용할 수 있는 모든 값을 사용할 수 있다.<br>

## 프로퍼티 & 메소드
객체에 대해서 다루게 될 때 **프로퍼티**와 **메소드**에 대한 이해가 없으면 객체를 이해할 수 없을 것이다. **객체란 것은 결국 껍대기를 이루는 말이고 실제 객체를 완성하는 구성요소는 프로퍼티와 메소드이기 때문이다.** <br>

<br>

## 프로퍼티
프로퍼티는 객체의 일부로 이름과 값 사이 연결을 의미한다. 다시 말하자면 **객체의 속성을 나타내는 접근 가능한 이름과 활용가능한 값을 가지는 특별한 형태라 할 수 있다.** 프로퍼티를 통해 객체가 가지고 있는 정보에 직접적으로 접근할 수 있게 해준다. **객체 밖에서 프로퍼티에 대한 접근 연산자는 . 을 이용한다.([]를 사용해서도 접근 가능하다.)**

```javascript
let number{
    one : 1,
    two : 2,
    three : 3
}

console.log(number.one); //1이 출력
console.log(number['one']);//동일하게 1이 출력

//만약 변수 안에 one이라는 값이 저장되어 있고 변수로 객체에 접근하려고 한다면 []를 사용해야 한다.
let i  = 'one';
console.log(number[i]);
```

<br>

프로퍼티를 선언하고 값을 할당하지 않는다면 syntax error이 발생한다. 또한 프로퍼티에 nudefined나 null을 할당한다고 해서 프로퍼티가 지워지는 것이 아니다. 프로퍼티의 삭제는 delete라는 keyword를 사용한다.

```javascript
let number{
    one : 1
}

number.one = null;
console.log(one); //null이 출력

delete number.one;
console.log(number.one); //undefined 출력
```

<br>

## 메소드

메소드는 객체가 가지고 있는 동작이다. **메소드와 함수는 동작을 실행한다는 면에서 동일하지만 둘은 엄연하게 다르다.** <br>

메소드는 위에 설명하였듯이 객체가 가지고 있는 동작이다. **메소드를 수행하기 위해서는 객체를 통해서 해당 메소드를 수행하여야 한다.** 즉 그 동작을 수행하는 주체는 객체이다. 그 동작을 수행하기위해서는 **객체에게 그 동작을 수행하라고 지시해야한다.** <br>

함수를 수행하기 위해서는 어떠한 객체에게 그 동작을 수행하라고 지시 하지 않는다. 그 이유는 **함수자체가 그 동작을 정의한 함수 객체이기 때문이다.**<br>

메소드를 수행하기 위해서는 객체의 정보를 담고있는 프로퍼티를 사용할 수 있다.

```javascript
let test{
    num1:1,
    mum2:2,
    sum:function(){console.log(test.num1+test.num2);}
}

test.sum(); //3이 출력
```

<br>

##  자바스크립트의 객체 생성방법

자바스크립트에서 객체를 생성하는 방법은 크게 2가지로 나누어진다. constructor를 이용하여 생성하는 방식과 객체 리터럴을 이용하는 것이다. 객체리터럴을 이용한 방식은 JSON(JavaScript Object Notation)을 이용하여 표현한다.

```javascript
// constructor를 이용하여 객체를 생성
let test = new Object();
test.name = 'temp';
console.log(test.name); //temp가 출력

//JSON 방식을 사용하여 객체 리터럴
let test2 = {
    name : 'temp';
}

console.log(test2.name); //temp가 출력
```

<br>

이 둘은 객체를 생성하는 방법이라는 관점에서는 동일하지만 객체의 사용이라느 방식에서 차이가 있다. **JSON 방식을 이용하면 객체 리터럴이기에 단일 객체로만 활용된다.**

<br>

## 생성자 함수

객체를 생성자를 통해서도 생성을 할 수 있다 객체가 가져야하는 것을 미리 정의해 놓을 때 주로 사용한다.

```javascript
function person(name,age){
    this.name : name,
    this.age : age
}
```

생성자 함수를 이용해서 객체를 생성하게되면 생성되는 객체마다 메모리를 할당받게 된다.

생성자 함수에 method를 추가하기 위해서는 자바스크립트에서 프로토타입을 지원한다.

```javascript
person.prototype.info = function(){
    console.log(`이름${this.name} 나이${this.age}`);
}
```

<br>

이렇게 프로토 타입으로 함수를 추가하게 되면 생성자 함수를 통해 만들어지는 객체들은 모두 info라는 method를 갖게된다.

```javascript
let lee = person("이우길",26);
lee.info(); // 결과로 이름이우길나이26 출력된다.
```