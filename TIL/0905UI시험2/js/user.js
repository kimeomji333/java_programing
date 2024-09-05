// 1. 패스워드 입력 요소를 클릭한 경우 "영문자 대/소문자 특수문자, 숫자 포함 8 ~ 32자" 라는 메시지가 나오게 한다.

// 2. 아이디, 패스워드, 패스워드 확인을 입력하지 않고 다음 입력 요소로 이동하는 경우 "필수 입력 항목 입니다" 라는 메시지가 입력 요소 하단에 나오게 한다.

const userid = document.getElementById("userid");
const password = document.getElementById("userpw");
const password_re = document.getElementById("userpw_re");
const result = document.getElementById("pwtxt");

password.addEventListener("focus", function() {
    pwtxt.innerHTML = "영문자 대/소문자 특수문자, 숫자 포함 8 ~ 32자";
});

function handleBlur(e){
    const target = e.target;
    const errorElement = target.parentElement.nextElementSibling;

    if(target.value.trim() == ""){
        errorElement.innerHTML = "필수 입력 항목 입니다.";
    }
    else{
        errorElement.innerHTML = "";
    }
}