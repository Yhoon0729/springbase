package ch06_aop;

public class ReadImpl {
	private ArticleDao articleDao;
	
	public ReadImpl (ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	public String read() {
		System.out.println("\nReadImpl.read() 메서드 호출");
		return articleDao.select();
	}
}
