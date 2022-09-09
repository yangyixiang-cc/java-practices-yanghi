package com.nnrs.socket.server.service;

import java.io.InputStream;
import java.util.List;

import com.nnrs.socket.entity.History;
import com.nnrs.socket.entity.Novel;
import com.nnrs.socket.entity.User;

public interface ShareService {

	/**
	 * 搜索图书
	 * 网络模糊搜索
	 * 图书名字或图书id
	 * @param novel
	 * @return
	 */
	List<Novel> selectNovel(String novel) throws Exception;	
	/**
	 * 书籍排行榜 排行榜的前十名
	 * @return
	 */
	List<Novel> rankingList() throws Exception;
	
}
