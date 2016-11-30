package enums;


public enum Role {
    ADMINISTRATOR("Administrator"),
    MERCHANDISER("Merchandiser"),
    SUPERVISOR("Supervisor"),
    CUSTOMER("Customer");

    private String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
