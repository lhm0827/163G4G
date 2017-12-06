/**
 * 
 */
package com.djh.sbm.provider.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.djh.sbm.provider.bean.Provider;
import com.djh.sbm.provider.service.ProviderService;
import com.djh.sbm.provider.service.impl.ProviderServiceImpl;

@SuppressWarnings("serial")
public class ProviderServlet extends HttpServlet {
	private ProviderService providerService = new ProviderServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "getProvider":
			getProvider(request, response);
			break;
		case "addprovider":
			addprovider(request, response);
			break;
		default:
			break;
		}
	}

	private void addprovider(HttpServletRequest request,
			HttpServletResponse response) throws IOException {	
		request.setCharacterEncoding("UTF-8");
		String providerName = request.getParameter("providerName");
		String providerDetail = request.getParameter("providerDetail");
		String contact = request.getParameter("contact");
		String telephone = request.getParameter("telephone");
		String facsimile = request.getParameter("facsimile");
		String address = request.getParameter("address");
		
		Provider provider = new Provider(
				providerName, 
				providerDetail, 
				contact, 
				telephone, 
				facsimile, 
				address);
		int row = providerService.addprovider(provider);
		PrintWriter out = response.getWriter();
		if(row > 0){
			response.sendRedirect("jsp/providerAdmin.jsp?ok=ok");
		}else{
			out.print("<script>alert('添加供应商失败!');</script>");
		}
	}

	private void getProvider(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Provider> list = providerService.getProvider();
		
		request.setAttribute("providers", list);
		//查询完所有的供应商之后再去进入到添加账单的页面
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/modify.jsp");
		requestDispatcher.forward(request, response);
	}

}
