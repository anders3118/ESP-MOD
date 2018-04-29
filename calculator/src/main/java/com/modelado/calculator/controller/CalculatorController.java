package com.modelado.calculator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

@RestController
@RequestMapping(value = "/calculator", method = RequestMethod.GET)
public class CalculatorController {

	@RequestMapping(value = "/add/**")
	public ResponseEntity<String> add(HttpServletRequest request) {
		ResponseEntity<String> response = null;
		Long result = null;

		try {
			String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
			List<Long> listInteger = CalculatorUtil.getIntegersFromPath(path.replaceAll("calculator/add/", ""));
			result = listInteger.stream().reduce(Long::sum).get().longValue();
			response = new ResponseEntity<>(String.format("Result = %s", result), HttpStatus.OK);
			return response;
		} catch (RuntimeException e) {
			response = new ResponseEntity<String>("Bad request, invalid parameters", HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	@RequestMapping(value = "/subs/**")
	public ResponseEntity<String> subs(HttpServletRequest request) {
		ResponseEntity<String> response = null;
		Long result = null;

		try {
			String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
			List<Long> listInteger = CalculatorUtil.getIntegersFromPath(path.replaceAll("calculator/subs/", ""));
			result = listInteger.stream().reduce((a, b) -> a - b).get().longValue();
			response = new ResponseEntity<>(String.format("Result = %d", result), HttpStatus.OK);
			return response;
		} catch (RuntimeException e) {
			response = new ResponseEntity<String>("Bad request, invalid parameters", HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	@RequestMapping(value = "/mult/**")
	public ResponseEntity<String> mult(HttpServletRequest request) {
		ResponseEntity<String> response = null;
		Long result = null;

		try {
			String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
			List<Long> listInteger = CalculatorUtil.getIntegersFromPath(path.replaceAll("calculator/mult/", ""));
			result = listInteger.stream().reduce((a, b) -> a * b).get().longValue();
			response = new ResponseEntity<>(String.format("Result = %d", result), HttpStatus.OK);
			return response;
		} catch (RuntimeException e) {
			response = new ResponseEntity<String>("Bad request, invalid parameters", HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	@RequestMapping(value = "/div/**")
	public ResponseEntity<String> div(HttpServletRequest request) {
		ResponseEntity<String> response = null;
		Double result = null;

		try {
			String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
			List<Double> listDouble = CalculatorUtil.getDoublesFromPath(path.replaceAll("calculator/div/", ""));
			result = listDouble.stream().reduce((a, b) -> a / b).get().doubleValue();
			response = new ResponseEntity<>(String.format("Result = %.2f", result), HttpStatus.OK);
			return response;
		} catch (RuntimeException e) {
			response = new ResponseEntity<String>("Bad request, invalid parameters", HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}
