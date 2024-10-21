const MyComponent = (props) => {
    return (
        <>
            <p>{props.name}가 추가한 내용</p>
            <p>여러개의 Element가 있을 시 부모태그 하나로 감싸주어야 함</p>
            <p>리렌더링: {props.data}</p>
            <p><input type="button" value="버튼" onClick={props.clickBtn}></input></p>
    </>
    )
}
export default MyComponent;