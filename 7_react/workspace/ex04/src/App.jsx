import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Header from './layout/Header';
import Footer from './layout/Footer';
import Main from './pages/Main';
import Info from './pages/info';

const App = () => {
    return (
        <BrowserRouter>
            <Header></Header>
            <Routes>
                <Route path='/' element={<Main/>}></Route>
                <Route path='/info' element={<Info/>}></Route>
            </Routes>
            <Footer></Footer>
        </BrowserRouter>
    )
}
export default App;