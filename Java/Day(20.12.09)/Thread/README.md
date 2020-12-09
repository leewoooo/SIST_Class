Thread
===

## Thread란

* `thread란 프로세스(process) 내에서 실제로 작업을 수행하는 주체를 의미한다.`

* `동시에 일(Method)를 처리 해야 할 때 사용하며` 작은 프로세스(process : cpu가 한번에 처리하는 일의 단위) 라고도 한다.

* `두 개 이상의 thread를 가지는 process를 multi-threaded process라고 한다.` (멀티 thread 지원 - 여러개의 프로그램을 동시에 처리하는 것)
    >하나의 process를 여러 조각으로 나눠 조각단위로 실행한다. <br>짧게 처리하여 결과를 주고 처리하고를 반복하기에 계속 실행되고 있는 것처럼 보인다.

* `선점형 cpu Scheduling` <-> 시분할 cpu Scheduling

    * Thread는 선점형 cpu Scheduling이다. (java또한 같다)

    * 시분할 cpu Scheduling은 thread가 cpu를 점유하는 시간을 설정하는 방식. <br>(작업관리자의 역할 중요)

    * 선점형 cpu Scheduling은 먼저 선점한 process가 cpu를 점유한다.<br>
     (선점한 process가 cpu를 선점하고 그 상태가 계속 유지되면 deadlock가 발생한다.)

* Interrupt가 발생될 수 있다.

    * 인터럽트란 프로그램을 실행하는 도중에 예기치 않은 상황이 발생할 경우 현재 실행중인 작업을 중단하고 발생된 상황을 처리한 후 다시 실행중인 작업으로 복귀하는 것을 말한다.

* Thread를 사용하면 program의 종료시간을 측정할 수 없다.


---

## Thread의 생명주기

* Ready, Run, Block, Dead 총 4개의 주기가 있다.

    <img src = https://user-images.githubusercontent.com/74294325/101594981-fac7ae00-3a35-11eb-8863-1d5550d0d6a4.png>
    <br>
    <br>

    * Ready : Scheduling을 처리하는 준비 단계.

    * Run : cpu를 점유하여 일을 하는 단계

    * Block : 점유하는 cpu에서 분리되어 일을 하지 않는 단계.

    * Dead : Thread가 죽은 상태.(JVM에서 한번 죽은 Thread는 다시 살아 날 수 없다.)

---

## Thread의 사용방법

1. Thread class를 상속을 받아서 쓰는 방법.

    <img src =https://user-images.githubusercontent.com/74294325/101603835-7bd97200-3a43-11eb-91df-c0b5635105e9.png>


    ```java
    //1.Thread를 상속받는다.
    public class Myclass extends Thread{

    //2.run method()를 Override 하고 동시에 처리되어야 할 code 정의
    @Overrid
    public void run(){
        //동시에 처리되어야 할 code 정의
    }

    //3.자식 class로 객체를 생성한다. (부모인 Thread가 생성된다.)
    Myclass mc = new Myclass();

    //4.Thread class의 start()를 호출하여 run()를 호출한다.
    mc.start(); //start에서 run을 호출하면 Override한 자식의 run()이 호출된다.
    }
    ```


2. Runnable interface를 구현하여 사용하는 방법.

    <img src = https://user-images.githubusercontent.com/74294325/101603988-ae836a80-3a43-11eb-962c-45b95f0971fa.png>
    

    ```java
    //1. Runnable Interface를 구현한다.
    public class Myclass implements Runnable{

    //2.run method()를 Override 하고 동시에 처리되어야 할 code 정의
    @Overrid
    public void run(){
        //동시에 처리되어야 할 code 정의
    }
    
    //3.자식 class로 객체를 생성한다. (부모인 Thread가 생성된다.)
    Myclass mc = new Myclass();
    }

    //4.Thread class를 이용해 객체를 만들고 매개변수로 Runnable을 구현한 class를 넣어준다.
    Thread t = new Thread(mc); 
    //Thread class의 생성자 중 매개변수로 Runnable을 받는 생성자가 있다. mc와 Runnable은 is-a관계

    //5.Thread class의 start()를 호출하여 run()를 호출한다.
    t.run(); //Has-A관계로 인해 Override한 run()이 호출된다.
    ```
