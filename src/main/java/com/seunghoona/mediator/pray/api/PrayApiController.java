package com.seunghoona.mediator.pray.api;

import com.seunghoona.mediator.module.log.Description;
import com.seunghoona.mediator.pray.application.PrayService;
import com.seunghoona.mediator.pray.dto.PrayRequest;
import com.seunghoona.mediator.pray.dto.PrayResponse;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prays")
public class PrayApiController {

	private final PrayService prayService;

	@GetMapping
	@Description("기도 다건 조회")
	public ResponseEntity<Page<PrayResponse>> getPrays(PrayRequest prayRequest, Pageable pageable) {
		return ResponseEntity.ok(prayService.getPrays(prayRequest, pageable));
	}

	@GetMapping("{id}")
	@Description("기도 단건 조회")
	public ResponseEntity<PrayResponse> getPray(@PathVariable(value = "id") Long id) {
		return ResponseEntity.ok(prayService.getPray(id));
	}

	@PostMapping
	@Description("기도 생성")
	public ResponseEntity<PrayResponse> createPray(PrayRequest prayRequest) {
		var uri = URI.create("");
		return ResponseEntity.created(uri).body(prayService.takePray(prayRequest));
	}

	@DeleteMapping
	@Description("기도 삭제")
	public ResponseEntity<Void> removePray(Long id) {
		prayService.remove(id);
		return ResponseEntity.noContent().build();
	}

}
