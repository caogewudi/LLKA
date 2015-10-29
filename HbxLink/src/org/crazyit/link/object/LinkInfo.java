package org.crazyit.link.object;

import java.util.List;
import java.util.ArrayList;

import android.graphics.Point;

/**
 * Description: 连接信息类
 * <br/>site: <a href="http://www.crazyit.org">crazyit.org</a> 
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class LinkInfo
{

	private List<Point> points = new ArrayList<Point>();


	public LinkInfo(Point p1, Point p2)
	{

		points.add(p1);
		points.add(p2);
	}


	public LinkInfo(Point p1, Point p2, Point p3)
	{
		points.add(p1);
		points.add(p2);
		points.add(p3);
	}


	public LinkInfo(Point p1, Point p2, Point p3, Point p4)
	{
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
	}


	public List<Point> getLinkPoints()
	{
		return points;
	}
}
