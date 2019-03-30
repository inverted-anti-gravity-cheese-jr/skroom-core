package org.skroom.model;

public class UserMetadata {

    private String userName;
    private String email;
    private String securityQuestion;
    private String secutityQuestionAnswer;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecutityQuestionAnswer() {
        return secutityQuestionAnswer;
    }

    public void setSecutityQuestionAnswer(String secutityQuestionAnswer) {
        this.secutityQuestionAnswer = secutityQuestionAnswer;
    }
}
