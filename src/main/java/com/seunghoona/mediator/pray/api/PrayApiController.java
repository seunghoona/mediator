package com.seunghoona.mediator.pray.api;

import com.seunghoona.mediator.module.log.Description;
import com.seunghoona.mediator.pray.application.PrayApiService;
import com.seunghoona.mediator.pray.application.PrayTakeService;
import com.seunghoona.mediator.pray.dto.PrayRequest;
import com.seunghoona.mediator.pray.dto.PrayResponse;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prays")
public class PrayApiController {

	private final PrayApiService prayApiService;
	private final PrayTakeService prayTakeService;

	@GetMapping
	@Description("기도 다건 조회")
	public ResponseEntity<Page<PrayResponse>> getPrays(PrayRequest prayRequest, Pageable pageable) {
		return ResponseEntity.ok(prayApiService.getPrays(prayRequest, pageable));
	}

	@GetMapping("{id}")
	@Description("기도 단건 조회")
	public ResponseEntity<PrayResponse> getPray(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok(prayApiService.getPray(id));
	}

	@PostMapping
	@Description("기도 생성")
	public ResponseEntity<PrayResponse> createPray(PrayRequest prayRequest) {
		var uri = URI.create("");
		return ResponseEntity.created(uri).body(prayTakeService.takePray(prayRequest));
	}

}
