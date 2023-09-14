package com.tictactoe.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Board extends InputAdapter {
    private Cell[][] cells;
    private Player currentPlayer;
    private ShapeRenderer shapeRenderer;

    private boolean isPaused;

    public Board() {
        isPaused = false;
        shapeRenderer = new ShapeRenderer();

        cells = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cell();
            }
        }

        currentPlayer = Player.X;

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (isPaused)
            return false;
        // Converter coordenadas em tela para as coordenadas do tabuleiro:
        Vector2 worldCoordinates = new Vector2(screenX, Gdx.graphics.getHeight() - screenY);
        Vector2 cellCoordinates = screenToCell(worldCoordinates);

        // Verifica se esta vazia
        int x = (int) cellCoordinates.x;
        int y = (int) cellCoordinates.y;

        if (isValidCell(x,y) && cells[x][y].isEmpty()) {
            // Realiza a jogada e troca de jogador
            cells[x][y].setPlayer(currentPlayer);
            isVerifyWin(currentPlayer);
            currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;

            return true;

        }

        return false;
    }

    public boolean isValidCell(int x, int y) {
        return x >= 0 && x < 3 && y >= 0 && y < 3;
    }

    private Vector2 screenToCell(Vector2 screenCoordinates) {
        float  cellWidth = Gdx.graphics.getWidth() / 3f;
        float cellHeight = Gdx.graphics.getHeight() / 3f;
        int x = (int) (screenCoordinates.x / cellWidth);
        int y = (int) (screenCoordinates.y / cellHeight);
        return new Vector2(x,y);
    }

    private void isVerifyWin(Player currentPlayer) {
        if (cells[0][0].getPlayer() == currentPlayer && cells[1][1].getPlayer() == currentPlayer && cells[2][2].getPlayer() == currentPlayer) {
            System.out.println("Player win: " + currentPlayer);
            isPaused = true;
            return;
        }

        if (cells[0][2].getPlayer() == currentPlayer && cells[1][1].getPlayer() == currentPlayer && cells[2][0].getPlayer() == currentPlayer) {
            System.out.println("Player win: " + currentPlayer);
            isPaused = true;
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (cells[i][0].getPlayer() == currentPlayer && cells[i][1].getPlayer() == currentPlayer && cells[i][2].getPlayer() == currentPlayer) {
                System.out.println("Player win: " + currentPlayer);
                isPaused = true;
                return;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (cells[0][i].getPlayer() == currentPlayer && cells[1][i].getPlayer() == currentPlayer && cells[2][i].getPlayer() == currentPlayer) {
                System.out.println("Player win: " + currentPlayer);
                isPaused = true;
                return;
            }
        }
    }

    public void render() {
        // Limpe a tela
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (shapeRenderer != null) {
            // Inicia o Shape Render para redenrizar
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(Color.WHITE);

            // Desenhando as linhas do tabuleiro
            float cellWidth = Gdx.graphics.getWidth() / 3f;
            float cellHeight = Gdx.graphics.getHeight() / 3f;

            for (int i = 1; i < 3; i++) {
                float x = i * cellWidth;
                float y = i * cellHeight;
                // linhas horizontais
                shapeRenderer.line(0, y, Gdx.graphics.getWidth(), y);
                // linhas verticais
                shapeRenderer.line(x, 0, x, Gdx.graphics.getHeight());
            }
            shapeRenderer.end();
            // Desenhar o jogador na tela;
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    Player player = cells[x][y].getPlayer();

                    float cellCenterX = cellWidth * (x + 0.5f);
                    float cellCenterY = cellHeight * (y + 0.5f);

                    shapeRenderer.setColor(Color.WHITE);
                    shapeRenderer.setAutoShapeType(true);

                    float lineLength = cellWidth * 0.2f;
                    if (player == Player.X) {
                        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
                        shapeRenderer.line(cellCenterX - lineLength, cellCenterY - lineLength,
                                            cellCenterX + lineLength, cellCenterY + lineLength);
                        shapeRenderer.line(cellCenterX - lineLength, cellCenterY + lineLength,
                                            cellCenterX + lineLength, cellCenterY - lineLength);
                        shapeRenderer.end();
                    } else if (player == Player.O) {
                        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                        shapeRenderer.circle(cellCenterX, cellCenterY, lineLength);
                        shapeRenderer.end();
                    }
                }
            }


        }

    }

    public void update() {

    }
}
