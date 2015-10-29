package org.crazyit.link.view;
/**
 * 根据游戏状态来绘制游戏界面上的全部方块
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.crazyit.link.Link;
import org.crazyit.link.board.GameService;
import org.crazyit.link.board.impl.GameServiceImpl;
import org.crazyit.link.object.GameConf;
import org.crazyit.link.object.LinkInfo;
import android.graphics.Point;
import org.crazyit.link.util.ImageUtil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Description: <br/>
 * site: <a href="http://www.crazyit.org">crazyit.org</a> <br/>
 * Copyright (C), 2001-2012, Yeeku.H.Lee <br/>
 * This program is protected by copyright laws. <br/>
 * Program Name: <br/>
 * Date:Download by http://www.codefans.net
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class GameView extends View
{

	private GameService gameService;

	private Piece selectedPiece;
	
	private LinkInfo linkInfo;
	private Paint paint;
	
	private Bitmap selectImage;

	public GameView(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		this.paint = new Paint();

		this.paint.setColor(Color.RED);

		this.paint.setStrokeWidth(3);
		this.selectImage = ImageUtil.getSelectImage(context);
	}

	public void setLinkInfo(LinkInfo linkInfo)
	{
		this.linkInfo = linkInfo;
	}

	public void setGameService(GameService gameService)
	{
		this.gameService = gameService;
	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		super.onDraw(canvas);
		if (this.gameService == null)
			return;
		Piece[][] pieces = gameService.getPieces();
		if (pieces != null)
		{

			for (int i = 0; i < pieces.length; i++)
			{
				for (int j = 0; j < pieces[i].length; j++)
				{
	
					if (pieces[i][j] != null)
					{
	
						Piece piece = pieces[i][j];
	
						canvas.drawBitmap(piece.getImage().getImage(),
							piece.getBeginX(), piece.getBeginY(), null);
					}
				}
			}
		}

		if (this.linkInfo != null)
		{

			drawLine(this.linkInfo, canvas);
	
			this.linkInfo = null;
		}
	
		if (this.selectedPiece != null)
		{
			canvas.drawBitmap(this.selectImage, this.selectedPiece.getBeginX(),
				this.selectedPiece.getBeginY(), null);
		}
	}


	private void drawLine(LinkInfo linkInfo, Canvas canvas)
	{
	
		List<Point> points = linkInfo.getLinkPoints();

		for (int i = 0; i < points.size() - 1; i++)
		{
	
			Point currentPoint = points.get(i);
			Point nextPoint = points.get(i + 1);

			canvas.drawLine(currentPoint.x , currentPoint.y,
				nextPoint.x, nextPoint.y, this.paint);
		}
	}


	public void setSelectedPiece(Piece piece)
	{
		this.selectedPiece = piece;
	}


	public void startGame()
	{
		this.gameService.start();
		this.postInvalidate();
	}

	public void refresh() {

		Piece[][] pieces = gameService.getPieces();
		List<Piece> notNullPieces = new ArrayList<Piece>();
		
	
		for (int i = 0; i < pieces.length ; i++)
		{
			for (int j = 0; j < pieces[0].length ; j++)
			{
				if(pieces[i][j] != null){
					Piece piece = new Piece(i,j);
					piece.setImage(pieces[i][j].getImage());
					

					Log.d("a", String.valueOf(piece.hashCode()));
					Log.d("b", String.valueOf(pieces[i][j].hashCode()));
					//pieces[i][j];
					notNullPieces.add(piece);
					System.out.println(".....i="+i+".....j="+j);
					
					
				}
			}
			
		}

		Collections.shuffle(notNullPieces);
		
		
		
		int k = 0;
		for(k = 0 ; k < notNullPieces.size();k++)
		{
			Log.d(String.valueOf(String.valueOf(k)), String.valueOf(notNullPieces.get(k).getImage().getImageId()));
		}
		k=0;
		for (int i = 0; i < pieces.length ; i++)
		{
			for (int j = 0; j < pieces[0].length ; j++)
			{
				if(pieces[i][j] != null){
					if(k < notNullPieces.size()) {

						
    					pieces[pieces[i][j].getIndexX()][pieces[i][j].getIndexY()].setImage(notNullPieces.get(k).getImage());

						k++;
					}
				}
				
			}
			
		}
	
		

	}
}
