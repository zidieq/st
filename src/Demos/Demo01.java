package Demos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.io.FileUtils;

import Util.FileUtil;

public class Demo01 {
	public static void main(String[] args) throws IOException {
		String jstr=FileUtil.getFileContext("in.txt");
	}
}
