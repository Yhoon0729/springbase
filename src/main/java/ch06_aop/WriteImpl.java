package ch06_aop;

public class WriteImpl {
	private ArticleDao articleDao;
	
	public WriteImpl(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	public void write() {
		System.out.println("\nWriteImpl.write() 메서드 호출됨");
		articleDao.insert();
	}
}
