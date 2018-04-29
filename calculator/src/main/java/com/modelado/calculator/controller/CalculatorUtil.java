package com.modelado.calculator.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorUtil {

	private static final String SLASH = "/";
	private static final String REGEX = "(\\/((-|\\+)?(\\d)+(\\/)?))+";

	/**
	 * 
	 * @param path
	 * @return
	 */
	public static List<Long> getIntegersFromPath(String path) {

		if (path.matches(REGEX)) {
			List<Long> listIntegers = new ArrayList<>();
			List<String> parts = Arrays.asList(path.split(SLASH));

			listIntegers = parts.stream().skip(1).map(Long::parseLong).collect(Collectors.toList());

			return listIntegers;
		}
		throw new RuntimeException("Invalid parameters");
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	public static List<Double> getDoublesFromPath(String path) {

		if (path.matches(REGEX)) {
			List<Double> listDoubles = new ArrayList<>();
			List<String> parts = Arrays.asList(path.split(SLASH));

			listDoubles = parts.stream().skip(1).map(Double::parseDouble).collect(Collectors.toList());

			return listDoubles;
		}
		throw new RuntimeException("Invalid parameters");
	}
}
