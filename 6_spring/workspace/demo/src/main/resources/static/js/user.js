//주소찾기 관련된 함수
function findAddr() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("addretc").value = extraAddr;
            
            } else {
                document.getElementById("addretc").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zipcode').value = data.zonecode;
            document.getElementById("addr").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("addrdetail").focus();
        }
    }).open();
}

//중복체크 관련된 코드
const result = document.getElementById("result");
function checkId(){
	const xhr = new XMLHttpRequest();
	const userid = document.joinForm.userid;
	if(userid.value == ""){
		alert("아이디를 입력하세요!");
		userid.focus();
		return;
	}
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			if(xhr.status == 200){
				let txt = xhr.responseText.trim();
				if(txt == "O"){
					result.innerHTML = "사용할 수 있는 아이디입니다!";
					document.joinForm.userpw.focus();
				}
				else{
					result.innerHTML = "중복된 아이디가 있습니다!";
					userid.value = "";
					userid.focus();
				}
			}
		}	
	}
	
	xhr.open("GET","/user/checkId?userid="+userid.value);
	xhr.send();
}

//비밀번호 검사에 관련된 코드들
//비밀번호 유효성 검사를 위한 배열
const pwTest = [false,false,false,false,false];
function pwcheck(){
	const userpw = document.joinForm.userpw;
	const userpw_re = document.joinForm.userpw_re;
	//아래쪽에 있는 귀여운 span 태그들 가져오기
	const spans = document.querySelectorAll(".pw_check span");
	
	//영어 대문자, 영어 소문자, 숫자, 특수문자를 한 글자씩 포함하는지 확인하는 정규식
	const reg = /^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?[~?!@-]).{4,}$/
	
	//무언가 키를 눌렀지만 value가 비었다는 뜻은 다 지웠다는 뜻
	//모든 span태그들 디자인 초기화, 유효성 검사용 배열 초기화
	if(userpw.value == ""){
		for(let i=0;i<5;i++){
			pwTest[i] = false;
			spans[i].classList="";
		}
		return;
	}
	
	if(!reg.test(userpw.value)){
		pwTest[0] = false;
		spans[0].classList = "pcf"
	}
	else{
		pwTest[0] = true;
		spans[0].classList = "pct";
	}
	if(userpw.value.length < 8){
		pwTest[1] = false;
		spans[1].classList = "pcf"
	}
	else{
		pwTest[1] = true;
		spans[1].classList = "pct"
	}
	//같은 문자가 네번 연속해서 있는지 검사하는 정규식
	if(/(\w)\1\1\1/.test(userpw.value)){
		pwTest[2] = false;
		spans[2].classList = "pcf";
	}
	else{
		pwTest[2] = true;
		spans[2].classList = "pct";
	}
	//[]안의 문자들로 문자열이 이루어져 있는지 검사하는 정규식
	if(!/^[a-zA-Z0-9~?!@-]*$/.test(userpw.value)){
		pwTest[3] = false;
		spans[3].classList = "pcf";
	}
	else{
		pwTest[3] = true;
		spans[3].classList = "pct";
	}
	if(userpw.value != userpw_re.value){
		pwTest[4] = false;
		spans[4].classList = "pcf";
	}
	else{
		pwTest[4] = true;
		spans[4].classList = "pct";
	}
}















