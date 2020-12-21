import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;
import java.lang.*;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

public class MapPostResponse {
	
	private String status;
	private String place_id;
	private String scope;
	private String reference;
	private String id;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
