내장객체
===

자바스크립트에서 자주 사용하는 내장객체를 확인해보자.

<br>

## String

1. charAt(index) : index에 해당하는 하나의 문자를 반환한다.
```javascript
let str = 'Hello';
let charAt = str.charAt(0); //'H'를 반환
```

<br>

2. indexOf(찾을 문자열, 시작위치) : 앞에서 부터 입력한 문자열의 위치를 반환 없으면 -1을 반환 (lastindexOf는 뒤에서 부터)
```javascript
let str = 'korea';
let indexOf = str.indexOf('o'); //1이반환
```
<br>

만약 찾을 문자열에 한글자 이상의 문자열을 입력했을 때 문자열이 있다면 문자열의 가장 첫글자의 인덱스를 반환한다.

<br>

3. replace(바뀔 문자열, 바꿀문자열) 
```javascript
let str 'LeeWoo'
let replace = str.replace('W','L'); //LeeLoo를 반환한다.
```

<br>

4. search(찾을 문자열) : 입력한 문자열이 존재하는 경우 문자열의 시작 위치를 반환하고 없을 경우 -1을 반환한다. 
```javascript
let str = 'korea';
let search = str.search('o'); //1이반환
```

5. split(자를 기준이 되는 문자열) : 문자열을 자를 기준이 되는 문자열로 잘라서 배열로 반환한다.
```javascript
let str = '사과,배,포도';
let arr = str.split(','); //배열 ['사과','배','포도'] 로 반환된다.
```

6. substring(시작 index, 끝index); :문자열에서 지정한 시작index부터 끝index까지 잘라서 리턴해준다. **끝index에 해당하는 문자열은 반환되는 문자열에 포함되지 않는다.**
```javascript
let str = '가나다라마바사';
let subString = str.subString(0,3); //가나다 반환
```

<br>

---

<br>

## Array

1. pop(); : 배열안에 마지막 요소를 제거하고 리턴한다.
```javascript
let arr = ['사과','배','포도'];
let popStr = arr.pop(); //popStr에는 포도가 할당된다.
arr.pop(); // 배열에서 배가 제거된다.
console.log(arr); //배열 안에 요소는 사과만 들어있다.
```

2. push(배열에 넣을 요소) : 배열안에 요소를 추가한다.
```javascript
let arr = ['사과','배','포도'];
arr.push('자두');
console.log(arr); //배열 안에는 사과,배,포도,자두가 들어있다.
```

3. sort(); : 배열의 요소를 정렬한다. (오름차순 정렬이다.)
```javascript
let arr = [1,4,6,2,3,4,7,4];
console.log(arr.sort()); // [1, 2, 3, 4, 4, 4, 6, 7] 로 반환된다.
```

4. reverse(); : 배열의 순서를 뒤집는다.
```javascript
let arr = [1,2,3,4,5,6];
console.log(arr.reverse()); // [6,5,4,3,2,1] 로 반환된다.
```

### ECMAScript5에서 추가된 내용

1. forEach(callback함수(요소,index,배열)); : 배열을 0번 index부터 끝 index까지 순회하며 요소를 반환해준다.
```javascript
let arr = [1,2,3,4,5];
arr.forEach(function(e, i ,a){
    console.log(e +'배열의 요소');
    console.log(i +'e요소의 index');
    console.log(a+'현재 forEach문에 사용되는 배열');
});
```

<br>

2. filter(callback함수(요소,index,배열)); : 콜백함수에서 조건에 맞는 요소들을 가지고 새로운 배열을 만들어 리턴한다.
```javascript
let arr = [1,2,3,4,5];
let temp = arr.filter(function(e, i ,a){
    return (e%2)===0; //이 때 boolean값이 반환되는 것이 아닌 해당하는 요소가 반환
});
console.log(temp); //temp 배열은 [2,4]로 구성되어 있다.
```
<br>

3. map(callback함수(요소,index,배열)); : 콜백함수를 통해 값을 바꿔서 바꾼 값을 요소로 갖는 새로운 배열을 리턴한다.
```javascript
let arr = [1,2,3,4,5];
let temp = arr.map(function(e,i,a){
    return e*e;
});
console.log(temp); //temp배열은 [1,4,9,16,25]로 구성되어있다.
```
<br>

정리하자면 배열을 **조회하거나 순차적으로 출력해야할 때에는 forEach**를 사용하고 **배열에서 특정 조건에 맞는 요소들만 골라서 새로운 배열을 생성해야 할 때 filter**를 사용하고 **배열에서 현재의 값에 연산을 하거나 모든 요소에 같은 조건을 가지고 값을 변경할 때는 map**를 사용하면 될 것 같다.
