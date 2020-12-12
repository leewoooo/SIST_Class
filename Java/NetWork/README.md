NetWork
===

## C/S (Client / Server) 프로그래밍

* 원격지에 존재하는 컴퓨터끼리 자원을 주고 받는 프로그램을 작성하는 것. (Network필요)

## OSI 7Layer (실제는 3단계 모델인 TCP/IP Model 사용)를 사용.

* 구조

    <img src = https://user-images.githubusercontent.com/74294325/101141989-5cfc6980-3658-11eb-8100-4cf6979f4c8a.png>

* Reference Model : 단계를 세분화하여 네트워크 계층을 이해하기 좋게 만든 모델.

* (하위) 물리계층-> 데이터링크-> 네트워크계층-> 전송계층-> 세션계층-> 표현계층-> 응용계층 (상위)

* 자바에서 사용 가능한 부분은 전송계층, 세션계층, 표현계층, 응용계층입니다.

## 컴퓨터 간 network

* 구조

    <img src = https://user-images.githubusercontent.com/74294325/101142138-8e753500-3658-11eb-9009-aa96260d91af.png>
---

## 전송 규약 (Protocol) 

* 데이터를 전송하기 위해 미리 정의해둔 형식.

* 자바에서는 TCP ,UDP를 사용할 수 있습니다.

### TCP (`Socket, Server Socket`)

* Transmission Control Protocol

* 전화로 많이 비교 한다.

* `속도가 느리다 (오류 검출을 한다 - CRC code가 포함되어 있다.)`

* 한번에 전송하는 크기가 일정하다.(1Packet = 8bit), 과금이 편하다.

* `데이터 전달이 확실하다.` (금융, 웹사이트 등에서 사용된다.)

### UDP (`Datagram Packet, Datagram Socket`)

* User Datagram Protocal

* 우편으로 많이 비교한다.

* `속도가 빠르다 (오류 검출을 하지 않는다.)`

* packet의 크기를 개발자가 설정할 수 있습니다, 과금이 어렵다.

* 데이터가 전달되지 않을 수 있다.(패킷이 꼬일 수 있다.)

* 화상채팅, 게임 등에서 사용된다.

---
### Java Network Program (컴퓨터끼리 연결하는 프로그램.)

* java.net package에 관련 class가 제공이 됩니다.

* TCP/ UDP 프로토콜을 사용하는는 프로그램만 작성할 수 있다.(Portocol 자체의 개발은 자바에서 할 수 없다.)

* Socket 프로그램.

    * 컴퓨터 끼리 연결만 수행 : 데이터를 주고 받기 위해서 IOStream을 사용.

* port

    * 데이터를 주고받기 위해 컴퓨터에서 사용하는 문. (0~65535사이의 포트를 연다.)

* ip address.

    * 네트워크에서 컴퓨터를 식별하기위해 사용하는 주소체계(IPv4, IPv6)

---
## Server ,Client (TCP / IP)


### 연결 (데이터를 주고 받을 수 없다. Stream을 연결해야 가능하다.)

* 구조

    <img src = https://user-images.githubusercontent.com/74294325/101141845-33dbd900-3658-11eb-919c-da26706ff52b.png>

* 연결되기전 Server와 Client의 상태는 Close입니다.

* Server는 port를 열고 접속자 소켓이 들어오기를 대기한다.(port는 선점이다 동일한 포트가 열릴 수 없다.)

* 접속자소켓이 들어오면 접속자 소켓을 저장하고 통신할 수 있는 상태를 만든다.

* 이 두 과정을 `1)회선 확립 과정`이라고 한다.

* Client는 임의의 포트를 열고 서버에 접속하는 일. (이 때 열리는 포트는 열리기 전까지 알 수 없다.)

* `2)소켓을 생성` - 지정한 ip address의 컴퓨터에 지정한 port로 접속시도

* Client의 소켓이 들어오면 Server는 맞게 들어왔을 시 `3)허가` 해준다 (이때 들어온 소켓으로 접속자의 정보를 알 수있다.)

* port가 열리지 않는다면 방화벽 설정에서 새 규칙으로 열리지 않는 port를 만들어준다.(outbound)

```java
//1. 회선 확립
//Listen 상태
ServerSocket ss = new ServerSocket(prot 번호));

//2.Client 소켓 생성 및 접속 시도
Socket s = new Socket(서버ip, 서버port);

//3.허가 하여 Server에서 접속자의 소켓을 받아들이는 일.
Socket Client = s.accept(); //Client에서 넘겨준 Socket과 Sever에서 받은 Socket은 같다.
```
---

### 연결 후 Data를 주고 받기 (Socket과 Stream을 연결해야 가능하다.)

* 연결이 완료된 이후 작업

* 구조 

    <img src = https://user-images.githubusercontent.com/74294325/101141753-173fa100-3658-11eb-920a-f62852f4593b.png>


* Server 

1. 서버 Socket 생성 (실행순서 1)
2. 접속자 Socket 받기. (실행순서 3)
3. 접속자 Socket에서 Stream얻기(실행순서 4)
4. Stream에서 데이터를 기록하고 목적지에 분출(실행순서 5)
5. 연결 끊기 (작은것 부터 끊기)(실행순서 7)

    ```java
    //1
    ServerSocket ss = new ServerSocket(3000);

    //2
    Socket client = ss.accept();

    //3
    DataOutputStream dos = new DataOutputStream(client.getOutputStream());
    //DataOutputStream을 사용한 이유는 정수 이외에 값들을 내보내기 위해서.

    //4
    dos.write(내보낼 값);

    dos.flush();

    //5
    dos.close();
    ss.close();
    client.close();
    ```

* Client


1. Socket 생성 (실행순서 2)
2. Socket에서 Stream얻기 (실행순서4)
3. Stream에서 데이터 읽어들이기(실행순서 6)
4. 연결 끊기 (작은것 부터 끊기) (실행순서 7)

    ```java
    //1
    Socket cilent = new Socket(서버ip,서버port);

    //2
    DataInputStream dis = new DataInputStream(cilent.getInputStream());

    //3
    Datatype 변수명 = dis.read(); //보내는 쪽의 Datatype에 따라 read() method가 달라짐 API확인

    //4
    dis.close();
    client.close();
    ```


* 데이터를 주고 받을때 순서에 맞게 write() 및 read() method를 사용하여야 한다.

    * 처음 writeUTF(), 두번째 writeBoolean() 이면 read또한 readUTF(),readBoolean()이어야 한다.


