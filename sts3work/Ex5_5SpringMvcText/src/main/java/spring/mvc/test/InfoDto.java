package spring.mvc.test;

import java.util.ArrayList;

public class InfoDto {
	
	private String name;
	private String color;
	private ArrayList<String> hobby;
	private String lang;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getHobby() {
	    if (hobby == null || hobby.isEmpty()) {
	        return "¾øÀ½";
	    } else {
	        String hobbies = "";
	        for (String h : hobby) {
	            hobbies += "[" + h + "]";
	        }
	        return hobbies;
	    }
	}
	 
	public void setHobby(ArrayList<String> hobby) {
		this.hobby = hobby;
	}
	
	
	
	

}
