import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Logout() {

  const [message, setMessage] = useState('');
  const navigate = useNavigate();

  const send = async () => {
    
    setMessage('');

    try {
      const response = await fetch('http://localhost:8080/logout', {

        method: 'POST',
        credentials: 'include'


      });

      // 성공했는지 실패했는지 확인
      const data = await response.json();

      if (response.ok) {
        navigate('/');
      } else {
        setMessage('서버 접속 실패');

      }


    } catch (error) {
      setMessage('서버 접속 실패');
    }

  }


  return (
    <>
      <h2>로그아웃 페이지</h2>
      <div>
        <button type="button" onClick={send}>
          로그아웃
        </button>
      </div>

      {message && <div>{message}</div>}
    </>
  );
}

export default Logout;