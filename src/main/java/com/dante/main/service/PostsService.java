package com.dante.main.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dante.main.domain.posts.PostsRepository;
import com.dante.main.dto.posts.PostsMainResponseDto;
import com.dante.main.dto.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	
	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto dto){
		return postsRepository.save(dto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc(){
		return postsRepository.findAlldesc()
				.map(PostsMainResponseDto::new)	//람다식
			//	.map(posts -> new PostsMainResponseDto(posts)) ^^위와 동일한 기능의 코드
				.collect(Collectors.toList());
	}
}
