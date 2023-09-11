document.addEventListener("DOMContentLoaded", () => {
    const socket = new WebSocket("ws://localhost:8080/conect");
    const Client = Stomp.over(socket);

    const board = document.getElementById("board");

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
            TicTocToe: {
                x,
                y,
            },
            Player,
        }

        Client.send("/app/makePlayer", {}, JSON.stringify(message));
    }

});
