import {BrowserRouter, Route, Routes} from 'react-router-dom'
import './assets/style/style.css';
import Main from './pages/Main';
import Join from './pages/user/Join';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Main></Main>}></Route>
        <Route path="/user/join" element={<Join></Join>}></Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App;
