import { useEffect, useRef, useState } from "react";
import Join from "../components/Join";

const JoinContainer = () => {
    const [inputs, setInputs] = useState({id:"",pw:"",name:""});
    // inputs. 을 줄이기 위해서
    const {id,pw,name} = inputs;
    const [list,setList] = useState([]);

    const inputRef = useRef([]);
    // inputRef는 배열로 만들어지기 때문에 그 배열에 각 input 태그들을 추가하는 작업을 하는 addInputRef 함수 선언
    const addInputRef = (el) => {
        // current 현재의 배열에 접근하기 위해
        inputRef.current.push(el);
        //console.log(inputRef.current);
    }

    const change = (e) => {
        const {name, value} = e.target;
        // inputs[name] = value; 첫번째에만 적용되니깐, set을 이용해서 객체를 바꿔줘야 한다.
        setInputs({
            //배열/객체에서 사용. 기존 배열/객체를 뜻함
            //name이라는 변수명을 프로퍼티 이름을 동적으로 설정
            ...inputs,
            [name]:value
        });
    }
    const join = () => {
        //console.log(inputs);
        if(!id){
            alert("아이디를 입력하세요!");
            inputRef.current[0].focus();
            return;
        }
        else if(!pw){
            alert("비밀번호를 입력하세요!");
            inputRef.current[1].focus();
            return;
        }
        else if(!name){
            alert("이름을 입력하세요!");
            inputRef.current[2].focus();
            return;
        }
        //실제로는 백 서버로 가입 요청
        setList([...list,inputs]);
        setInputs({id:"",pw:"",name:""});
        inputRef.current[0].focus();
        //console.log(list);
    }

    useEffect(()=>{
        inputRef.current[0].focus();
    },[list]);
    return <Join
        change = {change}
        join = {join}
        list = {list}
        inputs = {inputs}
        addInputRef = {addInputRef}
    />
}
export default JoinContainer;