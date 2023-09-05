package com.seunghoona.mediator.pray.application;

import com.seunghoona.mediator.pray.domain.PrayRepository;
import com.seunghoona.mediator.pray.dto.PrayRequest;
import com.seunghoona.mediator.pray.dto.PrayResponse;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrayServiceImpl implements
	PrayService {

	private final PrayRepository prayRepository;

	@Override
	public Page<PrayResponse> getPrays(PrayRequest prayRequest, Pageable pageable) {
		var findPrays = prayRepository.findAll(pageable);
		return PrayResponse.ofList(findPrays);
	}

	@Override
	public PrayResponse getPray(Long id) {
		var findPray = prayRepository.findById(id)
			.orElseThrow(EntityNotFoundException::new);
		return PrayResponse.of(findPray);
	}

	@Override
	public void remove(Long id) {
		var findPray = prayRepository.findById(id)
			.orElseThrow(EntityNotFoundException::new);

		prayRepository.delete(findPray);
	}
}
