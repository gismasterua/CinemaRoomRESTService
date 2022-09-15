
class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName != null && !firstName.equals("")? firstName: "";
    }

    public void setLastName(String lastName) {
        this.lastName = lastName != null && !lastName.equals("")? lastName: "";
    }

    public String getFullName() {
        if (this.firstName.equals("") && this.lastName.equals("")){
            return "Unknown";
        }
        else {
            return this.firstName.concat(" ").concat(this.lastName);
        }
    }
}