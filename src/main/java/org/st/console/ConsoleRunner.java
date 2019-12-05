package org.st.console;

import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.stereotype.Component;
@Component
public class ConsoleRunner implements CommandLineRunner {
	@Autowired
	private JobLauncher launcher;
	@Autowired
	private Job Job;

	@Override
	public void run(String... args) throws Exception {
		launcher.run((org.springframework.batch.core.Job) Job,new JobParametersBuilder()
				.addLong("time", System.currentTimeMillis())
				.toJobParameters());
	}

}
