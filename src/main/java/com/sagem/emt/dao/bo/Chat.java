package com.sagem.emt.dao.bo;

import java.time.LocalDateTime;

import com.sagem.emt.dao.entity.User;

import lombok.Data;

@Data
public class Chat {
	private User user;
	private String message;
	private LocalDateTime date;
}
