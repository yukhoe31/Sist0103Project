let irum ="홍길동";
let birth = 1988;
let likefood = '삼겹살';

let curYear = new Date().getFullYear(); //숫자 4자리 반환

//예전 출력 방식
let result = "이름: " + irum +"\n태어난 년도: " +birth+ "\n나이: " +(curYear-birth) +"\n좋아하는 음식: " +likefood;

console.log(result);

//리터럴 방식의 출력..중간변수$
//`` : 백틱(backtick)
let result2 = `이름:${irum}
태어난 연도: ${birth}
나이: ${curYear-birth}
좋아하는 음식: ${likefood}`;

console.log(result2);


