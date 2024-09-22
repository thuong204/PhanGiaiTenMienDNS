package model;

public class Domain {
	private  Integer id;
	private String domainName;
	private String contentDomain;
	public Domain(Integer id, String domainName, String contentDomain) {
		super();
		this.id = id;
		this.domainName = domainName;
		this.contentDomain = contentDomain;
	}
	public Domain() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Domain(String domainName, String contentDomain) {
		super();
		this.domainName = domainName;
		this.contentDomain = contentDomain;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getContentDomain() {
		return contentDomain;
	}
	public void setContentDomain(String contentDomain) {
		this.contentDomain = contentDomain;
	}
	

}
