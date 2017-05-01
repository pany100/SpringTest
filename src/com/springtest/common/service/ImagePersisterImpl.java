package com.springtest.common.service;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.web.multipart.MultipartFile;

public class ImagePersisterImpl implements ImagePersister{

	private String imagesFolder;
	
	public void setImagesFolder(String imagesFolder) {
		this.imagesFolder = imagesFolder;
	}
	
	@Override
	public String fileUpload(MultipartFile file) {
		
		String fileName = new BigInteger(130, new SecureRandom()).toString(32);
	    File newFile = new File(imagesFolder + fileName);
	    try {
			file.transferTo(newFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	    
	    return fileName;
	}

}
