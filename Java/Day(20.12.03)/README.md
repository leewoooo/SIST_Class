NetWork
===

## C/S (Client / Server) 프로그래밍

* 원격지에 존재하는 컴퓨터끼리 자원을 주고 받는 프로그램을 작성하는 것. (Network필요)

## OSI 7Layer (실제는 3단계 모델인 TCP/IP Model 사용)를 사용.

* Reference Model : 단계를 세분화하여 네트워크 계층을 이해하기 좋게 만든 모델.

* (하위) 물리계층-> 데이터링크-> 네트워크계층-> 전송계층-> 세션계층-> 표현계층-> 응용계층 (상위)

---

### 전송 규약 (Protocol) 

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

### Java Network Program

* java.net package에 관련 class가 제공이 됩니다.

* TCP/ UDP 프로토콜을 사용하는는 프로그램만 작성할 수 있다.(Portocol)

* Socket 프로그램.

    * 컴퓨터 끼리 연결만 수행 : 데이터를 주고 받기 위해서 IOStream을 사용.