package org.corodiak.l4jspring.exception;

public class MemberNotFoundException extends Exception {
    public MemberNotFoundException(String id) {
        super(String.format("UserId : %s", id));
    }
}
