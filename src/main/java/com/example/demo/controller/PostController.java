package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.PostDto;
import com.example.demo.model.Post;
import com.example.demo.service.PostService;
@RestController
public class PostController {

	@Autowired
	PostService postService;
	@PostMapping("/post")
	public void create(@RequestBody PostDto postDto)
	{
		postService.createPost(postDto);
	}
	
	@DeleteMapping("/post/{id}")
	@Transactional
	public void deletePost(@PathVariable Long id)
	{
		postService.deletePost(id);
	}
	@GetMapping("/post/{id}")
	public Optional<Post> getParticular(@PathVariable Long id)
	{
		return postService.getPostParticular(id);
	}
	@GetMapping("/post")
	public List<Post> getAll()
	{
		return postService.getAllPosts();
	}
}
