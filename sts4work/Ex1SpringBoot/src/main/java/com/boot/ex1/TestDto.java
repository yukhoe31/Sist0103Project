package com.boot.ex1;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@Getter
//@ToString
@Data //이걸 쓰면 Setter,Getter,ToString이 다 써진다.
public class TestDto {

	private String name;
	private String addr;
	
	
}
