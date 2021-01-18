JavaScript
===

**자바 스크립트는 client(web browser)쪽의 동적인 html을 생성하는 목적**을 가지고 있다. JSP/Servlet과 같은 경우는 Server Side에서 실행이 된다. <br>

사용자가 어떠한 서비스를 요청하였을 때 문서 전체의 내용이 변경되기 보다는 일부분만 변경 되는 일이 많다. 이 때 서버로 부터 변경되는 데이터만 받아와서 일부분으로 바뀌는 html을 동적으로 생성해야하는 상황이 생긴다. <br>

이 때 자바스크립트,Ajax,jquery를 이용하여 표현한다.

<br>

## 자바스크립트를 HTML에 불러오기

HTML안에서 자바스크립트의 문법을 사용하기 위해서는 &lt;script&gt; &lt;/script&gt;를 사용하여 script태그 안에서 자바스크립트를 작성해 준다.<br>

&lt;script&gt;의 위치에 따라서 실행되는 순서가 달라진다. &lt;head&gt;안에서 선언되면 HTML의 내용보다 먼저 로딩된다. 따라서 &lt;script&gt;안에서 HTML의 요소들에 접근을 할 수 없게된다. (window.onload 이벤트를 사용해서 HTML이 전부 로딩되게 한 후 접근할 수 도 있다.) <br>

**선언 위치를 결정하는 요인은 JS가 HTML이 로딩되는 시점에서 화면 표시를 위한 어떠한 동작을 한다면 &lt;head&gt;안에서 선언하는 것이 좋고 그렇지 않다면 &lt;body&gt; 요소에 포함하되 가장 아래 쪽에 선언하는 것이 좋다.**



* 예제

```html
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Insert title here</title>
		</head>
		<body>
			<script type="text/javascript">
				alert("Hello Javascript");
			</script>
		</body>
</html>
```

* alert : 사용자에게 경고창을 보여주는 JS의 내장함수.

