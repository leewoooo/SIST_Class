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

        * 구조

            <img src = https://user-images.githubusercontent.com/74294325/100746458-1292a700-3424-11eb-84a4-ec779a4cb463.png>
    
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


---

## 입력의 근원 
    
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
      

### BufferedReader, InputStreamReader의 사용

* BufferedReader, InputStreamReader

    * 구조

        <img src = https://user-images.githubusercontent.com/74294325/100583212-bd746980-332d-11eb-805e-cbca9aa7e2b6.png>


        <br>
        <br>

    * 8bit stream은 한글을 읽어드릴 수 없다. 그렇기에 8bit stream과 16bit stream을 이어서 사용한다.

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
        

---
# 2020-12-01 추가 내용

## 입력의 근원

* HDD (file)

    * 8bit Stream : FileInputStream - 모든 파일을 읽어들 일 수 있다.(파일 복사)

    * 16bit Stream : FileReader - 독자 포멧을 사용하지 않는 text file을 읽어들일 때.

    * file

        * java.io package에서 제공한다. (file의 정보를 얻을 때 사용)

        * file을 삭제하거나 이름을 변경할 수 있다.

    * file class의 문법 )

        * 생성
            
            ```java
            File file = new File("경로");
            ```
        
        * method를 호출하여 사용한다.

            ---
            * 정보얻기

            1. 파일이 존재하는지 boolean으로 반환하는 method
            ```java
            file.exists() //file이 존재하는지? 반환형 boolean
            ```

            2. 파일의 크기를 반환하는 method
            ```java
            file.length(); //byte 단위로 나온다 반환형 int
            ```

            3. 파일의 절대경로를 반환하는 method
            ```java
            file.getAbsolutePath();
            ```

            4. 파일의 규범경로를 반환하는 method(Os에서 파일에 접근할 수 있는 단 하나의 유일한 경로)

            ```java
            file.getCanonicalPath();
            ```

            5. 파일의 경로

            ```java
            file.path()
            ```

            6. file의 디렉토리 (file가 존재하는 경로)

            ```java
            file.Parent();
            ```

            7. file의 이름을  가져오는 method

            ```java 
            file.name();
            ```

            8. 가져온 file이 디렉토리인지 파일인지 boolean으로 반환
            
            ```java
            file.isFile();
            file.isDirectory();
            ```

            9. 가져온 file이 읽기 가능한지, 쓰기 가능한지, 실행 가능한지, 숨긴파일인지 boolean으로 반환

            ```java
            file.canRead();
            file.canWrite();
            file.canExecute();
            file.isHidden();
            ```

            ---
        * 조작

            1. 폴더생성 (파일은 생성 할 수 없다. :출력스트림 사용)

                ```java
                //1. file class 생성:
                File file = new File("생성할 폴더명");
                File file = new File("생성할 폴더 경로");

                //2. Directory 생성
                file.mkdir(); //하위 폴더가 없는 하나의 폴더를 생성
                file.mkdirs(); //여러개의 폴더를 생성할 수 있다.
                ```

            2. 파일삭제

                ```java
                //1. 삭제할 파일 경로를 가진 File class생성:
                File file = new File("삭제할 폴더명");
                File file = new File("삭제할 폴더 경로")
                
                //2. Directory 삭제
                //2-1 파일의 존재를 물어본다.
                file.exists();
                //2-2 파일을 지운다.
                file.delete();
                ```

            3. 파일이름변경

                ```java
                file.renameTo(변경할 이름을 가진 파일instance);
                ```
---

### File Stream 사용
        

* FileInputStream (8bit Stream / 한글을 읽어드릴 수 없다.)

    * 구조

        <img src = https://user-images.githubusercontent.com/74294325/100746781-82a12d00-3424-11eb-9724-cb6322a91886.png>

        ```java
        try{
        // 읽어들일 파일에 스트림을 연결한다.
        FileInputStream fis = new FileInputStream(new File("c:/dev/temp/java_read1.txt"));

        // 파일의 내용읽기.
        fis.read(); // 읽어드린 내용이 없다면 -1 반환
        }catch(FileNotFoundException fnfe){//FileInputStream에서 throws
            
        }catch(IOException){//read()에서 throws

        }//end catch
        ```

* BufferedReader , FileReader

    * 구조

        <img src = https://user-images.githubusercontent.com/74294325/100746822-9056b280-3424-11eb-8632-11d752ae31f1.png>

        ```java
        //1. File에 스트림 연결
        FileReader fr = new FileReader(new File("연결할 파일명"));

        //2. 줄단위로 읽어들이기 위한 Stream연결
        BufferedReader br = new BufferedReader(fr);

        //3. 줄 단위로 (\n이 나올 때 까지)읽기.
        String str = br.readLine();//읽어드린 내용이 없다면 null나옴
        
        //모든 줄 읽기
        String str = "";
        while((str = br.readLine())!=null){
            System.out.println(str);
        }
        ```

    * BufferedReader를 사용했을 때 한글이 깨지면 Charset을 Encoding하는 기능의 스트림 사용.

    * InputStreamReader는 8bit와 16bit을 연결하는 역할도 하지만 Encoding 하는 역할도 있다.

---
# 2020-12-02 추가 내용

## 출력 Stream

### 출력의 목적지 : File , File Stream의 사용

* 8bit : FileOutputStream - 모든 데이터를 파일에 기록할 수 있다.

    * FileOutputStream의 사용

    * 순서(스트림연결 -> 스트림에 기록 -> 스트림의 기록된 내용 분출 -> 기록 -> 스트림 끊기)

    * 구조

        <img src = https://user-images.githubusercontent.com/74294325/100836482-b4f96b80-34b2-11eb-9564-0bc4e198e4bc.png >

    ```java
    //1.생성(파일이 없을시 생성, 동일한 이름의 파일이 있을시 덮어쓴다.)
    //덮어쓰기전 물어보는 옵션은 JoptionPane을 이용하자
    //Directory는 만들 수 없기 때문에 Direactory를 만들려면 File Class와 같이 사용한다.
    FileOutputStream fos = new FileOutputStream(new File("파일의경로")); //FileNotFoundExcption 발생

    //2.Data를 Stream에 쓴다 (write() method를 이용한다.)
    //Stream에만 기록하는 것이지 file에는 적용이 되는 것이 아니다.
    fos.write(byte의 배열 or 정수); //IOException 발생 

    //3.Stream에 기록된 내용을 목적지로 분출한다.(flush() method를 이용한다.)
    fos.flush(); //IOException 발생
    
    //4.Stream 끊기 (Memory의 Leak 방지)
    fos.close(); //IOException 발생
    ```

* 16bit : FileWriter - 문자열 데이터만 파일에 기록할 수 있다.

    * 구조

        <img src = https://user-images.githubusercontent.com/74294325/100836249-503e1100-34b2-11eb-8e45-0830862efa55.png>

    ```java
    //1.생성(파일이 없을시 생성, 동일한 이름의 파일이 있을시 덮어쓴다.)
    //덮어쓰기전 물어보는 옵션은 JoptionPane을 이용하자
    //Directory는 만들 수 없기 때문에 Direactory를 만들려면 File Class와 같이 사용한다.
    FileWriter fw = new FileWriter(new File("파일의경로")); //FileNotFoundExcption 발생

    //2.Data를 Stream에 기록한다
    fw.write("문자열");

    //3.Stream에 기록된 내용을 목적지로 분출한다.
    fw.flush(); //기본형이 아닌 데이터형을 기록한 경우 flushf를 꼭 사용

    //4.Stream 끊기
    fw.close(); 
    //끊기를 이용하면 flush를 하지 않아도 분출되고 Stream은 끊어진다.
    //하지만 일반적으로 flush로 분출하고 남은것을 close가 check해주는 역할
    ```

* Input과 동일하게 16bit와 8bit를 결합하여 Stream을 생성해서 속도를 향상 시킬수 있다.

    * 구조

        <img src = https://user-images.githubusercontent.com/74294325/100836523-c80c3b80-34b2-11eb-86d7-40eaed6f753b.png>


---

### File 복사

* 대상 File을 읽어들여, 다른 이름의 파일에 그대로 내보내는 것이다.

* 구조

    <img src = https://user-images.githubusercontent.com/74294325/100830318-b329ab00-34a6-11eb-9f71-78dd84a1bb60.png>


* code

    ```java
    //1.읽기 스트림 연결
    FileInputStream fis = new FileInputStream(new File("경로"));

    //2. 쓰기 스트림을 연결
    FileOutputStream fos = new FileOutputStream(new File("경로"));

    //3. 파일의 내용을 읽어온다.
    int temp = 0;
    while((temp = fis.read()) != -1){

    //4. 스트림에 기록한다.
    fos.write(temp);

    //5. 스트림을 목적지에 분출한다.
    fos.flush();
    }

    //6. 연결 끊기
    fos.close();
    fis.close();
    ```

---

### 읽기, 쓰기 스트림의 속도 개선

* code

    ```java
    //1.읽기 스트림 연결
    FileInputStream fis = new FileInputStream(new File("경로"));

    //2. 쓰기 스트림을 연결
    FileOutputStream fos = new FileOutputStream(new File("경로"));

    //3. 파일의 내용을 읽어온다.
    int readSize = 0; //읽어드린 크기
    byte[] readData = new byte[512]; //HDD의 head가 한번에 읽어들여 저장할 크기와 비슷한 크기의 배열 생성
    
    //1. 스트림에서 읽어 들인 데이터를 배열에 넣는다.
    //2. 배열의 값이 있는 방의 갯수를 저장한다.
    //3. 값이 존재하면 
    while((readSize = fis.read(readData)) != -1){
    //readSize는 읽어들인 값이 저장된 배열의 데이터가 존재하는 곳까지의 갯수 저장.
    //

    //4. 스트림에 기록한다.
    fos.write(readData , 0, readSize);

    //5. 스트림을 목적지에 분출한다.
    fos.flush();
    }

    //6. 연결 끊기
    fos.close();
    fis.close();
    ```

---
## Object Stream (Marshall Stream)

* instance를 JVM외부로 내보내거나, JVM외부에 존재하는 instance를 JVM내부로 읽어들일 때 사용

* 모든 객체는 Stream을 타고 JVM외부로 나갈 수 없다. (Size를 알 수 없기 때문에.)
    > 기본형 Datatype은 Stream을 타고 JVM외부로 나갈수 있다.

* transient: 직렬화 방지 키워드 

* 객체를 읽을 때 ObjectInputStream, 객체를 내보낼 때 ObjectOutputStream을 사용한다.

* 객체가 Stream을 타고 JVM외부로 나가려면 java.io.Serializable interface를 구현해야합니다. (직렬화 하여 JVM을 나간다.)

* Serializable interface를 구현한 class는 Stream을 타고 나갈 수 있게 일정크기로 쪼개진다. - 직렬화 Marshalling

* 쪼개진 객체를 원래의 상태로 만드는 것. - 역직렬화 UnMarshalling

### 사용법

* (Marshalling code)

    ```java
    //1. 직렬화가 가능한 객체 생성
    public class Test implements Serializable{
        //값,,,,
    }

    //2. 객체를 내보내는 Stream 생성.(내보낼 때 어디까지 내보낼 것인지 명시)
    ObjectOutputStream oos = new ObjectInputStream(new FileOutputStream("파일경로"));

    //3. 객체를 Stream에 기록.
    Test t = new Test();
    oos.writeObject(t);//크기를 알수 없던 instnace가 byte단위로 쪼개져서 기록된다.

    //4. Stream에 직렬화되어 저장된 객체를 목적지로 분출.
    oos.flush();

    //5. Stream의 연결을 종료합니다.
    oos.close();

* (UnMarshalling code)

    ```java
    //1.객체 스트림 사용.
    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("파일경로"));

    //2.객체 읽기 -> 조각난 객체가 합쳐져서 반환된다. = 역 직렬화
    class명 객체명 = (class명)ois.readObject();

    //3.객체 사용.
    객체명.변수명, 객체명.method명();
    ```