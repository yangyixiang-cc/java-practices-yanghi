package com.ebooks.dao;

import java.util.List;

public interface FileDao {
	/*
	 * ��ʾ�鼮Ŀ¼
	 */
	public List<String> showML(String bookName) throws Exception;
	/*
	 * �Ķ��鼮
	 */
	public StringBuilder readBooks(String bookName,int chapter) throws Exception;
	
}
