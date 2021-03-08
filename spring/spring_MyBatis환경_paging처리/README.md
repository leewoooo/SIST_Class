SpringBoot,MyBatis 환경에서 페이징 처리
===

이전 jsp게시판으로 토이프로젝트를 진행한 적이 있어서 query문을 작성하는 것은 크게 어렵지 않았다. 

* 이전에 진행한 토이프로젝트 : [ITReviwBoard](https://github.com/LeeWoooo/ITReviwBoard)

게시판의 목록을 보여주는 요청이 있을 때 pageNumber에 따라 보여줄 게시글의 범위가 정해지는 것 또한 동일하다. 그럼 코드를 하나하나 확인하며 정리해나가보자. <br>

먼저는 게시판의 목록을 보여달라는 요청을 받는 Controller의 코드이다.

```java
@GetMapping("/listDiary.do")
public String listDiary(@RequestParam(value = "pageNumber",defaultValue = "1") int pageNumber,,,) {
,,,
}
```

이처럼 요청오게되면 parameter값으로 pageNumber값을 가져오게 된다. 여기서 Page를 요청하는 것이 아닌 **처음 게시판 목록에 대한 요청이 오는거라면 Get방식의 URL에는 pageNumber의 값을 포함하고 있지 않다.** 그렇기 때문에 default값을 설정하지 않고 매개변수로 받게되면 스프링 입장에서는 받은 매개변수가 없기 때문에 error를 발생시킬것이다. <br>

이후 게시글의 갯수를 알기 위해 DB에서 게시글의 갯수를 알아온다. 알아오는 이유는 밑에서 설명할 것이다.

```xml
<!--Mapper xml-->
<select id="count" resultType="java.lang.Integer">
    SELECT COUNT(*) FROM DIARYBOARD
</select>
```
```java
//게시글 갯수
public int count(String userID) {
    return session.selectOne("diaryMapper.count";
}
```

이렇게 게시글의 갯수를 알아온 이유는 Pagination 객체를 생성하기 위해서이다. 물론 객체를 생성하지 않고 Controller나 Service에서 처리할 수도 있지만 Paging처리를 하기 위한 객체를 생성하여 게시글의 갯수와 pageNumber를 받아 총 페이지의 수, 현재페이지에서 보여줄 게시글의 범위를 설정하기 위해서이다. Pagination Class의 코드는 이러하다.

```java
//PagiNation 생성
PagiNation pagiNation = new PagiNation(diaryService.count(), pageNumber);

//PagiNation class
@Getter
public class PagiNation {
	
	private int pageSize;
	private int count;
	private int totalPage;
	private int start;
	private int end;
	
	public PagiNation(int count ,int pageNumber) {
		this.count = count;
		this.pageSize = 10;
		this.totalPage = (int)Math.ceil(count/(double)pageSize);
		//만약 10개를 보여주고 현제 pageNumber가 1이라면 
		//시작값은 0
		//끝값은 11로 해서 범위를 0 < seq AND 11 > seq로 하면 10개의 게시물을 보여줄 수 있다.
		this.start = (pageSize*pageNumber) - pageSize;
		this.end = start + pageSize + 1;
	}
}
```

위의 필드를 조금 더 자세히 설명하자면 

* pageSize : 한 페이지에서 보여줄 게시글의 수
* totalPage : 현재 저장되어 있는 게시글로 인해 생길 페이지의 수 Math의 ceil method를 이용하여 총 게시글/보여줄 게시글의 수 를 하여 올림으로 처리한다 ex) 총 32의 게시글을 10개씩 보여준다 할 때 32/10이면 3페이지에 2개글이 남기때문에 총 4페이지가 되는것이다.
* start : DB를 조회할 때 시작 범위
* end : DB를 조회할 때 끝 범위 

이렇게 생성된 Pagination객체를 가지고 paging처리를 하면 된다. 이제 페이징 처리 할 준비가 끝났으니 적용해보자.

<br>

### view에 totalPage값을 상태유지해서 보낸 후 view에서 page번호 생성하기

위에서 생성한 Pagination 객체의 totalPage의 값을 model에 추가하여 view로 보낸다.

```java
//controller
model.addAttribute("totalPage", pagiNation.getTotalPage());
```

view에서는 controller에서 받은 totalPage를 가지고 반복문을 돌려 페이지번호를 생성한다. (JSTL을 이용하여 자바문법은 view에서 배제한다.) a tag로 페이지번호를 만들고 페이지번호를 통해 요청을 할 경우 controller에는 pageNumber와 같이 요청을 하게 되어 범위가 변경된다.

```html
<!--view-->
<c:forEach var="i" begin="1" end="${totalPage}">
        <a href="listDiary.do?pageNumber=${i}">${i}</a>
</c:forEach>
```

<br>

마지막으로 start와 end를 받은 DAO가 MapperXML에 등록되어 있는 query문을 사용하여 결과를 반환해준다 query문은 다음과 같다. 

```xml
<![CDATA[
    SELECT ,,, SEQ 
    FROM ( SELECT ,,, ROW_NUMBER()OVER(ORDER BY 정렬의 기준될 column) SEQ 
            FROM DIARYBOARD 
            WHERE SEQ > 0 )
    WHERE SEQ > #{start} AND SEQ < #{end}
]]> 		
```

먼저 subquery문을 이용하여  Inline View를 만든다.  Inline View에서는 ROW_NUMBER()OVER를 통해 게시글에 새로운 번호를 부여한다. 번호를 부여할 때 정렬기준 또한 설정할 수 있다. 그렇게 생성된 column에 위의 예제 query문에서는 SEQ라는 Alias를 부여했다. <br>

이 후 서브쿼리를 통해 조회하는 바깥 query문의 WERRE절에서 조회할 범위를 지정한다. Mapperxml에 매개변수로 start와 end값을 넣어줘야하는데 매개변수로는 값을 하나밖에 넣을 수 없다. 그렇기 때문에 Map을 통해 값을 넣어준다. 

```java
//service
Map<String, Object> pagingMap = new HashMap<>();
pagingMap.put("userID", userID);
pagingMap.put("start", start);
diaryDAO.findAllPaging(pagingMap);		

//dao
public List<DiaryVO> findAllPaging(Map<String, Object> pagingMap){
    return session.selectList("diaryMapper.findAllPaging",pagingMap);
}
```

위의 코드처럼 요청을 하게되면 Mapperxml에 key값을 통해 value값이 query문에 들어가게된다!




