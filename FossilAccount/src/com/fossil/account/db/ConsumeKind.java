package com.fossil.account.db;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Table;

@Table(name = "consumekind", execAfterTableCreated = "CREATE UNIQUE INDEX index_name ON consumekind(kindid,kinddes)")
public class ConsumeKind {
	@Column(column = "kindid")
	public String kindid;
	@Column(column = "kinddes")
	public String kinddes;

	public String getKindId() {
		return kindid;
	}

	public void setKindId(String kindid) {
		this.kindid = kindid;
	}

	public String getKindDes() {
		return kinddes;
	}

	public void setKindDes(String kinddes) {
		this.kinddes = kinddes;
	}
}
