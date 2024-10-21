import Info from "../components/info";

const InfoContainer = () => {
    //실제로는 백 서버와의 소통
    // const user = {id:"apple", pw:"1234", name:"김사과"};

    //백 서버와의 소통이 실패한 경우
    const user = {};

    //외부에서 백 서버와 통신을 했고, 그 데이터를 넘겨주기 위해서 props를 이용
    return <Info id={user.id} pw={user.pw} name={user.name} man/>
}
export default InfoContainer;