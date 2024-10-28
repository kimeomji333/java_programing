import axios from "axios";
import { useEffect, useState } from "react";
import Header from "../../layout/Header";
import { useLocation, useNavigate } from "react-router-dom";
import Pagination from "../../components/Pagination";

const List = () => {
    const navigate = useNavigate();

    //외부에서 받아온 cri가 있다면 받기( 즉, state로 넘겨진 데이터를 받는 방법 )
    const location = useLocation();
    //const cri = location.state;

    const [cri, setCri] = useState({
        pagenum:1,
        amount:10,
        type:"a",
        keyword:"",
        startrow:0
    });
    
    //백 서버에서 받아올 데이터(변하면 리렌더링 해야 함)
    const [data, setData] = useState();
    //렌더링하기 위한 페이지 구성 조건(변하면 리렌더링 해야 함)
    const [pageMaker, setPagemaker] = useState({
        startPage:1,
        endPage:1,
        realEnd:1,
        total:0,
        prev:false,
        next:false,
        cri:null
    })

    useEffect(()=> {
        //login check 먼저 해야하는데, <- Header로 만들었으니, 굳이 쓸 필요는 없겠네
        const temp = {
            pagenum:cri.pagenum,
            amount:cri.amount,
            type:cri.type,
            keyword:cri.keyword,
            startrow:cri.startrow
        }
        //데이터 받아오기
        axios.get(`/api/board/list/${cri.pagenum}`, {params:cri}).then((resp)=>{
            setData(resp.data);
            setPagemaker(resp.data.pageMaker);
        })
    },[cri])

    useEffect(()=>{
        //만약 이전 페이지에서 cri를 받아온것이 있다면
        if(location.state){
            //pageMaker의 cri를 그 받아온 것으로 세팅
            //State가 변화했으므로 리렌더링 진행
            // > 위에 있는 pageMaker에 종속되어 있는 Effect 호출
            setCri(location.state);
        }
    },[location.state])


    //데이터를 들고 시작할 수 없으니, 로딩중으로 표현
    if(!data){
        return <>로딩중...</>
    }
    else{
        const list = data.list;
        //삼항연산자 보단 빈배열을 만들어서 조건문/반복문으로 요소들 추가해서 배열에 있는 걸로 표현 => {elList}
        const elList = [];
        if(list && list.length > 0){
            for(const board of list){
                elList.push(
                    // navigate에서 state이름으로 데이터를 넘겨주는 방식(렌더링이 일어나는 props랑은 다름)
                    <div className="row" key={board.boardnum} onClick={()=>{ navigate(`/board/${board.boardnum}`, {state:pageMaker.cri}) }}> 
                        <div>{board.boardnum}</div>
                        <div>
                            {board.hotBoard?<sup className="hot">Hot</sup>:""}
                            {board.newBoard?<sup className="new">New</sup>:""}
                            <a className="get">
                                {board.boardtitle}<span id="reply_cnt">[{board.replyCnt}]</span>
                            </a>
                        </div>
                        <div>{board.userid}</div>
                        <div>{board.regdate}{board.regdate != board.updatedate ? "(수정됨)" : ""}</div>
                        <div>{board.readcount}</div>
                    </div>
                )
            }
        }
        else{
            elList.push(
                <div className="row no-list" key={-1}>
                    <div>등록된 게시글이 없습니다.</div>
                </div>
            )
        }
        return (
            <>
                <div id="wrap" className="list">
                    <Header></Header>
                    <div className="tar w1000 board-cnt">글 개수 : 0</div>
                    <div className="list table">
                        <div className="thead tac">
                            <div className="row">
                                <div>번호</div>
                                <div>제목</div>
                                <div>작성자</div>
                                <div>날짜</div>
                                <div>조회수</div>
                            </div>
                        </div>
                        <div className="tbody">
                            {elList}
                        </div>
                    </div>
                    <Pagination pageMaker={pageMaker}></Pagination>
                    <table className="btn_table">
                        <tbody>
                            <tr>
                                <td>
                                    <a className="write btn">글쓰기</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div className="search_area">
                        <form name="searchForm" id="searchForm" action="/board/list" className="row">
                            <input type="search" id="keyword" name="keyword" />
                            <a id="search-btn" className="btn">검색</a>
                            <input type="hidden" name="pagenum" />
                            <input type="hidden" name="amount" />
                        </form>
                    </div>
                </div>
            </>
        )
    }
}
export default List;