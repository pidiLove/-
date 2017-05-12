package com.pa.park.core.enumtype;
/** 
 * @author wangpei 
 * @version 创建时间：2017年5月12日 下午11:28:01 
 * 类说明 
 */
public enum AuthorityType {
	TOURIST("游客", 0),
	NORMAL("普通用户", 1),
//	ADMIN("实验室管理员", 2),
//	ROOT("超级管理员", 3),
	;
	private String name;
	private int index;
	
	private AuthorityType(String name, int index){
		this.name = name;
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
