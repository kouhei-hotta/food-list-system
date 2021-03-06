package models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "foods")
@NamedQueries({
    @NamedQuery(
            name = "getAllFoods",
            query = "SELECT f FROM Food AS f ORDER BY f.time_limit")
})

@Entity
public class Food {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @Column(name = "food_name", nullable = false)
    private String food_name;

    @Column(name = "amount", nullable = false)
    private String amount;     // 量

    @Column(name = "open_flag", nullable = false)
    private Integer open_flag;

    @Column(name = "time_limit", nullable = false)
    private Date time_limit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Integer getOpen_flag() {
        return open_flag;
    }

    public void setOpen_flag(Integer open_flag) {
        this.open_flag = open_flag;
    }

    public Date getTime_limit() {
        return time_limit;
    }

    public void setLimit(Date time_limit) {
        this.time_limit = time_limit;
    }



}
