Controller 
===

Controller란 MVC에서 C에 해당하며 사용자의 요청을 가장 앞단에서 받는 역할을 한다. 사용자가 요청하는 URL마다 알맞는 응답을 할 수 있도록 하는 역할을 한다. <Br>

## Controller에서 사용하는 Annotation

1. @Controller

- Controller의 역할을 수행한다고 명시를 해주는 Annotation으로 이 Annotation을 선언해주면 Spring FrameWork에 알린다. (컴포넌트 스캔 방식을 사용할 경우 스프링이 로딩되면서 Bean으로 등록)

* 예시

```java
@Controller
public class BoardController {
	,,,
}
```

<Br>

이 class안에서 각각 요청에 맞는 비지니스 로직을 호출하여 data를 처리한 후 model에 데이터를 저장해서 view에 넘기는 역할을 한다.

<br>

2. @RequestMapping

- 요청에 대해 어떠한 Controller, 어떠한 method가 처리할 지 mapping하기 위한 Annotation이며 사용위치는 Class나 method이다. HTTP의 method 방식을 설정할 수 있다.

* 예시

```java
@RequestMapping(value = "/listboard.do", method = RequestMethod.GET)
public String findAll(Model model) {
	model.addAttribute("list", boardDAO.findAll());
	return "listBoard";
}
```

<Br>

위의 예시를 살펴보면 /listboard.do로 GET방식의 요청이 오면 boardDAO.findAll()의 실행결과(List&lt;boardVO>)속성에 추가한 후 view에 넘겨준다. 반환하는 String은 viewResolver가 찾아줄 view의 이름이다.

<br>

3. @RequestParam, @PathVariable

클라이언트가 url을 통해 넘긴 값을 받아올 때 사용한다. @RequestParam은 생략이 가능하다. 사용 목적은 매개변수 값을 매핑하기 위해 사용한다.

* 예시(/updateboard.do?no=값 으로 요청이 들어올때)

```java
//ex1
@RequestMapping(value = "/updateboard.do", method = RequestMethod.GET)
public String update(@RequestParam int no, Model model) {
	model.addAttribute("board", boardDAO.findByNo(no));
	return "updateBoard";
}

//ex2
@RequestMapping(value = "/updateboard.do", method = RequestMethod.GET)
public String update(int no, Model model) {
	model.addAttribute("board", boardDAO.findByNo(no));
	return "updateBoard";
}
```

<br>

@PathVariable는 url 경로를 변수화 하여 사용할 수 있도록 해준다. 단 null값이 올 수 있는 것에는 적용하지 않는 것을 권장하며 넘겨받는 값에 .이 포함되어 있다면 .뒤에는 생략이된다.

* 예시(/updateboard.do/{no})

```java
@RequestMapping(value = "/updateboard.do", method = RequestMethod.GET)
public String update(@PathVariable("no") int no, Model model) {
	model.addAttribute("board", boardDAO.findByNo(no));
	return "updateBoard";
}
```

<br>

추가로 스프링 버전이 올라가면서 @RestController가 생겼다. 간단하게 이야기 하면 요청에 대한 응답을 json으로 할 수 있는 controller를 뜻한다 (@Controller + @ResponseBody) 이 내용은 추후 조금 더 자세히 다룰 예정이다. <br>

또한  Spring4.3 이후 HTTP method에 맞는 Annotation이 추가 되었다. 이건 빠르게 예시로 확인해보면 금방 이해 할 수 있을 것이다.

* 예시

```java
//기존 코드
@RequestMapping(value = "/listboard.do", method = RequestMethod.GET)
public String findAll(Model model) {
	model.addAttribute("list", boardDAO.findAll());
	return "listBoard";
}

//변경 코드
@GetMapping("/listboard.do")
public String findAll(Model model) {
	model.addAttribute("list", boardDAO.findAll());
	return "listBoard";
}
```

<br>

이와같이 HTTP method에 맞는 Annotation을 제공해준다. (GetMapping, PostMapping, PutMapping, DeleteMapping,,,)

<BR>

---

<Br>

## Controller method의 매개변수

Controller에 매개변수로 올 수 있는 것은 다음과 같다.

* 이미지

	<img src = https://user-images.githubusercontent.com/74294325/109622627-aa1ca880-7b7f-11eb-8fba-051b13c72eb1.PNG>

<Br>

기본적으로 Request와 Resoponse를 받을 수 있으며 View에 값을 넘길 때 사용하는 Model 및 상태 유지를 할 수 있는 Session을 받을 수 있다.


