package org.example;

import java.time.LocalDate;

public class YoungestEldestWorker {

    private String youngestEldest;
    private String name;
    private LocalDate birthday;


    public YoungestEldestWorker(String youngestEldest, String name, LocalDate birthday) {
        this.youngestEldest = youngestEldest;
        this.name = name;
        this.birthday = birthday;
    }

    public String getYoungestEldest() {
        return this.youngestEldest;
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public void setYoungestEldest(String youngestEldest) {
        this.youngestEldest = youngestEldest;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof YoungestEldestWorker)) return false;
        final YoungestEldestWorker other = (YoungestEldestWorker) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$youngestEldest = this.getYoungestEldest();
        final Object other$youngestEldest = other.getYoungestEldest();
        if (this$youngestEldest == null ? other$youngestEldest != null : !this$youngestEldest.equals(other$youngestEldest))
            return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$birthday = this.getBirthday();
        final Object other$birthday = other.getBirthday();
        if (this$birthday == null ? other$birthday != null : !this$birthday.equals(other$birthday)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof YoungestEldestWorker;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $youngestEldest = this.getYoungestEldest();
        result = result * PRIME + ($youngestEldest == null ? 43 : $youngestEldest.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $birthday = this.getBirthday();
        result = result * PRIME + ($birthday == null ? 43 : $birthday.hashCode());
        return result;
    }

    public String toString() {
        return "YoungestEldestWorker(youngestEldest=" + this.getYoungestEldest() + ", name=" + this.getName() + ", birthday=" + this.getBirthday() + ")";
    }
}
