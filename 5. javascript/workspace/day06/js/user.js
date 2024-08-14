function sendit(){
    const joinForm = document.joinForm;

    const userid = joinForm.userid;
    if(userid.value == ""){
        alert("아이디를 입력하세요!");
        userid.focus();
        return;
    }
    if(userid.value.length < 5 || userid.value.length > 12){
        alert("아이디는 5자 이상 12자 이하로 입력하세요!");
        userid.focus();
        userid.value = "";
        return;
    }

    // 영어, 한글 배열에서 반복문을 돌면서 검사 -> 보다는 정규식을 이용하자
    // const test = "abcdefghijklmnopqrstuvwxyz0123456789";
    // for(let i=0;i<userid.value.length;i++){
    //     if(!test.includes(userid.value[i])){
    //         alert("잘못된 문자가 사용되었습니다!");
    //         userid.focus();
    //         userid.value = "";
    //         return;
    //     }
    // }

    // 정규식을 이용해서 아이디 유효성 검사(정규식은 객체) 
    // 영어 대문자, 소문자, 숫자로만 이루어져 있는지 확인하는 정규식
    const exp_id = /^[A-za-z0-9]+$/
    if(!exp_id.test(userid.value)){
        alert("잘못된 문자가 사용되었습니다!");
        userid.focus();
        userid.value = "";
        return;
    }

    const userpw = joinForm.userpw;
    const userpw_re = joinForm.userpw_re;

    // if(userpw.value == ""){
    //     alert("비밀번호를 입력하세요!");
    //     userpw.focus();
    //     return;
    // }
    // if(userpw.value.length < 8){
    //     alert("비밀번호는 8자 이상으로 입력해주세요");
    //     userpw.focus();
    //     userid.value = "";
    //     return;
    // }
    // if(userpw.value != userpw_re.value) {
    //     alert("비밀번호 확인을 다시 해주세요!");
    //     userpw_re.focus();
    //     userpw_re.value = "";
    //     return;
    // }

    // 위의 value를 사용하지 않고 로직으로 가능
    const pwtxt = document.getElementById("pwtxt");
    if(pwtxt.innerHTML != "비밀번호가 확인되었어요~"){
        alert("비밀번호 확인을 다시 해주세요!") 
        userpw.focus();
        return;
    }

    const username = joinForm.username;
    if(username.value == ""){
        alert("이름을 입력하세요!");
        username.focus();
        return;
    }
    
    // 한글로 이루어졌는지 검사하는 정규식
    const exp_name = /^[가-힣]+$/
    if(!exp_name.test(username.value)){
        alert("이름에는 한글만 입력하세요!");
        username.focus();
        username.value = "";
        return;
    }
    //주소 유효성검사는 우편번호화 주소만/ 상세주소는 값이 비었는지만 확인
    let flag = false; // 항상 value를 이용하는 것이 아니라, flag도 가능하다.
    const hobbies = joinForm.userhobby;
    for(const hobby of hobbies){  // 중 하나를 꺼내온다.
        if(hobby.checked){
            flag = ture;
            break;
        }
    }
    if(!flag){
        alert("취미는 적어도 1개 이상 선택해 주세요!");
        return;
    }
    joinForm.submit();
}

// 비밀번호/확인 입력 시 마다 이 함수 호출. 입력할 때 이벤트가 필요.
// 키보드 하나 누를 때 3가지 이벤트 : 손가락으로 키보드를 누를 때 keydown, (눌려있는 상태 keypress), 땔 때 keyup
function pwCheck(){
    const joinForm = document.joinForm;
    const userpw = joinForm.userpw;
    const userpw_re = joinForm.userpw_re;
    const pwtxt = document.getElementById("pwtxt");

    if(userpw.value == ""){
        pwtxt.innerHTML = "비밀번호를 입력하세요!";
    }
    else if(userpw.value.length < 8){
        pwtxt.innerHTML = "비밀번호는 8자 이상으로 입력해주세요";
    }
    else if(userpw.value != userpw_re.value) {
        pwtxt.innerHTML = "비밀번호 확인을 다시 해주세요!";
    }
    else {
        pwtxt.innerHTML = "비밀번호가 확인되었어요~";
    }

}