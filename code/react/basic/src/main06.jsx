import { createRoot } from 'react-dom/client';
import React from 'react';

// main06.jsx
// 상황: gender를 남자 여자로 바꾸고 싶음
// JSX 내의 제어문
// JSX 영역 내에서는 if문 for문 을 쓸 수 없다

// 해결 방안
// 방법 1. 외부에서 미리 해결하기
// 방법 2. JSX 영역 내에서 직접 조건 처리를 할 수 있음
// <- if문 못쓴다며? 삼항 연산자는 쓸 수 있음
// 그래서 리액트할때 삼항 연산자를 많이 씀, if문을 못써서

// function My() {

//     const dog = {

//         name: '강아지',
//         age: 2,
//         gender: 'm'

//     };

//     let gender;

//     if (dog.gender === 'm') {
//         gender = '남자';
//     } else {
//         gender = '여자';
//     }

//     return (
//         <>
//             <h2>JSX 제어문</h2>
//             <ul>
//                 <li>{dog.name}</li>
//                 <li>{dog.age}</li>
//                 <li>{dog.gender}</li>
//                 <li>{dog.gender==='m' ? gender ='남자' : '여자'}</li>
//             </ul>
//         </>
//     )
// }

// JSX 내에서는 for문도 못쓴다
// 해결 방안 1. 외부에서 미리 작업
// 해결 방안 2. JSX 내부에서 map(요소를 특정 변환값으로 리턴해줌)을 사용함

// function My() {

//     // 배열 하나 만들기
//     const list = ['엄준식', '호날두', '메시', '손흥민', '김연아', '아이유'];

//     // let content =[];

//     // for (name of list) {
//     //     content.push(<li>{name}</li>);
//     // }

//     return (

//         <>
//             <h2>반복문</h2>
//             <ul>
//                 {
//                     list.map((item, index) => 
//                         <li key={index}>{item}</li>)
//                 }
//             </ul>
//         </>

//     );

// }

function My() {

    // 배열 하나 만들기
    const list = [
        {
            seq: 1,
            name: '엄준식'

        },
        {
            seq: 2,
            name: '호날두'

        },
        {
            seq: 3,
            name: '메시'

        }


    ];

    return (

        <>
            <h2>반복문</h2>
            <ul>
                {
                    list.map((item, index) =>
                        <li key={item.seq}>{item.name}</li>)
                }
            </ul>
        </>

    );

}

createRoot(document.getElementById('root')).render(<My />);