package ch04_di;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberPrinter {
   private SimpleDateFormat simpDateTimeFormatter;
   
   public MemberPrinter() {
      simpDateTimeFormatter = new SimpleDateFormat("yyyy년 MM월 dd일");
   }
   
   public void print(Member member) {
      if (simpDateTimeFormatter == null) {
         System.out.printf(
               "회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", 
               member.getId(), member.getEmail(),
               member.getName(), member.getRegisterDate());
      } else {
         System.out.printf(
               "회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n", 
               member.getId(), member.getEmail(),
               member.getName(), 
               simpDateTimeFormatter.format(member.getRegisterDate()));
      }
   }
   
}