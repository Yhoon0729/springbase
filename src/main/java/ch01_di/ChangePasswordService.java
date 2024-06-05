package ch01_di;

public class ChangePasswordService {
	
	MemberDao memberDao;
	
	public ChangePasswordService(MemberDao memberDao) {
		System.out.println("==ChangePasswordService==");
		memberDao.getDbName();
		this.memberDao = memberDao;
	} // end of ChangePassWordService()
	
	public void changePassword(String email, String oldPw, String newPw) {
		Member member = memberDao.selectByEmail(email);
		
		if (member == null) {
			throw new MemberNotFoundException();
		} // end of if (member != null)
		
		member.changePassword(oldPw, newPw);
		memberDao.update(member);
	} // end of changePassword()
} // end of class ChangePasswordService
