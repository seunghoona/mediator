package com.seunghoona.mediator.pray.api;

import com.seunghoona.mediator.module.log.Description;
import com.seunghoona.mediator.pray.application.PrayApiService;
import com.seunghoona.mediator.pray.dto.PrayRequest;
import com.seunghoona.mediator.pray.dto.PrayResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prays")
public class PrayApiController {

	private final PrayApiService prayApiService;

	@GetMapping
	@Description("기도 다건 조회")
	public ResponseEntity<List<PrayResponse>> getPrays(PrayRequest prayRequest) {
		return ResponseEntity.ok(prayApiService.getPrays(prayRequest));
	}

	@GetMapping("{id}")
	@Description("기도 단건 조회")
	public ResponseEntity<PrayResponse> getPray(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok(prayApiService.getPray(id));
	}


}
