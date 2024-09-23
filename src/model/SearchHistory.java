package model;

public class SearchHistory {
	private String domain_name;
	private String search_date;
	private String domain_content;
	public SearchHistory(String domain_name, String search_date, String domain_content) {
		super();
		this.domain_name = domain_name;
		this.search_date = search_date;
		this.domain_content = domain_content;
	}
	public SearchHistory() {
		super();
	}
	public String getDomain_name() {
		return domain_name;
	}
	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}
	public String getSearch_date() {
		return search_date;
	}
	public void setSearch_date(String search_date) {
		this.search_date = search_date;
	}
	public String getDomain_content() {
		return domain_content;
	}
	public void setDomain_content(String domain_content) {
		this.domain_content = domain_content;
	}
	
	

}
