package com.concretepage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class blaConf {
	@Bean(name="bla")
	public blabla instance(){
		return new blabla() ; 
	}
}


