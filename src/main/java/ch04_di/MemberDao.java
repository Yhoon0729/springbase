package ch04_di;

import java.util.Collection;

public interface MemberDao {
	void getDbName();
	Member selectByEmail(String email);
	void insert(Member member);
	void update(Member member);
	
	Collection<Member> selectAll();
}
