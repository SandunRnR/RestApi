package com.rnrsolutions.greenbless.ai_project.service;

import org.springframework.web.multipart.MultipartFile;

public interface AIService {
    String uplaod(
            int pCustomerID,
            MultipartFile file,
            String pIdentifiedObject) throws Exception;
}
