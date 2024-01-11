//펼침 연산자


let arr1 = [3,4,5];
let arr2 = [6,7,8];

//arr3에  arr1, arr2를 모두 넣고 싶을 경우

let arr3 = [...arr1, ...arr2, 30, 40];

//갯수 출력
console.log("arr3=" + arr3.length);
console.log(arr3);



let sum1 = (a, b, c)=> a + b + c;
console.log(sum1(3, 5, 7));
// console결과 : 15

console.log(sum1(...arr2));
// console결과 : 21

console.log(sum1(...arr3));
// console결과 : 12  (배열 앞에서 3개만 읽어서 합을 구함)