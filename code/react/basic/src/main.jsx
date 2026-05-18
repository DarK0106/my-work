import { StrictMode } from 'react';
import { createRoot } from 'react-dom/client';
import React from 'react';

/*
  JSX, JavaScript XML
  - React 로 HTML 을 작성하는 기술
  - JavaScript 코드 영역 내에서
  HTML을 직접 쓰는 느낌이 들게 한다(실제로는 아님)

  JSX를 쓰는 이유
  1. 컴포넌트 재사용
  2. JavaScript 텍스트 보간법 지원
  3. 자동 XSS 방어, 자동 이스케이프
  4. 컴파일 시 타입 오류 체크 가능
  5. 함수형 프로그래밍 방식 지원

*/

// 1. JSX를 사용하지 않고 React 페이지 구현해보자

// 리액트 엘리먼트, React Element
// - 리액트 환경에서의 태그 역할
// 렌더링 과정을 거치면 나중에 HTML 태그로 바뀐다
// const app = React.createElement('h1', {}, 'Hello JSX!!');

// createRoot(document.getElementById('root')).render(app);

// 2. JSX를 사용해서 구현
// <h1>Hello JSX ??</h1>: 이 구문은 HTML 처럼 보여도 HTML이 아니고
// 리액트가 JavaScript 영역에서 HTML 을 손쉽게 생성하기 위해서
// 만든 리액트 자체 표현식
// JSX를 사용하는 이유: 리액트 엘리먼트를 생성하는
// 리액트만의 표현식
// JSX는 XML 문법을 기반으로 구현되어 HTML보다 엄격하다

// const app = React.createElement('h1', {}, 'Hello JSX!!'); 랑 똑같음
const app = <h1>Hello JSX ??</h1>;