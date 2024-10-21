import { useState } from "react";

//props: {name:"김사과", age="20"} 형태로 담겨있음
//부모로부터 name, age를 props로 받아오고, data라는 상태를 가지고 초기값은 0이다. 
const MyComponent = (props) => {
    const [data,setData] = useState(0);

    //버튼을 눌렀을 때 호출되는 함수
    const handleClickBtn = ()=>{
        setData(data+1);
    }

    return (
    <>
        <p>{props.name}가 추가한 내용</p>
        <p>여러개의 Element가 있을 시 부모태그 하나로 감싸주어야 함</p>
        <p>리렌더링: {data}</p>
        <p><input type="button" value="버튼" onClick={handleClickBtn}></input></p>
    </>
    );
}
export default MyComponent;