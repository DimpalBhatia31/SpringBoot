package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PostDto;
import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;

@Service
public class PostService {
	@Autowired 
	PostRepository postReo;
	public void createPost(PostDto postDto)
	{
		Post post=new Post();
		post.setPostName(postDto.getPostName());
		post.setPostUSer(postDto.getPostUser());
		postReo.save(post);
	}
	
	public void deletePost(Long id)
	{
		postReo.deleteById(id);
	}
	
	public Optional<Post> getPostParticular(Long id)
	{
		return postReo.findById(id);	
	}
	public List<Post> getAllPosts()
	{
		return postReo.findAll();
	}
	
//	public void set

}
