package com.ext.share.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.Part;

import net.sf.json.JSONObject;

import com.ext.share.bo.ShareBo;
import com.ext.share.po.Share;
import com.ext.user.bo.UserInformationBo;
import com.ext.user.po.UserInformation;
import com.ext.util.FileUtil;
import com.ext.util.ImageUtil;
import com.ext.util.QssActionSupprot;
import com.ext.util.ResponseUtil;

public class ShareAction extends QssActionSupprot {

	private Share share;
	private ShareBo shareBo;
	private UserInformation userInformation;
	private UserInformationBo userInformationBo;
	private String msg;
	private String userid;
	private List<Share> list;

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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	public UserInformationBo getUserInformationBo() {
		return userInformationBo;
	}

	public void setUserInformationBo(UserInformationBo userInformationBo) {
		this.userInformationBo = userInformationBo;
	}

	public List<Share> getList() {
		return list;
	}

	public void setList(List<Share> list) {
		this.list = list;
	}

	/**
	 * 查询所有分享内容
	 * 
	 * @return
	 */
	public String findAllShare() {
		List<Share> list = new ArrayList();
		try {
			list = getShareBo().getAllShare();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		json.put("busList", output4ajax(new Object[] { list }));
		return ResponseUtil.returnJson(json.toString());
	}

	/**
	 * 分享文字
	 * 
	 * @return
	 */
	public String saveShareWords() {
		msg = null;
		String discribe = getParam("describes").toString();
		String userid = getParam("userId").toString();
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		share.setPersonId(Integer.valueOf(userid));
		share.setTypeId(1); // 这里把类型id写死了，后期需要修改
		share.setPlayTime(curDate);
		share.setDiscribe(discribe);
		try {
			getShareBo().saveShare(share);
			msg = "success";
		} catch (Exception e) {
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		return ResponseUtil.returnJson(json.toString());
	}

	/**
	 * 分享图片
	 * 
	 */
	public String saveSharePictures() throws IllegalStateException,
			IOException, ServletException {
		msg = null;
		String discribe = getParam("describes").toString();
		String userid = getParam("userId").toString();
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		share.setPersonId(Integer.valueOf(userid));
		share.setTypeId(2); // 这里把类型id写死了，后期需要修改
		share.setDiscribe(discribe);
		share.setPlayTime(curDate);
		Part part = getRequest().getPart("filepic");
		String url = saveFile(getFileName(part), part);
		share.setPicture(url);
		try {
			getShareBo().saveShare(share);
			msg = "success";
		} catch (Exception e) {
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		return ResponseUtil.returnJson(json.toString());
	}

	/**
	 * 点赞数加一
	 * 
	 */
	public String addShareGal() {
		msg = " ";
		int id = Integer.valueOf(getParam("id").toString());
		int clicknum = Integer.valueOf(getParam("clicknum").toString());
		int cnum = Integer.valueOf(clicknum)+1;
		// share.setId(Integer.valueOf(aid));
		// share.setPersonId(Integer.valueOf(pid));
		// share.setClickNumber(cnum);
		try {
			msg = getShareBo().updateGaL(id,cnum);
			if (msg.equals("success")) {
				msg = "success";
			} else {
				msg = "error";
			}
		} catch (Exception e) {
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		return ResponseUtil.returnJson(json.toString());
	}

	/**
	 * 评论数加一
	 * 
	 */
	public String addSharePls() {
		msg = " ";
		int id = Integer.valueOf(getParam("id").toString());
		int disnum = Integer.valueOf(getParam("disnum").toString());
		int dis_num = Integer.valueOf(disnum)+1;
		try {
			msg = getShareBo().updatePls(id,dis_num);
			if (msg.equals("success")) {
				msg = "success";
			} else {
				msg = "error";
			}
		} catch (Exception e) {
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		return ResponseUtil.returnJson(json.toString());
	}
	/**
	 * 转发量加一
	 * 
	 */
	public String addShareZfl() {
		msg = " ";
		int id = Integer.valueOf(getParam("id").toString());
		int zflnum = Integer.valueOf(getParam("zflnum").toString());
		int zfl_num = Integer.valueOf(zflnum)+1;
		try {
			msg = getShareBo().updateZfl(id, zfl_num);
			if (msg.equals("success")) {
				msg = "success";
			} else {
				msg = "error";
			}
		} catch (Exception e) {
			msg = "error";
		}
		JSONObject json = new JSONObject();
		json.put("msg", msg);
		return ResponseUtil.returnJson(json.toString());
	}

	/**
	 * 通过分享id导出分享详情
	 * 
	 */
	public String findByShareId() {

		String id = getParam("id").toString();
		int aid = Integer.valueOf(id);
		try {
			share = getShareBo().findById(aid);
		} catch (Exception e) {
		}
		JSONObject json = new JSONObject();
		json.put("share", output4ajax(new Object[] { share }));
		return ResponseUtil.returnJson(json.toString());

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
	private String saveFile(String filename, Part part) {
		String folderPath = "E:\\java_workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ext_web\\picture";
		String url = "";
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
			part.write(folderPath + filename);
			// 每个Part对象对应于一个文件上传域，该对象提供的大量方法来访问上传文件的文件类型，大小，输入流等。并提供一个write（String
			// file）将上传文件写入服务器磁盘。
			url = "http://192.168.43.224:8080/ext_web/picture/" + filename;
			// 图片缩放各种比例存储开始
			FileUtil.createDir(folderPath);
			FileUtil.createDir(folderPath + "/" + s);
			ImageUtil.scale(folderPath + filename, folderPath + "/" + s + "/2"
					+ lastName, 2, false);// 图片缩小二分之一
			ImageUtil.scale(folderPath + filename, folderPath + "/" + s + "/5"
					+ lastName, 5, false);// 图片缩小五分之一
			ImageUtil.scale(folderPath + filename, folderPath + "/" + s + "/10"
					+ lastName, 10, false);// 图片缩小十分之一
			// 图片缩放各种比例存储结束
		} catch (IOException e) {
			e.printStackTrace();
		}
		return url;
	}

}
