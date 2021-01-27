Local Storage
===

자바스크립트를 사용하다보면 값을 저장해야하는 경우 변수를 사용한다. 하지만 화면을 이동하거나 영구적으로 저장해야하는 경우 DB에 저장하거나 임시적으로 저장하고 싶은 쿠키를 사용하기도 한다. <br>

이처럼 일정 시간 또는 영구적으로 값을 저장하고 싶은 경우에 사용할 수 있는 Web Storage API인 Localstorage를 사용하게 된다.

## Localstorage

* 데이터를 사용자 로컬에 보존한다.

* 데이터를 저장, 덮어쓰기, 삭제 등 조작이 가능하다.

* 모바일에서도 가능

<br>

Localstorage의 기본 구성은 **키(key)와 값(value)을 하나의 세트로 저장한다. 도메인과 브라우저 별로 저장하며 값은 반드시 문자열로 저장된다.**

<br>

## 데이터 입력하기

localstorage객체의 setItem() method를 사용하게 된다. method는 매개변수로 key와 값을 받게 된다.

```javascript
localStorage.setItem("키","값");

//ex
function init(){
    localStorage.setItem("apple","사과");
}
```

<br>

## 입력된 데이터에서 값 얻기.

localstorage객체의 getItem() method를 사용하게 된다. method는 매개변수로 key를 받게 된다.

```javascript
localStorage.getItem("키");

//ex
function init(){
    localStorage.getItem("apple"); //결과로 사과를 반환한다.
}
```

<br>

## 입력된 데이터 삭제하기.

localstorage객체의 removeItem() method를 사용하게 된다. method는 매개변수로 key를 받게 된다.

```javascript
localStorage.removeItem("키");

//ex
function init(){
    localStorage.removeItem("apple"); 
    //삭제후 apple를 이용해 데이터를 조회하면 null값이 반환된다.
}
```

<br>


localStorage은 자바의 컬렉션 중 Map와 비슷한 성격을 가지고 있는 것 같다. key와 value가 한 쌍을 이루는 것과 **key는 중복이 되지 않는 다는 것이다.** <br>

**localStorage에 같은 key로 다른 값을 입력하려 하면 기존의 입력된 value는 지우지고 새로 입력한 value가 덮어쓰여 진다.**