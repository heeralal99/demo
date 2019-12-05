package org.st.processor;

import org.springframework.batch.item.ItemProcessor;

public class MyIteamProccessor implements ItemProcessor<String, String>{

	@Override
	public String process(String item) throws Exception {
		System.out.println("i am from proccessor");
		return item.toUpperCase();
	}

}
