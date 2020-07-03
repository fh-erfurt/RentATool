package de.rat.storage.exceptions;

public class DummyNotFoundException extends RuntimeException {
    public DummyNotFoundException(Long id)
    {
        super("Could not find dummy " +id);
    }

}
