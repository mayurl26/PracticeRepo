package com.nt.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.nt.listener.JobMonitoringListener;
import com.nt.model.Employee;
import com.nt.processor.EmployeeInfoItemProcessor;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jobFactory;
	@Autowired
	private StepBuilderFactory stepFactory;
	@Autowired
	private JobMonitoringListener listener;
	@Autowired
	private EmployeeInfoItemProcessor processor;
	@Autowired
	private DataSource ds;
	
	/*@Bean(name = "FFIR")
	public FlatFileItemReader<Employee> createFFIReader(){
		FlatFileItemReader<Employee> reader= new FlatFileItemReader<Employee>();
	    reader.setResource(new ClassPathResource("Employee_info.csv"));
	    
	    DefaultLineMapper<Employee> mapper= new DefaultLineMapper<Employee>();
	    
	    DelimitedLineTokenizer tokenizer= new DelimitedLineTokenizer();
	    
	    tokenizer.setDelimiter(",");
	    tokenizer.setNames("empno","ename","eaddrs","salary");
	    
	    BeanWrapperFieldSetMapper<Employee> beanMapper= new BeanWrapperFieldSetMapper<Employee>();
	    beanMapper.setTargetType(Employee.class);
	    
	    mapper.setFieldSetMapper(beanMapper);
	    mapper.setLineTokenizer(tokenizer);
	    
	    reader.setLineMapper(mapper);
	    return reader;
	    
	}*/
	
	@Bean(name = "FFIR")
	public JdbcCursorItemReader<Employee> createFFIReader(){
		
		
	    return new JdbcCursorItemReaderBuilder<Employee>()
	    		.dataSource(ds)
	    		.sql("select empno,ename,eaddrs,salary from employee")
	    		.beanRowMapper(Employee.class)
	    		.build();
	    
	}
	
	public FlatFileItemWriter<Employee> createWriter(){
		return new FlatFileItemWriterBuilder<Employee>()
				.name("writer")
				.resource(new FileSystemResource("e:/Employee.csv"))
				.lineSeparator("\r\n")
				.delimited().delimiter(",")
				.names("empno","ename","eaddrs","salary")
				.build();
	}
	
	
	
	/*@Bean(name = "jbiw")
	public JdbcBatchItemWriter<Employee> createWriter(){
		
		JdbcBatchItemWriter<Employee> writer= new JdbcBatchItemWriter<Employee>() {{
			setDataSource(ds);
			setSql("INSERT INTO EMPLOYEE VALUES(:empno,:ename,:eaddrs,:salary,:netSalary,:grossSalary)");
	        setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Employee>());
		}};
	
		return writer;
	
	}	*/
	
	/*@Bean(name = "jbiw")
	public JdbcBatchItemWriter<Employee> createWriter(){
		
		JdbcBatchItemWriter<Employee> writer= new JdbcBatchItemWriter<Employee>();
		writer.setDataSource(ds);
		writer.setSql("INSERT INTO EMPLOYEE VALUES(:empno,:ename,:eaddrs,:salary,:netSalary,:grossSalary)");
		BeanPropertyItemSqlParameterSourceProvider<Employee> provider= new BeanPropertyItemSqlParameterSourceProvider<Employee>();
		writer.setItemSqlParameterSourceProvider(provider);
		return writer;
	
	}	*/
		@Bean(name="step1")
		public Step creatStep() {
			return stepFactory.get("step1")
					.<Employee,Employee>chunk(10)
					.reader(createFFIReader())
					.processor(processor)
					.writer(createWriter())
					.build();
		}
		
	/*@Bean(name="step1")
	public FlatFileItemReader<Employee> createFFIReader(){
	     return new FlatFileItemReaderBuilder()
	    		 .name("file-reader")
	    		 .resource(new ClassPathResource("Employee_info.csv"))
	    		 .delimited()
	    		 .names("empno","ename","eaddrs","salary")
	    		 .targetType(Employee.class)
	    		 .build();
	    		       
	
	}*/
	
	@Bean(name = "job1")
	public Job createJob() {
		return jobFactory.get("job1")
				.listener(listener)
				.incrementer(new RunIdIncrementer())
				.start(creatStep())
				.build();
		
	}
	

}
