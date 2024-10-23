import { useEffect } from "react"

const Main = () => {
    useEffect(() => {
        alert("반가워요!");
    },[])

    return <div>초기화면 입니다.</div>
}
export default Main;