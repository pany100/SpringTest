package com.springtest.common.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImagePersister {

	public String fileUpload(MultipartFile uploadedFile);
	
}
