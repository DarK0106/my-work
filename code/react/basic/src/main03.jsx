import { createRoot } from 'react-dom/client';
import React from 'react';

// main03.jsx
// 리액트 컴포넌트, React Component
// - 클래스 또는 함수의 형태를 가진다
// 컴포넌트는 리액트 엘리먼트를 생성하는 역할
// 컴포넌트는 리액트 엘리먼트(객체)의 클래스 역할
// props를 전달할 수 있다
// 재사용이 가능하다.(import)
// React가 관리한다.

// 리액트 컴포넌트 필수 조건
// 1. 형태
// - 함수형 -> 보편적
// - 클래스명 -> 레거시

// 2. 이름
// 대문자로 시작(파스칼 표기법, 필수)

// 3. 내부 구현
// - JSX(주로 이 방식으로 구현)
// - React.createElement

// const app = (

//     <>
//         <h2>Hello</h2>
//         <p>React</p>
    
//     </>

// );

// 주석?
// React 나 JavaScript 나 똑같지만
// JSX 내부에서의 주석도 알고 있어야 함
// {/* 주석내용 */}
// {// 주석} <- 이렇게 작성하면 에러 발생

// 함수형 컴포넌트
// return 된 리액트 엘리먼트를
// render(여기에 넣고 싶다);
function My() {

    // 여긴 JavaScript 영역임
    // 여기선 {}가 객체 를 뜻함

    // 이곳에서 리액트 엘리먼트 선언(구현)
    return (
    // <>에서 </> 까진 JSX 영역임
    <>  
        // 이렇게 쓰면 이건 주석 아님
        {/* 이렇게 써야 주석임 */}
        <h2>Hello</h2>
        <p>React</p>
    
    </>
    );

}

// 이래도 되긴 하는데 잘못 쓰고 있는 것
// const app = My();

// 이래도 되긴 하는데 잘못 쓰고 있는 것
// const app = <My></My>

// .render(여기에다 넣어버림);
// .render(<My></My>);
// .render(<My />); 이렇게 써도 됨

createRoot(document.getElementById('root')).render(<My />);