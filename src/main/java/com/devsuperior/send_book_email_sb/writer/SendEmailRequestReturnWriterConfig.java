package com.devsuperior.send_book_email_sb.writer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.devsuperior.send_book_email_sb.domain.UserBookLoan;

@Configuration
public class SendEmailRequestReturnWriterConfig {
		
	@Bean
	public ItemWriter<UserBookLoan> sendEmailRequestReturnWriter(){
		
		return itens -> itens.forEach(System.out::println);
	}
}
