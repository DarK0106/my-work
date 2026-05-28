import React, { useEffect } from 'react';
import { createRoot } from 'react-dom/client';
import { useState } from 'react';
import { StrictMode } from 'react';

// main22.jsx
/*
    useEffect + cleanup
    - effect가 다시 실행 전 or 컴포넌트가 사라질 때 실행
    - 컴포넌트 + useEffect -> 이 작업이 중첩되면 안되는 작업 종종 있음
                           -> 통제하기 위한 수단이 cleanup
    - effect: 작업 시작
    - cleanup: 작업 정리

    useEffect(() => {
        // 렌더링마다 실행할 작업 하고

        return () => {
            // 이쪽에 cleanup
            // cleanup은 객체가 소멸될 때 실행

        };
    }, []);
*/
// function App() {

//     useEffect(() => {
//         console.log('effect 실행');

//         return () => {
//             console.log('cleanup 실행');
//         };
//     }, []);

//     return (
//         <>
//             <h2>Hooks <small>useEffect</small></h2>
//             <div>Hello</div>
//         </>
//     );
// }

function App() {

    const [count, setCount] = useState(0);

    useEffect(() => {

        console.log('effect 발생');

        const id = setInterval(() => {
            console.log('1초마다 실행');
        }, 1000);

        return () => {
            console.log('cleanup 발생');
            clearInterval(id);
        };

    }, [count]);

    return (
        <>
            <h2>Cleanup</h2>
            <div>타이머 테스트</div>
            <div>카운트: {count}</div>
            <button onClick={() => setCount(count + 1)}>증가</button>
        </>
    );
}


// StrictMode 는 개발할때만 사용
// 일단 렌더링 한 번 한거고, StrictMode 때문에
// cleanup이 실행되고, 다시 렌더링 한 번 더 한거
createRoot(document.getElementById('root')).render(<StrictMode><App
/></StrictMode>);