import { createRoot } from 'react-dom/client';
import React from 'react';

//main10.jsx
//- 이벤트 + 이벤트 객체

/*

    React Events
    - React는 HTML과 동일한 이벤트를 제공한다.
    - 이벤트 핸들러 -> 캐멀 표기법 
        ex) onClick={이벤트 콜백 함수}

*/

function m1() {
    alert('클릭1');
}

function m2() {
    alert('클릭2');
}

/*
    리액트 이벤트 함수에서의 이벤트 객체는
    순수 자바스크립트의 이벤트 객체가 아니다
    alert(event.type); 여기서 event 얘 말하는 것
    리액트의 이벤트 객체는 순수 자바스크립트 이벤트 객체의
    래핑 객체이다. 한번 감싼 녀석이란 뜻, 그래서 그냥 똑같은 일을 함
    그래서 리액트의 이벤트 객체를 합성 이벤트(SysntheticEvent)라고 함
    합성 이벤트?
        - 내부 문제점 해결
        - 브라우저 호환성을 유지
        - 브라우저마다 event 객체가 조금씩 다르다.
        - event의 사용법을 통일하고
        - 기존 event 객체와 사용법을 동일하게 구현했다
    
    만에 하나 진짜 순수한 자바스크립트 이벤트 객체가 필요하면
    - event.nativeEvnet: 이녀석이 원래 이벤트 객체
*/
function m3(name, event) {
    alert(name);
    alert(event.type);
}

function My() {
    return (
        <>
            <h2>리액트 이벤트</h2>
            <button onClick={m1}>클릭</button>
            <button onClick={m2}>클릭</button>
            <button onClick={() => alert('클릭3')}>클릭</button>
            <button onClick={() => m3('홍길동', event)}>클릭</button>
        </>
    );
}




createRoot(document.getElementById('root')).render(<My/>);