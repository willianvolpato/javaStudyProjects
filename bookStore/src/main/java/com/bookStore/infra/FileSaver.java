package com.bookStore.infra;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;

import javax.servlet.http.Part;

public class FileSaver {

	public static final String ROOT_PATH = "/BookStoreFiles/";
	
	public static String write(Part file, String path) {
		String fileRelativePath = path + System.currentTimeMillis() + "-" + file.getSubmittedFileName();
		try {
			
			file.write(ROOT_PATH + fileRelativePath);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return fileRelativePath;
	}

	public static void transfer(Path source, OutputStream outputStream) {
		
		try {
			
			FileInputStream input = new FileInputStream(source.toFile());
			
			try (ReadableByteChannel inputChannel = Channels.newChannel(input);
					WritableByteChannel outputChannel = Channels.newChannel(outputStream)){
				
				ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 10);
				
				while(inputChannel.read(buffer) != -1) {
					buffer.flip();
					outputChannel.write(buffer);
					buffer.clear();
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
}
