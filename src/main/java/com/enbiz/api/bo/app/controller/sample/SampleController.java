package com.enbiz.api.bo.app.controller.sample;

import java.util.List;

import javax.validation.Valid;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enbiz.api.bo.app.dto.request.sample.SampleRequest;
import com.enbiz.api.bo.app.dto.response.sample.SampleResponse;
import com.enbiz.api.bo.app.entity.Sample;
import com.enbiz.api.bo.app.service.sample.SampleService;
import com.enbiz.api.bo.base.advice.ApiError;
import com.enbiz.common.base.exception.AppException;
import com.enbiz.common.base.rest.Response;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/samples")
@Lazy
@Slf4j
@RequiredArgsConstructor
public class SampleController {
	private final SampleService sampleService;

	@GetMapping("")
	public Response<List<SampleResponse>> getAllSamples() {
		return new Response<List<SampleResponse>>().setPayload(sampleService.getAllSamples());
	}

	@GetMapping("/{id}")
	public Response<SampleResponse> getSample(@PathVariable Long id,
			@RequestHeader(value = "test-header-key1", required = false) String testHeader1) {
		log.info("id: {}, testHeader1: {}", id, testHeader1);
		return new Response<SampleResponse>().setPayload(sampleService.getSample(id));
	}

	@GetMapping("/search")
	public Response<List<SampleResponse>> searchSamples(@RequestBody SampleRequest sampleRequest) {
		log.info("sampleRequest: {}", sampleRequest);
		return new Response<List<SampleResponse>>().setPayload(sampleService.searchSamples(sampleRequest));
	}

	@PostMapping("")
	public Response<String> registerSample(@RequestBody @Valid Sample sample) throws InterruptedException {
		log.info("sampleRequest: {}", sample);

		return new Response<String>();
	}

	@PutMapping("/{id}")
	public Response<String> saveSample(@PathVariable Long id, @RequestBody SampleRequest sampleRequest) {
		log.info("id: {}, sampleRequest: {}", id, sampleRequest);

		return new Response<String>();
	}

	@PatchMapping("/{id}")
	public Response<String> modifySample(@PathVariable Long id, @RequestBody SampleRequest sampleRequest) {
		log.info("id: {}, sampleRequest: {}", id, sampleRequest);

		return new Response<String>();
	}

	@DeleteMapping("/{id}")
	public Response<String> removeSample(@PathVariable Long id) {
		log.info("id: {}", id);

		return new Response<String>();
	}

	@GetMapping("/error")
	public Response<String> getError() {
		if (true) {
			AppException.exception(ApiError.UNKNOWN);
		}

		return new Response<String>();
	}

	/**
	 * void 유형으로 응답하면 안됩니다. Response<T> 유형으로 응답 해야합니다.
	 * 
	 * @param sampleParam
	 * @throws InterruptedException
	 * @deprecated
	 */
	@PostMapping("/void")
	public void registerVod(@RequestBody SampleRequest sampleRequest) throws InterruptedException {
		log.info("sampleRequest: {}", sampleRequest);
	}

}
