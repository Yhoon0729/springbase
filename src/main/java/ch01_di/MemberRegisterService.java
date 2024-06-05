package ch01_di;

import java.util.Date;

public class MemberRegisterService {
	// MemberRegisterService가 MemberDao에 의존한다, MemberDao주소 설정 안 되면 사용 불가
	MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		memberDao.getDbName();
		this.memberDao = memberDao;
	} // end of MemberRegisterService()
	
	public void regist(RegisterRequest req) {
		System.out.println(req);
		
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new AlreadyExistingMemberException("email 중복" + req.getEmail());
		} // end of if(member != null)
		
		Member newMember = new Member(req.getEmail(), req.getName(), 
				req.getPassword(), new Date());
		
		memberDao.insert(newMember);
	} // end of regist()
} // end of class MemberRegisterService
