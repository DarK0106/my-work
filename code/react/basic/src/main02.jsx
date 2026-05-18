import { createRoot } from 'react-dom/client';
import React from 'react';

//main02.jsx
//- 한줄 태그 vs 여러줄 태그 작성하기

//1. 한줄 태그
// const app = <h2>Hello JSX</h2>;

// const app = <h2>Hello JSX</h2>
//             <p>안녕하세요.</p>;

//const app = <h2>Hello JSX</h2><p>안녕하세요.</p>;
//*** JSX 식에는 부모 요소가 하나 있어야 합니다.



//2. 여러 줄 태그 작성하기
//- <div></div>: 의도하지 않은 래퍼 <div>

//const app = <div><h2>Hello JSX</h2><p>안녕하세요.</p></div>;
// const app = <div>
//                 <h2>Hello JSX</h2>
//                 <p>안녕하세요.</p>
//             </div>;

//- <></>: Fragment, Short Fragment
//- <React.Fragment>: Explicit Fragment, Named Fragment
//        - 불필요한 루트 태그를 대신하기 위해 사용
// const app = <>
//                 <h2>Hello JSX</h2>
//                 <p>안녕하세요.</p>
//             </>;

// React 공식 문서에서 발췌:
// "JSX elements must be wrapped in a single parent element"

// const app = <React.Fragment>
//                 <h2>Hello JSX</h2>
//                 <p>안녕하세요.</p>
//             </React.Fragment>;

// 에러 발생: wrapper 요소가 없음
// const app =
//     (
//     <h2>Hello JSX</h2>
//     <ul>
//         <li>Item 1</li>
//         <li>Item 2</li>
//         <li>Item 3</li>
//     </ul>
//     );

// 해결 방안 1. <div> 태그로 감싸기, 근데 의도하지 않은 태그임
// const app =
//     (
//     <div>
//     <h2>Hello JSX</h2>
//     <ul>
//         <li>Item 1</li>
//         <li>Item 2</li>
//         <li>Item 3</li>
//     </ul>
//     </div>
//     );

// 해결 방안 2: 짧은 프래그먼트 사용 -> 쓸데없는 div 안 써도 됨
// 대부분 상황에서 추천, react를 import 하지 않아도 사용 가능
// Key 를 지원하지 않아서 loop를 사용할 수 없음, map()에서 사용 불가능
// const app =
//     (
//     <>
//     <h2>Hello JSX</h2>
//     <ul>
//         <li>Item 1</li>
//         <li>Item 2</li>
//         <li>Item 3</li>
//     </ul>
//     </>
//     );

// 해결 방안 3. <React.Fragment> 표현만 명시적으로 바뀐거고
// 2번이랑 똑같음, 하지만 무조건 import를 해야함, 근데 늘 하는 import긴 함
// import React from 'react'; <- 이걸 해야한다는 말
// Key 를 지원해서 loop를 사용할 수 있음, map()에서 사용 가능
// JSX 표현은 root 요소가 유일해야 한다
const app =
    (
    <React.Fragment>
    <h2>Hello JSX</h2>
    <ul>
        <li>Item 1</li>
        <li>Item 2</li>
        <li>Item 3</li>
    </ul>
    </React.Fragment>
    );

createRoot(document.getElementById('root')).render(app);