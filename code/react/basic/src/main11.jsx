import { createRoot } from 'react-dom/client';
import React from 'react';

// main11.jsx
/*
    JSX는 제어문 사용불가
    -> 삼항 연산자 + map() 사용

    조건부 렌더링 방법
    방법 1. 외부에서 if문 쓰기
    방법 2. 내부에서 삼항연산자 쓰기(Ternary, 3진법)
    방법 3. 내부에서 && 연산자 쓰기(단축 평가)


*/

// function User(props) {

//     const isLogin = props.isLogin;

//     if (isLogin) {
//         return (
//             <div>
//                 <h2>환영합니다.</h2>
//                 <p>로그인을 한 사람만 볼 수 있는 화면입니다.</p>
//                 <button>로그아웃</button>
//             </div>
//         );
//     } else {
//         return (
//             <div>
//                 <h2>로그인이 필요합니다.</h2>
//                 <p>서비스를 이용하려면 로그인하세요.</p>
//                 <button>로그인</button>
//             </div>
//         );
//     }
// }

// function My() {

//     return (
//         <>
//             <h2>조건부 렌더링 <small>if문</small></h2>

//             <User isLogin={false} />

//         </>
//     );

// }

//삼항 연산자
// function User(props) {

//     const isLogin = props.isLogin;

//     // return (
//     //     <>
//     //         {isLogin ? <div>참</div> : <div>거짓</div>}
//     //     </>
//     // );

//     return (

//         <>
//             <h2>조건부 렌더링 <small>if문</small></h2>

//             <User isLogin={false} />

//         </>
//     );
// }

// && 연산자 (단축 평가)
// function test() {
//     let n = 10;

//     // console.log('n이 0보다 크다') 얘가 false라서
//     // 참이라고 출력이 된건데
//     // console.log('n이 0보다 크다') 얘가 왜 실행이 안되고
//     // false라고 판단이 된건가
//     // 이게 단축평가라고 해서 왼쪽이 true면 그냥 오른쪽거는 실행안함
//     // 이걸로 성능이 좀 더 좋아짐
//     // 값이 null인가? -> 조건부 렌더링 -> 값 null, undefined, 0, 등.. Truty, Falsy
//     // 값이 존재하면 우측 항 실행
//     // 조건이 참이면 우측 항 반환
//     // 조건이 거짓이면 아무것도 출력 안함

//     if (n > 0 || console.log('n이 0보다 크다')) {
//         console.log('참');
//     }
// }

// 값의 null 유무에 따른 조건부 렌더링
// function Result(props) {
//     return (
//         <>
//             {/* <div>저는 {props.name}입니다.</div> */}
//             {/* {props.name != null ? <div>저는 {props.name}입니다.</div>: ''} */}
//             {props.name && <div>저는 {props.name}입니다.</div>}
//         </>
//     );
// }

// function My() {

//     return (
//         <>
//             <h2>조건부 렌더링 <small>if문</small></h2>

//             <Result name="홍길동" />
//             <Result name="아무개" />
//             <Result />

//         </>
//     );

// }

function UserProfile(props) {
    return (
        <>
            <h3>회원 정보</h3>
            <p>이름: {props.name}</p>

            {props.email &&
                <p>이메일: {props.email}</p>
            }

            {   props.isAuthenticated &&
                <button>회원 페이지 이동하기</button>

            }
        </>
    );
}

function My() {

    return (
        <>
            <h2>조건부 렌더링</h2>
            <UserProfile name="홍길동" email="hong@gmail.com" isAuthenticated={true} />

            <hr />

            <UserProfile name="아무개" isAuthenticated={false} />
        </>
    );

}

createRoot(document.getElementById('root')).render(<My />);