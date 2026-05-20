import { createRoot } from 'react-dom/client';
import React from 'react';
import './index.css';

// main05.jsx
// - JSX 내에서 속성 조작하기
// - JSX에서 HTML 태그는 아닌데 태그 비슷하게 생긴 애들로
// 속성을 조작해보자

// 이벤트도 HTML 입장에서 보면 속성이다
// JSX에서의 이벤트는 기존의 HTML 이벤트 핸들러,
// 즉 onclick, onmousedown을 캐멀 표기법으로 바꾸면 된다

// function m1() {
//     alert('m1입니다 ^^');
// }

// function My() {

//     const a = 'one';
//     const myTitle = 'Cristiano Ronaldo';

//     return (
//         <>
//             <h2>JSX Attribute</h2>
//             <div className={a} title={myTitle}>Content {a}</div>
//             <input type="button" value="버튼" onClick={m1} />
//             {/* 내가 외부에 함수를 만들기 부담스러운 상황 */}
//             {/* 그냥 짧은 기능이라서 */}
//             {/* 익명 함수로 등록을 해야함 */}
//             {/* onClick={alert('m2')} 하면 안 됨 */}
//             {/* 등록을 한게 아니고 호출을 해버린 것이기 때문 */}       
//             {/* 그래서 m2 함수의 반환값이 페이지에 보임 */}       
//             {/* <input type="button" value="버튼" onClick={alert('m2')} /> */}

//             <input type="button" value="버튼" onClick={() => {alert('m2');}} />
//         </>


//     );
// }

// Flag 타입 속성
// function My() {

//     const result = true;

//     return (
//         <>
//             <h2>JSX Attribute</h2>
//             <input type="button" value="버튼"
//                     onClick={() => {alert('m2');}} 
//                     disabled />
//             <input type="button" value="버튼"
//                     onClick={() => {alert('m2');}} 
//                     disabled={false} />
//             <input type="button" value="버튼"
//                     onClick={() => {alert('m2');}} 
//                     disabled={result} />
//         </>
//     );
// }

// style 속성
// 반드시 객체로만 값을 넣을 수 있다
// 일반 속성처럼 문자열로 CSS 작성을 하면 안된다
function My() {

    const myStyle = {

        color: 'crimson',
        fonsSize: '2em',
        'font-weight': 'bold'

    };

    return (
        <>
            <h2>JSX Inline Style</h2>
            <div style={myStyle}>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Sapiente mollitia dolorem corporis, ipsa natus eius eos magni cum dolores quo dolore sint esse! Sed dignissimos et illum sunt reprehenderit numquam?</div>

        </>

    )

}

createRoot(document.getElementById('root')).render(<My />);