import { useState, useEffect } from 'react';
import { BrowserRouter, Route, Routes, Link, useLocation } from 'react-router-dom';
import Home from './Home';
import Member from './Member';
import Board from './Board';
import BoardList from './BoardList';
import BoardView from './BoardView';
import BoardAdd from './BoardAdd';
import BoardDel from './BoardDel';
import Login from './Login';
import Logout from './Logout';

/*

    지금 sts에서 project-server 
    프로젝트에서 작업한 페이지랑 
    vscode에서 project-client에서 
    작업한 페이지가 
    서로 다른 페이지임 그래서
    둘이 이어줘야 함

*/


function App() {

    // 최상위 컴포넌트에서 현재 사용자의 로그인 여부를 판단
    // true면 인증사용자, false면 익명사용자
    const [isAuth, setIsAuth] = useState(null);
    // null을 넣은건 인증인지 익명인지 아직 검사하지 않았다는 것

    const location = useLocation();

    const navStyle = {
        display: 'flex',
        justifyContent: 'flex-end',
        gap: '.5rem',
        marginBottom: '1rem'
    };

    useEffect(() => {

        // effect가 호출되면
        // 서버에게 요청해서
        // 현재 이 사람이
        // 인증 사용자인지
        // 익명 사용자인지
        // 알려달라는 요청을 하는 것
        let flag = true;

        const checkAuth = async () => {
            const response = await fetch('http://localhost:8080/member', {
                method: 'GET',
                credentials: 'include'
            });

            if (response.ok) {
                //인증 사용자
                const data = await response.json();  // 인증 성공일 때만 파싱
                if (flag) {
                    setIsAuth(true);
                }
            } else {
                //익명 사용자
                if (flag) {
                    setIsAuth(false);
                }
            }
        };

        checkAuth();

        // cleanup: 컴포넌트가 사라지거나 effect가 다시 돌면
        // 이전 요청 결과로 state를 바꾸지 않도록 막음
        return () => {
            flag = false;
        };

    }, [location.pathname]);


    return (
        <>
            <h1>Project <small>Spring Boot + React</small></h1>

            {/* 메뉴 */}
            <nav style={navStyle}>
                <Link to="/">[Home]</Link>

                {isAuth === true && <Link to="/member">[Member]</Link>}

                <Link to="/board">[Board]</Link>
                
                {isAuth === false && <Link to="/login">[Login]</Link>}
                
                {isAuth === true && <Link to="/logout">[Logout]</Link>}
            </nav>

            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/member" element={<Member />} />
                <Route path="/board" element={<Board />}>
                    <Route path="list" element={<BoardList />} />
                    <Route path="add" element={<BoardAdd />} />
                    <Route path="view/:seq" element={<BoardView />} />
                    <Route path="del/:seq" element={<BoardDel />} />
                </Route>
                <Route path="/login" element={<Login />} />
                <Route path="/logout" element={<Logout />} />

            </Routes>
        </>
    );
}

export default App;