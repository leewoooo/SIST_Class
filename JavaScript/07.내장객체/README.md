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
let substring = str.substring(0,3); //가나다 반환
```

<br>

추가로 substr(시작index,가져올 문자갯수) 가 있다. 사용법을 코드로 확인해보자.
```javascript
let str = '안녕하세요';
let substr = str.substr(0,2); //0번 index부터 2개를 가져와서 안녕을 반환한다.
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

3. sort(); : 배열의 요소를 정렬한다. (오름차순 정렬이다. 단 문자열로 취급해서 두자리 이상 숫자는 callback함수로 정렬 기준을 만들어줘야한다.) -> 문자열을 오름차순으로 간단한 정렬을 하는 것이 아니라면 대부분 callback함수를 지정해서 사용
```javascript
let arr = [1,4,6,2,3,4,7,4];
console.log(arr.sort()); // [1, 2, 3, 4, 4, 4, 6, 7] 로 반환된다.

//두자리 숫자 배열 정렬
let arr2 = [10,8,200,40]
console.log(arr.sort()); // [10,200,40,8] 로 배열이 정렬된다

//따라서 callback함수로 정렬의 기준을 만들어 줘야한다.
console.log(arr.sort(a,b){ //오름차순
    return a-b;
})

console.log(arr.sort(a,b){ //오름차순
    return b-a;
})
```

<br>

* callback 함수에서 어떠한 값을 반환하는지가 중요하다. 숫자를 반환해야 하는데 총 3가지로 나눌 수 있다.

    1. 0보다 크다
    2. 0보다 작다
    3. 0과 같다.

    매개변수로 a와 b를 받았고 반환값이 0보다 큰 경우 만일 a,b값이 들어왔다면 그대로 a,b가 반환된다. a가 먼저온다.<br>

    매개변수로 a와 b를 받았고 반환값이 0 인 경우 만일 a와 b의 값이 들어왔다면 그대로 a,b가 반환된다. 순서 변경 없음. <br>

    매개변수로 a와 b를 받았고 반환값이 0보다 작은경우 만일 a와 b의 값이 들어왔다면 b,a가 반환된다. b가 먼저 오게된다 <br>


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

<br>

### 프로토 타입으로 필요한 함수 추가해서 사용해보기

문자열 찾는것을 예를 들어 indexOf를 사용하여 문자열의 존재 여부를 확인할 수도 있지만 함수의 이름이 직관적이지가 않기 때문에 직관적인 이름을 가진 method를 추가할 수 있다. 추가한 method는 작성중인 js에만 포함이 된다.<br>

코드를 통해 확인해보자.

```javascript
String.prototype.contain = (input)=>{
    return this.indexOf(input) > -1; //this는 이 함수를 쓰는 문자열
}

let str = '안녕하세요';
//만들어진 contain method를 사용할 수 있다. 현재와 같은경우 true반환
console.log(str.contain('안녕'));
```

