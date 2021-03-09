스프링환경에서 계층형 게시판 만들기
===

계층형 게시판을 만들어보려 한다. 계층형 게시판이란 하나의 게시글에 대한 답글을 달 수 있는 게시판을 이야기한다. 주로 쇼핑몰의 1:1문의 게시판을 보면 사용자가 게시글을 남기고 관리자가 그 게시글에 대한 답글을 남기는 식의 계시판을 생각하면 이야기가 편할 것 같다. **또한 답글이라고 해서 새로운 게시판테이블을 작성하는 것이 아니라 기존 게시글처럼 글이 작성되지만 query문 조작 및 view처리를 통해 처리를 하는 것이기 때문에 결국 (기존테이블에서)새로운 글을 작성하는 것과 동일한 처리이다.**<br>

### <strong>계층형 게시판을 만들기위해서 준비해야 할 것들을 나열해보자면</strong>

<Br>

0. 계층형 게시판을 만들기 위해서는 기존 게시판 테이블에서 3개의 column이 더 필요하다. (column명은 자유롭게 지어도 되지만 나는 아래와 같이 작성하였다.)

    - B_REF : 현재 답글이 어떠한 부모글을 참조하고 있는지 부모 글의 번호
    - B_STEP : 현재 답글의 그룹에서의 답글 순위를 나타내는 순서
    - B_LEVEL : 답글의 깊이 (예를들어 부모 글의 답글인지 답글의 답글인지 판한하기 위한 값)

    이 후 VO에 위의 3가지에 해당하는 필드를 선언해준다.

<Br>

1. 게시글에서 답글쓰기 tag를 작성하여 게시글 쓰기 form으로 이동할 때 답글을 쓸 게시글의 번호를 가지고 간다.

    * 예제코드
        ```html
        <a href="write.do?diaryNO=${diary.diaryNO}" class="btn btn-dark">답글쓰기</a>
        ```

<Br>

2. 게시글 작성 요청이 들어왔을 때 Controller에서 파라미터로 게시글 번호를 받는다. ( 게시글 번호를 받는 이유는 부모 글의 게시글 번호를 알기 위해서 이다. 하지만 부모 게시글을 작성할 때는 파라민터로 게시글 번호가 넘어오지 않으니 default값으로 0을 설정하자. 그 이유는 부모글 작성 요청, 답글작성이 같은 controller를 사용할 것이기 때문)

    * 예제코드
        ```java
        //답글쓰기로 접근하면 diaryNO가 넘어오기 때문에 받아줘야하고
        //처음 부모글을 작성할 때는 diaryNO값이 필요 없기때문에 default값 0으로 받는다.
        @GetMapping("/write.do")
        public String writeForm(@RequestParam(value = "diaryNO",defaultValue = "0") int diaryNO,Model model) {
            model.addAttribute("diaryNO", diaryNO);
            return "write";
        }
        ```

<br>


3. 게시글 작성 form에서 게시글을 작성하고 저장을 controller에게 요청할 때 게시글 번호 또한 같이 넘겨주어야 하기 때문에 input 의 속성을 hidden으로 설정하여 같이 값을 넘겨준다.

    * 예제코드
        ```html
        <!-- param으로 넘어온 diaryNO값을 hidden으로 넘긴다 -->
        <input type="hidden" name="diaryNO" value="${diaryNO}">
        ```

<br>

4. 이제 글을 저장하는 Controller에게 요청이 왔을때 부모글에대한 작성요청인지 답글에 대한 요청인지 판단하여 처리해주면된다. 만약 부모글이라면 넘어오는 게시글 번호가 0일테고 답글이라면 0이 아닌 부모 게시글의 번호를 가지고 올 것이다. 

    1. 부모글일 경우에는 현제 게시글의 번호중 Max값을 가져와 +1 한 값으로 게시글 번호를 설정해주고 ref의 값은 게시글의 번호와 동일하게 설정해준다. 당연히 부모글이기 때문에 게시글의 깊이와 step의 값은 0으로 할당해주면 된다. (여기서 getMax는 DB의 게시글 번호중에 가장 큰 값을 가져와서 +1한 값을 반환해주는 query이다. -> SELECT NVL(MAX(DIARYNO),0)+1 FROM DIARYBOARD)

    * 예제코드
        ```java
        int no = diaryDAO.getMax();
		int b_ref = no;
		int b_step = 0;
		int b_level = 0;
        ```
    
    2. 만약 부모글이 아니라 답글의 작성 요청이라면? 1. 넘어온 게시글 번호로 부모 게시글의 정보를 검색한다. 2. 부모 게시글의 ref값,step값,level값을 얻어온다. 3. 같은 답글 그룹에 있는 답글들의 step값을 1씩 증가시키고 앞으로 작성될 답글의 step값과 level값을 부모 게시글보다 +1한 값으로 설정한다.

    * 예제코드
        ```java
        //만약 답글에 대한 요청이라면? 답글과 부모글의 구분은 넘어오는 게시글 번호로 하면 0이 아닐경우 답글
		if(diaryVO.getDiaryNO() != 0) {
			//부모글의 정보를 조회하여 b_ref,b_step,b_level을 얻어온다.
			DiaryVO p_board = diaryDAO.findByNo(diaryVO.getDiaryNO());
			b_ref = p_board.getB_ref();
			b_step = p_board.getB_step();
			b_level = p_board.getB_level();
			
			//얻어온 값으로 현재 달려있는 답글의 step의 값을 1씩 증가시킨다.
			//증가시키는 이유는 가장 최신에 달리는 답글이 가장 작은 step값을 갖게하기위함
			Map<String, Integer> map = new HashMap<>();
			map.put("b_ref", b_ref);
			map.put("b_step", b_step);
			diaryDAO.updateStep(map);
			
			//증가를 시켰으면 이제 작성되는 답글의 b_step와 b_level을 부모의 값보다 1크게 증가
			b_step++;
			b_level++;
		}//end if
        ```

    3. 이 후 DB처리를 하기 위해 VO의 값을 설정하여 DAO에 넘겨준다.

    * 예제코드
        ```java
        //처리가 다 끝났으면 VO에 값 할당
		diaryVO.setDiaryNO(no);
		diaryVO.setB_ref(b_ref);
		diaryVO.setB_step(b_step);
		diaryVO.setB_level(b_level);

        //DAO 요청
        int result = diaryDAO.save(diaryVO);
        ```

<br>

5. 이제 게시글 리스트를 보여주는 화면에서 view처리만 하면 계층형 게시판은 끝난다. 게시글 리스트를 보여주는 View에서는 List<VO>를 받아서 반복문을 돌리며 list를 만들어 갈텐데 VO의 필드 값중 b_level값이 0보다 크다면 게시글 제목을 보여주는 곳에서 사용자가 지정한 문구를 추가해서 넣어주면 된다. 나는 level마다 띄어쓰기 2번을 넣고 마지막에 -->를 넣었다.

    * 예제코드
        ```html
        <c:forEach var="diary" items="${diaryList}">
            <tr>
                <td>${ diary.diaryNO }</td>
                <td>
                    <c:if test="${diary.b_level>0}">
                        <c:forEach var="i" begin="1" end="${diary.b_level}">
                            &nbsp;&nbsp;
                        </c:forEach>
                        -->
                    </c:if>
                        <a href="detailDiary.do?diaryNO=${ diary.diaryNO }">
                            ${ diary.diaryTitle }
                        </a>
                </td>
                <td>${ diary.createdAt }</td>
                <td>${ diary.modifiedAt }</td>
            </tr>
        </c:forEach>
        ```

<br>

6. 게시판 리스트를 조회하는 query문의 정렬기준을 설정하자면 먼저 b_ref를 내림차순으로 정렬하고 b_step를 오름차순으로 정렬하여 최신글이 위로 올라오게 한 후 같은 답글 그룹에서 가장 최근에 달린 글이 가장 위의 답글로 보이게 처리하였다.

    * 예제 query
        ```xml
        <![CDATA[
		SELECT USERID,DIARYTITLE,DIARYCONTENT,CREATEDAT,MODIFIEDAT,FNAME,DIARYNO,B_REF,B_STEP,B_LEVEL,SEQ 
		FROM ( SELECT USERID,DIARYTITLE,DIARYCONTENT,CREATEDAT,MODIFIEDAT,FNAME,DIARYNO,B_REF,B_STEP,B_LEVEL,ROW_NUMBER()OVER(ORDER BY B_REF DESC,B_STEP) SEQ 
		 		FROM DIARYBOARD 
		 		WHERE DIARYNO > 0 AND USERID=#{userID})
		WHERE SEQ > #{start} AND SEQ < #{end}
		]]> 		
        ```

<Br>

결과!!!

* 게시판

    <img src = https://user-images.githubusercontent.com/74294325/110424187-beaff200-80e5-11eb-9a9b-1c71815db13d.PNG>

* DB구조

    <img src = https://user-images.githubusercontent.com/74294325/110424435-22d2b600-80e6-11eb-86f4-fd42a7c2eedd.PNG>