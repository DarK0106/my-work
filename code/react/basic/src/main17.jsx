import React from 'react';
import { createRoot } from 'react-dom/client';
import { useState } from 'react'
import { BrowserRouter, Routes, Route, Link, NavLink, useParams } from 'react-router-dom';

// main17.jsx

/*
    React Router
    - 리액트 앱에서 라우팅 기능을 제공하는 라이브러리
    - 리액트 SPA이다.
        - 페이지 개념이 없다
        - 사용자 입장에서는 페이지가 있는게 자연스러움
        - 그래서 가상으로 페이지가 있는 것 처럼 보이게 만든다
        - 그게 라우팅이다

    전통적인 방식(JSP, Spring)
    URL이 바뀌면 서버에게 새 페이지를 요청해 브라우저에 새 HTML을 로딩함

    React Router 방식
    - 페이지가 1장인데 URL은 바꿀 수 있음, 페이지가 1장이라 서버에 요청 안 함
    - 요청을 안 하는 대신 내부 컴포넌트를 바꿔서 페이지가 바뀌는 느낌이 들지 않음
    - 새로고침 없음

    외부 라이브러리라서 설치 필요
    - npm install react-router-dom

    라우트 관련 컴포넌트
    1. <BrowserRouther>
    - 라우팅 시스템의 전체 툴

    2. <Routes>
    - <Route> 의 부모 컨테이너
    - 여러 경로들을 모아놓은 리스트

    3. <Route>
    - 특정 경로(path, URL)와 컴포넌트를 연결(매핑)

    4. <link>
    - 클릭 시 페이지를 이동하는 역할(새로고침 아님)
    - 컴포넌트 교체
    - <a>: 의 역할을 함(<a href> 의 래핑 객체임)

*/

// 이제부터 페이지를 여러개 만드는 작업을 해보자

/*

기본 라우팅 

[URL/Path]  [이전 방식]   [리액트 라우팅]
/           index.jsp     Home 컴포넌트
/about      about.jsp     About 컴포넌트
/contact    contact.jsp   Contact 컴포넌트

*/

function Home() {

    return (
        <>
            <h3>Home Page</h3>
            <p>시작 페이지입니다.</p>
        </>
    );
}

function About() {

    return (
        <>
            <h3>About Page</h3>
            <p>소개 페이지입니다.</p>
        </>
    );
}

function Contact() {

    return (
        <>
            <h3>Contact Page</h3>
            <p>문의 페이지입니다.</p>
        </>
    );
}

//설명만
// function App() {

//     return (
//         <>
//             <h2>사이트</h2>
//             3가지 페이지 중 1개만 보여주기
//         </>
//     );
// }

// 기본 라우팅 + 404 처리
// path="*" <- 작성해둔 모든 경로와 매칭이 안되면 *를 실행함
// Fallback Route 라고 부름
function NotFound() {

    return (
        <>
            <h3>404 Not Found</h3>
            <p>잘못된 요청입니다.</p>
        </>
    );
}

// function App() {

//     return (
//         <BrowserRouter>
//         <h2>쌍용 사이트</h2>

//         {/* 

//             <Link> 컴포넌트의 역할
//             리액트에게 특정 path를 전달하면서 전달된 path와 
//             매핑되어있는 컴포넌트를 화면에 렌더링하라고 시키는 역할 

//             링크를 클릭하면 물리적인 페이지는 변경이 없음
//             브라우저 주소창의 주소는 변경됨, 이게 History API 기능인데
//             그걸 리액트가 건드려서 쓰는 것


//         */}
//         <nav>

//             <Link to="/">Home</Link>&nbsp;|&nbsp;
//             {/* 404 체크용 */}
//             {/* <Link to="/about2">About</Link>&nbsp;|&nbsp; */}
//             <Link to="/about">About</Link>&nbsp;|&nbsp;
//             <Link to="/contact">Contact</Link>
//         </nav>

//         <hr />

//         {/* Route 1개당 웹페이지 1개라고 생각하면 편함 */}
//         <Routes>
//             <Route path= "/" element={<Home />} />
//             <Route path= "/about" element={<About />} />
//             <Route path= "/contact" element={<Contact />} />
//             <Route path= "*" element={<NotFound />} />


//         </Routes>
//         </BrowserRouter>
//     );
// }

// <Link> vs <NavLink>
function App() {

    const activeStlye = {
        color: 'tomato',
        fontWeight: 'bold'
    };

    return (
        <BrowserRouter>
            <h2>쌍용 사이트</h2>

            <nav>

                {/* <Link to="/">Home</Link>&nbsp;|&nbsp; */}
                <NavLink to="/" style={({ isActive }) => isActive ? activeStlye : undefined}>Home</NavLink>&nbsp;|&nbsp;
                {/* <Link to="/about">About</Link>&nbsp;|&nbsp; */}
                <NavLink to="/about" style={({ isActive }) => isActive ? activeStlye : undefined}>About</NavLink>&nbsp;|&nbsp;
                {/* <Link to="/contact">Contact</Link> */}
                <NavLink to="/contact" style={({ isActive }) => isActive ? activeStlye : undefined}>Contact</NavLink>&nbsp;|&nbsp;
            </nav>

            <hr />

            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/about" element={<About />} />
                <Route path="/contact" element={<Contact />} />
                <Route path="*" element={<NotFound />} />


            </Routes>
        </BrowserRouter>
    );
}

// URL 파라미터
// - /users?seq=1
// - /users/1
// - /users/2
// - /users/3

function Base() {

    return (
        <>
            <h3>유저 목록</h3>
            <ul>
                {/* <li><Link to="/user/1">1번 회원</Link></li>
                <li><Link to="/user/2">2번 회원</Link></li>
                <li><Link to="/user/3">3번 회원</Link></li> */}
                <li><Link to="/user/홍길동">1번 회원</Link></li>
                <li><Link to="/user/손흥민">2번 회원</Link></li>
                <li><Link to="/user/엄준식">3번 회원</Link></li>
            </ul>
        </>
    );

}

function User() {

    const { id, name } = useParams();

    // 일반적인 상황에선
    // 1. id만 넘기고
    // 2. id를 통해 ajax(fetch) 사용해서 DB 요청
    // 3. 나머지 정보도 가져와서 출력

    return (
        <>
            <h3>유저 정보</h3>
            <p>회원 번호: {id}</p>
            <p>회원 이름: {name}</p>
        </>
    );
}

function App2() {
    return (

        <BrowserRouter>
            <h2>React Router <small>URL Parameter</small></h2>
            <nav>
                <Link to="/">Home</Link>
            </nav>

            <hr />
            <Routes>
                {/* 목록보기 */}
                <Route path='/' element={<Base />} />
                {/* 상세보기 */}
                <Route path='/user/:id' element={<User />} />
            </Routes>
        </BrowserRouter>

    );
}

createRoot(document.getElementById('root')).render(<App2 />);
