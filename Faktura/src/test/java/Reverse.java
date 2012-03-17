import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Reverse {
	public static void main(String[] args) throws Exception {
		Reverse s= new Reverse();
		s.sendF();
	
	}
	public void originalf(){
		try{
		URL url = new URL("http://localhost:8080/IMS/spring/uploadd");
		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);

		connection.setRequestProperty("Content-Type", "text/html;charset=UTF-8");
		connection.setRequestProperty("enctype", "multipart/form-data");

		DataOutputStream printout = new DataOutputStream(connection.getOutputStream());
		
		printout.write(FileUtils.readFileToByteArray(new File("c:\\img_khar.jpg")));

		printout.flush();
		printout.close();

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		String decodedString;

		while ((decodedString = in.readLine()) != null) {
			System.out.println(decodedString);
		}
		in.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void sendF() {
		try {
			URL uploadURL = new URL("http://localhost:8080/IMS/spring/uploadd");
			System.out.println("uploadUrl" + uploadURL);
			HttpURLConnection connection = (HttpURLConnection) uploadURL.openConnection();
			connection.setRequestMethod("POST");
			
			connection.setDoOutput(true);
			connection.setUseCaches(false);
			connection.setDefaultUseCaches(false);
			connection.setRequestProperty("content-type", "img/jpeg");
			connection.setRequestProperty("content-length", String.valueOf(1000000));
			connection.setRequestProperty("uuid", "dd");
			
			OutputStream out = connection.getOutputStream();
		
			out.write(FileUtils.readFileToByteArray(new File("c:\\img_khar.jpg")));
			out.close();
			InputStream in = connection.getInputStream();
			System.err.println(connection.getResponseMessage());
			
			int c;
			while ((c = in.read()) != -1)
				System.err.write(c);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}