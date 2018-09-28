package com.zyh.controller.resume.vo;

import java.util.List;

import com.zyh.entity.resume.ZyhResumeBase;
import com.zyh.entity.resume.ZyhResumeEducation;
import com.zyh.entity.resume.ZyhResumeIntention;
import com.zyh.entity.resume.ZyhResumeSpeciality;
import com.zyh.entity.resume.ZyhResumeWork;

public class ResumeVO {
	
	private ZyhResumeBase zyhResumeBase;
	
	private List<ZyhResumeWork> zyhResumeWorks;
	
	private List<ZyhResumeEducation> zyhResumeEducations;
	
	private List<ZyhResumeSpeciality> zyhResumeSpecialities;
	
	private List<ZyhResumeIntention> zyhResumeIntentions;

	public ZyhResumeBase getZyhResumeBase() {
		return zyhResumeBase;
	}

	public void setZyhResumeBase(ZyhResumeBase zyhResumeBase) {
		this.zyhResumeBase = zyhResumeBase;
	}

	public List<ZyhResumeWork> getZyhResumeWorks() {
		return zyhResumeWorks;
	}

	public void setZyhResumeWorks(List<ZyhResumeWork> zyhResumeWorks) {
		this.zyhResumeWorks = zyhResumeWorks;
	}

	public List<ZyhResumeEducation> getZyhResumeEducations() {
		return zyhResumeEducations;
	}

	public void setZyhResumeEducations(List<ZyhResumeEducation> zyhResumeEducations) {
		this.zyhResumeEducations = zyhResumeEducations;
	}

	public List<ZyhResumeSpeciality> getZyhResumeSpecialities() {
		return zyhResumeSpecialities;
	}

	public void setZyhResumeSpecialities(List<ZyhResumeSpeciality> zyhResumeSpecialities) {
		this.zyhResumeSpecialities = zyhResumeSpecialities;
	}

	public List<ZyhResumeIntention> getZyhResumeIntentions() {
		return zyhResumeIntentions;
	}

	public void setZyhResumeIntentions(List<ZyhResumeIntention> zyhResumeIntentions) {
		this.zyhResumeIntentions = zyhResumeIntentions;
	}
	
	
}
