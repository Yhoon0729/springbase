package ch08_aop;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ArticleCacheAspect {

   private Map<Integer, Article> cache = new HashMap<>();
   
   @Around("execution(public * *..ReadArticleService.*(..))")
   public Article cache( ProceedingJoinPoint joinPoint) throws Throwable {
      
      System.out.println("[ACA] cache before 실행");
      
      Integer id = (Integer) joinPoint.getArgs()[0];
      
      Article article = cache.get(id);
      
      // 기존에 Article 객체가 저장되어 있음
      if( article != null ) {
         System.out.println( "[ACA] cache 에서 Article [ " + id + " ] 가져옴" );
         return article;
      }
      
      Article ret = (Article) joinPoint.proceed();
      // ret : Article(1) 객체, 핵심알고리즘이 리턴 객체
      
      System.out.println( "[ACA] cache after 실행 " );
      
      if( ret != null) {
         cache.put(id, ret);
         System.out.println( "[ACA] cahe 에 Article [ " + id + " ] 객체를 추가함" );
      }
      return ret;
      
   }// cache
   
}//class