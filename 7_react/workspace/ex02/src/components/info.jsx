// const Info = (props) => {
//     return (
//         <>
//             <p>
//                 아이디: {props.id}
//             </p>
//             <p>
//                 비밀번호: {props.pw}
//             </p>
//             <p>
//                 이름: {props.name}
//             </p>
//             <p>
//                 성별: {props.man ? "남" : "여"}
//             </p>
//         </>
//     );
// }
const Info = ({id, pw, name, man}) => {
    //js의 객체를 변수로 나누어 선언 가능
    // const {id, pw} = {id:"", pw:""};
    return (
        <>
            <p>
                아이디: {id}
            </p>
            <p>
                비밀번호: {pw}
            </p>
            <p>
                이름: {name}
            </p>
            <p>
                성별: {man ? "남" : "여"}
            </p>
        </>
    );
}
Info.defaultProps = {
    id: "defaultId",
    pw: "defaultPw",
    name: "defaultName"
}
export default Info;