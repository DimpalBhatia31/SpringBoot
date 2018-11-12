package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PostComment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	String postComment;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JsonBackReference
	Post post;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public String getPostComment() {
		return postComment;
	}
	public void setPostComment(String postComment) {
		this.postComment = postComment;
	}
	
	
}
