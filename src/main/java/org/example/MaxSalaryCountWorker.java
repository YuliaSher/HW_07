package org.example;

import java.math.BigDecimal;

public class MaxSalaryCountWorker {
    private String name;
    private BigDecimal salary;

    public MaxSalaryCountWorker(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MaxSalaryCountWorker)) return false;
        final MaxSalaryCountWorker other = (MaxSalaryCountWorker) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$salary = this.getSalary();
        final Object other$salary = other.getSalary();
        if (this$salary == null ? other$salary != null : !this$salary.equals(other$salary)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MaxSalaryCountWorker;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $salary = this.getSalary();
        result = result * PRIME + ($salary == null ? 43 : $salary.hashCode());
        return result;
    }

    public String toString() {
        return "MaxSalaryCountWorker(name=" + this.getName() + ", salary=" + this.getSalary() + ")";
    }
}
