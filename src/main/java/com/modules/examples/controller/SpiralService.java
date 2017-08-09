package com.modules.examples.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SpiralService {

	public List<Integer> getMatrixValues(int rows, int cols, String values) {
		int noOfRows = rows;
		int noOfColumns = cols;
		int f = 0;
		java.util.List<Integer> response = new LinkedList<Integer>();
		String matrix = values;
		String[] testStringValues = matrix.split(" ");
		int[] testValues = new int[(noOfRows * noOfColumns)];
		for (f = 0; f < testStringValues.length; f++) {
			testValues[f] = Integer.parseInt(testStringValues[f]);
		}

		int val = 0;
		int[][] a = new int[noOfRows][noOfColumns];
		for (int r = 0; r < a.length; r++) {
			for (int c = 0; c < a[r].length; c++) {
				a[r][c] = testValues[val];
				val++;
			}
		}
		int iterator = 0;
		int firstRowIndex = 0;
		int firstColumnIndex = 0;
		while (firstRowIndex < noOfRows && firstColumnIndex < noOfColumns) {
			for (iterator = firstColumnIndex; iterator < noOfColumns; ++iterator) {
				response.add(a[firstRowIndex][iterator]);

			}
			firstRowIndex++;
			for (iterator = firstRowIndex; iterator < noOfRows; ++iterator) {
				response.add(a[iterator][noOfColumns - 1]);
			}
			noOfColumns--;
			if (firstRowIndex < noOfRows) {
				for (iterator = noOfColumns - 1; iterator >= firstColumnIndex; --iterator) {
					response.add(a[noOfRows - 1][iterator]);
				}
				noOfRows--;
			}
			if (firstColumnIndex < noOfColumns) {
				for (iterator = noOfRows - 1; iterator >= firstRowIndex; --iterator) {
					response.add(a[iterator][firstColumnIndex]);
				}
				firstColumnIndex++;
			}
		}
		return response;
	}
}
