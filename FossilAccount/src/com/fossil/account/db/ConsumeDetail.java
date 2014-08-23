package com.fossil.account.db;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Table;

@Table(name = "consumedetail", execAfterTableCreated = "CREATE UNIQUE INDEX index_name ON consumekind(detailid,userid,time,kindid,money,tips)")
public class ConsumeDetail {
	@Column(column = "detailid")
	public String detailid;
	@Column(column = "userid")
	public String userid;
	@Column(column = "time")
	public String time;
	@Column(column = "kindid")
	public String kindid;
	@Column(column = "money")
	public String money;
	@Column(column = "tips")
	public String tips;

	public String getDetailId() {
		return detailid;
	}

	public void setDetailId(String detailid) {
		this.detailid = detailid;
	}

	public String getUserId() {
		return userid;
	}

	public void setUserId(String userid) {
		this.userid = userid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getKindId() {
		return kindid;
	}

	public void setKindId(String kindid) {
		this.kindid = kindid;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}
}
