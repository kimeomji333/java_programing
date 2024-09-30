//addEventListener vs. onclick()
//document.getElementById("checking-userid").addEventListener("click", checkId);

function checkId(){
    const userid = document.getElementById("userid");
    const idMessage = document.getElementById("idMessage");

    if(userid.value == ""){
        alert("아이디를 입력하세요!");
        userid.focus();
        return;
    }
	
	if(!/^[a-z0-9]{4,12}$/.test(userid.value)){
		idMessage.textContent = "영문 소문자와 숫자만 사용하여, 4~12자의 아이디를 입력해주세요.";
		return;
	}

	// 서버에 아이디 중복 체크 요청
	const xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState == 4 && xhr.status == 200){
            let txt = xhr.responseText.trim();
            
			if(txt == "O"){
                idMessage.innerHTML = "사용할 수 있는 아이디입니다!";
                idMessage.style.color = "blue";
                document.joinform.nickname.focus();
            }
            else{
                idMessage.innerHTML = "중복된 아이디가 있습니다!";
                idMessage.style.color = "red";
                userid.value = "";
                userid.focus();
            }
        }
    }

    xhr.open("GET", "/user/checkId?userId="+userid.value);
    xhr.send();
}

function checkPw(){
    const password = document.joinform.password.value;
    const pwMessage = document.getElementById("pwMessage");

    if(password == ""){
        alert("비밀번호를 입력하세요!");
        document.joinform.password.focus();
        return;
    }

    // 비밀번호 유효성 검사 조건
    const regex = /^(?=.*[a-zA-Z])(?=.*\d|[!@#$%^&*()_+=\-{}[\]:;"'<>?,./\\|`~]).{6,20}$/;
   
    if(!regex.test(password)){
        pwMessage.textContent = "영문 대문자와 소문자, 숫자, 특수문자 중 2가지 이상을 조합하여 6~20자로 입력해주세요.";
        pwMessage.style.color = "red";
        return;
    }
    else{
        pwMessage.textContent = "";
    }
}

function matchPw(){
    const password = document.joinform.password.value;
    const password_re = document.joinform.password_re.value;
    const pwMessage = document.getElementById("pwMessage");

    // 비밀번호 확인
    if(password != password_re){
        pwMessage.innerHTML = "비밀번호가 일치하지 않습니다.";
        pwMessage.style.color = "red";
    }
    else{
        pwMessage.innerHTML = "비밀번호가 일치합니다.";
        pwMessage.style.color = "blue";
    }
}
