package com.seunghoona.mediator.pray.application;

import com.seunghoona.mediator.pray.dto.PrayRequest;
import com.seunghoona.mediator.pray.dto.PrayResponse;
import java.util.List;

public interface PrayApiService {

	List<PrayResponse> getPrays(PrayRequest prayRequest);

	PrayResponse getPray(Long prayRequest);

}
