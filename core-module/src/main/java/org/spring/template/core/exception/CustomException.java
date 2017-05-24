package org.spring.template.core.exception;

/**
 * Created by osman on 9.5.2017.
 */
public class CustomException extends Exception {
    private int errorCode;
    private int reasonCode;
    private String errorMessage;

    public CustomException() {
    }

    public CustomException(int errorCode, int reasonCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.reasonCode = reasonCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(int reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
