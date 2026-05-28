import React from 'react';
import { createRoot } from 'react-dom/client';
import { useState } from 'react'

//main16.jsx
/*

  React Style
  
  [지역]
  1. 인라인 스타일
    - JSX 태그의 style 속성에 JavaScript 객체를 전달하는 방식
        - <div style={객체}>
        - 객체 = {color:'blue'}
        - <div style={{color:'blue'}}>
    - 간단한 스타일이나 일부 영역에서 간단하게 사용
    - 동적으로 적용

  [전역]
  2. 일반 CSS 파일
    - *.css 파일
    - import를 사용해서 적용

  [전역]
  3. CSS Module

  [확장]
  4. styled-components


*/



/*

  1. 인라인 스타일
  - 대부분의 속성은 속성 = 단일값(예: color:blue) 이었는데
  구조화된 속성(예: const style ={})이 들어감
  - style="color:blue; <- HTML의 일반적인 속성과는 성질이 다르다
  - JSX(자바스크립트 확장 문법)이 style속성같은 구조화된 데이터를 넣기
  최적화되어있음 구조화된 데이터를 자바스크립트 객체로 만듦

*/

// 방법 1. 인라인 스타일
// function App() {

//     const style = {

//         color: 'blue'
//     }

//     return (
//         <>
//             <h2>CSS <small>CSS Module</small></h2>
//             {/* <div style="color:blue;">내용입니다.</div> */}
//             <div style={style}>내용입니다.</div>
//             <div style={{ color: 'red' }}>내용입니다.</div>
//             <div>내용입니다.</div>
//         </>
//     );
// }

// 방법 2. 일반 CSS 파일 import 하기
// import './style1.css';

// function App() {
//     return (
//         <>
//             <h2 className='title'>CSS <small>CSS Module</small></h2>
//             <p className='content'>내용입니다.</p>
//         </>
//     )
// }

// 2. 일반 CSS 파일의 문제점
// - 컴포넌트가 여러개일때
// - ComponentA.jsx
// - ComponentB.jsx
// - App.jsx
// - aaa.css 를 ComponentA.jsx에만 import해서 적용시키고 싶어서 그렇게 했는데
// - 문제가 import도 안한 ComponentB.jsx에도 적용이 됨
// - 외부 *.css는 그 어떤 컴포넌트에 적용하더라고 전역으로 적용된다.
// (모든 컴포넌트에 적용된다.) 이건 리액트 구조(컴포넌트가 여러개 (jsx))가
// 결국 1장의 HTML페이지이기 때문에 발생한 문제이다.(SPA) 
// import ComponentA from './ComponentA';
// import ComponentB from './ComponentB';

// function App() {

//     return (
//         <>
//             <h2>React Style</h2>
//             <ComponentA />
//             <ComponentB />
//         </>
//     );

// }

// Alt + 좌클릭
// Ctrl + D: 내가 만약에 엄준식 이라는 단어를 블럭잡았다면
// Ctrl + D를 누르면 알아서 다른 엄준식을 찾아서 블럭잡아줌
// Alt + C: 대소문자 구분 On / Off

// 3. CSS Module
// ComponentC.jsx
// ComponentD.jsx
// CSS 파일 내에 클래스 선택자만 사용한다.
// import ComponentC from './ComponentC';
// import ComponentD from './ComponentD';

// function App() {

//     return (
//         <>
//             <h2>React CSS</h2>
//             <ComponentC />
//             <ComponentD />
//         </>
//     );

// }

// 방법 4. [확장] styled-components
// React CSS-in-JS 라고도 부름
// 외부 라이브러리라서 설치를 해야함
// npm install styled-components

import styled, { createGlobalStyle } from 'styled-components';
// 특징 1. 변수명이 대문자이다
// styled.h2;가 <h2>를 생각하고 만든것
// `` 안의 내용이 순수 CSS라 인기가 많았다고 함
// 변수명이 컴포넌트 이름이 되기 때문에 대문자로 작성한 것이다
// function Header() {

//   return <h2 style={{color: 'tomato'; fontSize: '3rem'}}></h2>;
// }
// 이거 한거랑 똑같음
// - <h2 style={{color: 'tomato'; fontSize: '3rem'}}></h2>
// 이거 한거랑 똑같음
const Header = styled.h2`
    color: tomato;
    font-size: 3rem;
`;
// function App() {

//     return (
//         <>
//             <h2>CSS-in-JS</h2>
//             <div>Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus neque ipsum voluptatibus unde, voluptatum veritatis corporis quo nisi tempora inventore deserunt repellendus enim accusamus nulla animi eum deleniti fugiat. Mollitia.</div>
//         </>
//     );
// }

const Content = styled.div`
    color: dodgerblue;
    font-size: 16px;
    line-height: 1.5rem;
`;

const Button = styled.button`
    padding: 10px, 20px;
    margin: 10px;
    border: none;
    border-radius: '5px';
    cursor: pointer;

    // 컴포넌트니까 props를 받을 수 있음
    background-color: ${props => props.type === 'primary' ? 'tomato' : 'orange'};
    color: ${props => props.type === 'primary' ? 'white' : 'black'};
`;

// styled 컴포넌트 끼리 상속이 가능하다
const TestButton = styled(Button)`
    box-shadow: 3px 3px 3px gray;

`;

const ToggleButton = styled.button`
  padding: 10px 20px;
  margin: 10px;
  border: none;
  border-radius: '5px';
  cursor: pointer;

  background-color: ${props => props.active ? 'cornflowerblue' : 'gray'};
`;

function App() {

    const [active, setActive] = useState(false);

    function handleClick() {
        setActive(!active);
    }

    return (
        <>
            <Header>CSS-in-JS</Header>
            <Content>Lorem ipsum dolor sit amet consectetur adipisicing elit. Natus neque ipsum voluptatibus unde, voluptatum veritatis corporis quo nisi tempora inventore deserunt repellendus enim accusamus nulla animi eum deleniti fugiat. Mollitia.</Content>
            <hr />
            <Button type='primary'>핵미사일 발사 버튼</Button>
            <Button>변기 물 내리기 버튼</Button>
            <Button>감자튀김 튀기기 버튼</Button>
            <TestButton type='primary'>집으로 가기 버튼</TestButton>
            <TestButton>대나무 헬리콥터 버튼</TestButton>

            <h3>state와 연동한 스타일 컴포넌트</h3>
            <ToggleButton active={active}>
                토글 버튼: {active ? '활성 상태' : '비활성 상태'}
            </ToggleButton>

            <button onClick={handleClick}>상태 변경</button>
        </>
    );
}

createRoot(document.getElementById('root')).render(<App />);