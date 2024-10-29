import axios from "axios";
import { useEffect, useState } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import Header from "../../layout/Header";
import Button from "../../components/Button";

const Modify = () => {
    const location = useLocation();
    const {cri, boardnum} = location.state; // {"cri":cri, "boardnum": 123}
    const navigate = useNavigate();

    //바뀌는 것들
    const [inputs, setInputs] = useState();
    const [files, setFiles] = useState();
    //원본
    const [board, setBoard] = useState(null);
    const [orgFiles, setOrgFiles] = useState();

    useEffect(()=>{
        axios.get(`api/board/${boardnum}`)
        .then((resp)=>{
            setOrgFiles(resp.data.files);
            setInputs(resp.data.board);
            setBoard(resp.data.board);

            const temp = [];
            let i = 0;
            for(; i<resp.data.files.length; i++){
                const fdto = resp.data.files[i];
                let ext = fdto.systemname.split(".").pop();
                let isThumbnail = ext == 'jpeg' ||  ext == 'jpg' ||  ext == 'png' ||  ext == 'gif' ||  ext == 'webp';
                temp.push({
                    id:i,
                    num:i,
                    file:{
                        name:fdto.orgname,
                        systemname:fdto.systemname
                    },
                    isThumbnail:isThumbnail? `/api/file/thumbnail/${fdto.systemname}`:''
                })
            }
            temp.push({id:i,num:i,file:"",thumbnail:""});
            setFiles(temp);
        })
    })
    if(!board){
        return <>로딩중...</>
    }
    else{
        return (
            <div id="wrap" className="get">
                <Header></Header>
                <form id="boardForm" name="boardForm">
                    <div className="table">
                        <div className="row">
                            <div>제목</div>
                            <div>
                                <input type="text" name="boardtitle" maxLength={50} placeholder="제목을 입력하세요" defaultValue={board.boardtitle}/>
                            </div>
                        </div>
                        <div className="row">
                            <div>작성자</div>
                            <div>
                                <input type="text" name="userid" maxLength={50} defaultValue={board.userid} readOnly />
                            </div>
                        </div>
                        <div className="row">
                            <div>내용</div>
                            <div>
                                <textarea name="boardcontents" defaultValue={board.boardcontents}></textarea>
                            </div>
                        </div>
                        {
                            files.map(item => {
                                return (
                                    <div className={`row r${item.num}`} key={item.id}>
                                        <div>파일 첨부{item.num + 1}</div>
                                        <div className={`file${item.num}_cont row`}>
                                            <div className="cols-7">
                                                <input
                                                    type="file"
                                                    name="files"
                                                    id={`file${item.num}`}
                                                    style={{ display: 'none' }}
                                                />
                                                <span id={`file${item.num}name`}>{item.file.name || '선택된 파일 없음'}</span>
                                            </div>
                                            <div className="row cols-3">
                                                <Button className="btn" value="파일 선택"></Button>
                                                <Button className="btn" value="첨부 삭제"></Button>
                                            </div>
                                            {item.thumbnail?
                                            <div className="thumbnail_area">
                                                <img src={item.thumbnail} alt={`thumbnail${item.id}`} className="thumbnail" />
                                            </div>
                                            : ""
                                            }
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
                                <Button value="수정완료" className="btn"></Button>
                                <Button value="목록" className="btn" onClick={() => {
                                    navigate("/board/list", { state: cri });
                                }}></Button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        );
    }
}
export default Modify;