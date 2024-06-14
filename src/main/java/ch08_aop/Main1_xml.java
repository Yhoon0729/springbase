package ch08_aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1_xml {
	public static void main(String[] args) {
		String[] path = {"ch08_aop/aop08.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(path);

		ReadArticleService service = ctx.getBean(ReadArticleService.class);

		Article a1 = null;
		try {
			a1 = service.getArticleAndReadCnt(1);
			System.out.println("[main]a1=" + a1);

			Article a2 = service.getArticleAndReadCnt(1);
			System.out.println("[main]a1=a2 : " + (a1 == a2));

			Article a3 = service.getArticleAndReadCnt(0);
			System.out.println("[main]a3=" + a3);
		} catch (ArticleNotFoundException e) {
			System.out.println("[main]" + e.getMessage());
		}
		System.out.println("\nUpdateMemberInfoTraceAspect 연습");
		MemberService ms = ctx.getBean("memberService", MemberService.class);
		ms.regist(new Member());
		ms.update("hong", new UpdateInfo());
		ms.delete("hong2", "test");
		
		MemberService ms2 = ctx.getBean("memberService2", MemberService.class);
		ms2.regist(new Member());
		ms2.update("hong", new UpdateInfo());
		ms2.delete("hong2", "test");

		System.out.println("\n[main]a1=" + a1);
	}
}
