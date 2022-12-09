package stock;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

/**
 * 发送邮件工具类
 * */
public class SendEmailUtil {
    private static String emailSTMP = "smtp.qq.com";
    private static boolean sslFlag = true;
    private static String sendPresonEmail = "3530711398@qq.com";
    private static String sendPresonName = "大宇";
    private static String sendCharset="GBK";
    private static String sendPwd="odhioskhicqrchab";

    /**
     * 发送邮件
     */
        public static boolean sendEmail(String recvPresonEmail, String titleText, String desc) {

        boolean flag = true;
        Properties props = new Properties();
        // 设置发送邮件的邮件服务器的属性
        props.put("mail.smtp.host", emailSTMP);
        if(sslFlag) {
            props.setProperty("mail.smtp.ssl.enable", "true");
            //设置为ssl
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            //邮箱发送服务器端口
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");

            props.put("mail.smtp.starttls.enable", true);
        }
        // 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
        props.put("mail.smtp.auth", "true");
        // 用刚刚设置好的props对象构建一个session
        Session session = Session.getDefaultInstance(props);
        // 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使
        // 用（你可以在控制台（console)上看到发送邮件的过程）
        session.setDebug(true);
        // 用session为参数定义消息对象
        MimeMessage message = new MimeMessage(session);
        try {
            // 加载发件人地址
            message.setFrom(new InternetAddress(sendPresonEmail,sendPresonName,sendCharset));
            // 加载收件人地址
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recvPresonEmail));

            // 加载标题
            message.setSubject(titleText);
            // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            Multipart multipart = new MimeMultipart();

            // 设置邮件的文本内容
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(desc,"text/html;charset=UTF-8");
            multipart.addBodyPart(contentPart);

            // 将multipart对象放到message中
            message.setContent(multipart);
            // 保存邮件
            message.saveChanges();
            // 发送邮件
            Transport transport = session.getTransport("smtp");
            // 连接服务器的邮箱
            transport.connect(emailSTMP, sendPresonEmail, sendPwd);
            // 把邮件发送出去
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        sendEmail("1064592074@qq.com","111","2222");
    }
}
