package com.rdpgroupbd.apps.util.log4j;

import java.util.Date;

import org.apache.log4j.net.SMTPAppender;

import com.rdpgroupbd.apps.util.DateUtil;

public class MailAppender extends SMTPAppender {

	@Override
	public void setSubject(String subject) {
		String date = DateUtil.format(new Date(), "MMM dd, yyyy HH:mm:ss a");
		subject = String.format("%s [%s]", subject, date.toUpperCase());
		super.setSubject(subject);
	}

}
