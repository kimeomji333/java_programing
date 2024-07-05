package api;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

public class SMSTest {
	public static void main(String[] args) {
		DefaultMessageService dms = NurigoApp.INSTANCE.initialize("{INPUT_YOUR_API_KEY}", "{INPUT_YOUR_API_SECRET_KEY}", "https://api.coolsms.co.kr");

		Message message = new Message(); // 데이터 포장용 클래스
		message.setFrom("발신번호 입력");
		message.setTo("수신번호 입력");
		message.setText("문자 보내기 테스트!");

		// 문자 1개 보내는 객체
		//요청에 대한 응답을 return
		SingleMessageSentResponse response = dms.sendOne(new SingleMessageSendingRequest(message));
		System.out.println(response);

		
	}

}
