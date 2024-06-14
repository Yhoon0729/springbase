package ch08_aop;

public interface ArticleDao {
	void insert(Article article);
	void updateReadCount(int id, int i);
}
