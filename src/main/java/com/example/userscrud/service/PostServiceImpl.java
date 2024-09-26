package com.example.userscrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userscrud.entity.Post;
import com.example.userscrud.repository.PostRepository;
import com.example.userscrud.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	
	public Post createPost(Post post) {
		return postRepository.save(post);
	}

}
