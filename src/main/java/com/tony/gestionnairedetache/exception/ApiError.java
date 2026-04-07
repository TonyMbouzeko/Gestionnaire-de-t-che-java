package com.tony.gestionnairedetache.exception;

import java.time.LocalDateTime;

public class ApiError{
private LocalDateTime timestamp;
private String error;
private String message;
private String path;
private int status;


public ApiError(){}

public LocalDateTime getTimestamp(){
    return timestamp;
}

public String getError(){
    return error;
}

public String getMessage(){
    return message;
}

public String getPath(){
    return path;
}

public int getStatus(){
    return status;
}


public void setTimestamp( LocalDateTime timestamp){
    this.timestamp = timestamp;

}

public void setError(String error){
    this.error = error;

}

public void setMessage(String message){
    this.message = message;

}

public void setPath(String path){
    this.path = path;
}

public void setStatus(int status){
    this.status = status;
}

}

