package com.tinyurl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class TinyurlService {
	
	private TinyUrlRepository tinyUrlRepository;

	@Autowired
	private TinyurlService(TinyUrlRepository tinyUrlRepository) {
		this.tinyUrlRepository = tinyUrlRepository;
	}
	
	

	public TinyUrlEntity createShortURL(String url) {

		String short_url = Integer.toHexString(url.hashCode());

		TinyUrlEntity tinyEntity = new TinyUrlEntity();
		tinyEntity.setOriginalURL(url);
		tinyEntity.setShortURL(short_url);
		tinyUrlRepository.save(tinyEntity); // store in db also

		
		return tinyEntity; // return the second page

	}
	
	public String getShortUrl(String shorturl) {

		return tinyUrlRepository.findByShortURL(shorturl).getOriginalURL();

	}

}
