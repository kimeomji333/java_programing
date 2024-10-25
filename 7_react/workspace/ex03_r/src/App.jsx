import {Link, Route, BrowserRouter as Router, Routes} from 'react-router-dom'
import './App.css';
import { useRef, useState } from 'react';

const App = () => {
    const [movies,setMovies] = useState([
        {id:1, title:'Movie 1', genre:'Drama', release_date:'2024-06-24'},
        {id:2, title:'Movie 2', genre:'Action', release_date:'2024-08-15'},
        {id:3, title:'Movie 3', genre:'Horror', release_date:'2024-10-23'}
    ]);


    return (
        <Route>
            <div className="container">
                <nav>
                    <ul>
                        <li><Link to={"/"}>List</Link></li>
                        <li><Link to={"/create"}>Add new Movie</Link></li>
                    </ul>
                </nav>
                <Routes>
                    <Route path='/' element={<Home movies={movies} setMovies={setMovies}></Home>}></Route>
                    <Route path='/create' element={<Create movies={movies} setMovies={setMovies}></Create>}></Route>
                </Routes>
            </div>
        </Route>
    )
}
const Home = ({movies,setMovies}) => {

    return (
        <div>
            <h1>Movie</h1>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Genre</th>
                        <th>Release Date</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {movie.map((movie) => (
                        <tr key={movie.id}>
                            <td>{movie.id}</td>
                            <td>{movie.title}</td>
                            <td>{movie.genre}</td>
                            <td>{movie.release_date}</td>
                            <td><button>Delete</button></td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}
const Create = ({movies,setMovies}) => {
    const [inputs,setInputs] = useState({id:'',title:'',genre:'',release_date:''});

    const write = () => {
        const isDuplicate = movies.some((movie) => movie.id == inputs.id)
        if(isDuplicate){
            alert("이미 존재하는 ID입니다.");
            return;
        }
        setMovies([...movies,inputs]);
        setInputs({id:'',title:'',genre:'',release_date:''});
    }

    return (
        <div>
            <h1>Create Movie</h1>
            <form>
                <div>
                    <input type="number" name="id" placeholder='Input Movie Id' />
                </div>
                <div>
                    <input type="text" name="title" placeholder='Input Movie Title' />
                </div>
                <div>
                    <input type="text" name="genre" placeholder='Input Movie Genre' />
                </div>
                <div>
                    <input type="date" name="release_date" />
                </div>
                <button>Add Movie</button>
            </form>
        </div>
    )
}
export default App;