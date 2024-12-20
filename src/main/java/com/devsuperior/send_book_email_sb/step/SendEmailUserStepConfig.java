package com.devsuperior.send_book_email_sb.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.devsuperior.send_book_email_sb.domain.UserBookLoan;

@Configuration
public class SendEmailUserStepConfig {
	
	@Autowired
	@Qualifier("transactionManagerApp") //esta na definição das configurações do DataSource
	private PlatformTransactionManager transactionManager;
	
	@Bean
	public Step sendEmailUserStep(ItemReader<UserBookLoan> readUsersWithCloseToReturnReader, 
			ItemWriter<UserBookLoan> sendEmailRequestReturnWriter ,JobRepository jobRepository) {
		
		return new StepBuilder("sendEmailUserStep", jobRepository)
				.<UserBookLoan, UserBookLoan>chunk(1, transactionManager)
				.reader(readUsersWithCloseToReturnReader)
				.writer(sendEmailRequestReturnWriter)
				.build();
	}
}
