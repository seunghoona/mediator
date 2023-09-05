package com.seunghoona.mediator.pray.dto;

import com.seunghoona.mediator.pray.domain.Pray;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;

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

	public static Page<PrayResponse> ofList(Page<Pray> prays) {
		return prays.map(PrayResponse::of);
	}
}
