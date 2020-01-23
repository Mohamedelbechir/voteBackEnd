package com.essaisprint.firstspring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * VoteException
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class VoteException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public VoteException(String message)
    {
        super(message);
    }
}
