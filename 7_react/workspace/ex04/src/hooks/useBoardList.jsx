import { useEffect, useRef, useState } from "react";

const useBoardList = (path) => {
    // /baord/list
    // /board2/list

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

    useEffect(() => {
        // 백 통신
        console.log(`/${path}/list`);
    })

    return {list:list, write:write, remove:remove}
}
export default useBoardList;