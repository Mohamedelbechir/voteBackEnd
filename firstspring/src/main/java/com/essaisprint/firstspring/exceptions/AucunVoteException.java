package com.essaisprint.firstspring.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * AucunVoteException
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AucunVoteException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AucunVoteException(String message)
    {
        super(message);
    }
}
