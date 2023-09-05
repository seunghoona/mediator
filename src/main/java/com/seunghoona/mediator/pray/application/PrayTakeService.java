package com.seunghoona.mediator.pray.application;

import com.seunghoona.mediator.pray.dto.PrayRequest;
import com.seunghoona.mediator.pray.dto.PrayResponse;


public interface PrayTakeService {
	PrayResponse takePray(PrayRequest prayRequest);
}
