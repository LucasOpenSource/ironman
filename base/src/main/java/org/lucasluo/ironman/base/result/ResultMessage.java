package org.lucasluo.ironman.base.result;

public enum  ResultMessage {
    SUCCESS("success"),
    FAIL("fail"),
    INVALID_PARAMETER("Invalid parameter!"),
    NO_SUCH_USER("No such user!"),
    REGISTER_USER_SUCCEED("Register user succeed!"),
    LOGIN_SUCCESS("Login succeed!"),
    LOGIN_FAILED("Unable to login due to fatal error!"),
    LOGIN_AUTH_FAILED("Invalid user name or password!");


    private String resultMessage;

    ResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getValue() {
        return this.resultMessage;
    }
}
