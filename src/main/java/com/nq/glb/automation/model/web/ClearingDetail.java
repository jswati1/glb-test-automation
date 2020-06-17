package com.nq.glb.automation.model.web;

public class ClearingDetail {

	private Section forReview;
	private Section preview;
	private Section complete;

	public Section getForReview() {
		return forReview;
	}

	public void setForReview(Section forReview) {
		this.forReview = forReview;
	}

	public Section getPreview() {
		return preview;
	}

	public void setPreview(Section preview) {
		this.preview = preview;
	}

	public Section getComplete() {
		return complete;
	}

	public void setComplete(Section complete) {
		this.complete = complete;
	}
	@Override
	public String toString() {
		return "ClearingDetail [forReview=" + forReview + ", preview=" + preview + ", complete=" + complete + "]";
	}
}
