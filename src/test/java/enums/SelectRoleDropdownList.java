package enums;

public enum SelectRoleDropdownList {
    ADMINISTRATOR("Administrator"),
    CUSTOMER("Customer"),
    MERCHANDISER("Merchandiser"),
    SUPERVISOR("Supervisor");
    //
    private String role;

    private SelectRoleDropdownList(String role) {
        this.role= role;
    }

    @Override
    public String toString() {
        return this.role;
    }
}
