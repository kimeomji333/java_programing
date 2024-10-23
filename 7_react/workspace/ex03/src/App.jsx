import {Link, Route, BrowserRouter as Router, Routes} from 'react-router-dom'
import './App.css';
import { useRef, useState } from 'react';

const App = () => {
    const [movies,setMovies] = useState([
        {id:1, title:'Movie 1', genre:'Drama', release_date:'2024-06-24'},
        {id:2, title:'Movie 2', genre:'Action', release_date:'2024-08-15'},
        {id:3, title:'Movie 3', genre:'Horror', release_date:'2024-10-23'}
    ]);

    const addMovie = (newMovie) => {
        setMovies([...movies, newMovie]);
    }

    const deleteMovie = (id) => {
        setMovies(movies.filter(movie => movie.id !== id));
    }

    return (
        <Router>
            <div className='container'>
                <nav>
                    <ul>
                        <li><Link to={"/"}>List</Link></li>
                        <li><Link to={"/create"}>Add new Movie</Link></li>
                    </ul>
                </nav>
                <Routes>
                    <Route path='/' element={<Home movies={movies} deleteMovie={deleteMovie}></Home>}></Route>
                    <Route path='/create' element={<Create movies={movies} addMovie={addMovie}></Create>}></Route>
                </Routes>
            </div>
        </Router>
    )
}
const Home = ({movies,deleteMovie}) => {
    return (
        <>
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
                    {movies.map((movie) => 
                        (
                            <tr key={movie.id}>
                                <td>{movie.id}</td>
                                <td>{movie.title}</td>
                                <td>{movie.genre}</td>
                                <td>{movie.release_date}</td>
                                <td><button onClick={() => deleteMovie(movie.id)}>Delete</button></td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
        </>
    )
}
const Create = ({addMovie, movies}) => {
    const id = useRef('');
    const title = useRef('');
    const genre = useRef('');
    const release_date = useRef('');
    const [error, setError] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();

        // 중복 아이디 체크
        const parseId = Number(id.current.value);
        console.log(parseId);
        if(isNaN(parseId) || movies.find(movie => movie.id === parseId)) {
            setError('중복된 id로 이미 존재합니다.');
            return;
        }
        else{
            setError('');
        }

        if(id.current.value && title.current.value && genre.current.value && release_date.current.value){
            addMovie({
                id: parseId,
                title: title.current.value,
                genre: genre.current.value,
                release_date: release_date.current.value
            });
            console.log({id,title,genre,release_date});
            id.current.value = '';
            title.current.value = '';
            genre.current.value = '';
            release_date.current.value = '';
        }
    }
    return (
        <div>
            <h1>Create Movie</h1>
            <form onSubmit={handleSubmit}>
                <div>
                    <input type='number' name='id' placeholder='Input Movie Id' ref={id}/>
                </div>
                <div>
                    <input type='text' name='title' placeholder='Input Movie Title' ref={title}/>
                </div>
                <div>
                    <input type='text' name='genre' placeholder='Input Movie Genre' ref={genre}/>
                </div>
                <div>
                    <input type='date' name='release_date' ref={release_date}/>
                </div>
                <button type='submit'>Add Movie</button>
            </form>
            <p style={{ color: 'red' }}>{error}</p>
        </div>
    )
}
export default App;