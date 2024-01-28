/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotelmanagement.model;

/**
 *
 * @author Admin
 */
public class Session {

    private static Session instance = new Session();
    private int staffId;
    private String nameStaff;

    public Session() {
    }

    public static Session getInstance() {
        return instance;
    }

    public void setStaffId(int id) {
        this.staffId = id;
    }

    public int getStaffId() {
        return this.staffId;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

}
