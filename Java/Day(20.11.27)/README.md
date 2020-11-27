Exception Handling
===

* Error : 발생하면 프로그램이 더 이상 진행할 수 없는 상태. (프로그램을 더이상 사용할 수 없다.)

* Exception : 발생하면 프로그램안에서 처리하여 연속된 진행을 할 수 있는상태. <br>(예외를 처리하는 로직을 구현하여 프로그램을 계속해서 사용할 수 있다.)

* 개발자가 반드시 예외상황에 대한 대비 코드를 작성하고 처리할 수 있도록 구현해야 한다.

* 상속도 (이외에도 많은 예외들이 존재한다.)

    <img src = https://user-images.githubusercontent.com/74294325/100398518-5424fa00-3092-11eb-96da-cdbb3f17c25d.png>

    * 출처 = https://velog.io/@codepark_kr/%EC%9E%90%EB%B0%94-%EC%9D%B4%EB%A1%A0-%EC%98%88%EC%99%B8-%EC%B2%98%EB%A6%AC

    <br>

* `예외는 Runtime Exception과 Compile Exception으로 나누어진다.`

    * Compile Exception = 개발자가 반드시 try-catch로 처리해야 하는 Exception<br>
    (bytecode가 제대로 생성되지 않는 상황에 발생하는 예외)
    
    * Runtime Exception = 가발자가 try~catch를 하지 않아도 JVM이 처리해주는 Exception <br>
    (저장과 연산이 제대로 수행되지 못하는 상황에 발생하는 예외)


    * 컴파일 순서 (이 과정에서 일어나는 것이 Compile Exception )
        
        1. source code작성 

        2. 저장 : 클래스 명. java

        3. Compile ( javac.exe ) -> 성공 시 bytecode를 생성한다.

    * 런타임 (이 과정에서 일어나는 것이 Runtime Exception)
       
        * JVM에서 bytecode를 실행시킨다. -> 이때 Memory와 cpu사용

* 예외처리는 try~catch, throws, throw를 사용하여 예외를 처리

    * `try~catch는 예외를 잡아서 처리하는 역할`

    * `throws는 발생된 예외를 던진다 (자신이 처리하지 않는다.)`

    * `throw(예외를 강제로 발생시킨다 -> 사용자 정의 예외class와 자주 사용)`


* **`예외발생이 예상되는 code는 API를 확인해서 알 수있다.`**<br>
**`API에서 method를 사용할 때 그 method가 예외를 throws하고있는지 확인해야 한다.`**

----


* 문법)

    * try~catch

        ```java
        try{
            //예외발생이 예상되는 code를 작성한다.
        }catch(예외처리class 객체명){
            //예외가 발생했을 때 제공할 code
        }catch(예외처리class 객체명){
            //예외가 발생했을 때 제공할 code
        }finally{
            //예외가 발생하거나 발생하지 않더라도 실행되어야 할 code
        }
        ```

    * 예외가 발생하면 가장 처음 발생한 예외에 해당하는 catch문을 실행 후 종료 <br>
    (여러개의 catch문이 한번에 실행되지는 않는다.)

    * catch문 작성은 제일 위에 있는 catch문 부터 마지막 catch문까지 최하단에 있는 자식부터 최상단 부모 순으로 작성한다. (예외는 세세하게 자세하게 처리한다.)

    * 예제코드)

        ```java
        try {
			num1 = Integer.parseInt(args[0]);//ArrayIndexOutOfBoundsException, NumberFormatException
			num2 = Integer.parseInt(args[1]);//ArrayIndexOutOfBoundsException, NumberFormatException

			result = num1/num2;//ArithmeticException
			System.out.printf("%d / %d = %d",num1, num2 , result);
		
		}catch (ArrayIndexOutOfBoundsException aioobe) {
			
		}catch(NumberFormatException nfe){
			
		} catch (ArithmeticException e) {
			
		} catch (Exception e){ //개발자가 인식하지 못하는 예외 처리를 하기 위해 최상위 예외class를 마지막에 정의해준다. 

		finally {
			
		}//end try
        ```

    * 예외발생이 예상되는 것마다 예외처리를 하는 방식을 조금 더 추천한다.

        ```java
        try {
			num1 = Integer.parseInt(args[0]); //ArrayIndexOutOfBoundsException, NumberFormatException
		}catch(ArrayIndexOutOfBoundsException aiob) {
		
		}catch(NumberFormatException nfe) {
		
		}
		```
    
    * 예외 출력

        * 예외처리 클래스가 제공하는 메세지를 출력하는 것.

        * 예외 상황에 대한 정보를 확인하고 대응 코드를 작성할 수 있다.

        * 예외전용 출력 스트림.

            ```java
            System.err.println("예외에 대한 메세지");
            // err은 예외전용 출력 스트림
            ```
        * 모든 예외처리 class는 예외메세지를 반환하는 method를 가지고 있다.

            * 간단한 예외메세지를 출력
                ```java
                예외 instance.getMessage(); //예외의 이유만 출력된다.

                ```
            
            * 예외를 class와 예외 메세지를 출력
                ```java
                예외 instnace.toString();
                ```

            * 예외를 자세하게 내용들을 출력
                ```java
                예외 instance.printStackTrace(); 
                //출력까지 같이해준다.
                //stack에 쌓인 Message들을 가져와 출력해준다.
                //stack에서 가져오는동안 정상실행되는 code가 먼저 출력 될 수도 있다.
                ```

        * Compile Exception

            * 객체 복제(동일한 값을 가진 객체를 하나 더 만들것)될 수 없다.

            * 객체 복제할 때에는 Object에서 제공하는 clone()를 사용한다.

            * 객체 복제 되려면 타입체크가 되어야 한다. <br>
            (Cloneable interface을 구현해야 가능하다(Datatype 체크 목적))
    
            * `반드시 CloneNotSupportedException를 처리해줘야한다.`

            * 이와 같이 API에서 사용할 때 예외를 던지는 것들의 예외를 처리해줘야한다.

    * throws

        * method안에서 발생된 예외를 method밖으로 던질 때 사용.

        * method를 호출한 곳에서 예외를 처리하도록 만드는 것.

        * `일 처리 코드와 예외처리 코드를 분리할 수 있다.`

        * throws되는 예외는 method안에서 try~catch로 처리하지 않는다.

        * 문법)

            ```java
            접근지정자 반환형 method명(매배변수,,) throws 예외class,,,{...}
            ```
            
            * 호출하는 곳에서 예외처리)

                ```java
                Try{
                    method명();
                }catch(예외class 객체명){
                    //예외가 발생하였을때 제공할 코드들
                }
                ```

    * throw

        * 예외를 강제로 발생 시킬때 사용한다.

        * 발생된 예외는 try~catch 또는, throws로 반드시 처리해야한다.

        * 사용자 정의 예외처리 class와 주로 사용하게된다.

        * 특정 상황에서 예외를 발생시켜 처리할 때 사용한다.

        * 문법)

            ```java
            //throw new 예외처리class();
            public void test(){

            //예외가 발생된 후 바로처리 : 권장하지 않음.
                try{
                    throw new Exception();
                catch(Exception e){
                    
                }
            }
            ------------------------------------------

            //throws에서는 throw로 발생시킨 예외 또는 부모 예외로 예외를 날릴 수 있다.
            public void test() throws Exception{
               throw new Exception(); 
            }

            ```

    * 문자열의 비교를 사용할 때 NullPointerException을 방지하기위해

        ```java
        A.equals(변수명);
        ```

        * A에 정의해놓은 상수를 넣고 변수에 비교대상이 될 값을 넣어 방지한다.
        