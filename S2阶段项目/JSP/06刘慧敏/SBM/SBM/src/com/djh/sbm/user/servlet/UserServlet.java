/**
 * 
 */
package com.djh.sbm.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.djh.sbm.user.bean.User;
import com.djh.sbm.user.service.UserService;
import com.djh.sbm.user.service.impl.UserServiceImpl;
import com.djh.sbm.util.Constant;
import com.djh.sbm.util.IDUtil;

@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {
	private UserService userService = new UserServiceImpl();
	private User user = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "userlogin":
			dologin(request, response);
			break;
		case "repswd":
			doRepswd(request, response);
			break;
		case "exit":
			doExit(request, response);
			break;
		case "uploadPic":
			uploadPic(request, response);
			break;
		case "addUser":
			addUser(request, response);
			break;
		case "selectUser":
			doselectUser(request, response);
			break;
		default:
			break;
		}
	}

	private void doselectUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String userName = request.getParameter("userName");
		user = userService.doselectUser(userName);
		response.sendRedirect("jsp/userAdmin.jsp");
	}

	private void doRepswd(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String oldpswd = request.getParameter("oldpswd");
		String newpswd = request.getParameter("newpswd");
		user = (User) request.getSession().getAttribute("user");
		if(user.getUserPassword().equals(oldpswd)){
			user= userService.doRepswd(user, newpswd);
			response.sendRedirect("jsp/repswd.jsp?update=ok");
			request.getSession().setAttribute("newpswd", newpswd);
		}else{
			response.sendRedirect("jsp/repswd.jsp?update=no");
		}
	}

	private void addUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = (String)request.getAttribute("userName");
		String userPassword = (String)request.getAttribute("userPassword");
		String userSex = (String)request.getAttribute("userSex");
		String userAge = (String)request.getAttribute("userAge");
		String telephone = (String)request.getAttribute("telephone");
		String address = (String)request.getAttribute("address");
		String type = (String)request.getAttribute("type");

		String pic = (String) request.getAttribute("pic");

		User user = new User(
				userName, 
				userPassword,
				userSex,
				Integer.parseInt(userAge),
				telephone, 
				address, 
				pic,
				Integer.parseInt(type));

		int row = userService.addUser(user);
		PrintWriter out = response.getWriter();
		if(row > 0){
			response.sendRedirect("jsp/userInfo.jsp?picPath="+pic+"&ok=ok");
		}else{
			out.print("<script>alert('添加用户失败!');</script>");
		}
	}

	@SuppressWarnings("deprecation")
	private void uploadPic(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		SmartUpload smartUpload = new SmartUpload();
		smartUpload.initialize(getServletConfig(), request, response);
		smartUpload.setAllowedFilesList("png,jpg,jpeg,gif");
		smartUpload.setMaxFileSize(1024*1024*5);
		try {
			smartUpload.upload();
			Request sRequest = smartUpload.getRequest();
			File file = smartUpload.getFiles().getFile(0);
			String picName = IDUtil.getUUID();
			String picFilePath = Constant.FILE_USER_PHOTO_PATH;
			java.io.File filePath = new java.io.File(request.getRealPath("/")+picFilePath);
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			String extName = file.getFileExt();
			String picPath = picFilePath + picName + "." +extName;
			String savePath = request.getRealPath("/") + picPath;
			file.saveAs(savePath);
			request.setAttribute("userName", sRequest.getParameter("userName"));
			request.setAttribute("userPassword", sRequest.getParameter("userPassword"));
			request.setAttribute("userSex", sRequest.getParameter("userSex"));
			request.setAttribute("userAge", sRequest.getParameter("userAge"));
			request.setAttribute("telephone", sRequest.getParameter("telephone"));
			request.setAttribute("address", sRequest.getParameter("address"));
			request.setAttribute("type", sRequest.getParameter("type"));
			request.setAttribute("pic", picPath);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("user?cmd=addUser");
			requestDispatcher.forward(request, response);
		} catch (IOException e) {

			e.printStackTrace();
		} catch (SmartUploadException e) {

			e.printStackTrace();
		}
	}

	private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
		PrintWriter out = response.getWriter();
		out.print("<script>window.top.location.href='"+basePath+"'</script>");
	}

	@SuppressWarnings("unchecked")
	private void dologin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		boolean isLogin = false;
		ServletContext application = request.getServletContext();
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		user = userService.dologin(userName, userPassword);
		if (user != null) {
			request.getSession().setAttribute("user", user);
			List<User> users = (List<User>) application.getAttribute("online");
			for (User userOnline : users) {
				if(userOnline.getUserId() == user.getUserId()){
					isLogin = true;
				}
			}
			if(!isLogin){
				users.add(user);
				application.setAttribute("online", users);
				response.sendRedirect("account?cmd=getPagebean");
			} else {

				response.sendRedirect("index.jsp?loginMsg=failed");
			}
		}

	}
}
