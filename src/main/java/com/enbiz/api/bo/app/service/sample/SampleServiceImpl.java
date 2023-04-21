package com.enbiz.api.bo.app.service.sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.enbiz.api.bo.app.dto.request.sample.SampleRequest;
import com.enbiz.api.bo.app.dto.response.sample.SampleResponse;
import com.enbiz.api.bo.app.repository.replica.sample.SampleMapper;
import com.enbiz.api.bo.base.advice.ApiError;
import com.enbiz.common.base.exception.AppException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Lazy
@Slf4j
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {
	private final SampleMapper sampleMapper;

	@Value("${sample.prop}")
	private String sampleProp;

	@Override
	public List<SampleResponse> getAllSamples() {
		log.debug("sample prop: {}", sampleProp);
		return sampleMapper.selectAllSamples();
	}

	@Override
	public SampleResponse getSample(Long id) {
		SampleResponse sampleResponse = sampleMapper.selectSampleById(id).orElse(null);
		if (sampleResponse == null) {
			AppException.exception(ApiError.DATA_NOT_FOUND);
		}
		return sampleResponse;
	}

	@Override
	public List<SampleResponse> searchSamples(SampleRequest sampleRequest) {
		return sampleMapper.selectSamples(sampleRequest);
	}

}
