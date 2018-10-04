package dev.controller.vm;

/**
 * @author diginamic09
 * 
 * Code et message d'erreur envoyé au front lors de la levée d'une exception
 *
 */
public class ErrorVM {

	private ErrorCode code;

    private String message;

    public ErrorVM(ErrorCode code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public ErrorVM(ErrorCode code) {
        this.code = code;
    }

    /**
     * @return the code
     */
    public ErrorCode getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(ErrorCode code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}