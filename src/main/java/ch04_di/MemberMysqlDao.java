package ch04_di;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberMysqlDao implements MemberDao{
	
	private static long nextId = 0;
	private Map<String, Member> map = new HashMap();
	String dbname = "mysql";
	
	public void getDbName() {
		System.out.println(dbname);
	}

	@Override
	public Member selectByEmail(String email) {

		return map.get(email);
	}

	@Override
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
		System.out.println(dbname+" : "+member);
	}

	@Override
	public void update(Member member) {
		map.put(member.getEmail(), member);
		
	}

	@Override
	public Collection<Member> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
