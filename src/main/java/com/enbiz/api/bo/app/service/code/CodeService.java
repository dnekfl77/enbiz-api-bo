package com.enbiz.api.bo.app.service.code;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.enbiz.api.bo.app.dto.code.CodeReqDto;
import com.enbiz.api.bo.app.dto.code.CodeResDto;
import com.enbiz.api.bo.app.entity.StStdCd;
import com.enbiz.api.bo.app.enums.common.MIXEDCODE;
import com.enbiz.api.bo.app.repository.main.code.CodeMapper;

import lombok.RequiredArgsConstructor;

@Service
@Lazy
@RequiredArgsConstructor
public class CodeService {

	private final CodeMapper codeMapper;

	/**
	 * 공통코드 조회
	 * 
	 * @param grpCds
	 * @return
	 */
	public Map<String, List<StStdCd>> getStStdCd(String grpCds) {
		String[] params = grpCds.toUpperCase().split(",");
		List<StStdCd> stdCdEntityList = codeMapper.getStStdCd(params);
		return stdCdEntityList.stream().collect(Collectors.groupingBy(StStdCd::getGrpCd));
	}

	/**
	 * 공통코드 역순 조회
	 * 
	 * @param grpCds
	 * @return
	 */
	public Map<String, List<StStdCd>> getReverseStStdCd(String grpCds) {
		String[] params = grpCds.toUpperCase().split(",");
		List<StStdCd> stdCdEntityList = codeMapper.getStStdCd(params);
		Collections.reverse(stdCdEntityList);
		return stdCdEntityList.stream().collect(Collectors.groupingBy(StStdCd::getGrpCd));
	}

	public Map<String, List<CodeResDto>> getForwardCdCdNmFromStStdCdByArrayGrpCd(String grpCds) throws Exception {
		String[] params = grpCds.toUpperCase().split(",");

		List<CodeResDto> resonseList = codeMapper.getCdCdNmFromStStdCdByArrayGrpCd(params);

		Map<String, List<CodeResDto>> collect = resonseList.stream().collect(Collectors.groupingBy(CodeResDto::getKey));

		return collect;
	}

	public Map<String, List<CodeResDto>> getReverseCdCdNmFromStStdCdByArrayGrpCd(String grpCds) throws Exception {
		String[] params = grpCds.toUpperCase().split(",");

		List<CodeResDto> resonseList = codeMapper.getCdCdNmFromStStdCdByArrayGrpCd(params);

		Collections.reverse(resonseList);

		Map<String, List<CodeResDto>> collect = resonseList.stream().collect(Collectors.groupingBy(CodeResDto::getKey));

		return collect;
	}

	public Map<String, List<CodeResDto>> getForwardCdCdNmFromCcSiteBaseByEmpty() throws Exception {
		List<CodeResDto> stdCdEntityList = codeMapper.getCdCdNmFromCcSiteBaseByEmpty();

		Map<String, List<CodeResDto>> collect = stdCdEntityList.stream()
				.collect(Collectors.groupingBy(CodeResDto::getKey));

		return collect;
	}

	public Map<String, List<CodeResDto>> getForwardCdCdNmFromStStdCdByGrpCdRef1Val(CodeReqDto params) throws Exception {
		List<CodeResDto> resonseList = codeMapper.getCdCdNmFromStStdCdByGrpCdRef1Val(params);

		Map<String, List<CodeResDto>> collect = resonseList.stream().collect(Collectors.groupingBy(CodeResDto::getKey));

		return collect;
	}

	public Map<String, List<CodeResDto>> getForwardCdCdNmByMixedCode(List<CodeReqDto> params) throws Exception {
		Map<String, List<CodeResDto>> codeToReferResponseDto = new HashMap<>();

		for (CodeReqDto codeReqDto : params) {
			if (StringUtils.equals(MIXEDCODE.TABLE.getCd(), codeReqDto.getType())) {
				if (StringUtils.equals("SITE", codeReqDto.getCode())
						&& StringUtils.equals("CC_SITE_BASE", codeReqDto.getReferCode())) {
					Map<String, List<CodeResDto>> codeList = this.getForwardCdCdNmFromCcSiteBaseByEmpty();

					for (Map.Entry<String, List<CodeResDto>> entry : codeList.entrySet()) {
						codeToReferResponseDto.put(entry.getKey(), entry.getValue());
					}
				}
			}
			if (StringUtils.equals(MIXEDCODE.NORMAL_CODE.getCd(), codeReqDto.getType())) {
				Map<String, List<CodeResDto>> codeList = this
						.getForwardCdCdNmFromStStdCdByArrayGrpCd(codeReqDto.getCode());

				for (Map.Entry<String, List<CodeResDto>> entry : codeList.entrySet()) {
					codeToReferResponseDto.put(entry.getKey(), entry.getValue());
				}
			}
			if (StringUtils.equals(MIXEDCODE.NORMAL_MULTI_CODE.getCd(), codeReqDto.getType())) {
				Map<String, List<CodeResDto>> codeList = this
						.getForwardCdCdNmFromStStdCdByArrayGrpCd(codeReqDto.getCode());

				for (Map.Entry<String, List<CodeResDto>> entry : codeList.entrySet()) {
					codeToReferResponseDto.put(entry.getKey(), entry.getValue());
				}
			}
			if (StringUtils.equals(MIXEDCODE.REFER_CODE.getCd(), codeReqDto.getType())) {
				Map<String, List<CodeResDto>> codeList = this.getForwardCdCdNmFromStStdCdByGrpCdRef1Val(codeReqDto);

				for (Map.Entry<String, List<CodeResDto>> entry : codeList.entrySet()) {
					codeToReferResponseDto.put(entry.getKey(), entry.getValue());
				}
			}
		}

		return codeToReferResponseDto;
	}
}
