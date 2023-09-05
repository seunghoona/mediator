package com.seunghoona.mediator.pray.application;

import com.seunghoona.mediator.pray.domain.Pray;
import com.seunghoona.mediator.pray.domain.PrayRepository;
import com.seunghoona.mediator.pray.dto.PrayRequest;
import com.seunghoona.mediator.pray.dto.PrayResponse;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrayApiServiceImpl implements
	PrayApiService {

	private final PrayRepository prayRepository;

	@Override
	public List<PrayResponse> getPrays(PrayRequest prayRequest) {
		return PrayResponse.ofList(prayRepository.findAll());
	}

	@Override
	public PrayResponse getPray(Long id) {
		var pray = prayRepository.findById(id)
			.orElseThrow(EntityNotFoundException::new);
		return PrayResponse.of(pray);
	}
}
