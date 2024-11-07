/**
 * 
 */
package com.company.utils;

import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;


public class Constant {
	private static final String ROOT = System.getProperty("user.dir");

	public static File getMinicap() {
		return new File(ROOT, "minicap");
	}

	public static File getMinicapBin() {
		return new File(ROOT, "minicap/bin");
	}

	public static File getMiniTouchBin() {
		return new File(ROOT, "minitouch");
	}

	public static File getMinicapSo() {
		return new File(ROOT, "minicap/shared");
	}
	
	public static File getMinicapAdb() {
		return new File(ROOT, "platform-tools");
	}


	/**
	 * 从 JAR 包中的路径提取资源并保存为一个临时文件。
	 *
	 * @param resourcePath 资源在 JAR 包中的路径，例如 "BOOT-INF/classes/myBinaryFile.bin"
	 * @return 临时文件对象，包含资源文件的数据
	 * @throws Exception 如果无法读取资源或创建临时文件时出现异常
	 */
	public static File getFileFromJar(String resourcePath) throws Exception {
		// 获取资源的 InputStream
		InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(resourcePath);
		if (inputStream == null) {
			throw new IllegalArgumentException("资源文件在 JAR 包中未找到: " + resourcePath);
		}

		// 创建临时文件，并在 JVM 退出时删除
		File tempFile = Files.createTempFile("resource-", ".tmp").toFile();
		tempFile.deleteOnExit();

		// 将资源文件内容复制到临时文件
		try (OutputStream outputStream = new FileOutputStream(tempFile)) {
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
		}
		return tempFile;
	}

}
