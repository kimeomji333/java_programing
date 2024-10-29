import axios from "axios";
import { useEffect, useRef, useState } from "react";
import { useLocation, useNavigate, useParams } from "react-router-dom";
import Header from "../../layout/Header";
import Button from "../../components/Button";

const Get = () => {
    const {boardnum} = useParams();
    const cri = useLocation().state;
    const navigate = useNavigate();

    const [data, setDate] = useState({board:null, files:null});
    const {board, files} = data;
    const [loginUser, setLoginUser] = useState();

    const remove = () => {
        axios.delete(`api/board/${board.boardnum}`)
        .then((resp)=>{
            alert(`${resp.data}번 게시글 삭제!`)
            navigate(`/board/list`, {state:cri})
        })
    }

    useEffect(()=> {
        axios.get(`/api/board/${boardnum}`)
        .then((resp)=>{
            //서버에서 데이터를 어떻게 보내주는지 확인해보면, resp.date : { board:{BoardDTO}, files:[{},{},..] }
            setDate(resp.data);
        })
        //로그인체크
        axios.get(`/api/user/loginCheck`).then(resp=>{
            if(resp.data.trim() != ""){
                setLoginUser(resp.data.trim());
            }
        })
    },[])
    

    if(!board){
        return <>로딩중...</>
    }
    else{
        return (
            <>
                <div id="wrap" className="get">
                <Header></Header>
                <form id="boardForm" name="boardForm">
                    <div className="table">
                        <div className="row">
                            <div>제목</div>
                            <div>
                                <input type="text" name="boardtitle" maxLength={50} placeholder="제목을 입력하세요" readOnly value={board.boardtitle}/>
                            </div>
                        </div>
                        <div className="row">
                            <div>작성자</div>
                            <div>
                                <input type="text" name="userid" maxLength={50} readOnly value={board.userid}/>
                            </div>
                        </div>
                        <div className="row">
                            <div>내용</div>
                            <div>
                                <textarea name="boardcontents" readOnly value={board.boardcontents}></textarea>
                            </div>
                        </div>
                        {
                            files.map((file,i)=>{
                                //file : 꺼내온 FileDTO 형태의 객체
                                let ext = file.systemname.split(".").pop();
                                let isThumbnail = ext == 'jpeg' ||  ext == 'jpg' ||  ext == 'png' ||  ext == 'gif' ||  ext == 'webp';
                                return (
                                    <div className={`row r${i}`} key={`r${i}`}>
                                        <div>첨부 파일{i+1}</div>
                                        <div className={`file${i}_cont row`}>
                                            <div className="cols-10">
                                                <a className="download" id={`file${i}name`} href={`/api/file/download/${file.systemname}`}>{file.orgname}</a>
                                            </div>
                                            <div className="thumbnail_area">
                                                {
                                                    isThumbnail ? <img src={`/api/file/thumbnail/${file.systemname}`} alt={`thumbnail${i}`} className="thumbnail"></img> : ""
                                                }
                                            </div>
                                        </div>
                                    </div>
                                )
                            })
                        }
                    </div>
                </form>
                <table className="btn_area">
                    <tbody>
                        <tr>
                            <td>
                                {
                                    loginUser == board.userid ? 
                                    <>
                                        <Button value="수정" className="btn" onClick={()=>{ navigate(`/board/modify`, {state:{"cri":cri, "boardnum":board.boardnum}} ) }}></Button>
                                        <Button value="삭제" className="btn" onClick={remove}></Button>
                                    </> : ""

                                }
                                <Button value="목록" className="btn" onClick={() => {
                                    navigate("/board/list", { state: cri });
                                }}></Button>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div className="reply_line">
                   
                </div>
            </div>
            </>
        )
    }
}
export default Get;