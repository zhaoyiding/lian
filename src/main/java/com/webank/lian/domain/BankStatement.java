package com.webank.lian.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by eleanorchen on 2018/7/28.
 */
public class BankStatement {
    private Integer id;

    private String bankName;

    private String personIdentification;

    private Timestamp operateDate;

    private String operateType;

    private BigDecimal amount;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BankStatement{");
        sb.append("id=").append(id);
        sb.append(", bankName=").append(bankName);
        sb.append(", personIdentification=").append(personIdentification);
        sb.append(", operateDate=").append(operateDate);
        sb.append(", operateType=").append(operateType);
        sb.append(", amount=").append(amount);
        sb.append('}');
        return sb.toString();

    }

    public BankStatement(Integer id, String bankName, String personIdentification, Timestamp operateDate, String operateType, BigDecimal amount) {
        this.id = id;
        this.bankName = bankName;
        this.personIdentification = personIdentification;
        this.operateDate = operateDate;
        this.operateType = operateType;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPersonIdentification() {
        return personIdentification;
    }

    public void setPersonIdentification(String personIdentification) {
        this.personIdentification = personIdentification;
    }

    public Timestamp getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Timestamp operateDate) {
        this.operateDate = operateDate;
    }

    public String getOperateType() {
        return operateType;
    }

    public void setOperateType(String operateType) {
        this.operateType = operateType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
