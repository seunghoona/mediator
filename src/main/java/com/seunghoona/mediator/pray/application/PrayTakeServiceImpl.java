package com.seunghoona.mediator.pray.application;

import com.seunghoona.mediator.pray.domain.PrayRepository;
import com.seunghoona.mediator.pray.dto.PrayRequest;
import com.seunghoona.mediator.pray.dto.PrayResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrayTakeServiceImpl implements
	PrayTakeService {

	private final PrayRepository prayRepository;

	@Override
	public PrayResponse takePray(PrayRequest prayRequest) {
		var pray = prayRequest.toPray();
		return PrayResponse.of(prayRepository.save(pray));
	}

}
