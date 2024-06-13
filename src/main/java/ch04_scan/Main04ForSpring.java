package ch04_scan;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch04_di.AlreadyExistingMemberException;
import ch04_di.ChangePasswordService;
import ch04_di.IdPasswordNotMatchException;
import ch04_di.MemberInfoPrinter;
import ch04_di.MemberListPrinter;
import ch04_di.MemberNotFoundException;
import ch04_di.MemberRegisterService;
import ch04_di.RegisterRequest;
import ch04_di.VersionPrinter;

public class Main04ForSpring {
	private static ApplicationContext ctx = null;

	public static void main(String[] args) throws IOException {
		ctx = new AnnotationConfigApplicationContext(App04Ctx.class);

		String[] names = ctx.getBeanDefinitionNames();
		Arrays.stream(names).forEach(name -> System.out.println(name));
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("명령어를 입력하시오");
			String command = sc.nextLine();
			if (command.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다");
				break;
			}
			if (command.startsWith("new")) {
				processNewCommand(command.split(" "));
				continue;
			} else if (command.startsWith("change")) {
				processChangeCommand(command.split(" "));
				continue;
			} else if (command.equals("list")) {
				processListCommand();
				continue;
			} else if (command.startsWith("info")) {
				processInfoCommand(command.split(" "));
				continue;
			} else if (command.equals("version")) {
				processVersionCommand();
				continue;
			}
			printHelp();
		}
	} // end of main()

	private static void processNewCommand(String[] arg) {
		// arg[0]=new, arg[1]=이메일, arg[2]=이름, arg[3]=비밀번호, arg[4]=비밀번호확인
		if (arg.length != 5) {
			printHelp();
			return;
		} // end of if(arg.length != 5)

		MemberRegisterService regSvc = ctx.getBean(MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);

		if (!req.isPasswordEqual()) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		} // end of if(!req.isPasswordEqual())

		try {
			regSvc.regist(req);
		} catch (AlreadyExistingMemberException e) {
			System.out.println("이미 존재하는 이메일 입니다.\n");
		} // end of tryCatch

	} // end of processNewCommand()

	private static void processChangeCommand(String[] arg) {
		if (arg.length != 4) {
			printHelp();
			return;
		} // end of if(arg.length != 4)

		// arg[0]=change, arg[1]=이메일, arg[2]=기존비밀번호, arg[3]=변경 할 비밀번호
		ChangePasswordService changePwdSvc = ctx.getBean(ChangePasswordService.class);

		try {
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("비밀번호 변경 완료");
		} catch (MemberNotFoundException e) {
			System.out.println("존재하지 않는 이메일 입니다");
		} catch (IdPasswordNotMatchException e) {
			System.out.println("이메일과 비밀번호가 일치하지 않습니다");
		}

	} // end of processChangeCommand()

	private static void printHelp() {
		System.out.println("\n잘못된 명령입니다. 아래 명령어 사용법을 확인하세요");
		System.out.println("명령어 사용법:");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("change 이메일 현재암호 변경암호\n");
	} // end of printHelp()

	private static void processListCommand() {
		MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrinter.printAll();
	} // end of processListCommand()

	private static void processInfoCommand(String[] arg) {
		if (arg.length != 2) {
			printHelp();
			return;
		}
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(arg[1]);
	} // end of processInfoCommand()

	private static void processVersionCommand() {
		VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
		versionPrinter.print();
	} // end of processVersionCommand()

} // end of class Main04ForSpring
