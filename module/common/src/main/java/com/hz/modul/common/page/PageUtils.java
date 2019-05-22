package com.hz.modul.common.page;

import java.util.List;


/**
 * 分页器工具类
 *
 * @author yulewei
 */
public class PageUtils {

	/**
	 * 从完整list列表中提取分页对象
	 */
	public static <T> PageList<T> extractPageList(List<T> allData, Paginator p) {
		return PageUtils.extractPageList(allData, p.getPage(), p.getPageSize());
	}

	/**
	 * 从完整list列表中提取分页对象
	 */
	public static <T> Page<T> extractPage(List<T> allData, Paginator p) {
		return PageUtils.extractPage(allData, p.getPage(), p.getPageSize());
	}

	/**
	 * 从完整list列表中提取分页对象
	 */
	public static <T> PageList<T> extractPageList(List<T> allData, int page, int pageSize) {
		int fromIndex = Math.min(pageSize * (page - 1), allData.size());
		int toIndex = Math.min(fromIndex + pageSize, allData.size());
		List<T> subList = allData.subList(fromIndex, toIndex);
		return PageList.of(subList, page, pageSize, allData.size());
	}

	/**
	 * 从完整list列表中提取分页对象
	 */
	public static <T> Page<T> extractPage(List<T> allData, int page, int pageSize) {
		int fromIndex = Math.min(pageSize * (page - 1), allData.size());
		int toIndex = Math.min(fromIndex + pageSize, allData.size());
		List<T> subList = allData.subList(fromIndex, toIndex);
		Page<T> pageObj = new Page<T>(page, pageSize, allData.size());
		pageObj.addAll(subList);
		return pageObj;
	}

/*	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11, 22, 33, 44, 55);
		Page<Integer> pageList = PageUtils.extractPage(list, 1, 2);
		System.out.println(JsonResult.success(pageList));
	}*/

}
