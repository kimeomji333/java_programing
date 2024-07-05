package api;

import java.util.Random;
import java.util.Scanner;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

public class PhoneCheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String userid = sc.next();
		System.out.print("비밀번호 : ");
		String userpw = sc.next();
		System.out.print("핸드폰 번호 : ");
		String userphone = sc.next();
		
		//처리
		String source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789~!@#$%^";
		int len = source.length();
		String otpMsg = "";
		Random r = new Random();

//		만들고 싶은 문자열의 길이만큼 반복하며
		for (int i = 0; i < 5; i++) {
//			"source" 길이보다 작은 랜덤한 정수 생성
			int idx = r.nextInt(len);
//			"source" 에서 그 위치에 해당하는 문자를 뽑아 otpMsg에 누적연결
			otpMsg += source.charAt(idx);
		}
//		System.out.println(otpMsg);
		
		sendMsg(userphone,"아래의 인증번호를 입력하세요\n"+otpMsg);
		
		System.out.print("인증번호 : ");
		String otpMsg2 = sc.next();
		
		if(otpMsg.equals(otpMsg2)) {
			System.out.println("핸드폰 번호가 인증되었습니다!");
			System.out.println("가입을 계속 진행합니다...");
			
		}
		else {
			System.out.println("핸드폰 인증을 실패했습니다!");
		}
		
	}
	static void sendMsg(String to, String text) {
		DefaultMessageService dms = NurigoApp.INSTANCE.initialize(
				"{INPUT_YOUR_API_KEY}", "{INPUT_YOUR_API_SECRET_KEY}", "https://api.coolsms.co.kr");
		Message message = new Message();
		
		message.setFrom("01012341234");
		message.setTo(to);
		message.setText(text);
		
		SingleMessageSentResponse response = dms.sendOne(
				new SingleMessageSendingRequest(message)
		);
	}
}


















