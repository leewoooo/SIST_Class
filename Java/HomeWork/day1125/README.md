Work(2020.11.20)
===
Work내용

* 아이디에서 엔터가 눌려지면 아이디가 존재할 때 커서를 비번으로 이동.

* 아이디가 존재하지 않으면 MessageDialog를 사용하여 “아이디필수입력” 을 보여준다.

* 비밀번호에서 엔터가 눌려지면  아이디와 비밀번호가 모두 존재할 때 <br>
출력용 JLable에 id와 비밀번호를 Serif, 진하게, 25px로 이쁜색을 설정하여 보여준다.

* 아이디가 존재하지 않으면 MessageDialog를 사용하여 "아이디필수입력” 을 보여주고, 커서를 아이디 위치로 이동

* 비밀번호가 존재하지 않으면 MessageDialog를 사용하여 “비번필수입력” 을 보여주고,
커서를 비밀번호 위치로 이동


* ClassDiagram

    <img src = https://user-images.githubusercontent.com/74294325/100219863-e4135880-2f59-11eb-8d41-407a5493f1cf.png>

---

* 과제 IMAGE

    * 실행

    <img src = https://user-images.githubusercontent.com/74294325/100219341-36a04500-2f59-11eb-9ff9-ad2baf941c70.png>


    * ID 필수입력

    <img src = https://user-images.githubusercontent.com/74294325/100219469-5fc0d580-2f59-11eb-81e7-1823654e1c1a.png>

    * PASSWORD 필수입력

    <img src = https://user-images.githubusercontent.com/74294325/100219524-7404d280-2f59-11eb-842a-e74d46c160a3.png>

    * ID 및 PASSWORD입력

    <img src = https://user-images.githubusercontent.com/74294325/100219650-9a2a7280-2f59-11eb-9c53-c33fce7ed934.png>

---

## 코드수정


* 이전 코드

```java
    if(e.getSource() == ds.getJtfName() && id.length()>0) {
		this.idFlag=true;
		ds.getJpwPassword().requestFocus();
	}else if(e.getSource() == ds.getJtfName() && id.length()<1) {
		JOptionPane.showMessageDialog(ds, "ID필수입력");
		ds.getJtfName().requestFocus();
	}//end if
		
	if(e.getSource() == ds.getJpwPassword() && password.length()>0) {
		this.passwordFlag=true;
	}else if(e.getSource() == ds.getJpwPassword() && password.length()<1) {
		JOptionPane.showMessageDialog(ds, "PASSWORD필수입력");
		ds.getJpwPassword().requestFocus();
	}//end if

```

* 수정 코드

```java
    if(e.getSource() == ds.getJtfName() && !(id.isEmpty())) {
	    this.idFlag=true;
		ds.getJpwPassword().requestFocus();
	}
		
	if(e.getSource() == ds.getJtfName() && id.isEmpty()) {
		JOptionPane.showMessageDialog(ds, "ID필수입력");
		ds.getJtfName().requestFocus();
	}//end if
		
	if(e.getSource() == ds.getJpwPassword() && !(password.isEmpty())) {
		this.passwordFlag=true;
	}
		
	if(e.getSource() == ds.getJpwPassword() && password.isEmpty()) {
		JOptionPane.showMessageDialog(ds, "PASSWORD필수입력");
		ds.getJpwPassword().requestFocus();
	}//end if
```

* 수정 이유
> event는 if else와 같이 묶어서 관리하는 것보다 각각의 if문으로 관리하는것이 좋다.<br>
> 각 String이 비었는지 문자열이 있는지 확인할때는 숫자로 비교하지말고 isEmpty()를 사용하자