package com.seunghoona.mediator.pray.dto;

import com.seunghoona.mediator.pray.domain.Pray;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PrayRequest {

	private String content;

	public Pray toPray() {
		return Pray.builder()
			.content(content)
			.build();
	}

}
