import { createRoot } from 'react-dom/client';
import React from 'react';
import List from './List';

// main07.jsx
// 컴포넌트

// 리액트 컴포넌트
// 데이터와 화면을 묶어 놓은 단위
// 화면의 일부분을 구성하는 독립적이고 재사용이 가능한 UI 조각
// 1파일 = 1컴포넌트이다?
// 컴포넌트화 시키는지를 계속 확인해야한다

// 대문자로 만드는 것 유의
// List.jsx
// item.jsx


createRoot(document.getElementById('root')).render(<List />);