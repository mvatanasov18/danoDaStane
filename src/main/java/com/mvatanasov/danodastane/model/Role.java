package com.mvatanasov.danodastane.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Role {
    @Id
    private Integer id;
    private String roleName;

    private Boolean isTeamLead;
    private Boolean isCEO;
    private Boolean isDeveloper;
    private Boolean isUnassigned;

    public void setIdByRoleName(){
        switch (roleName){
            case "CEO": this.id=1;break;
            case "Developer": this.id=3;break;
            case "Team Lead": this.id=2;break;
            case "Unassigned": this.id=4;break;
        }
    }

    public Role(String roleName){
        this.roleName=roleName;

    }
    public Role(int id) {
        this.id=id;
        switch (id){
            case 1:roleName="CEO";break;
            case 2:roleName="Team Lead";break;
            case 3:roleName="Developer";break;
            case 4:roleName="Unassigned";break;

        }
    }


    public Boolean getTeamLead() {
        return isTeamLead;
    }

    public void setTeamLead() {
        isTeamLead = roleName.equals("Team Lead");
    }

    public Boolean getCEO() {
        return isCEO;
    }

    public void setCEO() {
        isTeamLead = roleName.equals("CEO");
    }

    public Boolean getDeveloper() {
        return isDeveloper;
    }

    public void setDeveloper() {
        isTeamLead = roleName.equals("Developer");
    }

    public Boolean getUnassigned() {
        return isUnassigned;
    }

    public void setUnassigned() {
        isTeamLead = roleName.equals("Unassigned");
    }

    public void setBooleanFields(){
        setCEO();
        setDeveloper();
        setTeamLead();
        setUnassigned();
        System.out.println("isCEO: "+getCEO());
        System.out.println("isDeveloper: "+getDeveloper());
        System.out.println("isTeamLead: "+getTeamLead());
        System.out.println("isUnassigned: "+getUnassigned());

    }

    public Role() {
        //setBooleanFields();
    }
    public Role(Integer id,String name){
        this.id=id;
        this.roleName=name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id.equals(role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
