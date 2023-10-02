import * as graph from "./drawGraph.js";

const Y_LOWER_BOUND = -5;
const Y_UPPER_BOUND = 5;
const FLOAT_FIVE_DECIMALS_REGEX = /^[+-]?\d+(\.\d{1,5})?$/;


const warningLabel = document.getElementById("y-warning-label");
const sendButton = document.getElementById("send-form")
const Y_WARNING_TEXT = `X value must be a float number between: ${Y_LOWER_BOUND} 
                    and ${Y_UPPER_BOUND} (inclusive, ${ROUNDING_ACCURACY} decimals places of number)`

function formSubmit(event) {
    event.preventDefault();

    const x = getX();
    const y = getY();
    const r = graph.getR();

    const url = new URL("./check-hit-controller", window.location.href);
    const params = `x=${x}&y=${y}&r=${r}`;
    url.search = new URLSearchParams(params).toString();

    fetch(url, {
        method: "POST"
    }).then(resp => {
            if (resp.ok) {
                return resp.json();
            }
            throw new Error(resp.statusText);
        }
    ).then(resp => {
        POINTS.push(resp);
        graph.fillGraph();
    }).catch(err => console.log(err));

}


function getX() {
    const selectedX = document.getElementById("x");
    return Number.parseFloat(selectedX.value);
}

function getY() {
    const typedY = document.getElementById("y");
    return Number.parseFloat(typedY.value);
}

function validateY() {
    const yText = document.getElementById("y").value;
    if (
        !FLOAT_FIVE_DECIMALS_REGEX.test(yText) ||
        parseFloat(yText) < Y_LOWER_BOUND ||
        parseFloat(yText) > Y_UPPER_BOUND
    ) {
        sendButton.disabled = true;
        warningLabel.innerHTML = Y_WARNING_TEXT;
        warningLabel.hidden = false;
        warningLabel.className = "alert alert-warning" // role="alert"
        return;
    }
    sendButton.disabled = false;
    warningLabel.innerHTML = "Correct Y value!";
    warningLabel.className = "alert alert-success";
}

function clear() {
    if (!confirm("Are you sure?"))
        return;
    fetch("./clear-controller", {
        method: "POST"
    }).then(resp => {
        if (!resp.ok)
            throw new Error();
    }).then(resp => {
        POINTS.splice(0, POINTS.length);
        graph.fillGraph();
    }).catch(err => console.log(err));
}


document.getElementById("point-form").addEventListener("submit", event => formSubmit(event));
document.getElementById("clear").addEventListener('click', event => clear());
document.getElementById("y").addEventListener('input', event => validateY());
validateY();