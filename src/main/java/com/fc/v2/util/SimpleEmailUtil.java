package com.fc.v2.util;

import com.fc.v2.common.conf.V2Config;
import com.fc.v2.common.spring.SpringUtils;
import com.fc.v2.model.auto.TSysEmail;
import com.fc.v2.model.custom.email.MailSenderInfo;
import com.fc.v2.model.custom.email.MyAuthenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * 简单邮件发送通用类
 * @ClassName: SimpleMailSender
 * 
 * @date 2019-06-09 23:57
 **/
public class SimpleEmailUtil {

	private static Logger logger = LoggerFactory.getLogger(SimpleEmailUtil.class);

	/**
	 * 以文本格式发送邮件
	 * @param mailInfo 待发送的邮件的信息
	 * @return
	 * @throws Exception
	 */
	public boolean sendTextMail(MailSenderInfo mailInfo) throws Exception {
		logger.info("构造一个发送邮件的session");
		// 判断是否需要身份认证
		MyAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		if (mailInfo.isValidate()) {
			// 如果需要身份认证，则创建一个密码验证器
			authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
		// 根据session创建一个邮件消息
		Message mailMessage = new MimeMessage(sendMailSession);
		// 创建邮件发送者地址
		Address from = new InternetAddress(mailInfo.getFromAddress());
		// 设置邮件消息的发送者
		mailMessage.setFrom(from);
		// 创建邮件的接收者地址，并设置到邮件消息中
		Address to = new InternetAddress(mailInfo.getToAddress());
		mailMessage.setRecipient(Message.RecipientType.TO, to);
		// 设置邮件消息的主题
		mailMessage.setSubject(mailInfo.getSubject());
		// 设置邮件消息发送的时间
		mailMessage.setSentDate(new Date());
		// 设置邮件消息的主要内容
		String mailContent = mailInfo.getContent();
		mailMessage.setText(mailContent);
		// 发送邮件
		Transport.send(mailMessage);
		logger.info("发送成功！");
		return true;
	}

	/**
	 * 以HTML格式发送邮件、以及附件
	 * @param mailInfo 待发送的邮件信息
	 */
	public boolean sendHtmlMail(MailSenderInfo mailInfo,List<File> fileList) throws Exception {
		// 判断是否需要身份认证
		MyAuthenticator authenticator = null;
		Properties pro = mailInfo.getProperties();
		// 如果需要身份认证，则创建一个密码验证器
		if (mailInfo.isValidate()) {
			authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
		}
		// 根据邮件会话属性和密码验证器构造一个发送邮件的session
		Session sendMailSession = Session.getInstance(pro, authenticator);
		// 根据session创建一个邮件消息
		Message mailMessage = new MimeMessage(sendMailSession);
		// 创建邮件发送者地址
		Address from = new InternetAddress(mailInfo.getFromAddress());
		// 设置邮件消息的发送者
		mailMessage.setFrom(from);
		// 创建邮件的接收者地址，并设置到邮件消息中
		Address to = new InternetAddress(mailInfo.getToAddress());
		// Message.RecipientType.TO属性表示接收者的类型为TO
		mailMessage.setRecipient(Message.RecipientType.TO, to);
		// 设置邮件消息的主题
		mailMessage.setSubject(mailInfo.getSubject());
		// 设置邮件消息发送的时间
		mailMessage.setSentDate(new Date());
		// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
		Multipart mainPart = new MimeMultipart();
		// 创建一个包含HTML内容的MimeBodyPart
		BodyPart html = new MimeBodyPart();
		// 设置HTML内容
		html.setContent(mailInfo.getContent(), "text/html; charset=utf-8");
		mainPart.addBodyPart(html);
		

        // 遍历添加附件
        if (fileList != null && fileList.size() > 0) {
            for (File file : fileList) {
                BodyPart attachmentBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(file);
                attachmentBodyPart.setDataHandler(new DataHandler(source));
                attachmentBodyPart.setFileName(file.getName());
                mainPart.addBodyPart(attachmentBodyPart);
            }
        }
		
		
		// 将MiniMultipart对象设置为邮件内容
		mailMessage.setContent(mainPart);
		//保存邮件
		mailMessage.saveChanges();
		// 发送邮件
		Transport.send(mailMessage);
		return true;
	}
	
	public static void sendEmail(TSysEmail tSysEmail) throws Exception {
		V2Config v2Config= SpringUtils.getBean(V2Config.class);
		// 这个类主要是设置邮件
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost(v2Config.getEmailSmtp());
		mailInfo.setMailServerPort(v2Config.getEmailPort());
		mailInfo.setValidate(true);
		mailInfo.setSsl(true);
		mailInfo.setUserName(v2Config.getEmailAccount());
		mailInfo.setPassword(v2Config.getEmailPassword());// 您的邮箱密码
		mailInfo.setFromAddress(mailInfo.getUserName());//发件人地址
		mailInfo.setToAddress(tSysEmail.getReceiversEmail());//收件人地址
		mailInfo.setSubject(tSysEmail.getTitle());
		mailInfo.setContent(tSysEmail.getContent());
		// 这个类主要来发送邮件
		SimpleEmailUtil sms = new SimpleEmailUtil();
		// sms.sendTextMail(mailInfo);//发送文体格式
		 // 附件
//        String fileName1 = "C:\\Users\\Administrator\\Desktop\\周报.txt";
//        File file1 = new File(fileName1);
//        String fileName2 = "C:\\Users\\Administrator\\Desktop\\111.rp";
//        File file2 = new File(fileName2);
//        List<File> fileList = new ArrayList<File>();
//        fileList.add(file1);
//        fileList.add(file2);
		sms.sendHtmlMail(mailInfo,null);// 发送html格式
	}



	 
	public static void main(String[] args) throws Exception {
		// 这个类主要是设置邮件
		MailSenderInfo mailInfo = new MailSenderInfo();
		mailInfo.setMailServerHost("smtp.sina.com");
		mailInfo.setMailServerPort("465");
		mailInfo.setValidate(true);
		mailInfo.setSsl(true);
		mailInfo.setUserName("CongCong@sina.com");
		mailInfo.setPassword("password");// 您的邮箱密码
		mailInfo.setFromAddress("CongCong@sina.com");//发件人地址
		mailInfo.setToAddress("CongCong@qq.com");//收件人地址
		mailInfo.setSubject("subject");
		mailInfo.setContent("<div class=\"content\" style=\"\" id=\"faqDetail\">\r\n"
				+ "  <div class=\"return\" style=\"display:none;\"><a href=\"/cgi-bin/help\">首页</a> » <a href=\"/cgi-bin/help?id=28\">客户端设置</a></div>\r\n"
				+ "  <h2>如何设置IMAP、POP3/SMTP及其SSL加密方式？ </h2>\r\n" + "  <div class=\"answer\">\r\n"
				+ "  <div><font color=\"#555555\">&nbsp;</font> \r\n" + "<div>如果您的电子邮件客户端支持SSL，可以在设置中选择使用SSL。</div>\r\n"
				+ "<div>&nbsp;</div>\r\n" + "</div>");
		// 这个类主要来发送邮件
		SimpleEmailUtil sms = new SimpleEmailUtil();
		// sms.sendTextMail(mailInfo);//发送文体格式
		 // 附件
        String fileName1 = "C:\\Users\\Administrator\\Desktop\\周报.txt";
        File file1 = new File(fileName1);
        String fileName2 = "C:\\Users\\Administrator\\Desktop\\111.rp";
        File file2 = new File(fileName2);
        List<File> fileList = new ArrayList<File>();
        fileList.add(file1);
        fileList.add(file2);
		sms.sendHtmlMail(mailInfo,fileList);// 发送html格式
	}

}
