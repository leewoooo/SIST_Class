Jquery
===

Javascript의 library로 생산성을 높여주고 코드의 재사용성을 높여준다.

## Jquery의 사용 이유

1. HTML의 요소를 간단하게 선택하기 위해 사용한다.

2. 선택된 요소를 효율적으로 제어할 수 있는 다양한 수단을 제공해준다.

<br>

## Jquery의 문법

<img src = https://user-images.githubusercontent.com/74294325/105803904-cb6b0180-5fe1-11eb-9550-86ff6f976d5c.PNG>

<br>

매개변수에는 CSS의 선택자를 사용할 수 있으며 $()를 사용하여 HTML의 요소를 가져와 객체를 생성 할 수 있다 코드로 확인해보자.
<br>

```html
<h1 class="title">안녕하세요</h1>
```

<br>

이와 같이 h1요소가 존재할 때 javascript에서 사용을 하려면 이와같이 사용해야 했다.
```javascript
let title = document.querySelector(".title");
```

<br>

하지만 jquery를 사용한다면 title이라는 객체를 이와같이 선언할 수 있다.
```javascript
let title = $(".title");
// let title = jQuery(".title");
```

<br>

이 코드를 확인해보면 jquery가 얼마나 간단하게 HTML의 요소를 가져올 수 있는 지 확인할 수 있다.
여기서 $는 jquery의 wrapper라 하는데 $대신에 jQuery를 사용하여 작성할 수 있다.

<br>

### EX 
```javascript
//일반 문서 객체로 jquery객체를 생성
$(document);

//CSS선택자로 jquery 객체를 생성
$('h1');

// HTML 문자열로 jquery 객체를 생성, 주로 동적인 노드들을 생성 할 때 사용한다.
$('<h1></h1>');
```

<br>

---

<br>

## 이벤트 등록

이벤트란 시스템에서 일어나는 사건을 의미하며 javascript나 jquery에게 이벤트란 브라우져에서 일어나는 사건을 의미한다. 예를 들어 마우스의 이동이나 버튼의 클릭등과 같은 것이 이벤트다. <br>


### 문법
```javascript
$(선택자).이벤트명(이벤트가 발생되었을 때 실행할 함수);
```

<br>

이벤트가 발생되었을 때 실행할 함수에는 익명함수로 지정해 줄 수도 있고 미리 만들어 놓은 함수를 넣어줄 수 있다.

<br>

예제로 확인해보자.(click이벤트)

```html
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
			<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script> <!--CDN방식-->
			<style type="text/css">
				.active{
					background-color: #dddddd;
				}
			</style>
		</head>
		<body>
			<h1>좋아하는 음식을 추가해주세요.</h1>
			<ul>
				
			</ul>
			<hr>
			<input type="text">
			<input type="button" value="등록">
			<script type="text/javascript">
			
				$(function () {
                    //input 요소중에 type이 button인 요소를 객체로 생성해서 click이벤트를 등록(익명함수 사용)
					$("input[type=button]").click(function () { 
						const input = $("input[type=text]"); //input 요소중에 type이 text인 요소를 객체로 생성
						const list = $("<li></li>"); //li 객체 생성
						$(list).text( $(input).val() ); //생성된 li객체 안 text에 값 할당
						$("ul").append(list); //ul객체의 자식요소로 li를 추가
						$(input).val(""); //input 요소의 값 초기화

						$(list).click(function () {
							$('li').removeClass("active"); //li요소의 active라는 class 삭제
							$(this).addClass("active"); //현재 이벤트의 target인(list)의 active라는 class 추가
							$("input[type=text]").val( $(this).text() );
						})
						
					})
				})	
			
			</script>
		</body>
</html>
```

<br>

이와 같이 $()의 wrapper로 HTML의 요소를 감싸고 그 뒤에 그 요소에서 지정한 이벤트가 발생했을 경우 실행할 함수를 지정해주는 방식으로 control할 수 있다.


<br>

---

<br>

## 이벤트의 종류

<img src = https://user-images.githubusercontent.com/74294325/105811481-0d9b3f80-5ff0-11eb-8ffa-5f8d85005e35.PNG>

<br>

<img src = https://user-images.githubusercontent.com/74294325/105811516-1d1a8880-5ff0-11eb-800c-89da784ed1aa.PNG>

<br>

<img src = https://user-images.githubusercontent.com/74294325/105811551-27d51d80-5ff0-11eb-9941-6aebfd52b178.PNG>

<br>

<img src = https://user-images.githubusercontent.com/74294325/105811576-302d5880-5ff0-11eb-8202-33c4340d5a08.PNG>

<br>

상황에 맞게 필요한 이벤트들을 검색하거나 기록해 둔 것을 찾아 사용하면 될 것 같다.




## mouseover(),mouserout()과 mouseenter(), mouseleave()의 차이

마우스 관련 이벤트 중 비슷한 성능을 가지고 있지만 이벤트가 적용되는 범위가 다른 이벤트 들이다.<br>

mouseover(),mouserout()과 같은 경우는 이벤트가 발생시 **선택자의 자손들 까지도 영향을 끼친다.**<br>

mouseenter(), mouseleave()와 같은 경우는 이벤트가 발생 시 **선택자의 자손들에게는 영향을 끼치지 않는다.**<br>


mouseover와 같은 경우는 이벤트 발생 시점이 마우스가 요소에 들어갈 때이지만 **마우스가 요소 위에 계속 존재한다면 여러번 실행된다.** 하지만 mouseenter과 같은 경우는 이벤트 발생시점은 동일하지만 **마우스가 요소에 진입했을 경우 단 한번 실행된다.**

<br>

---

<br>

## $().text() , $(),html()

가져온 HTML의 요소의 내부 문자를 조작한다. 차이점은 text는 문자열로 인식을 하지만 html은 html요소로 인식을 하게 된다. 매개변수가 없을 경우 가져온 요소의 값을 가져오지만 매개변수가 있을 경우에는 값을 할당하는 역할을 한다. <br>

```javascript
<h1 class="title">안녕하세요</h1>

let text = $('.title').text(); //text에는 안녕하세요 라는 문자열이 담긴다.
let html = $('.title').html(); //html에는 안녕하세요 라는 문자열이 담긴다.
```

<br>

이와같이 가져온 요소 안에 문자만 존재한다면 text나 html이나 기능은 동일하다 하지만 다른 경우를 확인해보자. <br>

```javascript
<h1 class="title"><span>안녕하세요</span></h1>
let text = $('.title').text(); //text에는 안녕하세요 라는 문자열이 담긴다.
let html = $('.title').html(); //html에는 <span>안녕하세요</span> 라는 문자열이 담긴다.
```
<br>

가져온 요소 안에 다른 HTML의 요소가 존재한다면 html()은 요소안에 존재하는 요소 까지 같이 가져오게 된다.

<br>

값을 넣을 때도 동일하다 코드로 확인해보자.
```javascript
<h1 class="title"></h1>
$('.title').text('안녕하세요');// 가져온 요소의 내부에 안녕하세요 라는 문자열을 선언
$('.title').html('<img src =이미지 경로>'); //가져온 요소에 img가 삽입된다.
```

<br>

---

<br>

## parent(), find()

가져온 요소의 부모 요소나 자식 요소를 parent()와 find()를 통해 찾을 수 있다.

```javascript

$().parent() //가져온 요소의 부모 요소를 얻기

$().find(가져온 요소 중 찾을 자식의 요소) //가져온 요소에서 지정한 자식 요소 얻기

<ul class='parent'>
    <li class='child'>li1</li>
    <li>li2</li>    
    <li>li3</li>
    <li>li4</li>
</ul>

let childList = $('.parent').find('li');
//childList에는 parent의 자식인 li가 들어온다. li에 해당하는 자식이 1개 이상일 경우 배열로 반환된다. (현재 ul밑에 li가 4개이니 배열로 반환)

let parentList = $('.child').parent();
//child의 부모인 ul이 parentList에 할당된다.
```

<br>

---

<br>

## addClass(), removeClass()

가져온 요소의 속성중 class를 추가하거나 삭제할 수 있다.

```javascript
<h1 class="title">안녕하세요</h1>

$('h1').removeClass('title'); //h1요소에서 title라는 class가 삭제된다.

$('h1').addClass('active'); //h1요소에 active라는 class가 추가된다.
```

<br>

이 함수의 활용법은 css에 조작에도 사용이 된다.
```css
.active{
    background-color : #dddddd;
}
```

이와같이 미리 css에 style을 지정해 놓고 addClass나 removeClass와 같은 함수로 class를 추가, 삭제하면서 요소에 대한 style을 조작할 수 있다.

<br>

---

<br>

## CSS()

가져온 요소의 CSS를 jquery로 조작할 수 있다.

```javascript
<h1 class="title" style="color : #dddddd">안녕하세요</h1>

//class가 title인 요소의 color을 가져온다.
$('.title').css('color');

//class가 title인 요소의 color을 red로 설정
$('.title').css('color','red');

//class가 title인 요소의 color를 blue로 bacgroudColor는 #dddddd로설정
$('.title').css({
    color:'blue',
    backgroundColor : #dddddd
});
```

<br>

하나 이상의 스타일을 지정할 때에는 매개변수에 객체를 지정해준다.


<br>

---

<br>

## attr()

가져온 요소의 속성을 조작할 수 있다.

```javascript
<img src = '#void'/>

//img요소의 src 속성을 가져온다.
$('img').attr('src');

//img요소의 src 속성을 https://www.naver.com/로 설정한다.
$('img').attr('src','https://www.naver.com/');

//img요소의 src 속성 및 alt속성을 한꺼번에 지정한다.
$('img').attr({
    src:'https://www.naver.com/',
    alt:'네이버'
);
```
<br>

하나 이상의 속성을 지정할 때에는 매개변수에 객체를 지정해준다.



