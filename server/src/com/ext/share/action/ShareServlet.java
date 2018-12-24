package com.ext.share.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ext.share.bo.ShareBo;
import com.ext.share.po.Share;
import com.ext.util.DatabaseUtils;
import com.ext.util.FileUtil;
import com.ext.util.ImageUtil;

/**
 * Servlet implementation class ShareServlet
 */
@MultipartConfig
@WebServlet("/ShareServlet.do")
// @WebServlet("/ShareServlet")
public class ShareServlet extends HttpServlet {
	private Properties pro = new Properties();
	private static final long serialVersionUID = 1L;
	private Share share;
	private ShareBo shareBo;
	private String msg;
	private List<Share> list;
	private static String url = "";

	public Share getShare() {
		return share;
	}

	public void setShare(Share share) {
		this.share = share;
	}

	public ShareBo getShareBo() {
		return shareBo;
	}

	public void setShareBo(ShareBo shareBo) {
		this.shareBo = shareBo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShareServlet() {
		super();
		// TODO Auto-generated constructor stub

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		// 初始化时，使得sring 能够注入Bo

		ServletContext servletContext = config.getServletContext();
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		AutowireCapableBeanFactory autowireCapableBeanFactory = webApplicationContext
				.getAutowireCapableBeanFactory();

		// autowireCapableBeanFactory.configureBean(this, "idMaker");
		// autowireCapableBeanFactory.configureBean(this, "imgTestBo");
		autowireCapableBeanFactory.configureBean(this, "shareBo");

		try {
			pro.load(new FileInputStream(config.getServletContext()
					.getRealPath("/") + "fileFolder.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 分享图片
		 * 
		 */
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		msg = null;
		
		String discribe = request.getParameter("describe").toString();
		String userid = request.getParameter("pId").toString();
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		share.setPersonId(Integer.valueOf(userid));
		share.setTypeId(2); // 这里把类型id写死了，后期需要修改
		share.setDiscribe(discribe);
		share.setPlayTime(curDate);

		Part part = request.getPart("file");
		url = saveFile(getFileName(part), part,url);
		//http://localhost:8080/ext_web/picture/share_pics/20161013002001.jpg
		//url = url.concat(",");
		share.setPicture(url);
		try {
			getShareBo().saveShare(share);
			msg = "success";
			out.print(msg);
		} catch (Exception e) {
			msg = "error";
			out.print(msg);
		}
	}

	/**
	 * 从Part的Header信息中提取上传文件的文件名
	 * 
	 * @param part
	 * @return 上传文件的文件名，如果如果没有则返回null
	 */
	private String getFileName(Part part) {
		String fileNameExtractorRegex = "filename=\".+\"";
		// 获取header信息中的content-disposition，如果为文件，则可以从其中提取出文件名
		String cotentDesc = part.getHeader("content-disposition");
		String fileName = null;
		Pattern pattern = Pattern.compile(fileNameExtractorRegex);
		Matcher matcher = pattern.matcher(cotentDesc);
		if (matcher.find()) {
			fileName = matcher.group();
			fileName = fileName.substring(10, fileName.length() - 1);
		}
		return fileName;
	}

	/**
	 * 
	 * @param folder
	 * @param filename
	 * @param part
	 * @param lastName
	 * @param s
	 * @return
	 * @date 日期: 2015年8月18日 上午11:49:26
	 * @author 作者： ZhengChenHui
	 * @description 描述: 保存多种尺寸图片
	 */
	private String saveFile(String filename, Part part,String url) {
		String folderPath = "E:\\java_workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ext_web\\picture\\share_pics\\";
		//String folderPath = pro.getProperty("shareFolder");//上面的路径换成这种方式表示，Property为一路径的配置文件，以键值对形式存在，方便修改路径
		String urll = "";
		FileUtil.createDir(folderPath);
		String lastName = filename.substring(filename.lastIndexOf('.'));
		String s = "";

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String rq = format.format(new Date());
		s = rq.replace("-", "");
		s = s.replace(":", "");
		s = s.replace(" ", "");
		filename = s + lastName;
		try {
			
			// 每个Part对象对应于一个文件上传域，该对象提供的大量方法来访问上传文件的文件类型，大小，输入流等。并提供一个write（String
			// file）将上传文件写入服务器磁盘。
			//url = DatabaseUtils.basePath + "share_pics/" + filename;
			urll = DatabaseUtils.basePath +"ext_web/picture/share_pics/" + filename;
			// 图片缩放各种比例存储开始
			FileUtil.createDir(folderPath);
			part.write(folderPath + filename);
			//FileUtil.createDir(folderPath + "/" + s);
			/*ImageUtil.scale(folderPath + filename, folderPath + "/" + s + "/2"
					+ lastName, 2, false);// 图片缩小二分之一
			ImageUtil.scale(folderPath + filename, folderPath + "/" + s + "/5"
					+ lastName, 5, false);// 图片缩小五分之一
			ImageUtil.scale(folderPath + filename, folderPath + "/" + s + "/10"
					+ lastName, 10, false);// 图片缩小十分之一
*/			// 图片缩放各种比例存储结束
		} catch (IOException e) {
			e.printStackTrace();
		}
		return urll.concat(",").concat(url);
	}
}
