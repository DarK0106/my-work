import { createRoot } from 'react-dom/client';
import React from 'react';

// main04.jsx
// JSX 영역 내에서의 표현식
// - JSX내에서는 {}(표현식)을 사용할 수 있다
// ${값}, th:text="${값}" <- 이거랑 비슷함
// JSX의 강력한 기능 중 하나
// ** {} 영역 내부는 순수한 JavaScript 영역이다. **

function My() {

    const name = '홍길동';
    const age = 23;

    function sum(a, b) {
        return a + b;
    }

    const johnDoe = {

        name: '엄준식',
        age: 42

    };


    return (
        <>
            <h2>JSX</h2>
            <div>제 이름은 홍길동이고, 나이는 23세입니다.</div>
            <div>제 이름은 {name}이고, 나이는 {age*52}세 입니다.</div>
            <div>제 이름은 {johnDoe.name}이고, 나이는 {johnDoe.age}세입니다.</div>
            <div>1 + 1 = {sum(1, 1)}</div>
            {/* <div>함수: { function aaa() {} }</div> */}
            {/* <div>로그: { console.log('react') }</div> */}
        
        </>


    );


}

createRoot(document.getElementById('root')).render(<My />);