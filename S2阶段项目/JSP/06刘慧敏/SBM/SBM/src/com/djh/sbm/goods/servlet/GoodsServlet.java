/**
 * 
 */
package com.djh.sbm.goods.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.djh.sbm.goods.bean.Goods;
import com.djh.sbm.goods.service.GoodsService;
import com.djh.sbm.goods.service.impl.GoodsServiceImpl;


@SuppressWarnings("serial")
public class GoodsServlet extends HttpServlet {
	private GoodsService goodsService = new GoodsServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "getGoodsInfoByName":
			getGoodsInfoByName(request, response);
			break;
		case "updateGoods":
			updateGoods(request, response);
			break;

		default:
			break;
		}
	}

	private void updateGoods(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String businessNum = request.getParameter("businessNum");
		Goods goods = (Goods) request.getAttribute("goods");
		
		int goodsNum = goods.getGoodsNum() + Integer.parseInt(businessNum);
		int row = goodsService.updateGoods(goodsNum, goods.getGoodsId());
		
		if(row > 0){
			//更新成功
			response.sendRedirect("account?cmd=getPagebean&&p=1");
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新商品库存失败');</script>");
		}
	}

	private void getGoodsInfoByName(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String goodsName = request.getParameter("goodsName");
		
		Goods goods = goodsService.getGoodsInfoByName(goodsName);
		
		request.setAttribute("goods", goods);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("account?cmd=addAccount");
		requestDispatcher.forward(request, response);
		
	}

}
