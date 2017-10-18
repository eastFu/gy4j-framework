/*---------------------------------------------------
 * 版权所有：北京光宇华在线科技有限责任公司
 * 作者：bjkandy
 * 联系方式：kangruiwei@gyyx.cn 
 * 版本号：2015年5月28日
 *
 * 注意：本内容仅限于公司内部使用，禁止转发。
 * ------------------------------------------------*/
package com.gyyx.core.util;

/**
 * 获取当前应用的系统路径
 * 
 * @author bjkandy
 * @version 2015年5月28日
 */
public class SystemPath {

	public static String getSysPath() {
		String path = Thread.currentThread().getContextClassLoader()
				.getResource("").toString();
		String temp = path.replaceFirst("file:/", "").replaceFirst(
				"WEB-INF/classes/", "");
		String separator = System.getProperty("file.separator");
		String resultPath = temp.replaceAll("/", separator + separator);
		return resultPath;
	}

	public static String getClassPath() {
		String path = Thread.currentThread().getContextClassLoader()
				.getResource("").toString();
		String temp = path.replaceFirst("file:/", "");
		String separator = System.getProperty("file.separator");
		String resultPath = temp.replaceAll("/", separator + separator);
		return resultPath;
	}

	public static String getSystempPath() {
		return System.getProperty("java.io.tmpdir");
	}

	public static String getSeparator() {
		return System.getProperty("file.separator");
	}

	public static void main(String[] args) {
		System.out.println(getSysPath());
		System.out.println(System.getProperty("java.io.tmpdir"));
		System.out.println(getSeparator());
		System.out.println(getClassPath());
	}
}
