package api;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

public class SMSTest {
	public static void main(String[] args) {
		DefaultMessageService dms = NurigoApp.INSTANCE.initialize(
				"{INPUT_YOUR_API_KEY}", "{INPUT_YOUR_API_SECRET_KEY}", "https://api.coolsms.co.kr");
		Message message = new Message();
		message.setFrom("{INPUT_YOUR_PHONE_NUMBER}");
		message.setTo("01012341234");
		message.setText("문자 보내기 테스트! 제에ㅐ에에ㅔ바아아아알");
		
		SingleMessageSentResponse response = dms.sendOne(
				new SingleMessageSendingRequest(message)
		);
		System.out.println(response);
	}
}











