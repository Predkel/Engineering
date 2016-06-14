package by.pvt.predkel.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for anonymous complex type.
 */


public class User extends Entity {
    private static final long serialVersionUID = 1L;
    private String login;
    private String password;
    private int role;
    private List<Building> building;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getRole() != user.getRole()) return false;
        if (!getLogin().equals(user.getLogin())) return false;
        return getPassword().equals(user.getPassword());

    }

    @Override
    public int hashCode() {
        int result = getLogin().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getRole();
        return result;
    }

    public User() {
    }

    public User(String login, String password, Integer role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }


    /**
     * Gets the value of the login property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Gets the value of the password property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the role property.
     */
    public int getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     */
    public void setRole(Integer value) {
        this.role = value;
    }

    /**
     * Gets the value of the building property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the building property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBuilding().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Building }
     */
    public List<Building> getBuilding() {
        if (building == null) {
            building = new ArrayList<Building>();
        }
        return this.building;
    }

    public void setBuilding(List<Building> building) {
        this.building = building;
    }
}
