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

    public String getRoleType() {
        return roleName;
    }
    
    public static Role getRole(final String roleString) {
        for (final Role roleEnum : Role.values()) {
            if (roleEnum.getRoleType().equals(roleString)) {
                return roleEnum;
            }
        }
        return null;
    }
}
