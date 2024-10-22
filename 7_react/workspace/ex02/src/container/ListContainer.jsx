import { useEffect, useRef, useState } from "react";
import List from "../components/List";

const ListContainer = () => {
    //console.log("!!!");
    const [list,setList] = useState([]);
    const KEY = useRef(0);
    const NUM = useRef(0);

    const write = () => {
        const board = {key:KEY.current, num:NUM.current};
        setList([board,...list])
        KEY.current++;
        NUM.current++;
    }

    const remove = (key) => {
        for(let i = 0; i < list.length; i++){
            if(list[i].key == key){
                list[i] = null;
            }
            else if(list[i].key > key){
                list[i].key -= 1;
            }
        }
        KEY.current--;
        setList(
            // null 이 아닌 경우에 살려놈. 
            list.filter(
                (item)=>item != null
            )
        );
    }
    
    //처음 렌더링 되었을 때, useEffect 호출해야 함 
    useEffect(()=>{
        //서버에서 게시글 데이터 요청
        //setList([{boardnum:1},{boardnum:2},{boardnum:3}]);
    },[]);

    // return list?
    //     <List
    //     />:
    //     <>로딩중...</>
    return <List
        list = {list}
        write = {write}
        remove = {remove}
    />
}
export default ListContainer;