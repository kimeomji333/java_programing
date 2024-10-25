import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Header from './layout/Header';
import Footer from './layout/Footer';
import Main from './pages/Main';
import Info from './pages/info';
import List from './pages/List';
import Product from './pages/Product';

const App = () => {
    return (
        <BrowserRouter>
            <Header></Header>
            <Routes>
                <Route path='/' element={<Main/>}></Route>
                <Route path='/info' element={<Info/>}></Route>
                <Route path='/list' element={<List/>}></Route>
                <Route path='/product/:prodnum' element={<Product/>}></Route>
            </Routes>
            <Footer></Footer>
        </BrowserRouter>
    )
}
export default App;