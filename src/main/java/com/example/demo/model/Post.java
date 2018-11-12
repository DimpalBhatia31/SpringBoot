package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	String postName;
	String postUSer;
	int noOfComments;
	
/*	@OneToMany
	@JoinColumn(name="post_id") // it create new column in Post_comment table name as post_id and if we comment 
	// this line then a new table will create with two columns
	*/
	 @OneToMany(cascade=CascadeType.PERSIST)
    @JoinTable(name="Post_Comment_record", joinColumns={@JoinColumn(name="Post_id", referencedColumnName="id")}
    , inverseJoinColumns={@JoinColumn(name="Post_comment_id", referencedColumnName="id")})
	 @JsonManagedReference
	List<PostComment> commentList;
	 
	public List<PostComment> getCommentList() {
		return commentList;
	}
	public int getNoOfComments() {
		return noOfComments;
	}
	public void setNoOfComments(int noOfComments) {
		this.noOfComments = noOfComments;
	}
	public void setCommentList(List<PostComment> commentList) {
		this.commentList = commentList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	public String getPostUSer() {
		return postUSer;
	}
	public void setPostUSer(String postUSer) {
		this.postUSer = postUSer;
	}
	

}
