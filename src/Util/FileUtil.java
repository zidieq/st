package Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {
	public static String getFileContext(String filePath) throws IOException {
		StringBuilder result = new StringBuilder();
		File file = new File(filePath);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = null;
		while ((line = br.readLine()) != null) {
			result.append(line).append("\n");
		}
		br.close();
		return result.toString();
	}
}
