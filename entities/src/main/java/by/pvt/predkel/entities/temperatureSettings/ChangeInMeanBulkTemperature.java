package by.pvt.predkel.entities.temperatureSettings;

import by.pvt.predkel.entities.Entity;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ChangeInMeanBulkTemperature complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 */

public class ChangeInMeanBulkTemperature extends Entity {
    private static final long serialVersionUID = 1L;

    private int roomId;

    private List<Double> changes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChangeInMeanBulkTemperature)) return false;
        if (!super.equals(o)) return false;

        ChangeInMeanBulkTemperature that = (ChangeInMeanBulkTemperature) o;

        if (getRoomId() != that.getRoomId()) return false;
        return getChanges() != null ? getChanges().equals(that.getChanges()) : that.getChanges() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getRoomId();
        result = 31 * result + (getChanges() != null ? getChanges().hashCode() : 0);
        return result;
    }

    /**
     * Gets the value of the roomId property.
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * Sets the value of the roomId property.
     */
    public void setRoomId(int value) {
        this.roomId = value;
    }

    /**
     * Gets the value of the changes property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the changes property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChanges().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Double }
     */
    public List<Double> getChanges() {
        if (changes == null) {
            changes = new ArrayList<Double>();
        }
        return this.changes;
    }

}
