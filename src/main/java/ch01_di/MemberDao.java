package ch01_di;

public interface MemberDao {
	void getDbName();
	Member selectByEmail(String email);
	void insert(Member member);
	void update(Member member);
}
