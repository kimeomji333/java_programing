const Join = ({join,change,list,inputs,addInputRef}) => {
    return (
        <>
            <h2>회원가입</h2>
            <form>
                <p>
                    <input type="text" placeholder="Input Join Id" name="id" onChange={change} value={inputs.id} ref={addInputRef}/>
                </p>
                <p>
                    <input type="password" placeholder="Input Join Pw" name="pw" onChange={change} value={inputs.pw} ref={addInputRef}/>
                </p>
                <p>
                    <input type="text" placeholder="Input Join Name" name="name" onChange={change} value={inputs.name} ref={addInputRef}/>
                </p>
                <p>
                    <input type="button" value="Join!" onClick={join}/>
                </p>
            </form>
            <hr/>
            <ul>
                {
                    //반복문을 돌기 위해서 map 함수 사용
                    list.map((user)=>{
                        return <li key={user.id}>{user.name}({user.id} - {user.pw})</li>
                    })
                }

            </ul>
        </>
    )
}
export default Join;