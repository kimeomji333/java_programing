import { useState } from "react";
import MyComponent from "../components/MyComponent";

const MyComponentContainer = (props) => {
    const [data,setData] = useState(0);

    const handler = () => {
        setData(data+1);
    }


    return <MyComponent 
        name={props.name}
        data={data}
        clickBtn={handler}/>
}
export default MyComponentContainer;