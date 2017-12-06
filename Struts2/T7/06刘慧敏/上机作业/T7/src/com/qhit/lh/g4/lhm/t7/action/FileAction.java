/**
 * 
 */
package com.qhit.lh.g4.lhm.t7.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 刘慧敏
 *TODO
 *2017年12月6日下午3:25:15
 */
public class FileAction extends ActionSupport {

	private String username;
	private File uploadFile;
	private String uploadFileFileName;
	private String uploadFileContentType ;
	
	public String upload() {
		if(uploadFile != null) {
			try {
				//读取上传文件的输出流
				InputStream is = new FileInputStream(uploadFile);
				//得到文件保存路径
				String savePath = ServletActionContext.getServletContext().getRealPath("/")+"upload/"+ uploadFileFileName;
				File file =new File(savePath);
				//创建文件夹
				if(!file.exists()) {
					file.mkdirs();
				}
				//保存到服务器，将上传的内容写入到savePath的文件夹中
				OutputStream os = new FileOutputStream(savePath+uploadFileFileName);
				//写入数据
				byte[] buffer = new byte[8096];
				int len = 0;
				while((len = is.read(buffer)) != -1){
					os.write(buffer, 0, len);
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadFile", "文件未找到！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				super.addFieldError("uploadFile", "文件保存服务器失败！");
			}
		}else {
			super.addFieldError("uploadFile", "文件未找到！");
			return "input";	
		}
		
		
		
		return "uploadSuccess";
	}

	
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	
	


}
