import Footer from "./components/Footer";
import Header from "./components/Header";
import InfoContainer from "./container/infoContainer";
import JoinContainer from "./container/JoinContainer";
import ListContainer from "./container/ListContainer";
import MyComponentContainer from "./container/MyComponentContainer";

//라우터: 길 찾아갈 수 있게 해주는 표지판의 하드웨어
const Router = () => {
    const command = document.location.href.split(":3000")[1];
    console.log(command);

    let component = null;
    switch(command){
        case "/my":
            component = <MyComponentContainer/>;
            break;
        case "/info":
            component = <InfoContainer/>;
            break;
        case "/join":
            component = <JoinContainer/>;
            break;
        case "/list":
            component = <ListContainer/>;
            break;
    }
    return (
        <>
            <Header/>
            {component}
            <Footer/>
        </>
    )
} 
export default Router;