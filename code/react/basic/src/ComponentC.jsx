// ComponentC.jsx

// 현재 컴포넌트에만 적용할 전용 외부 CSS 파일을 만들자
// = 격리를 할 수 있는 CSS 파일을 만들자
// ComponentC.module.css 를 만들자

// import './ComponentC.module.css'; <- 이렇게 하면 안됨
// 순수하게 외부 파일로서 가져온 것

import styles from './ComponentC.module.css';

function ComponentC() {

    return (
        <>
            <h3 className={styles.mainTitle}>ComponentC</h3>
            <div className={styles.mainContent}>C 컴포넌트입니다.</div>
        </>
    );

}

export default ComponentC;