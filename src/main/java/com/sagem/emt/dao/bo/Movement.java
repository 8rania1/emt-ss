package com.sagem.emt.dao.bo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Movement {
	private LocalDateTime date;
	private String direction;
	private String equipment;
	private String reason;
}
