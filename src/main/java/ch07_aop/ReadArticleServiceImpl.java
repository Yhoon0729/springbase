package ch07_aop;

public class ReadArticleServiceImpl implements ReadArticleService{

	@Override
	public Article getArticleAndReadCnt(int id) throws ArticleNotFoundException {
		System.out.println("getArticleAndReadCnt(" + id + ") 호출됨 --> joinPoint");
		if(id == 0) {
			throw new ArticleNotFoundException("id는 0이 안됨");
		}
		return new Article(id);
	}

}
