package ch07_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main_aop07 {
	public static void main(String[] args) {
		String[] path = {"ch07_aop/aop07.xml", "ch07_aop/di07.xml"};
		ApplicationContext ctx =
				new ClassPathXmlApplicationContext(path);
		
		ReadArticleService service = ctx.getBean(ReadArticleService.class);
		
		Article a1 = null;
		try {
			a1 = service.getArticleAndReadCnt(1);
			System.out.println("[main]a1="+a1);
			
			Article a2 = service.getArticleAndReadCnt(1);
			System.out.println("[main]a1=a2 : " + (a1==a2));
			
			Article a3 = service.getArticleAndReadCnt(0);
			System.out.println("[main]a3="+a3);
		} catch (ArticleNotFoundException e) {
			System.out.println("[main]" + e.getMessage());
		}
		
		System.out.println("\n[main]a1=" + a1);
	}
}
