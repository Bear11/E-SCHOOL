package com.ext.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;



 /**
  *                                                                                            
  * @author wangwei
  * @description 描述：异常记录类
  *
  */
public class LogWrite{                                               
	    /** 
	     * 创建文件 
	     * @param fileName 
	     * @return 
	     */  
	    public static boolean createFile(File fileName)throws Exception{  
		     try{  
		      if(!fileName.exists()){  
		       fileName.createNewFile();  
		      }  
		     }catch(Exception e){  
		      e.printStackTrace();  
		     }  
		     return true;  
	    } 
	   /**
	    * 
	   * @author 作者:wangwei
	   * @version 创建时间：2015年4月21日 下午7:07:51 
	   * @description 描述：记录异常
	   * @return 返回值说明：
	   * @param 参数：@param className
	   * @param 参数：@param methodName
	   * @param 参数：@param errorInfo
	    */
    	public static  void errorLogToTxt(String className, String methodName,String errorInfo) {  
    	        String str = new String(); //原有txt内容  
    	        String s1 = new String();//内容更新  
    	        
    	        try {  
    	        	Date d = new Date();
    	        	String datatime = StringFormatter.formatDate(d);
    	        	datatime = datatime.replace("-", "");
    	            File f = new File(DatabaseUtils.logPath+datatime+"errorLog.txt");
    	            if (!f.getParentFile().exists()) {
    	            	   f.getParentFile().mkdirs();
    	            }
    	          ///判断文件是否存在以及是否大于1G                                               
    	            if (f.exists()&&(f.length()/1024)+1>1024*1024) {  
    	            	///删除该文件                                                
    	                f.delete();      
    	            } else  if (!f.exists()){  
    	                createFile(f);
    	            }     
    	            BufferedReader input = new BufferedReader(new FileReader(f));  
    	  
    	            while ((str = input.readLine()) != null) {  
    	                s1 += str + "\r\n";  
    	            }  
    	            input.close();  
    	            BufferedWriter output = new BufferedWriter(new FileWriter(f));  
    	            output.write(s1);  
                   
                    output.write("<------------------------------------------------------------------------------------->\r\n");                       
    	            ///写入“Debug Info: ”                                                
    	            output.write("异常时间　　："+ StringFormatter.formatTime(new Date() ) + "\r\n");                                                
    	            //写入出错的类名称                                                
    	            output.write("异常类名　　：" + className + "\r\n");                                                
    	            //写入出错的方法名称                                                
    	            output.write("异常方法名　：" + methodName + "\r\n");                                                
    	            //写入错误信息                                                
    	            output.write("异常错误信息：" + errorInfo + "\r\n"); 
    	            output.write("<------------------------------------------------------------------------------------->\r\n");                       
    	            ///清空缓冲区内容，并把缓冲区内容写入基础流                                                
    	            output.flush();                                                
    	            ///关闭写数据流                                                
    	            output.close();  
    	        } catch (Exception e) {  
    	            e.printStackTrace();  
    	  
    	        }  
    	  
    	}  
    /**
 	    * 
 	   * @author 作者:wangwei
 	   * @version 创建时间：2015年4月21日 下午7:07:51 
 	   * @description 描述：记录操作日志
 	   * @return 返回值说明：
 	   * @param 参数：@param moduleName
 	   * @param 参数：@param type
 	   * @param 参数：@param desc
 	   * @param 参数：@param userName
  	   * @param 参数：@param personName
  	   * @param 参数：@param personId
 	    */
     	public static  void doLogToTxt(String moduleName, String type,String desc,String userName,String personName,String personId) {  
     	        String str = new String(); //原有txt内容  
     	        String s1 = new String();//内容更新  
     	        try {  
     	        	Date d = new Date();
    	        	String datatime = StringFormatter.formatDate(d);
    	        	datatime = datatime.replace("-", "");
    	            File f = new File(DatabaseUtils.logPath+datatime+"doLog.txt");
     	            if (!f.getParentFile().exists()) {
     	            	   f.getParentFile().mkdirs();
     	            }
     	          ///判断文件是否存在以及是否大于1G                                                
     	            if (f.exists()&&(f.length()/1024)+1>1024*1024) {  
     	            	///删除该文件                                                
     	                f.delete();      
     	            } else  if (!f.exists()){  
     	                createFile(f);
     	            }     
     	            BufferedReader input = new BufferedReader(new FileReader(f));  
     	  
     	            while ((str = input.readLine()) != null) {  
     	            	 s1 += str + "\r\n";    
     	            }  
     	            input.close();  
     	            BufferedWriter output = new BufferedWriter(new FileWriter(f));  
     	            output.write(s1);  
     	            output.write("<------------------------------------------------------------------------------------->\r\n");                                                
     	            output.write("操作时间　　："+ StringFormatter.getFormattedDate(new Date() ));    
     	            output.write("操作类型　：" + type + "\r\n");  
     	            output.write("操作模块名　　：" + moduleName + "\r\n");  
     	            output.write("操作人信息　：姓名-" + personName +"账号-"+userName+"操作人id-"+personId+ "\r\n");  
     	            output.write("操作描述：" + desc + "\r\n");                                                
     	            output.write("<------------------------------------------------------------------------------------->\r\n");                                                
     	            output.flush();                                                
     	            output.close();  
     	        } catch (Exception e) {  
     	            e.printStackTrace();  
     	  
     	        }  
     	  
     	}  
     	
     	 /**
  	    * 
  	   * @author 作者:wangwei
  	   * @version 创建时间：2015年4月21日 下午7:07:51 
  	   * @description 描述：记录登录日志
  	   * @return 返回值说明：
  	   * @param 参数：@param userName
  	   * @param 参数：@param personName
  	   * @param 参数：@param personId
  	    */
      	public static  void loginLogToTxt(String userName,String personName,String personId,int flag) {  
      	        String str = new String(); //原有txt内容  
      	        String s1 = new String();//内容更新  
      	        try {  
      	        	Date d = new Date();
    	        	String datatime = StringFormatter.formatDate(d);
    	        	datatime = datatime.replace("-", "");
    	            File f = new File(DatabaseUtils.logPath+datatime+"loginLog.txt");
      	            if (!f.getParentFile().exists()) {
      	            	   f.getParentFile().mkdirs();
      	            }
      	          ///判断文件是否存在以及是否大于1G                                             
      	            if (f.exists()&&(f.length()/1024)+1>1024*1024) {  
      	            	///删除该文件                                                
      	                f.delete();      
      	            } else  if (!f.exists()){  
      	                createFile(f);
      	            }     
      	            BufferedReader input = new BufferedReader(new FileReader(f));  
      	  
      	            while ((str = input.readLine()) != null) {  
      	            	 s1 += str + "\r\n";   
      	            }  
      	            input.close();  
      	            BufferedWriter output = new BufferedWriter(new FileWriter(f));  
      	            
      	            output.write(s1);  
      	            output.write("<------------------------------------------------------------------------------------->\r\n");                                                
	   	            output.write("登录时间　　："+ StringFormatter.getFormattedDate(new Date() ));    
	   	            output.write("登录账号    　：" + userName + "\r\n");  
	   	            if(flag==1){
	   	            	output.write("登录ip    　：" + getIp2(ServletActionContext.getRequest()) + "\r\n");  
	   	            }else{
	   	         	output.write("登录ip    　：" + getIpAddr(ServletActionContext.getRequest()) + "\r\n");  
	   	            }
	   	            
	   	            output.write("登录人信息　：姓名-" + personName +"     id-"+personId+ "\r\n");  
	   	            output.write("<------------------------------------------------------------------------------------->\r\n");                                                
      	            ///清空缓冲区内容，并把缓冲区内容写入基础流                                                
      	            output.flush();                                                
      	            ///关闭写数据流                                                
      	            output.close();  
      	        } catch (Exception e) {  
      	            e.printStackTrace();  
      	  
      	        }  
      	  
      	}  
      	
        public static String getIpAddr(HttpServletRequest request) { 
	            String ip = request.getHeader("x-forwarded-for"); 
	            if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	                ip = request.getHeader("Proxy-Client-IP"); 
	            } 
	            if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	                ip = request.getHeader("WL-Proxy-Client-IP"); 
	            } 
	            if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	                ip = request.getRemoteAddr(); 
	            } 
	            return ip; 
	        } 
      	/**
      	 * 
      	* @author 作者:wangwei
      	* @version 创建时间：2015年4月22日 上午11:44:02 
      	* @description 描述：
      	* @return 返回值说明：
      	* @param 参数：@param request
      	* @param 参数：@return
      	 */
      	public static String getIp2(HttpServletRequest request) {
            String ip = request.getHeader("X-Forwarded-For");
            if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
                //多次反向代理后会有多个ip值，第一个ip才是真实ip
                int index = ip.indexOf(",");
                if(index != -1){
                    return ip.substring(0,index);
                }else{
                    return ip;
                }
            }
            ip = request.getHeader("X-Real-IP");
            if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
                return ip;
            }
            return request.getRemoteAddr();
        }
}