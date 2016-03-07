package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReadWriteFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String MYSQL_USER = System.getenv().get("MYSQL_USER");
		String MYSQL_PASSWORD = System.getenv().get("MYSQL_PASSWORD");
		String MYSQL_HOST = System.getenv().get("MYSQL_HOST");
		String MYSQL_DATABASE = System.getenv().get("MYSQL_DATABASE");

		// String MYSQL_USER = "java";
		// String MYSQL_PASSWORD = "java";
		// String MYSQL_HOST = "10.3.10.11";
		// String MYSQL_DATABASE = "javatest";

		try {
			BufferedReader bufReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(new File("/opt/tomcat/webapps/dbtest/META-INF/contextbak.xml"))));
			StringBuffer strBuf = new StringBuffer();
			for (String tmp1 = null; (tmp1 = bufReader.readLine()) != null; tmp1 = null) {
				// 替换UC操作
				String tmp = new String(tmp1.toString().getBytes("UTF-8"));
				tmp = tmp.replaceAll("MYSQL_USER", MYSQL_USER);
				tmp = tmp.replaceAll("MYSQL_PASSWORD", MYSQL_PASSWORD);
				tmp = tmp.replaceAll("MYSQL_HOST", MYSQL_HOST);
				tmp = tmp.replaceAll("MYSQL_DATABASE", MYSQL_DATABASE);
				System.out.println(tmp);
				strBuf.append(tmp);
				strBuf.append(System.getProperty("line.separator"));

			}
			bufReader.close();
			String strBuf2 = new String(strBuf.toString().getBytes("UTF-8"));
			PrintWriter printWriter = new PrintWriter("/opt/tomcat/webapps/dbtest/META-INF/context.xml");
			printWriter.write(strBuf2.toString().toCharArray());
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
