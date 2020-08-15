package com.nq.glb.automation.model.web;

/**
 * @author jswati
 *
 */
public class DocsetDetail extends UtilitiesDetail{

	private SiteElement summary;
	private Section all;
	private Section federal;
	private Section municipal;
	private Section tribal;
	private Section commercial;
		

	public SiteElement getSummary() {
		return summary;
	}

	public void setSummary(SiteElement summary) {
		this.summary = summary;
	}

	public Section getAll() {
		return all;
	}
	public void setAll(Section all) {
		this.all = all;
	}
	public Section getFederal() {
		return federal;
	}
	public void setFederal(Section federal) {
		this.federal = federal;
	}
	public Section getMunicipal() {
		return municipal;
	}
	public void setMunicipal(Section municipal) {
		this.municipal = municipal;
	}
	public Section getTribal() {
		return tribal;
	}
	public void setTribal(Section tribal) {
		this.tribal = tribal;
	}
	public Section getCommercial() {
		return commercial;
	}
	public void setCommercial(Section commercial) {
		this.commercial = commercial;
	}


@Override
public String toString() {
	return "DocsetDetail [summary=" + summary + ", all=" + all + ", federal="
			+ federal + ", municipal=" + municipal + ", tribal=" + tribal + ", commercial=" + commercial + "]";
}
}


