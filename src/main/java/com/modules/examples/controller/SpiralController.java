package com.modules.examples.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpiralController {

	@Autowired
	private SpiralService spiralService;

	@ResponseBody
	@RequestMapping(value="/getMatrix",method=RequestMethod.GET)
	public List<Integer> spiralMatrix(@RequestParam(value = "rows") Integer rows,
			@RequestParam(value = "columns") Integer columns,
			@RequestParam(value = "matrixValues") String matrixValues) {
		return spiralService.getMatrixValues(rows, columns, matrixValues);
	}
}
