package domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/*
 * @author Christof Van Cauteren
 */

@Entity
@Table(name = "TBL_TEST")
public class Test 
{   
    @Id
    private int testID;
    private String testname;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    private double resultAchieved;
    private int resultTotal;
    private String comment;

    public Test() {
    }
    
    public Test(String testname, Date date, double resultAchieved, int resultTotal, String comment) 
    {
        this.testname = testname;
        this.date = date;
        this.resultAchieved = resultAchieved;
        this.resultTotal = resultTotal;
        this.comment = comment;
    }

    public String getTestname() 
    {
        return testname;
    }

    public void setTestname(String testname) 
    {
        this.testname = testname;
    }

    public Date getDate() 
    {
        return date;
    }

    public void setDate(Date date) 
    {
        this.date = date;
    }

    public double getResultAchieved() 
    {
        return resultAchieved;
    }

    public void setResultAchieved(double resultAchieved) 
    {
        this.resultAchieved = resultAchieved;
    }

    public int getResultTotal() 
    {
        return resultTotal;
    }

    public void setResultTotal(int resultTotal) 
    {
        this.resultTotal = resultTotal;
    }

    public String getComment() 
    {
        return comment;
    }

    public void setComment(String comment) 
    {
        this.comment = comment;
    }
}
