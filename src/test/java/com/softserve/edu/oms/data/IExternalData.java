	package com.softserve.edu.oms.data;
	import java.util.List;

	/**
	 * IExternalData stands above all classes,
	 * which work with any kind of data
	 *
	 * @since 01.12.16
	 */
	public interface IExternalData {

		List<List<String>> getAllCells(String absoluteFilePath, String sheetName);

	}