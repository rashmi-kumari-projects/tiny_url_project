package com.tinyurl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class TinyUrlController {

	
	private TinyurlService tinyurlService;

	@Autowired
	private TinyUrlController(TinyurlService tinyurlService) {
		this.tinyurlService = tinyurlService;
	}
	
	// To return the FirstPage
	@GetMapping("/shorten")
	public String urlshortnerpage() {
		return "url-shortener"; // return the first page
	}
	private static final String BASE_URL = "http://localhost:8080/"; // Base URL 
	
	@PostMapping("/shorten")
	public String createShortURL(@RequestParam String url, Model model) {
		
		TinyUrlEntity urlsdata =	tinyurlService.createShortURL(url);

		String shortenedUrl = BASE_URL + urlsdata.getShortURL();
		model.addAttribute("shortenedUrl", shortenedUrl);
		model.addAttribute("originalUrl", urlsdata.getOriginalURL());
		return "url-shortener-result"; // return the second page

	}

	// to redirect the Short URL to Original URL
	@GetMapping("/{shorturl}")
	@ResponseBody
	public void getShortUrl(@PathVariable String shorturl, HttpServletResponse httpServletResponse) throws IOException {

		httpServletResponse.sendRedirect(tinyurlService.getShortUrl(shorturl));

	}

}
