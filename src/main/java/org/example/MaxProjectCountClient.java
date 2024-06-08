package org.example;

public class MaxProjectCountClient {
    private String name;
    private int projectCount;

    public MaxProjectCountClient(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    public String getName() {
        return this.name;
    }

    public int getProjectCount() {
        return this.projectCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MaxProjectCountClient)) return false;
        final MaxProjectCountClient other = (MaxProjectCountClient) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (this.getProjectCount() != other.getProjectCount()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MaxProjectCountClient;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        result = result * PRIME + this.getProjectCount();
        return result;
    }

    public String toString() {
        return "MaxProjectCountClient(name=" + this.getName() + ", projectCount=" + this.getProjectCount() + ")";
    }
}
