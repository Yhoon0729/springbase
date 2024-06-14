package ch08_aop;

import org.springframework.stereotype.Component;

@Component("memberServiceImpl")
public class MemberServiceImpl implements MemberService{

	@Override
	public void regist(Member member) {
		System.out.println("MemberServiceImpl.regist() 메서드 실행");
	}

	@Override
	public boolean update(String memberId, UpdateInfo info) {
		System.out.println("MemberServiceImpl.update() 메서드 실행");
		return false;
	}

	@Override
	public boolean delete(String id, String str) {
		System.out.println("MemberServiceImpl.delete() 메서드 실행");
		return false;
	}

}
