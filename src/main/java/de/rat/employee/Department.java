package de.rat.employee;

public class Department {

    private String depName;

    public Department( String depName) {

        this.depName = depName;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    boolean changeDepartment(String newName){
    setDepName(newName);
      return true;
    }
}
