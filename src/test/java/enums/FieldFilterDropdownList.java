package enums;

public enum FieldFilterDropdownList {
    ALL_COLUMNS("All columns"),
    USER_NAME("User Name"),
    FIRST_NAME("First Name"),
    LAST_NAME("Last Name"),
    ROLE("Role");

    private String fieldname;

    FieldFilterDropdownList(String fieldname) {
        this.fieldname = fieldname;
    }

    public String getFieldName() {
        return fieldname;
    }
}
