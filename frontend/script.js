let numberToGuess;
let attempts;

const input = document.getElementById("guessInput");
const message = document.getElementById("message");
const attemptsText = document.getElementById("attempts");
const guessBtn = document.getElementById("guessBtn");
const restartBtn = document.getElementById("restartBtn");

startGame();

function startGame() {
    numberToGuess = Math.floor(Math.random() * 100) + 1;
    attempts = 0;
    attemptsText.textContent = "Attempts: 0";
    message.textContent = "";
    message.className = "";
    input.value = "";
    input.disabled = false;
    guessBtn.disabled = false;
}

function checkGuess() {
    const guess = Number(input.value);

    if (!guess || guess < 1 || guess > 100) {
        message.textContent = "❌ Enter a number between 1 and 100";
        message.className = "error";
        return;
    }

    attempts++;
    attemptsText.textContent = `Attempts: ${attempts}`;

    if (guess < numberToGuess) {
        message.textContent = "⬇ Too low!";
        message.className = "error";
    } else if (guess > numberToGuess) {
        message.textContent = "⬆ Too high!";
        message.className = "error";
    } else {
        message.textContent = `🎉 Correct! You guessed it in ${attempts} attempts`;
        message.className = "success";
        input.disabled = true;
        guessBtn.disabled = true;
    }

    input.value = "";
    input.focus();
}

guessBtn.addEventListener("click", checkGuess);
restartBtn.addEventListener("click", startGame);

input.addEventListener("keydown", function (e) {
    if (e.key === "Enter") {
        checkGuess();
    }
});
