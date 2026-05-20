import React from 'react';
import { createRoot } from 'react-dom/client';
import { useState } from 'react'

// main12.jsx

// 객체 배열 + Primary Key
// DB 데이터 기준으로 만들어라?
// function My() {

//     // 이렇게 하지 말고
//     // const list = ['맑음', '흐림', '비', '우박', '눈'];

//     const list = [

//         {id: 1, state: '맑음'},
//         {id: 2, state: '흐림'},
//         {id: 3, state: '비'},
//         {id: 4, state: '우박'},
//         {id: 5, state: '눈'}
//     ]

//     return (
//         <>
//             <h2>map()</h2>
//             <ul>
//                 {/* 자바스크립트 영역 */}
//                 {
//                     // JSX 영역
//                     // item => 까지 자바스크립트 영역
//                     // <li></li> 이건 JSX 영역
//                     // <li></li> 안에 자바스크립트 영역인 {item}
//                     // 근데 이렇게 하지 말고
//                     // list.map(item => <li>{item}</li>)
//                     list.map((item) => <li key={item.id}>{item.state}</li>)

//                 }

//             </ul>

//         </>
//     );
// }

// props로 전달하는 데이터에는 Key가 자동으로 들어가지 않는다
function Item(props) {

    return (

        <>
            <li>[{props.seq}]{props.name}({props.price.toLocaleString()}원)</li>

        </>
    )

}

function List() {

    const list = [

        { seq: 1, name: '마우스', price: 30000 },
        { seq: 2, name: '키보드', price: 50000 },
        { seq: 3, name: '모니터', price: 100000 }

    ];

    return (
        <>
            <h2>상품 목록</h2>
            <ul>
                {
                    // list.map(product => <Item name={product.name} price={product.price} />)(
                    list.map(product =>
                        <Item
                            key={product.seq}
                            seq={product.seq}
                            name={product.name}
                            price={product.price}
                        />
                    )
                }
            </ul>
        </>
    );

}

createRoot(document.getElementById('root')).render(<List />);