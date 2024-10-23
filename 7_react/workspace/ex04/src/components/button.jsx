const Button = ({value,onClick,id,className,size}) => {
    return <input type="button" value={value} onClick={onClick} id={id} className={`btn ${className} ${size}-btn`} />
}
export default Button;