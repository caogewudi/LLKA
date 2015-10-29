package org.crazyit.link.board.impl;

import java.util.ArrayList;
import java.util.List;

import org.crazyit.link.board.AbstractBoard;
import org.crazyit.link.object.GameConf;
import org.crazyit.link.view.Piece;

/**
 * Description: 创建横的游戏区域
 * <br/>site: <a href="http://www.crazyit.org">crazyit.org</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class HorizontalBoard extends AbstractBoard
{
	protected List<Piece> createPieces(GameConf config,
		Piece[][] pieces)
	{

		List<Piece> notNullPieces = new ArrayList<Piece>();
		for (int i = 0; i < pieces.length; i++)
		{
			for (int j = 0; j < pieces[i].length; j++)
			{

				if (j % 2 == 0)
				{

					Piece piece = new Piece(i, j);

					notNullPieces.add(piece);
				}
			}
		}
		return notNullPieces;
	}
}
