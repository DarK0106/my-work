import React from 'react';
import { createRoot } from 'react-dom/client';
import { useState } from 'react';

// main14.jsx
// 1. <input>
// 2. <textarea>
// 3. <select>
// 컨트롤 1개당 state 1개 <- 기본
// state를 Setter를 통해서만 바꿨을 때 화면 갱신이 발생

// function My() {

//     const [content, setContent] = useState('');

//     function handleChange(e) {
//         setContent(e.target.value);
//     }

//     function send(e) {
//         e.preventDefault();
//         alert(content);
//     }

//     return (
//         <>
//             <h2>제어 컴포넌트 <small>textarea</small></h2>  

//             <form onSubmit={send}>
//                 <textarea 
//                     value={content}
//                     onChange={handleChange}
//                     ></textarea>
//                 <br />
//                 <button>제출하기</button>
//             </form>

//             <hr />

//             <h3>현재 state 값</h3>
//             <p>{content}</p>

//         </>
//     );
// }

// function My() {

//     const [content, setContent] = useState('blue');

//     function handleChange(e) {
//         setContent(e.target.value);
//     }

//     function send(e) {
//         e.preventDefault();
//         alert(content);
//     }

//     return (
//         <>
//             <h2>제어 컴포넌트 <small>textarea</small></h2>  

//             <form onSubmit={send}>
//                 <select value={content} onChange={handleChange}>
//                     <option value="red">빨강</option>
//                     <option value="yello">노랑</option>
//                     <option value="blue">파랑</option>
//                     <option value="green">초록</option>
//                     <option value="black">검정</option>
//                 </select>
//                 <br />
//                 <button>제출하기</button>
//             </form>

//             <hr />

//             <h3>현재 state 값</h3>
//             <p>{content}</p>

//         </>
//     );
// }

// <input> + <textarea> + <select>
// 1 컨트롤(<input>, <textarea>, <select>, ..) 당
// 1 state
// function My() {

//     const [name, setName] = useState('Cristiano Ronaldo');
//     const [intro, setIntro] = useState('안녕하세요 호날두입니다. SIUUUUUUUUUUUUUUUU');
//     const [gender, setGender] = useState('f');

//     function handleNameChange(e) {
//         setName(e.target.value);
//     }
//     function handleIntroChange(e) {
//         setIntro(e.target.value);
//     }
//     function handleGenderChange(e) {
//         setGender(e.target.value);
//     }

//     return (

//         <>
//             <h2>폼</h2>
//             <form>
//                 <div>
//                     <label>이름: </label>
//                     <input
//                         type='text'
//                         value={name}
//                         onChange={handleNameChange}

//                     />
//                 </div>
//                 <div>
//                     <label>자기소개: </label>
//                     <textarea
//                         value={intro}
//                         onChange={handleIntroChange}
//                     ></textarea>
//                 </div>
//                 <div>
//                     <label>성별: </label>
//                     <select value={gender} onChange={handleGenderChange}>
//                         <option value="m">남자</option>
//                         <option value="f">여자</option>
//                     </select>
//                 </div>

//             </form>
//         </>
//     )

// }

function My() {

    // form 은 {name: '',intro: '',gender: ''}
    // 을 담고 있는 변수인데 우리가 state라고 부르는것
    const [form, setForm] = useState({

        name: '',
        intro: '',
        gender: ''

    });

    function handleChange(e) {
        const key = e.target.name;
        const value = e.target.value;

        alert(key);
        alert(value);

        // state는 개발자가 직접 수정하면 안된다
        // 반드시 Setter를 써서 바꿔야
        // 화면이 다시 렌더링됨
        // form.name = value;
        // form.intro = value;
        // form.gender = value;

        // setForm({
        //     name: '바뀐이름',
        //     intro: '원래소개',
        //     gender: '원래성별'

        // });

        // prevForm: 수정된 전 상태의 state 값
        setForm(prevForm => ({

            // name: '원래이름',
            // intro: '원래소개',
            // gender: '원래성별'
            // 위에 이렇게 쓰는거랑
            ...prevForm,
            // 이거랑 같음

            // 저 셋 중에 뭘 수정했는지를 모름
            // intro: '바뀐소개'
            // 근데 위처럼 쓰면 intro는 그냥 문자열임
            // 그래서 [intro] 이렇게 쓰면 됨
            [intro]: '바뀐소개'

        }));
    }

    return (

        <>
            <h2>폼</h2>
            <form>
                <div>
                    <label>이름: </label>
                    <input
                        type='text'
                        name='name'
                        value={form.name}
                        onChange={handleChange}

                    />
                </div>
                <div>
                    <label>자기소개: </label>
                    <textarea
                        value={form.intro}
                        name='intro'
                        onChange={handleChange}
                    ></textarea>
                </div>
                <div>
                    <label>성별: </label>
                    <select value={form.gender} onChange={handleChange} name='gender'>
                        <option value="m">남자</option>
                        <option value="f">여자</option>
                    </select>
                </div>

            </form>
        </>
    )

}

createRoot(document.getElementById('root')).render(<My />);