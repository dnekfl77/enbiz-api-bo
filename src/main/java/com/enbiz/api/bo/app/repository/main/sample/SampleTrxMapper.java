package com.enbiz.api.bo.app.repository.main.sample;

import com.enbiz.api.bo.app.entity.Sample;

public interface SampleTrxMapper {
	void insertSample(Sample sample);

	void updateSample(Sample sample);

	void deleteSample(Long id);
}
