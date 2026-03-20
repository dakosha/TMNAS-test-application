package com.jsfdemo.app;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;

/**
 * Bean demonstrating: h:form, h:inputText, h:inputTextarea, h:outputText,
 * h:outputLabel, h:message, h:commandButton, h:panelGrid
 */
@Named("textInputBean")
@ViewScoped
public class TextInputBean implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String comments;
    private String submittedSummary;

    @PostConstruct
    public void init() {
        firstName = "";
        lastName = "";
        email = "";
        phone = "";
        comments = "";
        submittedSummary = null;
    }

    public void submit() {
        submittedSummary = String.format(
                "Name: %s %s | Email: %s | Phone: %s | Comments: %s",
                firstName, lastName, email, phone, comments
        );
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Form submitted successfully!", null));
    }

    public void clear() {
        init();
    }

    // --- Getters / Setters ---

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSubmittedSummary() {
        return submittedSummary;
    }

    public void setSubmittedSummary(String submittedSummary) {
        this.submittedSummary = submittedSummary;
    }
}

