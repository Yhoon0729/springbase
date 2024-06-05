package ch01_di;

import java.util.HashMap;
import java.util.Map;

public class MemberOracleDao implements MemberDao{
	
	private static long nextId = 0;
	private Map<String, Member> map = new HashMap();
	String dbname = "oracle";
	
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
}
