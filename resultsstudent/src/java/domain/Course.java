/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author thomas
 */
@Entity
@Table(name = "TBL_COURSE")

public class Course {
    @Id
    private int Id;
    
    private String name;
    private int Year;

    public Course() {
    }
    
    
    
    public Course(String name, int year){
        this.name = name;
        this.Year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }
    
    
    
}
