package com.sagem.emt.dao.bo;

import com.sagem.emt.dao.entity.MovementDirection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovementDirectionCount {
	private MovementDirection direction;
	private Long count;

}
