package com.nguyenanhtuyen.service.impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenanhtuyen.model.Comment;
import com.nguyenanhtuyen.model.Post;
import com.nguyenanhtuyen.repository.CommentRepository;
import com.nguyenanhtuyen.service.CommentService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentRepo;

	@Override
	public void saveComment(Post post, String username, String content) {
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setUsername(username);
		comment.setPostedDate(new Date());
		post.setComments(comment);
		commentRepo.save(comment);
	}

}
