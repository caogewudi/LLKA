package org.crazyit.link.view;

import android.graphics.Point;

/**
 * Description: 连连看游戏中的方块对象
 * <br/>site: <a href="http://www.crazyit.org">crazyit.org</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class Piece
{

	private PieceImage image;

	private int beginX;

	private int beginY;

	private int indexX;

	private int indexY;


	public Piece(int indexX , int indexY)
	{
		this.indexX = indexX;
		this.indexY = indexY;
	}

	public int getBeginX()
	{
		return beginX;
	}

	public void setBeginX(int beginX)
	{
		this.beginX = beginX;
	}

	public int getBeginY()
	{
		return beginY;
	}

	public void setBeginY(int beginY)
	{
		this.beginY = beginY;
	}

	public int getIndexX()
	{
		return indexX;
	}

	public void setIndexX(int indexX)
	{
		this.indexX = indexX;
	}

	public int getIndexY()
	{
		return indexY;
	}

	public void setIndexY(int indexY)
	{
		this.indexY = indexY;
	}
	

	public PieceImage getImage()
	{
		return image;
	}

	public void setImage(PieceImage image)
	{
		this.image = image;
	}


	public Point getCenter()
	{
		return new Point(getImage().getImage().getWidth() / 2
			+ getBeginX(), getBeginY()
			+ getImage().getImage().getHeight() / 2);
	}	

	public boolean isSameImage(Piece other)
	{
		if (image == null)
		{
			if (other.image != null)
				return false;
		}

		return image.getImageId() == other.image.getImageId();
	}
}
