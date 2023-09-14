package com.tictactoe;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.tictactoe.entities.Board;

public class Game extends ApplicationAdapter {
	private Board board;
	
	@Override
	public void create () {
		board = new Board();
	}

	@Override
	public void render () {
		board.render();
	}
	
	@Override
	public void dispose () {
	}
}
