package ch08_aop;

public class Article {
	private int id;
	private ArticleDao dao;
	
	public Article() {
		
	}
	
	public Article(int id) {
		this.id = id;
	}
	
	public void increaseReanCount() {
		dao.updateReadCount(id, 1);
	}
	
	public void setDao(ArticleDao dao) {
		this.dao = dao;
	}
}
