package com.dante.main.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dante.main.domain.posts.Posts;
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
		
		//given
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
				.author("dante0806@naver.com")
				.content("테스트 컨텐트")
				.title("테스트 타이틀")
				.build();
		
		//when
		postService.save(dto);
		
		//then
		Posts posts = postsRepository.findAll().get(0);
		assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
		assertThat(posts.getContent()).isEqualTo(dto.getContent());
		assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
	}
}
