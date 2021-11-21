/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Tri
 */
public class MentorStatistic {
    int totalRequest;
    int pendingRequest;
    int acceptedRequest;
    int rejectedRequest;

    public MentorStatistic() {
    }

    public MentorStatistic(int totalRequest, int pendingRequest, int acceptedRequest, int rejectedRequest) {
        this.totalRequest = totalRequest;
        this.pendingRequest = pendingRequest;
        this.acceptedRequest = acceptedRequest;
        this.rejectedRequest = rejectedRequest;
    }

    public int getTotalRequest() {
        return totalRequest;
    }

    public void setTotalRequest(int totalRequest) {
        this.totalRequest = totalRequest;
    }

    public int getPendingRequest() {
        return pendingRequest;
    }

    public void setPendingRequest(int pendingRequest) {
        this.pendingRequest = pendingRequest;
    }

    public int getAcceptedRequest() {
        return acceptedRequest;
    }

    public void setAcceptedRequest(int acceptedRequest) {
        this.acceptedRequest = acceptedRequest;
    }

    public int getRejectedRequest() {
        return rejectedRequest;
    }

    public void setRejectedRequest(int rejectedRequest) {
        this.rejectedRequest = rejectedRequest;
    }
}
