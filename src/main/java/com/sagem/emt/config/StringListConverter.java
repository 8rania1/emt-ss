package com.sagem.emt.config;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import jakarta.persistence.AttributeConverter;

public class StringListConverter implements AttributeConverter<List<String>, String> {
	@Override
	public String convertToDatabaseColumn(List<String> list) {
		return StringUtils.join(list, ",");
	}

	@Override
	public List<String> convertToEntityAttribute(String joined) {
		String[] permissions = StringUtils.split(joined, ",");
		return permissions == null ? null : Arrays.asList(permissions);
	}
}
