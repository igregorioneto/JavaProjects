document.addEventListener("DOMContentLoaded", () => {
    const socket = new WebSocket("ws://localhost:8080/conect");
    const Client = Stomp.over(socket);

    var start = false;

    const board = document.getElementById("board");
    const loading = document.getElementById("loading");
    loading.innerHTML = "Starting Game...";
    loading.style.display = "block";
    board.style.display = "none";

    const result = document.getElementById("result");

    const startGameDiv = document.getElementById("startGame");

    const buttonStartGame = document.createElement("button");
    buttonStartGame.innerHTML = "Start Game";

    buttonStartGame.onclick = function() {
        start = !start;
        const message = {
            startGame: start
        }
        Client.send("/app/startGame", {}, JSON.stringify(message));

        if (start) {
            loading.style.display = "none";
            board.style.display = "grid";
            buttonStartGame.innerHTML = "Playing...";
        } else {
            loading.style.display = "block";
            board.style.display = "none";
            buttonStartGame.innerHTML = "Start Game";
        }
    }

    function handleStartGame(s) {
        console.log(s);
    }

    startGameDiv.appendChild(buttonStartGame);

    result.textContent = "Player Win: ";

    const cells = new Array(3).fill(null).map(() => new Array(3).fill(null));
    let player = {"representation": "X"};

    for(let i = 0; i < 3; i++) {
        for(let j = 0; j < 3; j++) {
            const cell = document.createElement("div");
            cell.classList.add("cell");
            cell.dataset.row = i;
            cell.dataset.col = j;
            cell.addEventListener("click", () => handleCellClick(i, j));
            board.appendChild(cell);
        }
    }

    function handleCellClick(i, j) {
            const cell = document.querySelector(`[data-row="${i}"][data-col="${j}"]`);
            if (cell.textContent == "") {
                handleSendMakePlayer(parseInt(i), parseInt(j), player);
                cell.textContent = player.representation;
                console.log(i,j);
            }

            handleChangePlayer();
    }

    function handleChangePlayer() {
        if(player.representation === "X") {
            player = {"representation": "O"};
        } else if (player.representation === "O") {
            player = {"representation": "X"};
        } else {
            return;
        }
    }

    function handleSendMakePlayer(x, y, Player) {
        const message = {
            TicTacToe: {
                x,
                y,
            },
            Player,
        }

        Client.send("/app/makePlayer", {}, JSON.stringify(message));
    }

    function modifyPlayerWin(r) {
        console.log(r);
        result.textContent = "Player Win: " + r;
    }

    function connection() {
        Client.connect({}, function(frame) {
            console.log("Conectado: " + frame);

            Client.subscribe("/tictactoe", function(result) {
                const r = result.body;
                modifyPlayerWin(r);
            });

            Client.subscribe("/start", function(result) {
                const s = result.body;
                handleStartGame(s);
            })
        });
    }

    connection();
});

