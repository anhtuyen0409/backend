package com.nguyenanhtuyen.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nguyenanhtuyen.model.AppUser;
import com.nguyenanhtuyen.model.Post;
import com.nguyenanhtuyen.repository.PostRepository;
import com.nguyenanhtuyen.service.PostService;
import com.nguyenanhtuyen.util.Constants;

@Service
@Transactional
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepository postRepo;

	@Override
	public Post savePost(AppUser appUser, HashMap<String, String> request, String postImageName) {
		String caption = request.get("caption");
		String location = request.get("location");
		Post post = new Post();
		post.setCaption(caption);
		post.setLocation(location);
		post.setUsername(appUser.getUsername());
		post.setPostedDate(new Date());
		post.setUserImageId(appUser.getId());
		appUser.setPost(post);
		postRepo.save(post);
		return post;
	}

	@Override
	public List<Post> postList() {
		return postRepo.findAll();
	}

	@Override
	public Post getPostById(Integer id) {
		return postRepo.findPostById(id);
	}

	@Override
	public List<Post> findPostByUsername(String username) {
		return postRepo.findPostByUsername(username);
	}

	@Override
	public Post deletePost(Post post) {
		try {
			Files.deleteIfExists(Paths.get(Constants.POST_FOLDER + "/" + post.getName() + ".png"));
			postRepo.deletePostById(post.getId());
			return post;
		} catch (Exception e) {
			return null;
		}	
	}

	@Override
	public String savePostImage(MultipartFile multipartFile, String fileName) {
		try {
			byte[] bytes = multipartFile.getBytes();
			Path path = Paths.get(Constants.POST_FOLDER + fileName + ".png");
			Files.write(path, bytes, StandardOpenOption.CREATE);
		} catch (IOException e) {
			System.out.println("Error occured. Photo not saved!");
			return "Error occured. Photo not saved!";
		}
		System.out.println("Photo saved successfully!");
		return "Photo saved successfully!";
	}

}
