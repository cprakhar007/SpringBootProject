package com.nagarro.library.bookservice;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.nagarro.library.entity.BooksDetails;

@Service
public class BooksServices {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public List<BooksDetails> getAllbooks(){
		
	BooksDetails[] bs = restTemplate.getForObject("http://localhost:8085/books", BooksDetails[].class);
	
	List<BooksDetails>ls= Arrays.asList(bs);
		
		return ls;
	}
	
	
	public void createBook(BooksDetails bs) {
		
		
		
		restTemplate.postForObject("http://localhost:8085/books", bs,BooksDetails.class);
		
		
	}
	
	
	public void deleteBook(int bcode) {
		
		restTemplate.delete("http://localhost:8085/books/"+Integer.toString(bcode));
	}
	
	public void updateBook(BooksDetails bs) {
		
		restTemplate.put("http://localhost:8085/books", bs);
	}
	
	
	public boolean isBookexist(BooksDetails bd,List<BooksDetails>ls) {
	
		
		for(BooksDetails fd:ls) {
			
			if(fd.getBcode()==bd.getBcode())
			{
				return true;
			}
		}
		
		return false;
	}
	

}
