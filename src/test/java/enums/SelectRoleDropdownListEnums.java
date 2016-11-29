package enums;

public enum SelectRoleDropdownListEnums {
    ADMINISTRATOR("Administrator"),
    MERCHANDISER("Merchandiser"),
    SUPERVISOR("supervisor");
    //
    private String role;

    private SelectRoleDropdownListEnums (String role) {
        this.role= role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return this.role;
    }
}
