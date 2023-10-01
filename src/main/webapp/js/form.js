

function formSubmit(event) {
    event.preventDefault();

    const x = getX();
    const y = getY();
    const r = getR();

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