package com.sist.exam03;

public class MemberService {

	private final UpdateInfo info;

	public MemberService(UpdateInfo info) {
		this.info = info;
	}



	public void update(String memberID) {
		System.out.println(memberID + "의 정보를 " + info.getId() + "로 수정하였습니다.");
	}
}
