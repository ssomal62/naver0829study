const defaultResult = 0;
let currentResult = defaultResult;
let logEntries = [];

// Gets input from input field
function getUserNumberInput() {
  return parseInt(usrInput.value);
}

// Generates and writes calculation log
function createAndWriteOutput(operator, resultBeforeCalc, calcNumber) {
  const calcDescription = `${resultBeforeCalc} ${operator} ${calcNumber}`;
  outputResult(currentResult, calcDescription); // from vendor file
}

function writeToLog(
  operationIdentifier,
  prevResult,
  operationNumber,
  newResult
) {
  const logEntry = {
    operation: operationIdentifier,
    prevResult: prevResult,
    number: operationNumber,
    result: newResult
  };
  logEntries.push(logEntry);
  console.log(logEntries);
}

function add() {
  const enteredNumber = getUserNumberInput();
  const initialResult = currentResult;

}

function subtract() {
  const enteredNumber = getUserNumberInput();
  const initialResult = currentResult;

}

function multiply() {
  const enteredNumber = getUserNumberInput();
  const initialResult = currentResult;

}

function divide() {
  const enteredNumber = getUserNumberInput();
  const initialResult = currentResult;

}


const combine = (operation) => {
  const enteredNumber = getUserNumberInput();
  const initialResult = currentResult;
  let operator= '';

  if(operation === 'ADD'){
    currentResult += enteredNumber;
    operator = '+';
  } else if (operation === 'SUBTRACT') {
    currentResult -= enteredNumber;
    operator = '-';
  } else if (operation === 'MULTIPLY') {
    currentResult *= enteredNumber;
    operator = '*';
  } else{
    currentResult /= enteredNumber;
    operator = '/';
  }

  createAndWriteOutput(operator, initialResult, enteredNumber);
  writeToLog(operation, initialResult, enteredNumber, currentResult);

};


addBtn.addEventListener('click', combine.bind(this,'ADD'));
subtractBtn.addEventListener('click', combine.bind(this,'SUBTRACT'));
multiplyBtn.addEventListener('click', combine.bind(this,'MULTIPLY'));
divideBtn.addEventListener('click', combine.bind(this,'DIVIDE'));
