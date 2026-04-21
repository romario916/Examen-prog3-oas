package com.federation.model;

public class FederationStat {
    private String collectivityName;
    private Double attendanceRate;
    private Double membershipDuesPaidPercentage;
    private Integer newAdherentsCount;

    public FederationStat() {}

    // Getters
    public String getCollectivityName() { return collectivityName; }
    public Double getAttendanceRate() { return attendanceRate; }
    public Double getMembershipDuesPaidPercentage() { return membershipDuesPaidPercentage; }
    public Integer getNewAdherentsCount() { return newAdherentsCount; }

    // Setters
    public void setCollectivityName(String collectivityName) { this.collectivityName = collectivityName; }
    public void setAttendanceRate(Double attendanceRate) { this.attendanceRate = attendanceRate; }
    public void setMembershipDuesPaidPercentage(Double percentage) { this.membershipDuesPaidPercentage = percentage; }
    public void setNewAdherentsCount(Integer count) { this.newAdherentsCount = count; }
}
