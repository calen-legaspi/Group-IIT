package com.onb.shoppingcart.web.binder;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;

public class BigDecimalToString implements Converter<BigDecimal, String> {

	@Override
	public String convert(BigDecimal b) {
		return b.toString();
	}

}
