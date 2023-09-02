package com.nguyenanhtuyen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyenanhtuyen.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
