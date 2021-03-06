package com.nq.glb.automation.model.web;

/**
 * @author jswati
 *
 */
public class InvoicesDetail extends UtilitiesDetail {

	private SiteElement header;
	private SiteElement content;

	public SiteElement getHeader() {
		return header;
	}

	public void setHeader(SiteElement header) {
		this.header = header;
	}

	public SiteElement getContent() {
		return content;
	}

	public void setContent(SiteElement content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "InvoicesDetail [header=" + header + ", content=" + content + "]";
	}

}
