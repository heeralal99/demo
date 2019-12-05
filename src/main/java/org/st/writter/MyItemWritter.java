package org.st.writter;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

public class MyItemWritter implements ItemWriter<String> {

	@Override
	public void write(List<? extends String> items) throws Exception {

		System.out.println("i am from writer");
		
	}

}
