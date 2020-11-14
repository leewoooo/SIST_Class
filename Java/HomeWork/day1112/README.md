Work(2020.11.12)
===
Work내용
- --

### 과제1

#### 1. String 데이터가 존재한다. 

```java
String station="봉천,신림,신대방.구로디지털단지,대림.신도림,문래,영등포구청,당산,합정,홍대입구";
```

### 2.실행내용

* 각각의 역을StringTokenizer를 사용하여 String[]에 저장하고 반환하는 method를 만든다.

* 1번 method를 호출하여 반환되는 배열을 받아 아래와 같이 출력한다. 

* 배열을 입력받아 아래와 같이 출력한다. 
* 출력양식
    >역명<br>
    ====<br>
    봉천<br>
    신림...<br>
    홍대입구<br>
    =======
* 과제 완료 [code](https://github.com/LeeWoooo/SIST_Class/blob/master/Java/HomeWork/day1112/HomeWork1.java)

* 코드 작성 방법중 강사님과 달랐던 점.<br>
    >for문과 while문의 차이 for문은 시작과 끝을 알고 있을 때 주로 사용되지만 지금과 같은경우는<br>
    Token의 존재를 알 수 없기에 while문을 사용하는 것이 바람직하다.
```java
    //나의 코드
    
    for(int i = 0; i <stations.length ; i++) {
			stations[i] = stk.nextToken();
			if(i==stations.length-1) { //index에 벗어나지 않게 끝방까지 채운후 break;
				break; 
			}//if
		}//for
     
    
    //강사님의 코드
    
     int idx = 0;
		 // 3. Token이 존재하는지 물어보고 Token이 있다면 
		 while(stk.hasMoreTokens()) {
		// 4. Token을 가져와서 배열 방에 저장을 한다.
			 stationArr[idx] = stk.nextToken();
			 idx++;
		 }//end while
 ```    
    
### 과제 2

* 1~45번 사이의 임의의 숫자 6개를 배열에 저장하여 반환하는 method를 만들고<br>
숫자 6개를 출력해 보세요. ( 중복숫자가 나오면 안됩니다. )
* 과제 완료 [code](https://github.com/LeeWoooo/SIST_Class/blob/master/Java/HomeWork/day1112/HomeWork2.java)
