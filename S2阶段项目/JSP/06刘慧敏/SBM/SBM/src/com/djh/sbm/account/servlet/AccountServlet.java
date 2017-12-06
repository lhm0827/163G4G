
package com.djh.sbm.account.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.djh.sbm.account.service.AccountService;
import com.djh.sbm.account.service.impl.AccountServiceImpl;
import com.djh.sbm.common.bean.PageBean;
import com.djh.sbm.common.service.CommonService;
import com.djh.sbm.common.service.impl.CommonServiceImpl;
import com.djh.sbm.goods.bean.Goods;

@SuppressWarnings("serial")
public class AccountServlet extends HttpServlet {
	private CommonService cService = new CommonServiceImpl();
	private AccountService aService = new AccountServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "getPagebean":
			getPagebean(request, response);
			break;
		case "getPagebeanByParam":
			getPagebeanByParam(request, response);
			break;
		case "addAccount":
			addAccount(request, response);
			break;
		case "updateAccount":
			updateAccount(request, response);
			break;
		case "deleteAccount":
			deleteAccount(request, response);
			break;

		default:
			break;
		}
	}

	private void deleteAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String accountId = request.getParameter("accountId");
		
		int row = aService.deleteAccountById(Integer.parseInt(accountId));
		if(row > 0){
			//删除成功
			response.sendRedirect("account?cmd=getPagebean&&p=1");
		}else{
			//删除失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除失败');</script>");
		}
	}

	private void updateAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String accountId = request.getParameter("accountId");
		String isPayed = request.getParameter("isPayed");
		
		
		int row = aService.updateAccount(Integer.parseInt(accountId), Integer.parseInt(isPayed));
		
		if(row > 0){
			//修改成功
			response.sendRedirect("account?cmd=getPagebean&&p=1");
		}else{
			//修改失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新失败');</script>");
		}
	}

	private void addAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String providerId = request.getParameter("providerId");
		String isPayed = request.getParameter("isPayed");
		String businessNum = request.getParameter("businessNum");
		
		Goods goods = (Goods) request.getAttribute("goods");
		
		int row = aService.addAccount(
						goods, 
						Integer.parseInt(providerId), 
						Integer.parseInt(isPayed), 
						Integer.parseInt(businessNum));
		
		if(row > 0){
			//添加成功
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("goods?cmd=updateGoods");
			requestDispatcher.forward(request, response);
		}else{
			//添加失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('添加失败');</script>");
		}
		
		
	}

	private void getPagebeanByParam(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<String> wheres = new ArrayList<>();
		List<String> values = new ArrayList<>();

		String productName = request.getParameter("productName");
		String isPayed = request.getParameter("isPayed");

		if(productName != null && productName != ""){
			wheres.add("goodsName");
			values.add(productName);
		}
		if(isPayed != null && isPayed != ""){
			wheres.add("isPayed");
			values.add(isPayed);
		}

		PageBean pageBean = new PageBean();

		//先获取count
		int count = aService.getCount(wheres, values);
		//设置count的值，同时也设置pagetotal的值
		pageBean.setCount(count);
		//设置p的值
		String p = request.getParameter("p");

		if(p != null && p != ""){
			pageBean.setP(Integer.parseInt(p));
		}else{
			pageBean.setP(1);
		}
		pageBean = aService.getAccount(pageBean, wheres, values);

		request.getSession().setAttribute("pageBean", pageBean);

		//更新子窗口视图
		PrintWriter out = response.getWriter();
		out.print("<script>location.href='jsp/admin_bill_list.jsp'</script>");

	}

	private void getPagebean(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		PageBean pageBean = new PageBean();
		//先获取count
		int count = cService.getCount("tb_account", null, null);
		//设置count的值，同时也设置pagetotal的值
		pageBean.setCount(count);
		//设置p的值
		String p = request.getParameter("p");

		if(p != null && p != ""){
			pageBean.setP(Integer.parseInt(p));
		}else{
			pageBean.setP(1);
		}
		pageBean = aService.getAccount(pageBean);

		request.getSession().setAttribute("pageBean", pageBean);

		if(p != null && p != ""){
			//
			PrintWriter out = response.getWriter();
			out.print("<script>location.href='jsp/admin_bill_list.jsp'</script>");
		}else{
			//说明第一次进入
			response.sendRedirect("jsp/admin_index.jsp");
		}
	}

}
