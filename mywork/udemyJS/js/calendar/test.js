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

let date= 1;
let outputCalendar= '';

let publicHoliday = [
    //  {name : "공휴일", date : 1017},
    {name : "신정",   date : 11},
    {name : "3.1절", date : 31},
    {name : "얼인날", date : 55},
    {name : "현충일", date : 66},
    {name : "광복절", date : 815},
    {name : "개천절", date : 103},
    {name : "한글날", date : 109},
    {name : "성탄절", date : 1225}
];

const moveMonth = (way) => {

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

    generateCalenderTable(getYear.value, getMonth.value);
}

const checkErrorDate = (year, month) => {

    const errYearCaption = document.getElementById('captionYear');
    const errMonthCaption= document.getElementById('captionMonth');

    const yearRange     = (1900 <= year) && (year <= 2100) ? 'in' : 'out';
    const monthRange    = (1 <= month) && (month <= 12) ? 'in' : 'out';

    let errMessage    = "* 눈을 들어 BOX를 보라";
    let errOutline = "2px solid #f06e50";

    const setError = (e1_Message1, e2_Message2, e1_Outline1, e2_Outline2) => {
        errYearCaption.innerText  = e1_Message1;
        errMonthCaption.innerText = e2_Message2;
        getYear.style.outline  = e1_Outline1;
        getMonth.style.outline = e2_Outline2;
    };

    if (yearRange === 'in' && monthRange === 'in') {
        setError("", "", "0", "0");
        generateCalenderTable(year, month)
    } else if (yearRange === 'out' && monthRange === 'out') {
        setError(errMessage, errMessage, errOutline, errOutline);
    } else if (yearRange === 'in' && monthRange === 'out') {
        setError("", errMessage, "0", errOutline);
    } else {
        setError(errMessage, "", errOutline, "0");
    }
}


const setHerder = (month) => {
    const header = document.getElementById('header');

    header.innerText = MONTH_HEADER_NAME[month - 1].toUpperCase();
}

const setDayOfWeek = () => {
    const thead = document.querySelector('thead');
    let outputCalendar= '';

    Array.from(DAY_OF_WEEK).forEach(day => outputCalendar += `<th>${day}</th>`);
    thead.innerHTML = outputCalendar;
}

const checkHoliday = (month) => {
    const combineDate= Number(month + date);
    //아래 두줄은 챗지피티에 도움을 구함.
    //foundHoliday ? 는 foundHoliday의 값이 [false, 0, undefined, 빈문자열]이 아니면 [true]반환 (값이 있으면 true 반환)
    const foundHoliday = Array.from(publicHoliday).find(hoilyDay => hoilyDay.date === combineDate);
    return foundHoliday ? foundHoliday.name : null;
}

const createTd = (month) => {

    if (checkToday === 'y' && (checkHoliday(month) !== null)) {
        outputCalendar += `<td class="containDate row${col % 7} todayHoliday">${date}<div class="holidayCaption">${checkHoliday(month)}</div></td>`;
    } else if (checkToday === 'y') {
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


    setHerder(month);

    for (let col = 1; col <= maxIndex; col++) {

        const checkToday  = () =>
            Number(year + month + date) === Number(CURRENT_YEAR + "" +  CURRENT_MONTH + "" + CURRENT_DATE) ? 'y' : 'n';

        if (col % 7 === 1) {
            outputCalendar += '<tr>';
        }

        if (isPossibleDateInput) {
            createTd();
        } else if (Math.floor((col - 1) / 7) === 0 && firstDate.getDay() === (col - 1) % 7) {
            createTd();
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

    setDayOfWeek();

    getYear.value  = CURRENT_YEAR;
    getMonth.value = CURRENT_MONTH;

    generateCalenderTable(getYear.value, getMonth.value);

    ifUserSetDate.addEventListener('change', () =>  checkErrorDate(getYear.value, getMonth.value));

    prevMonth.addEventListener('click', moveMonth.bind(this,prevMonth));
    nextMonth.addEventListener('click', moveMonth.bind(this,nextMonth));

});
