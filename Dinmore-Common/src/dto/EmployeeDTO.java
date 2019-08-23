/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Bilal
 */
public class EmployeeDTO extends SuperDTO{
    
    private String id;
    private String password;
    private String role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public EmployeeDTO() {
    }

    public EmployeeDTO(String id, String password, String role) {
        this.id = id;
        this.password = password;
        this.role = role;
    }
    
    
}
