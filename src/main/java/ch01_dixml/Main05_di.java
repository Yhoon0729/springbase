package ch01_dixml;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch01_di.AlreadyExistingMemberException;
import ch01_di.ChangePasswordService;
import ch01_di.IdPasswordNotMatchException;
import ch01_di.MemberDao;
import ch01_di.MemberNotFoundException;
import ch01_di.MemberRegisterService;
import ch01_di.RegisterRequest;

public class Main05_di {
	static GenericXmlApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new GenericXmlApplicationContext("classpath:ch01_dixml/container05.xml");
		// 컨테이너 만들어지는 시점에 constructor-arg 가 먼저 실행됨
		System.out.println("====================");
		MemberDao md = ctx.getBean("memberDao", MemberDao.class);
		md.getDbName();

		Scanner sc = new Scanner(System.in);
		while (0 == 0) {
			System.out.println("명령어를 입력하시오");
			String command = sc.nextLine();
			if (command.equalsIgnoreCase("exit")) { // 대소문자 상관 없이 exit 문장
				System.out.println("종료합니다");
				break;
			} else if (command.startsWith("new")) { // 회원 등록
				processNewMember(command.split(" "));
				continue;
			} else if (command.startsWith("change")) { // 비밀번호 변경
				processChangeCommand(command.split(" "));
			} else {
				printHelp();
				continue;
			} // end of if (command)
		} // end of while(0==0)
	} // end of main

	private static void processNewMember(String[] arg) {
		// arg[0]=new, arg[1]=이메일, arg[2]=이름, arg[3]=비밀번호, arg[4]=비밀번호확인
		if (arg.length != 5) {
			printHelp();
			return;
		} // end of if(arg.length != 5)
		
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		if(!req.isPasswordEqual()) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		} // end of if(!req.isPasswordEqual())
		
		try {
			regSvc.regist(req);
		} catch(AlreadyExistingMemberException e) {
			System.out.println("이미 존재하는 이메일 입니다.\n");
		} // end of tryCatch
		
	} // end of processNewMember()
	
	private static void processChangeCommand(String[] arg) {
		if(arg.length != 4) {
			printHelp();
			return;
		} // end of if(arg.length != 4)
		
		// arg[0]=change, arg[1]=이메일, arg[2]=기존비밀번호, arg[3]=변경 할 비밀번호
		ChangePasswordService changePwdSvc
		= ctx.getBean("changePwdSvc", ChangePasswordService.class);
		
		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("비밀번호 변경 완료");
		} catch(MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일 입니다");
		} catch(IdPasswordNotMatchException e) {
			System.out.println("이메일과 비밀번호가 일치하지 않습니다");
		}

	} // end of processChangeCommand()

	private static void printHelp() {
		System.out.println("\n잘못된 명령입니다. 아래 명령어 사용법을 확인하세요");
		System.out.println("명령어 사용법:");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재암호 변경암호\n");
	} // end of printHelp()
} // end of class Main05_di
