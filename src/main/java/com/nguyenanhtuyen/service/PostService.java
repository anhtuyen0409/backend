package com.nguyenanhtuyen.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.nguyenanhtuyen.model.AppUser;
import com.nguyenanhtuyen.model.Post;

public interface PostService {

	public Post savePost(AppUser appUser, HashMap<String, String> request, String postImageName);
	
	public List<Post> postList();
	
	public Post getPostById(Integer id);
	
	public List<Post> findPostByUsername(String username);
	
	public Post deletePost(Post post);
	
	public String savePostImage(MultipartFile multipartFile, String fileName);
	
}
