import {BrowserRouter, Route, Routes} from 'react-router-dom'
import './assets/style/style.css';
import Main from './pages/Main';
import Join from './pages/user/Join';
import List from './pages/board/list';
import Write from './pages/board/Write';
import Get from './pages/board/Get';
import Modify from './pages/board/Modify';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Main/>}></Route>
        <Route path="/user/join" element={<Join/>}></Route>
        <Route path="/board/list" element={<List/>}></Route>
        <Route path="/board/write" element={<Write/>}></Route>
        <Route path="/board/:boardnum" element={<Get/>}></Route>
        <Route path="/board/modify" element={<Modify/>}></Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App;
