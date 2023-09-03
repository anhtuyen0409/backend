package com.nguyenanhtuyen.service;

import com.nguyenanhtuyen.model.Post;

public interface CommentService {

	public void saveComment(Post post, String username, String content);
	
}
