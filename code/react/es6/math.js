// math.js

// 내보내려는 대상 앞에 export라는걸 붙여야 함
// export const PI = 3.14;

// module 에서 할 수 있는 여러 가지 작업들
/*
    내보내기 방식
    - named export
        1. 직접 내보내기
        2. 한번에 여러개 내보내기
    
    - default export
        1. 기본 내보내기


*/

// 1. 직접 내보내기
// - 선언하면서 동시에 내보내기
// - 내보내는 이름으로 불러들이기를 한다
// PI라는 이름으로 내보냈기 때문에
// PI라는 이름으로 불러들였다
// const PI = 3.14;
// export {PI};

// 2. 한번에 여러개 내보내기
// const a = 10;
// const b = 20;
// export {a, b};

// 기본 내보내기
// const PI = 3.14;
// export {PI};
// default가 붙은 애는 하나만 존재할 수 있음
// export default PI;

// 모듈을 만들어서 내보내기를 가장 많이 하는건 함수
const sum = (a, b) => {
    return a + b;
};

// export {sum};

const substract = (a, b) => {
    return a - b;
};

const multiple = (a, b) => {

    return a * b;
}

// export {substract, sum};
export default sum;
export {substract, multiple};