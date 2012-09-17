package com.rdpgroupbd.apps.smvc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class AuditUser implements Serializable {

	private static final long serialVersionUID = 7633980225509154662L;

	@Column(name = "F_REGISTER_USER")
	private Integer entryUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "F_REGISTER_DATE")
	private Date entryDate;

	@Column(name = "F_REVISION_USER", insertable = false)
	private Integer reviseUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "F_REVISION_DATE", insertable = false)
	private Date reviseDate;

	public Integer getEntryUser() {
		return entryUser;
	}

	public void setEntryUser(Integer entryUser) {
		this.entryUser = entryUser;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Integer getReviseUser() {
		return reviseUser;
	}

	public void setReviseUser(Integer reviseUser) {
		this.reviseUser = reviseUser;
	}

	public Date getReviseDate() {
		return reviseDate;
	}

	public void setReviseDate(Date reviseDate) {
		this.reviseDate = reviseDate;
	}

}
