package com.proyecto.kdaf;

import java.util.ArrayList;

public class Diagnoses {

	private String id;
	private String url;
	private String scenario_id;
	private String scenario_url;
	private String service_url;
	private String service_code;
	private String started_at;
	private String finished_at;
	private String status;
	private String scenario_description;
	private String service_description;
	private ArrayList<Hypotheses> hypotheses;
	
	
	public Diagnoses() {
		super();
		this.hypotheses= new ArrayList<Hypotheses>();
		// TODO Auto-generated constructor stub
	}

	
	public Diagnoses(String id, String url,
			String scenario_id, String scenario_url, String service_url, String service_code, String started_at,
			String finished_at, String status, String scenario_description, String service_description, ArrayList<Hypotheses> hypotheses) {
		super();
		
		this.id = id;
		this.url = url;
		this.scenario_id = scenario_id;
		this.scenario_url = scenario_url;
		this.service_url = service_url;
		this.service_code = service_code;
		this.started_at = started_at;
		this.finished_at = finished_at;
		this.status = status;
		this.scenario_description = scenario_description;
		this.service_description = service_description;
		this.hypotheses = hypotheses;
		
	}
	


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getScenario_id() {
		return scenario_id;
	}


	public void setScenario_id(String scenario_id) {
		this.scenario_id = scenario_id;
	}


	public String getScenario_url() {
		return scenario_url;
	}


	public void setScenario_url(String scenario_url) {
		this.scenario_url = scenario_url;
	}


	public String getService_url() {
		return service_url;
	}


	public void setService_url(String service_url) {
		this.service_url = service_url;
	}


	public String getService_code() {
		return service_code;
	}


	public void setService_code(String service_code) {
		this.service_code = service_code;
	}


	public String getStarted_at() {
		return started_at;
	}


	public void setStarted_at(String started_at) {
		this.started_at = started_at;
	}


	public String getFinished_at() {
		return finished_at;
	}


	public void setFinished_at(String finished_at) {
		this.finished_at = finished_at;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public String getScenario_description() {
		return scenario_description;
	}


	public void setScenario_description(String scenario_description) {
		this.scenario_description = scenario_description;
	}


	public String getService_description() {
		return service_description;
	}


	public void setService_description(String service_description) {
		this.service_description = service_description;
	}
	
	public ArrayList<Hypotheses> getHypotheses()
	{
		return hypotheses;
	}
	
	public void setHypotheses(ArrayList<Hypotheses> hypotheses)
	{
		this.hypotheses = hypotheses;
	}
	
	public void anadirHypotheses(Hypotheses hypotheses)
	{
		this.hypotheses.add(hypotheses);
	}
	
	
	
}
