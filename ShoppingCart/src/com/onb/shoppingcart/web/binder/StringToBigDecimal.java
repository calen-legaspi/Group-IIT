package com.onb.shoppingcart.web.binder;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;

public class StringToBigDecimal implements Converter<String, BigDecimal> {

	@Override
	public BigDecimal convert(String bidDecimal) {
		return new BigDecimal(bidDecimal);
	}

}
