package generic;

//타입이 매번 다르면 따로 적을 수 없으니, Object 타입을 이용해서 사용한다. 
//그리고 GenericMain에서 사용할 때 어떤 타입이 될지 결정이 난다. 
//Object 필드로 선언 시 사용할 때마다 다운캐스팅을 해야지만 정상적으로 사용 가능(불편)
//public class Save {
//	Object data;
//}

public class Save<IVE>{
	IVE data;
}
