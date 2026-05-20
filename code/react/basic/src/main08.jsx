import { createRoot } from 'react-dom/client';
import React from 'react';

// main08.jsx
// React 할 때 제일 중요한 것?
// 1. 컴포넌트 + JSX
// 2. props

/* 
    main08.jsx
    - props

    Props
    - Properties
    - 부모 컴포넌트가 자식 컴포넌트에게 전달하는 데이터를 뜻함
    - 매개변수 역할
    - 컴포넌트 태그의 속성 형태로 전달됨
    - Props는 읽기 전용(Immutable): 자식 컴포넌트는 부모 컴포넌트가 
    전달한 props 값을 직접 수정할 수 없다.
    자식이 엄준식 호날두 할 수 없음
    - 항상 단방향 전달이다. 항상 부모 -> 자식 방향이다.

*/

// function Student(props) {
//     return (

//         <div>저는 {props.name}입니다. {props.age} {props.color}/</div>

//     );

// }

// // Student 컴포넌트의 부모 컴포넌트
// // 재사용 하려고 컴포넌트 쓰는거
// function My() {
//     return (
//         <>
//             <Student />
//             <Student name ="엄준식" age="20" color="검정" />
//             <Student name ="호날두" age="42" color="빨강" />
//         </>
//     )
// }

// function Student(props) {
//     return (
//         <div>저는 {props.name}입니다. {props.age}, {props.color}</div>
//     );
// }

// function My() {

//     //데이터셋
//     const list = [
//         { seq: 1, name: '강아지', age: 3, color: '검정'},
//         { seq: 2, name: '고양이', age: 2, color: '하양'},
//         { seq: 3, name: '거북이', age: 100, color: '노랑'}
//     ];

//     return (
//         <>
//             {
//                 list.map(item => <Student name={item.name} age={item.age} color={item.color} />)
//             }
        
//         </>

//     )

// }

// 구조분해 할당으로 props 받기
// function Student({ name, age, color }) {
//     return (
//         <div>저는 {name}입니다. {age}, {color}</div>
//     );
// }

// function My() {

//     //데이터셋
//     const list = [
//         { seq: 1, name: '강아지', age: 3, color: '검정'},
//         { seq: 2, name: '고양이', age: 2, color: '하양'},
//         { seq: 3, name: '거북이', age: 100, color: '노랑'}
//     ];

//     return (
//         <>
//             {
//                 list.map(item => <Student key={item.key} name={item.name} age={item.age} color={item.color} />)
//             }
        
//         </>

//     )

// }

// function Student(props) {
//     return (
//         <div>저는 {props.name}입니다. {props.age}, {props.color}</div>
//     );
// }

// function My() {

//    const hong = {
//     name: '홍길동',
//     age: 20,
//     color: '파랑'
//    };

//    return (

//         <>
//             {/* 방법 1. 개별 속성 전달(가장 명시적) */}
//             {/* <Student name={hong.name} age={hong.age} color={hong.color} /> */}

//             {/* 방법 2. Spread Operator 사용(가장 권장 + 필드가 여러개일때) */}
//             {/* <Student {...hong} /> */}

//             {/* 방법 3. 객체 자체를 전달 */}
//             <Student info={hong} />

//         </>
//    );

// }

// 일부 속성만 props로 받기
// function Student(props) {
//     return (
//         <div>저는 {props.name}입니다.</div>
//     );
// }

// function My() {

//     const hong = {
//         name: '홍길동',
//         age: 20,
//         color: '파랑'
//     };
    
//     return (
//         <>
//             <Student name={hong.name} />
//         </>
//     );
// }

// 일부 속성만 props로 받기
// function Student({name}) {
//     return (
//         <div>저는 {name}입니다.</div>
//     );
// }

// function Student(props) {
    
//     const {name} = props;
    
//     return (
//         <div>저는 {name}입니다.</div>
//     );
// }

// function My() {

//     const hong = {
//         name: '홍길동',
//         age: 20,
//         color: '파랑'
//     };
    
//     return (
//         <>
//             <Student name={hong.name} />
//         </>
//     );
// }

//기본값
function Student({name, age = 30, color = '주황'}) {

    return (
        <>
            <div>저는 {name}입니다.</div>
            <div>나이는 {age}세</div>
            <div>색상은 {color}</div>
        </>
    );
}

function My() {

    const hong = {
        name: '홍길동',
        age: 20,
        color: '파랑'
    };
    
    return (
        <>
            <Student {...hong} />
            <Student name="호호호" />
        </>
    );
}

createRoot(document.getElementById('root')).render(<My />);