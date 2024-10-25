import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

const Product = () => {
    //useParam(): Path Params을 추출하는 방법, 넘겨진 파라미너명들을 Key, 
    //그 자리에 위치한 값을 value로 가지는 객체

    //const params = useParams();
    //console.log(params.prodnum);

    const {prodnum} = useParams();
    console.log(prodnum);

    const [product,setProduct] = useState(null);

    useEffect(()=>{
        const products = [
            {
                prodnum:1,
                prodname:"연필",
                prodprice:1000
            },
            {
                prodnum:2,
                prodname:"지우개",
                prodprice:2000
            },
            {
                prodnum:3,
                prodname:"볼펜",
                prodprice:3000
            }
        ]
        // 백에서는 데이터 가져오니, 지금만 사용
        for(let item of products){
            if(item.prodnum == prodnum){
                setProduct(item);
                break;
            }
        }
    },[])

    if(product == null){
        return <>잘못된 상품 번호입니다.</>
    }
    else{
        return (
            <>
                상품번호 : {product.prodnum}<br/>
                상품명 : {product.prodname}<br/>
                상품가격 : {product.prodprice}<br/>
            </>
        )
    }
}
export default Product;