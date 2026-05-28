import React, { useEffect } from 'react';
import { createRoot } from 'react-dom/client';
import { useState } from 'react'

//main21.jsx
/*

    useEffect + 의존성 배열
    - useEffect(() => {}, [의존성 배열])
    - [의존성 배열] 역할: 이 배열의 값이 변경할 때만 useEffect를 호출해라
    방법 1. []: 빈 배열 넣기
    방법 2. [값]: 값이 들어간 배열 넣기

*/

//1. 의존성 배열이 없을 때(main20.jsx 동일)
// 그 어떤 state가 변경되도 렌더링이 발생하다 보니
// 항상 useEffect가 호출되어 useEffect가 성능을 너무 저하시킴
// 그래서 조건부 호출로 수정해야 함
// function App() {

//     const [count, setCount] = useState(0);
//     const [text, setText] = useState('');

//     useEffect(() => {
//         console.log('렌더링 발생');
//     });

//     return (
//         <>
//             <h2>Hooks <small>useEffect</small></h2>
//             <div>count: {count}</div>
//             <button onClick={() => setCount(count + 1)}>카운트 증가</button>
//             <hr />
//             <input type="text"
//                 value={text}
//                 onChange={(e) => setText(e.target.value)} />

//         </>
//     );
// }

// 2. 의존성 배열 사용
// []: 빈 배열 넣기
// App() 컴포넌트가 처음 렌더링될때만 실행해라, 
// 그 이후 렌더링에는 실행하지 마라
// 굳이 따지자면 생성자 역할, onload 이벤트 역할과 유사
// 초기 설정 , 최초 데이터 로딩 등에 사용
// 기존의 useEffect는 setinterval, 빈 배열 넣으면 settimeout과 유사?
// function App() {

//     const [count, setCount] = useState(0);
//     const [text, setText] = useState('');

//     useEffect(() => {
//         console.log('렌더링 발생');
//     }, []);

//     return (
//         <>
//             <h2>Hooks <small>useEffect</small></h2>
//             <div>count: {count}</div>
//             <button onClick={() => setCount(count + 1)}>카운트 증가</button>
//             <hr />
//             <input type="text"
//                 value={text}
//                 onChange={(e) => setText(e.target.value)} />

//         </>
//     );
// }


// 의존성 배열 사용
// [값]: 값이 들어간 배열 넣기
// 값이 바뀔 때에만 렌더링을 발생시켜라
// 가장 많이 사용하는, 일반적인 형태
function App() {

    const [count, setCount] = useState(0);
    const [text, setText] = useState('');

    useEffect(() => {
        console.log('렌더링 발생');
    }, [count]);

    return (
        <>
            <h2>Hooks <small>useEffect</small></h2>
            <div>count: {count}</div>
            <button onClick={() => setCount(count + 1)}>카운트 증가</button>
            <hr />
            <input type="text"
                value={text}
                onChange={(e) => setText(e.target.value)} />

        </>
    );
}

createRoot(document.getElementById('root')).render(<App />);