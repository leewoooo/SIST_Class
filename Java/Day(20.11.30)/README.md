IO(Input / Output Stream)
===

* JVM외부에 존재하는 Data를 JVM내부로 읽어 들이거나, JVM내부의 데이터를 JVM 외부로 내보낼 때 사용하는 Object.

*  java.io package에서 관련 class를 제공한다.

*  Stream을 이용하여 외부의 값을 읽어오고, 내부의 값을 내보낸다.

    * 구조

        <img src = https://user-images.githubusercontent.com/74294325/100572706-82683b00-3319-11eb-8024-0bc105ecedea.png>


    * Stream

        <img src = https://user-images.githubusercontent.com/74294325/100566033-4e384e80-3308-11eb-846f-9dec997dc880.png>

        * [출처 naver blog ](https://m.blog.naver.com/PostView.nhn?blogId=dg_667&logNo=220953203959&proxyReferer=https:%2F%2Fwww.google.com%2F)


    * Stream은 방향성이 단방향이다(InputStream은 Input만 OutPutStream은 OutPut만 가능)

    * Stream = 8bit stream(byte stream), 16bit stream(String stream) 두 종류를 제공한다.
    
        * 16bit Stream은 문자열에 한하여 읽고 쓰기가 둘다 가능하다.(유니코드로 된 문자를 입출력)<br>
        (Inputstream = Reader, Output stream = Writer)
    
        * 8bit Stream은 모든 종류의 Data를 읽고, 쓸 수 있다.<br>    
        (Inputstream , Outputstream)

        * 8bit stream과 16bit stream은 결합하여 사용할 수 있다.(편의성)

        * 데이터의 이동 속도 ( 8bit > 16 bit)

        * 한번에 옮길 수 있는 Data양 ( 8bit < 16bit)

    * `Stream은 생성되어 있으면 memory를 계속 소모합니다.(memory leak)`
        > 사용이 끝난 stream은 memory leak를 막기위해 close()해야 합니다.
    
    * **`System class에서 제공하는 표준 stream은 close()하지 않습니다.`**

* 입력의 근원 
    
    * 시스템 입력 (키보드 입력)

        * 키보드를 입력하면 keyboardBuffer에 키 값들이 적재된다. (길이는 256)<br> Enter가 입력되면 적재된 키 값들이 Os로 넘겨진 후 Os가 실행 가능한 명령인지 판단.

            * Enter가 입력되면 keyboardBuffer에 있는 내용은 os에게 전달 후 초기화

            * 구조 

                <img src = https://user-images.githubusercontent.com/74294325/100574830-323fa780-331e-11eb-9ed1-19acf8cf98be.png>

            * 키보드의 입력을 받기위해서는 JVM이 연결한 System.in Stream을 사용한다.

            * 문법)

                ```java
                trt{
                    int inputCode = System.in.read();
                }catch(IOException ie{//read method가 예외를 throws하고 있기에 처리해줘야함.
                    //예외 처리 코드 
                }//end catch
                ```
      

        * BufferedReader, InputStreamReader의 사용

            <img src = https://user-images.githubusercontent.com/74294325/100583212-bd746980-332d-11eb-805e-cbca9aa7e2b6.png>


            <br>
            <br>

            * 8bit stream은 한글 입력은 가능하나(한글자씩) 출력은 가능하지 않다. 그렇기에 8bit stream과 16bit stream을 이어서 사용한다.

            * BufferedReader
                
                * 16bit stream으로 줄단위의 입력을 읽어 들일 수 있다.

                * 생성자는 기본생성자가 없고 Reader를 매개변수로 받는 생성자가 있다.

                * Reader매개변수에 InputStreamReader를 이용하여 사용한다.

            * InputStreamReader

                * 16bitstream과 8bit stream을 이어주는 역할을 한다. 

                * 매개변수로 8bit inputstream을 받는다.

            * 문법)

                ```java
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			    String msg = br.readLine(); //키보드로 입력되어 Enter치기전까지의 값들을 읽어옴
			    System.out.println(msg);
                ```
        
