package org.crazyit.link.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.crazyit.link.object.GameConf;
import org.crazyit.link.util.ImageUtil;
import org.crazyit.link.view.Piece;
import org.crazyit.link.view.PieceImage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Description: 游戏区域的抽象类
 * <br/>site: <a href="http://www.crazyit.org">crazyit.org</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */

public abstract class AbstractBoard
{

	protected abstract List<Piece> createPieces(GameConf config,
		Piece[][] pieces);
	
	public Piece[][] create(GameConf config)
	{

		Piece[][] pieces = new Piece[config.getXSize()][config.getYSize()];

		List<Piece> notNullPieces = createPieces(config, pieces);

		List<PieceImage> playImages = ImageUtil.getPlayImages(config.getContext(),
			notNullPieces.size());

		int imageWidth = playImages.get(0).getImage().getWidth();
		int imageHeight = playImages.get(0).getImage().getHeight();

		for (int i = 0; i < notNullPieces.size(); i++)
		{

			Piece piece = notNullPieces.get(i);
			piece.setImage(playImages.get(i));

			piece.setBeginX(piece.getIndexX() * imageWidth
				+ config.getBeginImageX());
			piece.setBeginY(piece.getIndexY() * imageHeight
				+ config.getBeginImageY());

			pieces[piece.getIndexX()][piece.getIndexY()] = piece;
		}
		return pieces;
	}
	
	
}
