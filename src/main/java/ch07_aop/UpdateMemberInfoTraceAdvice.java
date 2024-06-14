package ch07_aop;

public class UpdateMemberInfoTraceAdvice {
	public void traceReturn(boolean ret, String id, UpdateInfo info) {
		System.out.println("[TA] 정보 수정 : 결과="+ret+", 대상회원="+id+
				", 수정정보="+info);
	}
}
