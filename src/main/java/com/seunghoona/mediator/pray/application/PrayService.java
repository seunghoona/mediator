package com.seunghoona.mediator.pray.application;

import com.seunghoona.mediator.pray.dto.PrayRequest;
import com.seunghoona.mediator.pray.dto.PrayResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PrayService {

	Page<PrayResponse> getPrays(PrayRequest prayRequest, Pageable pageable);

	PrayResponse getPray(Long prayRequest);

}
