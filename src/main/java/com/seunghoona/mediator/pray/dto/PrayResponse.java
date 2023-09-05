package com.seunghoona.mediator.pray.dto;

import com.seunghoona.mediator.pray.domain.Pray;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PrayResponse {

	private Long id;
	private String content;

	public static PrayResponse of(Pray pray) {
		return PrayResponse.builder()
			.id(pray.getId())
			.content(pray.getContent())
			.build();
	}

	public static List<PrayResponse> ofList(List<Pray> prays) {
		return prays.stream()
			.map(PrayResponse::of)
			.collect(Collectors.toList());
	}
}
