package ch08_aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UpdateMemberInfoTraceAspect {
	
	@AfterReturning(pointcut = "args(id,info)", returning = "ret", argNames = "ret,id,info")
	public void traceReturn(boolean ret, String id, UpdateInfo info) {
		System.out.println("[TA] 정보 수정 : 결과="+ret+", 대상회원="+id+
				", 수정정보="+info);
	}
}
