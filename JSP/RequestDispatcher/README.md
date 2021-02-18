RequestDispatcher
===

RequestDispatcher는 클라이언트로부터 최초로 들어온 요청을 JSP/Servlet 내에서 원하는 자원으로 요청을 보내는 역할을 수행하거나,특정 자원에 처리를 요청하고 처리 결과를 얻어오는 기능을 수행하는 class이다. <br>

즉 a로 들어온 요청을 controller등을 통해 data를 가공하고 처리해서 b로 넘길수 있는 기능을 제공하는 역할을 주로 한다. **간단하게 이야기하자면 mapping된 주소로 요청이 오면 controller에서 데이터를 처리한 후 request에 attribute를 추가하여 view에 넘겨주는 역할을 한다고 할 수 있다.**<br>

## RequestDispatcher 생성(얻는) 방법

RequestDispatcher는 ServletContext나 ServletRequest class를 통해 얻을 수 있다. <br>

### ServletRequest를 통해 얻는 방법

서블릿 class에서 service() method나 doGet(),doPost()등에서 매개변수로 HttpServletRequest를 받기 때문에 이것을 이용하여 RequestDispatcher를 얻을 수 있습니다. 얻어올 때 매개변수로 request와 response를 넘길 페이지를 지정해주게 되는데 **절대경로와,상대경로를 둘 다 입력할 수 있다.**

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    RequestDispatcher dispatcher = request.getRequestDispatcher("이동할 page의 경로");
    // 이 안에서 비지니스 로직을 처리한 후 결과를 이동할 page로 넘길 수 있습니다.
    dispatcher.forward(request, response); //이 때 request에 값을 추가해서 보낼 수 있다.
}
```

<Br>

이렇게 controller에 요청이이 들어왔다고 하면 데이터를 처리한 후 RequestDispatcher를 통해 이동할 page를(view)설정한 후 request, response를 보내준다. 여기에 값을 추가해서 보내는 예제를 확인해보자면 

```java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String url = request.getRequestURI().toString();
    if(url.endsWith("insertBook.do")) {
        request.setAttribute("pageName", "insertBook"); 
        RequestDispatcher dispatcher = request.getRequestDispatcher("insertBook.jsp");
        dispatcher.forward(request, response);
    }else if(url.endsWith("listBook.do")) {
        request.setAttribute("pageName", "listBook");
        RequestDispatcher dispatcher = request.getRequestDispatcher("insertBook.jsp");
        dispatcher.forward(request, response);
    }
}
```

<br>

현재 위의 예제 코드를 보면 controller에 들어온 request를 통해 setAttribute를 통해 값을 집어 넣는다. 이렇게 값을 추가해서 forward되는 page에서 값을 받아서 사용할 수 있게된다. 결국 요청이 오면 controller에서 data를 처리하고 view단에서 가져온 data를 이용해 화면을 그릴 수 있도록 할 수 있다. (spring에서 model객체와 비슷하다.)

```java
//jsp
<%
    Object test = request.getAttribute("key값");
%>

//jsp ex
<%
    String test = (String)request.getAttribute("pageName");
%>
```

<br>

값을 가져올 떄 getAttribute()를 사용하게 되는데 반환되는 객체가 object라 String을 받으려면 앞에 casting을 해줘야한다.