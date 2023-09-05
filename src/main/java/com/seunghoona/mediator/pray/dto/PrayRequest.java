package com.seunghoona.mediator.pray.dto;

import com.seunghoona.mediator.pray.domain.Pray;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PrayRequest {

	public Pray toPray() {

		return Pray.builder().build();
	}

}
