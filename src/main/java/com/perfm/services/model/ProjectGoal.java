package com.perfm.services.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="projectgoals")
@TypeAlias("projectgoal")
public class ProjectGoal extends AbstractDocument{

	private String scoringAnnotation;
	private String reviewerComments;
	private int projectDelivery;
	private int individualExtension;
	public String getScoringAnnotation() {
		return scoringAnnotation;
	}
	public void setScoringAnnotation(String scoringAnnotation) {
		this.scoringAnnotation = scoringAnnotation;
	}
	public String getReviewerComments() {
		return reviewerComments;
	}
	public void setReviewerComments(String reviewerComments) {
		this.reviewerComments = reviewerComments;
	}
	public int getProjectDelivery() {
		return projectDelivery;
	}
	public void setProjectDelivery(int projectDelivery) {
		this.projectDelivery = projectDelivery;
	}
	public int getIndividualExtension() {
		return individualExtension;
	}
	public void setIndividualExtension(int individualExtension) {
		this.individualExtension = individualExtension;
	}
	public ProjectGoal(String scoringAnnotation, String reviewerComments, int projectDelivery,
			int individualExtension) {
		this.scoringAnnotation = scoringAnnotation;
		this.reviewerComments = reviewerComments;
		this.projectDelivery = projectDelivery;
		this.individualExtension = individualExtension;
	}

	
	
}
