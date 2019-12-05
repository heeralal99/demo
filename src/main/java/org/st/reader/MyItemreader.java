package org.st.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class MyItemreader implements ItemReader<String> {
	
	String[] inputs= {"hyderabad","banglore","chennai","pune","mumbai"};
	int cout=0;
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		
		System.out.println("i am from reader"+cout);
		if(cout<5)
		{
			return inputs[cout++];
		}
		
		return null;
	}

}
