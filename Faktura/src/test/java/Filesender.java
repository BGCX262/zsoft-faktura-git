import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.commons.io.FileUtils;

public class Filesender {
	public static void main(String[] a) {
		Filesender filesender = new Filesender();
		filesender.sendFile();
	}

	public void send() {
		try {
			URL url = new URL("http://localhost:9090/SpringApp/spring/upload/");
			HttpURLConnection m_connection;
			m_connection = (HttpURLConnection) url.openConnection();
			String parameters = "data=some_post_data";
			m_connection.setDoOutput(true);
			m_connection.setRequestMethod("POST");
			m_connection.setRequestProperty("Content-Type", "MultiPart/Form-Data");
			byte bytes[] = parameters.getBytes();
			m_connection.setRequestProperty("Content-length", "" + bytes.length);
			m_connection.connect();
			OutputStream out = m_connection.getOutputStream();
			out.write(bytes);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendFile() {
		try {
			URL url;
			URLConnection urlConn;
			DataOutputStream printout;
			DataInputStream input;

			// URL of Remote Script.
			url = new URL("http://localhost:9090/SpringApp/spring/upload/"); // testpostdata
																			// is
																			// the
																			// servlet
																			// name

			// Open New URL connection channel.
			urlConn = url.openConnection();

			// Let the run-time system (RTS) know that we want input.
			urlConn.setDoInput(true);

			// we want to do output.
			urlConn.setDoOutput(true);

			// We want no caching
			urlConn.setUseCaches(false);

			// Specify the header content type.
			// urlConn.setRequestProperty("Content-Type",
			// "text/html;charset=UTF-8");
			// urlConn.setRequestProperty("enctype", "multipart/form-data");
			// Send POST output.
			String content = "name=" + URLEncoder.encode("Hitesh Agrawal") + "&profession="
					+ URLEncoder.encode("Software Engineer");

			OutputStreamWriter out = new OutputStreamWriter(urlConn.getOutputStream());
			out.write("string=" + content);
			out.close();

			printout = new DataOutputStream(urlConn.getOutputStream());

			printout.writeBytes("file=" + FileUtils.readFileToByteArray(new File("c:\\ss.txt")).toString());
			printout.flush();
			printout.close();

			// // Get response data.
			// input = new DataInputStream(urlConn.getInputStream());
			// String str;
			// while (null != ((str = input.readLine()))) {
			// System.out.println(str);
			// }
			// input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
