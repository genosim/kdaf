package com.proyecto.kdaf;


public class Hypotheses {

	private String percentage;
	private String id;
	private String type;
	private String value;
	private String probability;

	public Hypotheses()
	{
		super();
		this.percentage = "";
		this.id = "";
		this.type = "";
		this.value = "";
		this.probability = "";
		
	}
	
	public Hypotheses(Hypotheses hypotheses)
	{
		super();
		this.percentage = hypotheses.getPercentage();
		this.id = hypotheses.getId();
		this.type = hypotheses.getType();
		this.value = hypotheses.getValue();
		this.probability = hypotheses.getProbability();
		
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getProbability() {
		return probability;
	}

	public void setProbability(String probability) {
		this.probability = probability;
	}

	
	
}
