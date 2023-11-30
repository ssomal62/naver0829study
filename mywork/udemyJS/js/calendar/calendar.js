const CURRENT_YEAR   = new Date().getFullYear();
const CURRENT_MONTH  = new Date().getMonth() + 1;
const CURRENT_DATE   = new Date().getDate();
const DAY_OF_WEEK      = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'];
const MONTH_HEADER_NAME= ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];

const getYear  = document.getElementById('setYear');
const getMonth = document.getElementById('setMonth');
const prevMonth= document.getElementById('prevMonth');
const nextMonth= document.getElementById('nextMonth');
const ifUserSetDate = document.getElementById('areaUserSetDate');
const errYearCaption = document.getElementById('captionYear');
const errMonthCaption= document.getElementById('captionMonth');

let date= 0;
let outputCalendar= '';
let isErrDateForm = false;
let holidayConfirmationForYear = CURRENT_YEAR;

const publicHoliday = [
  //  {name : "공휴일", date : 1017},
    {id : "신정", name : "신정",  date : '0101', position : "none",},
    {id : "3.1절",name : "3.1절", date : '0301', position : "none"},
    {id : "얼인날",name : "어린이날", date : '0505', position : "none"},
    {id : "현충일",name : "현충일", date : '0606', position : "none"},
    {id : "광복절",name : "광복절", date : '0815', position : "none"},
    {id : "개천절",name : "개천절", date : '1003', position : "none"},
    {id : "한글날",name : "한글날", date : '1009', position : "none"},
    {id : "성탄절",name : "성탄절", date : '1225', position : "none"}
];

const lunarHoliday = [
    {id : "석탄일", name : "석가탄신일", date : '0408', position : "none"},
    {id : "",    name : "추석", date : '0814', position : "fist"},
    {id : "추석", name : "추석", date : '0815', position : "mid"},
    {id : "",    name : "추석", date : '0816', position : "last"}
];

const resetHolidayAsYearChange = () => { //입력폼의 연도가 바뀌면 음력 휴일을 갱신한다.
    if (holidayConfirmationForYear !== getYear.value){
        removeLunar();
        changeLunarToSolar();
        holidayConfirmationForYear = getYear.value;
    }
}

const removeLunar = () => {
    for (let i = publicHoliday.length-1 ; i >= 0  ; i--){
        if(publicHoliday[i].name === "추석" || publicHoliday[i].name === "석가탄신일"){
            publicHoliday.splice(i,1);
        }
    }
}

const changeLunarToSolar = () => {
    for (let i = 0; i < lunarHoliday.length; i++){
        let newHoilday;

        if(Number(lunarHoliday[i].date) === 1230){
            newHoilday = {
                id : lunarHoliday[i].id,
                name : lunarHoliday[i].name,
                date: Resut(getYear.value + 1 + lunarHoliday[i].date),
                position : lunarHoliday[i].position};
        }else{
            newHoilday = {id : lunarHoliday[i].id,
                name : lunarHoliday[i].name,
                date: Resut(getYear.value + lunarHoliday[i].date),
                position : lunarHoliday[i].position};
        }
        publicHoliday.push(newHoilday);
    }
}

const moveMonth = (way) => {
    if(isErrDateForm === true){
        getYear.value = CURRENT_YEAR;
        getMonth.value = CURRENT_MONTH;
        isErrDateForm = !isErrDateForm;
    }

    if(way === nextMonth && Number(getMonth.value) === 12){
        getYear.value++;
        getMonth.value = 1;
    } else if (way === nextMonth){
        getMonth.value++;
    } else if(way === prevMonth && Number(getMonth.value) === 1){
        getYear.value--;
        getMonth.value = 12;
    } else if (way === prevMonth){
        getMonth.value--;
    }

    checkErrorDate(getYear.value, getMonth.value);
}

const checkErrorDate = (year, month) => {
    const yearRange     = (1841 < year) && (year < 2043) ? 'in' : 'out';
    const monthRange    = (1 <= month) && (month <= 12) ? 'in' : 'out';

    let errMessage = "* 눈을 들어 BOX를 보라";
    let errOutline = "2px solid #f06e50";

    if (yearRange === 'in' && monthRange === 'in') {
        setDateErrorNotice("", "", "0", "0");
        resetHolidayAsYearChange(year);
        generateCalenderTable(year, month)
    } else if (yearRange === 'out' && monthRange === 'out') {
        setDateErrorNotice(errMessage, errMessage, errOutline, errOutline);
        isErrDateForm = true;
    } else if (yearRange === 'in' && monthRange === 'out') {
        setDateErrorNotice("", errMessage, "0", errOutline);
        isErrDateForm = true;
    } else {
        setDateErrorNotice(errMessage, "", errOutline, "0");
        isErrDateForm = true;
    }
}

const setDateErrorNotice = (e1_Message1, e2_Message2, e1_Outline1, e2_Outline2) => {
    errYearCaption.innerText  = e1_Message1;
    errMonthCaption.innerText = e2_Message2;
    getYear.style.outline  = e1_Outline1;
    getMonth.style.outline = e2_Outline2;
};

const showMonthName = (month) => {
    const header = document.getElementById('header');
    header.innerText = MONTH_HEADER_NAME[month - 1].toUpperCase();
}

const createDayOfWeek = () => {
    const thead = document.querySelector('thead');
    let outputCalendar= '';

    Array.from(DAY_OF_WEEK).forEach(day => outputCalendar += `<th>${day}</th>`);
    thead.innerHTML = outputCalendar;
}

const checkHoliday = (month) => {

    const checkNumberOfMonth = parseInt(month) < 10 ?  ('0' + month) : month;
    const checkNumberOfDate = parseInt(date) < 10 ?  ('0' + date) : date;

    const combineDate = checkNumberOfMonth + checkNumberOfDate;

    //foundHoliday ? 는 foundHoliday의 값이 [false, 0, undefined, 빈문자열]이 아니면 [true]반환 (값이 있으면 true 반환)
    const foundHoliday = Array.from(publicHoliday).find(hoilyDay => hoilyDay.date === combineDate);
    return foundHoliday ? foundHoliday.id : null;
}

const checkToday  = (year, month) => {
    return  Number(year + month + date) === Number(CURRENT_YEAR + "" +  CURRENT_MONTH + "" + CURRENT_DATE) ? 'y' : 'n';
}

const createTd = (year, month, col) => {
    if (checkToday(year,month) === 'y' && (checkHoliday(month) !== null)) {
        outputCalendar += `<td class="containDate row${col % 7} todayHoliday">${date}<div class="holidayCaption">${checkHoliday(month)}</div></td>`;
    } else if (checkToday(year,month) === 'y') {
        outputCalendar += `<td class="containDate row${col % 7} today">${date}<div class="todayCaption">today</div></td>`;
    } else if (checkHoliday(month) !== null) {
        outputCalendar += `<td class="containDate row${col % 7} holiday" >${date}<div class="holidayCaption">${checkHoliday(month)}</div></td>`;
    } else {
        outputCalendar += `<td class="containDate row${col % 7}">${date}</td>`;
    }
    date++;
}

const generateCalenderTable = (year, month) => {

    const lastDate  = new Date(year, month, 0).getDate();
    const firstDate   = new Date(year, month - 1, 1);
    const tbody = document.querySelector('tbody');
    const maxIndex = lastDate + (6 - new Date(year, month - 1, lastDate).getDay()) + firstDate.getDay();

    let isPossibleDateInput= false;

    showMonthName(month);

    outputCalendar = '';
    date = 1;

    for (let col = 1; col <= maxIndex; col++) {

        if (col % 7 === 1) {
            outputCalendar += '<tr>';
        }

        if (isPossibleDateInput) {
            createTd(year, month, col);
        } else if (Math.floor((col - 1) / 7) === 0 && firstDate.getDay() === (col - 1) % 7) {
            createTd(year, month, col);
            isPossibleDateInput = !isPossibleDateInput;
        } else {
            outputCalendar += '<td></td>';
        }

        if (date - 1 === lastDate) {
            date = 0;
            isPossibleDateInput = !isPossibleDateInput;
        }

        if (col % 7 === 0) {
            outputCalendar += '</tr>';
        }
    }
    tbody.innerHTML = outputCalendar;
}

window.addEventListener('load',  ()  => {

    createDayOfWeek();

    getYear.value  = CURRENT_YEAR;
    getMonth.value = CURRENT_MONTH;

    generateCalenderTable(getYear.value, getMonth.value);

    changeLunarToSolar();

    ifUserSetDate.addEventListener('change', () =>  checkErrorDate(getYear.value, getMonth.value));

    prevMonth.addEventListener('click', moveMonth.bind(this,prevMonth));
    nextMonth.addEventListener('click', moveMonth.bind(this,nextMonth));

});


//////아래는 음력을 구하는 라이브러리

function f_Number(str) {
    for (i=0; i< str.length; i++) {
        ch = str.charAt(i);
        if (ch < "0" || ch > "9") {
            return false;
        }
    }
    return true;
}
function Resut(lunaDate) {

    // 음력 데이터 (평달 - 작은달 :1,  큰달:2 )
    // (윤달이 있는 달 - 평달이 작고 윤달도 작으면 :3 , 평달이 작고 윤달이 크면 : 4)
    // (윤달이 있는 달 - 평달이 크고 윤달이 작으면 :5,  평달과 윤달이 모두 크면 : 6)
    var kk = [[1, 2, 4, 1, 1, 2, 1, 2, 1, 2, 2, 1],   /* 1841 */
        [2, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2, 1],
        [2, 2, 2, 1, 2, 1, 4, 1, 2, 1, 2, 1],
        [2, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2],
        [1, 2, 1, 2, 2, 1, 2, 1, 2, 1, 2, 1],
        [2, 1, 2, 1, 5, 2, 1, 2, 2, 1, 2, 1],
        [2, 1, 1, 2, 1, 2, 1, 2, 2, 2, 1, 2],
        [1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 2, 1],
        [2, 1, 2, 3, 2, 1, 2, 1, 2, 1, 2, 2],
        [2, 1, 2, 1, 1, 2, 1, 1, 2, 2, 1, 2],
        [2, 2, 1, 2, 1, 1, 2, 1, 2, 1, 5, 2],   /* 1851 */
        [2, 1, 2, 2, 1, 1, 2, 1, 2, 1, 1, 2],
        [2, 1, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2],
        [1, 2, 1, 2, 1, 2, 5, 2, 1, 2, 1, 2],
        [1, 1, 2, 1, 2, 2, 1, 2, 2, 1, 2, 1],
        [2, 1, 1, 2, 1, 2, 1, 2, 2, 2, 1, 2],
        [1, 2, 1, 1, 5, 2, 1, 2, 1, 2, 2, 2],
        [1, 2, 1, 1, 2, 1, 1, 2, 2, 1, 2, 2],
        [2, 1, 2, 1, 1, 2, 1, 1, 2, 1, 2, 2],
        [2, 1, 6, 1, 1, 2, 1, 1, 2, 1, 2, 2],
        [1, 2, 2, 1, 2, 1, 2, 1, 2, 1, 1, 2],   /* 1861 */
        [2, 1, 2, 1, 2, 2, 1, 2, 2, 3, 1, 2],
        [1, 2, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2],
        [1, 1, 2, 1, 2, 1, 2, 2, 1, 2, 2, 1],
        [2, 1, 1, 2, 4, 1, 2, 2, 1, 2, 2, 1],
        [2, 1, 1, 2, 1, 1, 2, 2, 1, 2, 2, 2],
        [1, 2, 1, 1, 2, 1, 1, 2, 1, 2, 2, 2],
        [1, 2, 2, 3, 2, 1, 1, 2, 1, 2, 2, 1],
        [2, 2, 2, 1, 1, 2, 1, 1, 2, 1, 2, 1],
        [2, 2, 2, 1, 2, 1, 2, 1, 1, 5, 2, 1],
        [2, 2, 1, 2, 2, 1, 2, 1, 2, 1, 1, 2],   /* 1871 */
        [1, 2, 1, 2, 2, 1, 2, 1, 2, 2, 1, 2],
        [1, 1, 2, 1, 2, 4, 2, 1, 2, 2, 1, 2],
        [1, 1, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1],
        [2, 1, 1, 2, 1, 1, 2, 1, 2, 2, 2, 1],
        [2, 2, 1, 1, 5, 1, 2, 1, 2, 2, 1, 2],
        [2, 2, 1, 1, 2, 1, 1, 2, 1, 2, 1, 2],
        [2, 2, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1],
        [2, 2, 4, 2, 1, 2, 1, 1, 2, 1, 2, 1],
        [2, 1, 2, 2, 1, 2, 2, 1, 2, 1, 1, 2],
        [1, 2, 1, 2, 1, 2, 5, 2, 2, 1, 2, 1],   /* 1881 */
        [1, 2, 1, 2, 1, 2, 1, 2, 2, 1, 2, 2],
        [1, 1, 2, 1, 1, 2, 1, 2, 2, 2, 1, 2],
        [2, 1, 1, 2, 3, 2, 1, 2, 2, 1, 2, 2],
        [2, 1, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2],
        [2, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2],
        [2, 2, 1, 5, 2, 1, 1, 2, 1, 2, 1, 2],
        [2, 1, 2, 2, 1, 2, 1, 1, 2, 1, 2, 1],
        [2, 1, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2],
        [1, 5, 2, 1, 2, 2, 1, 2, 1, 2, 1, 2],
        [1, 2, 1, 2, 1, 2, 1, 2, 2, 1, 2, 2],   /* 1891 */
        [1, 1, 2, 1, 1, 5, 2, 2, 1, 2, 2, 2],
        [1, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 2],
        [1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2],
        [2, 1, 2, 1, 5, 1, 2, 1, 2, 1, 2, 1],
        [2, 2, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2],
        [1, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1],
        [2, 1, 5, 2, 2, 1, 2, 1, 2, 1, 2, 1],
        [2, 1, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2],
        [1, 2, 1, 1, 2, 1, 2, 5, 2, 2, 1, 2],
        [1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 2, 1],   /* 1901 */
        [2, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 2],
        [1, 2, 1, 2, 3, 2, 1, 1, 2, 2, 1, 2],
        [2, 2, 1, 2, 1, 1, 2, 1, 1, 2, 2, 1],
        [2, 2, 1, 2, 2, 1, 1, 2, 1, 2, 1, 2],
        [1, 2, 2, 4, 1, 2, 1, 2, 1, 2, 1, 2],
        [1, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 1],
        [2, 1, 1, 2, 2, 1, 2, 1, 2, 2, 1, 2],
        [1, 5, 1, 2, 1, 2, 1, 2, 2, 2, 1, 2],
        [1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 2, 1],
        [2, 1, 2, 1, 1, 5, 1, 2, 2, 1, 2, 2],   /* 1911 */
        [2, 1, 2, 1, 1, 2, 1, 1, 2, 2, 1, 2],
        [2, 2, 1, 2, 1, 1, 2, 1, 1, 2, 1, 2],
        [2, 2, 1, 2, 5, 1, 2, 1, 2, 1, 1, 2],
        [2, 1, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2],
        [1, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 1],
        [2, 3, 2, 1, 2, 2, 1, 2, 2, 1, 2, 1],
        [2, 1, 1, 2, 1, 2, 1, 2, 2, 2, 1, 2],
        [1, 2, 1, 1, 2, 1, 5, 2, 2, 1, 2, 2],
        [1, 2, 1, 1, 2, 1, 1, 2, 2, 1, 2, 2],
        [2, 1, 2, 1, 1, 2, 1, 1, 2, 1, 2, 2],   /* 1921 */
        [2, 1, 2, 2, 3, 2, 1, 1, 2, 1, 2, 2],
        [1, 2, 2, 1, 2, 1, 2, 1, 2, 1, 1, 2],
        [2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 1, 1],
        [2, 1, 2, 5, 2, 1, 2, 2, 1, 2, 1, 2],
        [1, 1, 2, 1, 2, 1, 2, 2, 1, 2, 2, 1],
        [2, 1, 1, 2, 1, 2, 1, 2, 2, 1, 2, 2],
        [1, 5, 1, 2, 1, 1, 2, 2, 1, 2, 2, 2],
        [1, 2, 1, 1, 2, 1, 1, 2, 1, 2, 2, 2],
        [1, 2, 2, 1, 1, 5, 1, 2, 1, 2, 2, 1],
        [2, 2, 2, 1, 1, 2, 1, 1, 2, 1, 2, 1],   /* 1931 */
        [2, 2, 2, 1, 2, 1, 2, 1, 1, 2, 1, 2],
        [1, 2, 2, 1, 6, 1, 2, 1, 2, 1, 1, 2],
        [1, 2, 1, 2, 2, 1, 2, 2, 1, 2, 1, 2],
        [1, 1, 2, 1, 2, 1, 2, 2, 1, 2, 2, 1],
        [2, 1, 4, 1, 2, 1, 2, 1, 2, 2, 2, 1],
        [2, 1, 1, 2, 1, 1, 2, 1, 2, 2, 2, 1],
        [2, 2, 1, 1, 2, 1, 4, 1, 2, 2, 1, 2],
        [2, 2, 1, 1, 2, 1, 1, 2, 1, 2, 1, 2],
        [2, 2, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1],
        [2, 2, 1, 2, 2, 4, 1, 1, 2, 1, 2, 1],   /* 1941 */
        [2, 1, 2, 2, 1, 2, 2, 1, 2, 1, 1, 2],
        [1, 2, 1, 2, 1, 2, 2, 1, 2, 2, 1, 2],
        [1, 1, 2, 4, 1, 2, 1, 2, 2, 1, 2, 2],
        [1, 1, 2, 1, 1, 2, 1, 2, 2, 2, 1, 2],
        [2, 1, 1, 2, 1, 1, 2, 1, 2, 2, 1, 2],
        [2, 5, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2],
        [2, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2],
        [2, 2, 1, 2, 1, 2, 3, 2, 1, 2, 1, 2],
        [2, 1, 2, 2, 1, 2, 1, 1, 2, 1, 2, 1],
        [2, 1, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2],   /* 1951 */
        [1, 2, 1, 2, 4, 2, 1, 2, 1, 2, 1, 2],
        [1, 2, 1, 1, 2, 2, 1, 2, 2, 1, 2, 2],
        [1, 1, 2, 1, 1, 2, 1, 2, 2, 1, 2, 2],
        [2, 1, 4, 1, 1, 2, 1, 2, 1, 2, 2, 2],
        [1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2],
        [2, 1, 2, 1, 2, 1, 1, 5, 2, 1, 2, 2],
        [1, 2, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2],
        [1, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1],
        [2, 1, 2, 1, 2, 5, 2, 1, 2, 1, 2, 1],
        [2, 1, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2],   /* 1961 */
        [1, 2, 1, 1, 2, 1, 2, 2, 1, 2, 2, 1],
        [2, 1, 2, 3, 2, 1, 2, 1, 2, 2, 2, 1],
        [2, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 2],
        [1, 2, 1, 2, 1, 1, 2, 1, 1, 2, 2, 1],
        [2, 2, 5, 2, 1, 1, 2, 1, 1, 2, 2, 1],
        [2, 2, 1, 2, 2, 1, 1, 2, 1, 2, 1, 2],
        [1, 2, 2, 1, 2, 1, 5, 2, 1, 2, 1, 2],
        [1, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 1],
        [2, 1, 1, 2, 2, 1, 2, 1, 2, 2, 1, 2],
        [1, 2, 1, 1, 5, 2, 1, 2, 2, 2, 1, 2],   /* 1971 */
        [1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 2, 1],
        [2, 1, 2, 1, 1, 2, 1, 1, 2, 2, 2, 1],
        [2, 2, 1, 5, 1, 2, 1, 1, 2, 2, 1, 2],
        [2, 2, 1, 2, 1, 1, 2, 1, 1, 2, 1, 2],
        [2, 2, 1, 2, 1, 2, 1, 5, 2, 1, 1, 2],
        [2, 1, 2, 2, 1, 2, 1, 2, 1, 2, 1, 1],
        [2, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 1],
        [2, 1, 1, 2, 1, 6, 1, 2, 2, 1, 2, 1],
        [2, 1, 1, 2, 1, 2, 1, 2, 2, 1, 2, 2],
        [1, 2, 1, 1, 2, 1, 1, 2, 2, 1, 2, 2],   /* 1981 */
        [2, 1, 2, 3, 2, 1, 1, 2, 2, 1, 2, 2],
        [2, 1, 2, 1, 1, 2, 1, 1, 2, 1, 2, 2],
        [2, 1, 2, 2, 1, 1, 2, 1, 1, 5, 2, 2],
        [1, 2, 2, 1, 2, 1, 2, 1, 1, 2, 1, 2],
        [1, 2, 2, 1, 2, 2, 1, 2, 1, 2, 1, 1],
        [2, 1, 2, 2, 1, 5, 2, 2, 1, 2, 1, 2],
        [1, 1, 2, 1, 2, 1, 2, 2, 1, 2, 2, 1],
        [2, 1, 1, 2, 1, 2, 1, 2, 2, 1, 2, 2],
        [1, 2, 1, 1, 5, 1, 2, 1, 2, 2, 2, 2],
        [1, 2, 1, 1, 2, 1, 1, 2, 1, 2, 2, 2],   /* 1991 */
        [1, 2, 2, 1, 1, 2, 1, 1, 2, 1, 2, 2],
        [1, 2, 5, 2, 1, 2, 1, 1, 2, 1, 2, 1],
        [2, 2, 2, 1, 2, 1, 2, 1, 1, 2, 1, 2],
        [1, 2, 2, 1, 2, 2, 1, 5, 2, 1, 1, 2],
        [1, 2, 1, 2, 2, 1, 2, 1, 2, 2, 1, 2],
        [1, 1, 2, 1, 2, 1, 2, 2, 1, 2, 2, 1],
        [2, 1, 1, 2, 3, 2, 2, 1, 2, 2, 2, 1],
        [2, 1, 1, 2, 1, 1, 2, 1, 2, 2, 2, 1],
        [2, 2, 1, 1, 2, 1, 1, 2, 1, 2, 2, 1],
        [2, 2, 2, 3, 2, 1, 1, 2, 1, 2, 1, 2],   /* 2001 */
        [2, 2, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1],
        [2, 2, 1, 2, 2, 1, 2, 1, 1, 2, 1, 2],
        [1, 5, 2, 2, 1, 2, 1, 2, 2, 1, 1, 2],
        [1, 2, 1, 2, 1, 2, 2, 1, 2, 2, 1, 2],
        [1, 1, 2, 1, 2, 1, 5, 2, 2, 1, 2, 2],
        [1, 1, 2, 1, 1, 2, 1, 2, 2, 2, 1, 2],
        [2, 1, 1, 2, 1, 1, 2, 1, 2, 2, 1, 2],
        [2, 2, 1, 1, 5, 1, 2, 1, 2, 1, 2, 2],
        [2, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2],
        [2, 1, 2, 2, 1, 2, 1, 1, 2, 1, 2, 1],   /* 2011 */
        [2, 1, 6, 2, 1, 2, 1, 1, 2, 1, 2, 1],
        [2, 1, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2],
        [1, 2, 1, 2, 1, 2, 1, 2, 5, 2, 1, 2],
        [1, 2, 1, 1, 2, 1, 2, 2, 2, 1, 2, 2],
        [1, 1, 2, 1, 1, 2, 1, 2, 2, 1, 2, 2],
        [2, 1, 1, 2, 3, 2, 1, 2, 1, 2, 2, 2],
        [1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2],
        [2, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 2],
        [2, 1, 2, 5, 2, 1, 1, 2, 1, 2, 1, 2],
        [1, 2, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1],   /* 2021 */
        [2, 1, 2, 1, 2, 2, 1, 2, 1, 2, 1, 2],
        [1, 5, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2],
        [1, 2, 1, 1, 2, 1, 2, 2, 1, 2, 2, 1],
        [2, 1, 2, 1, 1, 5, 2, 1, 2, 2, 2, 1],
        [2, 1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 2],
        [1, 2, 1, 2, 1, 1, 2, 1, 1, 2, 2, 2],
        [1, 2, 2, 1, 5, 1, 2, 1, 1, 2, 2, 1],
        [2, 2, 1, 2, 2, 1, 1, 2, 1, 1, 2, 2],
        [1, 2, 1, 2, 2, 1, 2, 1, 2, 1, 2, 1],
        [2, 1, 5, 2, 1, 2, 2, 1, 2, 1, 2, 1],   /* 2031 */
        [2, 1, 1, 2, 1, 2, 2, 1, 2, 2, 1, 2],
        [1, 2, 1, 1, 2, 1, 5, 2, 2, 2, 1, 2],
        [1, 2, 1, 1, 2, 1, 2, 1, 2, 2, 2, 1],
        [2, 1, 2, 1, 1, 2, 1, 1, 2, 2, 1, 2],
        [2, 2, 1, 2, 1, 4, 1, 1, 2, 1, 2, 2],
        [2, 2, 1, 2, 1, 1, 2, 1, 1, 2, 1, 2],
        [2, 2, 1, 2, 1, 2, 1, 2, 1, 1, 2, 1],
        [2, 2, 1, 2, 5, 2, 1, 2, 1, 2, 1, 1],
        [2, 1, 2, 2, 1, 2, 2, 1, 2, 1, 2, 1],
        [2, 1, 1, 2, 1, 2, 2, 1, 2, 2, 1, 2],   /* 2041 */
        [1, 5, 1, 2, 1, 2, 1, 2, 2, 2, 1, 2],
        [1, 2, 1, 1, 2, 1, 1, 2, 2, 1, 2, 2]];

    var input_day = lunaDate;
    var gan = ["甲","乙","丙","丁","戊","己","庚","辛","壬","癸"];
    var jee = ["子","丑","寅","卯","辰","巳","午","未","申","酉","戌","亥"];
    var ddi = ["쥐","소","범","토끼","용","뱀","말","양","원숭이","닭","개","돼지"];
    var week = ["일","월","화","수","목","금","토"];

    var md = [31,0,31,30,31,30,31,31,30,31,30,31];

    var year =input_day.substring(0,4);
    var month =input_day.substring(4,6);
    var day =input_day.substring(6,8);
    // 음력에서 양력으로 변환
    var lyear, lmonth, lday, leapyes;
    var syear, smonth, sday;
    var mm, y1, y2, m1;
    var i, j, k1, k2, leap, w;
    var td, y;
    lyear = get_year(year);        // 년도 check
    lmonth = get_month(month);     // 월 check

    y1 = lyear - 1841;
    m1 = lmonth - 1;
    leapyes = 0;
    if (kk[y1][m1] > 2)  {
        /*if (document.frmTest.yoon[0].checked) {
                 leapyes = 1;
                 switch (kk[y1][m1]) {
                             case 3:
                             case 5:
                                     mm = 29;
                                     break;
                             case 4:
                             case 6:
                                     mm = 30;
                                     break;
                  }
        }
        else {*/
        switch (kk[y1][m1]) {
            case 1:
            case 3:
            case 4:
                mm = 29;
                break;
            case 2:
            case 5:
            case 6:
                mm = 30;
                break;
        }
        // }
    }

    lday = get_day(day, mm);

    td = 0;
    for (i=0; i<y1; i++) {
        for (j=0; j<12; j++) {
            switch (kk[i][j]) {
                case 1:
                    td = td + 29;
                    break;
                case 2:
                    td = td + 30;
                    break;
                case 3:
                    td = td + 58;    // 29+29
                    break;
                case 4:
                    td = td + 59;    // 29+30
                    break;
                case 5:
                    td = td + 59;    // 30+29
                    break;
                case 6:
                    td = td + 60;    // 30+30
                    break;
            }
        }
    }
    for (j=0; j<m1; j++) {
        switch (kk[y1][j]) {
            case 1:
                td = td + 29;
                break;
            case 2:
                td = td + 30;
                break;
            case 3:
                td = td + 58;    // 29+29
                break;
            case 4:
                td = td + 59;    // 29+30
                break;
            case 5:
                td = td + 59;    // 30+29
                break;
            case 6:
                td = td + 60;    // 30+30
                break;
        }
    }
    if (leapyes == 1) {
        switch(kk[y1][m1]) {
            case 3:
            case 4:
                td = td + 29;
                break;
            case 5:
            case 6:
                td = td + 30;
                break;
        }
    }
    td =  td + parseFloat(lday) + 22;
    // td : 1841 년 1 월 1 일 부터 원하는 날짜까지의 전체 날수의 합
    y1 = 1840;
    do {
        y1 = y1 +1;
        if  ((y1 % 400 == 0) || ((y1 % 100 != 0) && (y1 % 4 == 0))) {
            y2 = 366;
        }
        else {
            y2 = 365;
        }
        if (td <= y2) {
            break;
        }
        else {
            td = td- y2;
        }
    } while(1);
    syear = y1;
    md[1] = parseInt(y2) -337;
    m1 = 0;
    do {
        m1= m1 + 1;
        if (td <= md[m1-1]) {
            break;
        }
        else {
            td = td - md[m1-1];
        }
    } while(1);
    smonth = parseInt(m1);
    sday = parseInt(td);
    y = parseInt(syear -1);
    td = y * 365 + y/4 - y/100 +  y/400;
    for ( i=0; i<smonth-1; i++) {
        td = td + md[i];
    }
    // td = make_data(td) + sday;
    w = td % 7;
    // i = (td + 4) % 10;
    // j = (td + 2) % 12;
    k1 = (parseInt(lyear) + 6) % 10;
    k2 =(parseInt(lyear) + 8) % 12;
    /*         document.write("<br><br><center>");
             document.write("음력 ",gan[k1],jee[k2],"년 ",ddi[k2],"띠해 ",lyear," 년 ",lmonth," 월 ",lday," 일 ","(",gan[i],jee[j],")","<br>");
             document.write("양력 ",syear," 년 ",smonth," 월 ",sday," 일 ",week[w],"요일");
             document.write("<br><br><a href='#' onclick='history.go(-1);'>돌아 가기</a>");*/
    if(smonth < 10){
        smonth = "0"+smonth;
    }
    if(sday < 10){
        sday = "0"+sday;
    }
    //console.log(lunaDate+" => 양력 휴일 변환: "+smonth+"월"+sday+"일");
    return smonth+""+sday;
}
function get_year(src) {
    if ((src < 1841) || (src > 2043 )) {
        //alert('연도 범위는 1841 ~ 2043 까지입니다.');
        //document.frmTest.input_day.focus();
    }
    else
        return src;
}
function get_month(src) {
    if ((src < 1) || (src > 12 )) {
        alert('월 범위는 1 ~ 12 까지입니다.');
        document.frmTest.input_day.focus();
    }
    else
        return src;
}
function get_day(src,day) {
    if ((src < 1) || (src > day )) {
        alert('일 범위가 틀립니다.');
        document.frmTest.input_day.focus();
    }
    else
        return src;
}
function febdays(src) {
    if ((src%4 !=0) || ((src%100 == 0) && (src%400 !=0))) {
        return 28;          // 윤년이 아님
    }
}

