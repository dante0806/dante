package com.dante.main.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.dante.main.domain.posts.Posts;

import lombok.Getter;

@Getter
public class PostsMainResponseDto {
	private Long id;
	private String title;
	private String author;
	private String modifiedDate;
	
	public PostsMainResponseDto(Posts entity) {
		id = entity.getId();
		title = entity.getTitle();
		author = entity.getAuthor();
		modifiedDate = toStringDateTime(entity.getModifiedDate());
	}
	
	/**
     * Java 8 
     */
	private String toStringDateTime(LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return Optional.ofNullable(localDateTime)
				.map(formatter::format)
				.orElse("");
	}
	
	/**
     * Java 7 
     */
	private String toStringDataeTimeByjava7(LocalDateTime localDateTime){
		if(localDateTime == null){
			return "";
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return formatter.format(localDateTime);
	}
}
