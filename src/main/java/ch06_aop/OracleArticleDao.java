package ch06_aop;

public class OracleArticleDao implements ArticleDao{

	@Override
	public void insert() {
		System.out.println("OracleArticleDao.insert() 메서드 호츨");
	}

	@Override
	public String select() {
		System.out.println("OracleArticleDao.select() 메서드 호출");
		return "홍길동의 글";
	}
}
