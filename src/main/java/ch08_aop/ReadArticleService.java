package ch08_aop;

public interface ReadArticleService {
	Article getArticleAndReadCnt(int id) throws ArticleNotFoundException;
	
}
