package com.example.pcb.exception;

import java.sql.SQLException;

public class QueryException extends Exception {
    public QueryException(String message) {
        super(message);
    }
}
