package com.fossil.account.db;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Table;

// �������ע�⣬ �������������Ӱ��
@Table(name = "user", execAfterTableCreated = "CREATE UNIQUE INDEX index_name ON user(userid,nickname,level,logo)")
public class User extends EntityBase {

	@Column(column = "userid")
	// �������ע�⣬ ��������������Ӱ��
	public String userid;
	@Column(column = "nickname")
	public String nickname;
	@Column(column = "level")
	public String level;
	@Column(column = "logo")
	public String logo;

	public String getUserID() {
		return userid;
	}

	public void setUserID(String userid) {
		this.userid = userid;
	}

	public String getNickName() {
		return nickname;
	}

	public void setNickName(String nickname) {
		this.nickname = nickname;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
}
