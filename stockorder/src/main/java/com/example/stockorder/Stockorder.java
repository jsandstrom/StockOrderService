package com.example.stockorder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stockorder {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer amount;
    private boolean buy;
    private Integer stockId;
    private double fee;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public boolean isBuy() {
		return this.buy;
	}

	public void setBuy(boolean buy) {
		this.buy = buy;
	}

	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

    public void setFee(double d) {
        this.fee = d;
    }

    public Double getFee() {
        return this.fee;
    }

    public Double calculateTotalCost() {
        return amount + fee;
    }

}