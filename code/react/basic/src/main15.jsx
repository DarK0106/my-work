import React from 'react';
import { createRoot } from 'react-dom/client';
import { useState } from 'react';

// main15.jsx

/*
    React Form
    - input, textarea, select -> value 와 state를 연결
    - checkbox, radio -> checked와 state를 연결


*/

// function My() {

//     // 초기값은 일단 false
//     const [checked, setChecked] = useState(false);

//     function handleChange(e) {
//         setChecked(e.target.checked);
//     }

//     function send(e) {
//         alert();
//     }

//     return (
//         <>
//             <h2>폼 <small>체크박스</small></h2>
//             <div>

//                 <input
//                     type="checkbox"
//                     checked={checked}
//                     onChange={handleChange}

//                 />
//                 &nbsp;
//                 1억원이 결제됩니다.
//                 <br />
//                 <button disabled={!checked} onClick={send}>동의합니다.</button>
//             </div>
//             <hr />
//             <h3>현재 state 값</h3>
//             {/* 
//                 리액트는 아래의 값을 
//                 화면에 출력하지 않음
//                 - boolean
//                 - null
//                 - undefined
//                 굳이 출력하고 싶다면?
//             */}
//             <p>{checked.toString()}</p>
//             <p>{String(checked)}</p>
//             <p>{checked ? '동의함' : '동의안함'}</p>
//         </>
//     );
// }

//여러개의 체크박스
function My() {

    const [form, setForm] = useState({
        agree: false,
        email: false
    });


    function handleChange(e) {
        const key = e.target.name;
        const checked = e.target.checked;

        setForm(prevForm => ({
            ...prevForm,
            [key]: checked
        }));
    }

    function send(e) {
        alert();
    }

    return (
        <>
            <h2>폼 <small>체크박스</small></h2>
            <div>
                <input
                    type="checkbox"
                    name="agree"
                    checked={form.agree}
                    onChange={handleChange}
                />
                &nbsp;
                약관에 동의합니다.
            </div>
            <div>
                <input
                    type="checkbox"
                    name="email"
                    checked={form.email}
                    onChange={handleChange}
                />
                &nbsp;
                이메일 수신에 동의합니다.
            </div>
            <hr />
            <h3>현재 state값</h3>
            <p>{form.agree ? '약관 동의함' : '약관 동의 안함'}</p>
            <p>{form.email ? '수신 동의함' : '수신 동의 안함'}</p>
        </>
    );
}

createRoot(document.getElementById('root')).render(<My />);