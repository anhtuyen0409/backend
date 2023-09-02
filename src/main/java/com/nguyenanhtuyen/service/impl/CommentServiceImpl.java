package com.nguyenanhtuyen.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyenanhtuyen.model.Comment;
import com.nguyenanhtuyen.repository.CommentRepository;
import com.nguyenanhtuyen.service.CommentService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository commentRepo;

	@Override
	public void saveComment(Comment comment) {
		commentRepo.save(comment);
	}

}
