package de.rat.storage.exceptions;

public class ToolNotFoundException extends RuntimeException{
    public ToolNotFoundException(Long id)
    {

        super("Could not find tool " +id);
    }
}
