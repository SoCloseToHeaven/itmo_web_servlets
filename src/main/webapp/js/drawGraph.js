const canvas = document.getElementById("graph-canvas")
const ctx = canvas.getContext("2d")

const width = 300
const height = 300


const labels = ["-R", "-R/2", "0", "R/2", "R"];
const FIGURE_COLOR  = "#9f40de";
const POINTER_COLOR = "#0f4213";
const POINT_RADIUS  = 4;
function fillGraph() {
    ctx.save();
    ctx.font = "13px sans-serif";
    ctx.fillStyle = 'white';
    ctx.fillRect(0, 0, width, height);


    ctx.fillStyle = FIGURE_COLOR;
    // Second sector
    ctx.beginPath();

    ctx.moveTo(width / 6, height / 2);
    ctx.lineTo(width / 2, height / 6);
    ctx.lineTo(width / 2, height / 2);
    ctx.fill();
    // Third sector
    ctx.beginPath();
    ctx.moveTo(width / 2, height / 2);
    ctx.arc(width / 2, height / 2, width / 6,Math.PI / 2, Math.PI);
    ctx.fill()
    // Fourth sector
    ctx.beginPath();
    ctx.moveTo(width / 2, height / 2);
    ctx.lineTo(width / 2, height / 6 * 5);
    ctx.lineTo(width / 6 * 4, height / 6 * 5);
    ctx.lineTo(width / 6 * 4, height / 2);
    ctx.fill();

    ctx.fillStyle = "black";
    // draw labels
    for (let i = 1; i < 6; i++) {
        ctx.beginPath();
        ctx.moveTo((i * width) / 6, height / 2 - 5);
        ctx.lineTo((i * width) / 6, height / 2 + 5);
        ctx.moveTo(width / 2 - 5, (i * height) / 6);
        ctx.lineTo(width / 2 + 5, (i * height) / 6);
        ctx.stroke();

        ctx.textAlign = "center";
        ctx.textBaseline = "bottom";
        ctx.fillText(labels[i - 1], (i * width) / 6, height / 2 - 7);

        ctx.textAlign = "left";
        ctx.textBaseline = "middle";
        ctx.fillText(labels[i - 1], width / 2 + 7, height - (i * height) / 6);
    }

    // draw axis x
    ctx.beginPath()
    ctx.moveTo(0, height / 2);
    ctx.lineTo(width, height / 2);
    ctx.lineTo(width - 5, height / 2 + 5);
    ctx.lineTo(width - 5, height / 2 - 5);
    ctx.lineTo(width, height / 2);
    ctx.stroke();

    // draw axis y

    ctx.beginPath();
    ctx.moveTo(width / 2, height);
    ctx.lineTo(width / 2, 0);
    ctx.lineTo(width / 2 + 5, 5);
    ctx.lineTo(width / 2 - 5, 5);
    ctx.lineTo(width / 2, 0);
    ctx.stroke();
    if (POINTS) {
        POINTS.forEach((point) => {
            ctx.beginPath();

            ctx.fillStyle = point.color;

            const xStep = point.x * (width / 3) / getR();
            const yStep = -(point.y * (height / 3) / getR());
            const positionX = width / 2 + xStep;
            const positionY = height / 2 + yStep;

            ctx.moveTo(positionX, positionY);
            ctx.arc(positionX, positionY, POINT_RADIUS, 0, 2 * Math.PI);
            ctx.fill();
        });
    }
    ctx.restore();
}

function drawPointer(event) {
    const rect = canvas.getBoundingClientRect();
    if (!rect)
        return;
    fillGraph();

    const mouseX = event.clientX - rect.left;
    const mouseY = event.clientY - rect.top;

    ctx.save();

    ctx.beginPath();
    ctx.fillStyle = POINTER_COLOR;
    ctx.arc(mouseX, mouseY, POINT_RADIUS, 0, 2 * Math.PI);
    ctx.fill();

    ctx.restore();
}

function getR() {
    const checkedR = document.querySelector(
        'input[name="r"]:checked');
    const r = Number.parseFloat(checkedR.value);
    return r;
}

fillGraph();