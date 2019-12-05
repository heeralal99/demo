package org.st.configuractio;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.st.listner.MyListner;
import org.st.processor.MyIteamProccessor;
import org.st.reader.MyItemreader;
import org.st.writter.MyItemWritter;
@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Bean
	public ItemReader<String> reader()
	{
		return new MyItemreader();
	}
	@Bean
	public ItemProcessor<String, String> procees()
	{
		return new MyIteamProccessor();
	}
	@Bean
	public ItemWriter<String> writer()
	{
		return new MyItemWritter();
	}
	@Autowired
	private StepBuilderFactory sf;
	@Bean
	public Step stepA()
	{
		return sf.get("stepA").<String,String>chunk(50)
				.reader(reader())
				.processor(procees())
				.writer( writer())
				.build();
	}
	@Autowired
	private JobBuilderFactory jf;
	@Bean
	public JobExecutionListener listener()
	{
		return new MyListner();
	}
	@Bean
	public Job jobA() {
		return (Job) jf.get("jobA")
				.incrementer(new RunIdIncrementer())
				.listener(listener())
				.start(stepA())
				.build();
	}
}
