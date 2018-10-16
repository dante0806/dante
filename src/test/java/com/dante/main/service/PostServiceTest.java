package com.dante.main.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dante.main.domain.posts.PostsRepository;
import com.dante.main.domain.posts.PostsSaveRequestDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {

	@Autowired
	private PostsService postService;
	
	@Autowired
	private PostsRepository postsRepository;
	
	@After
	public void cleanup(){
		postsRepository.deleteAll();
	}
	
	@Test
	public void insertDtoDataToPostsTable (){
		
		//PostsSaveRequestDto dto = Posts
	}
}
