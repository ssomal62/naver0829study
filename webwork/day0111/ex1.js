// 화살표 함수

//테스트 1
function hello1() {
    console.log("hello1 호출 - 기본 함수");
}

let hello2 = () => console.log("hello2 호출 - 화살표 함수");

//함수 호출
hello1();
hello2();

//테스트2
function sum1(x, y) {
    return x + y;
}

let sum2 = (x, y) => x + y;

console.log(sum1(10, 20));
console.log(sum2(10, 20));