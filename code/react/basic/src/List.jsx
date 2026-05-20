// List.jsx
// 조각 페이지
// Item 컴포넌트의 부모 컴포넌트

import Item from "./Item";

function List() {

    return (
        <>
            <h2>목록</h2>
            <ul>
                <Item />
                <Item />
                <Item />
            </ul>
        </>
    );

}

export default List;