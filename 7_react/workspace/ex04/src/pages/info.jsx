import Button from "../components/button";
import {useNavigate} from 'react-router-dom';

const Info = ({id='did',pw,name,man}) => {
    const navigate = useNavigate();
    return (
        <>
            <p>아이디: {id}</p>
            <p>비밀번호: {pw}</p>
            <p>이름: {name}</p>
            <p>성별: {man?"남":"여"}</p>
            <p>
                <Button value={'메인으로'} onClick={() => {
                    navigate("/");
                }}></Button>
            </p>
        </>
    )
}
Info.defaultProps = {
    pw:'dpw',
    name:'dname',
    man:true
}
export default Info;