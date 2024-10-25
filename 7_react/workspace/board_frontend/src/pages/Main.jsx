import { useEffect, useRef, useState } from "react";
import Button from "../components/Button";
import { useNavigate } from "react-router-dom";

const Main = () => {
    const [inputs,setInputs] = useState({userid:"",userpw:""})
    const {userid,userpw} = inputs;
    const navigate = useNavigate();


    const inputRef = useRef([]);
    const addInputRef = (el) => {
        if(!inputRef.current.includes(el)){
            inputRef.current.push(el);
        }
    }

    const change = (e) => {
        const {name,value} = e.target;
        setInputs({
            ...inputs,
            [name]:value,
        })
    }

    const login = () => {

    }

    useEffect(()=>{
        window.setTimeout(function(){
            document.querySelector("#wrap+img").classList = "hdd";
            document.querySelector("#wrap").style.display = "block";
        },1300);
    })

    return (
        <div className="main">
            <div id="wrap" className="login">
                <form action="/user/login" method="post" name="loginForm">
                    <table>
                        <tbody>
                            <tr>
                                <th>아이디</th>
                                <td>
                                    <input type="text" name="userid" value={inputs.userid} ref={addInputRef} onChange={change}/>
                                </td>
                            </tr>
                            <tr>
                                <th>비밀번호</th>
                                <td>
                                    <input type="password" name="userpw" ref={addInputRef} onChange={change}/>
                                </td>
                            </tr>
                            <tr>
                                <td colSpan="2">
                                    <div className="btn_area">
                                        <Button value="로그인" onClick={login}></Button>
                                        <Button value="회원가입" onClick={()=>{ navigate("/user/join") }}></Button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
            <img alt="" src={require('../assets/images/타이틀.png')}/>
        </div>
    )
}
export default Main;