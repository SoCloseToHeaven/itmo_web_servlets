const Y_LOWER_BOUND = -5;
const Y_UPPER_BOUND = 5;
const FLOAT_FIVE_DECIMALS_REGEX = /^[+-]?\d+(\.\d{1,5})?$/;


const warningLabel = document.getElementById("y-warning-label");
const sendButton = document.getElementById("send-form")
const Y_WARNING_TEXT = `X value must be a float number between: ${Y_LOWER_BOUND} 
                    and ${Y_UPPER_BOUND} (inclusive, ${ROUNDING_ACCURACY} decimals places of number)`

async function formSubmit(event) {
    event.preventDefault();

    const x = getX();
    const y = getY();
    const r = getR();

    const url = new URL("./check-hit-controller", window.location.href);
    const params = `x=${x}&y=${y}&r=${r}`;
    url.search = new URLSearchParams(params).toString();

    await fetch(url, {
        method: "POST"
    }).then(resp => {
            if (resp.ok) {
                return resp.json();
            }
            throw new Error(resp.statusText);
        }
    ).then(resp => {
        POINTS.push(resp);
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
function getR() {
    const checkedR = document.querySelector(
        'input[name="r"]:checked');
    return Number.parseFloat(checkedR.value);
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

async function clear() {
    if (!confirm("Are you sure?"))
        return;
    await fetch("./clear-controller", {
        method: "POST"
    }).then(resp => {
        if (!resp.ok)
            throw new Error();
    }).then(resp => {
        POINTS.splice(0, POINTS.length);
    }).catch(err => console.log(err));
}

validateY();