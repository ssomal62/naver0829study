//map 반복문. 리액트는 for문을 사용할 수 없음.
//배열 중 일부 항목만을 추출할 때 : slice, filter 사용

let array =  ['red', 'green', 'blue', 'pink', 'orange', 'gray'];

array.map((color, idx) => console.log(idx + ":" + color));

//배열의 데이터 잘라내기, 걸러내기
//blue를 삭제 후 다시 출력

// array=[
//     ...array.slice(0, 2),  /*0~1번을 잘라내기 : red, green*/
//     ...array.slice(3, array.length) /* 3부터 length-1까지 잘라내기*/
//       ];
// array.map((color, idx) => console.log(idx + ":" + color));

console.log("................................");

let array2 = array.filter((color, idx)=> idx !== 2);
array2.map((color, idx)=> console.log(idx + ":" + color))