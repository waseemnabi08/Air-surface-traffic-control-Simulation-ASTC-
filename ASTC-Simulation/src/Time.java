public class Time {
    private int hour;
    private int minute;
    private int second;

    

    //defualt constructor
    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }
    public Time(int hour, int minute, int second) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be between 0 and 59");
        }
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Second must be between 0 and 59");
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public Time(Time time) {
        this.hour = time.getHour();
        this.minute = time.getMinute();
        this.second = time.getSecond();
    }

    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be between 0 and 59");
        }
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Second must be between 0 and 59");
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setTime(Time time) {
        this.hour = time.getHour();
        this.minute = time.getMinute();
        this.second = time.getSecond();
    }

    public int getHour() {
        return this.hour;
    }

    public void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Hour must be between 0 and 23");
        }
        this.hour = hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Minute must be between 0 and 59");
        }
        this.minute = minute;
    }

    public int getSecond() {
        return this.second;
    }

    public void setSecond(int second) {
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Second must be between 0 and 59");
        }
        this.second = second;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
    }

    public Time nextSecond() {
        ++this.second;
        if (this.second >= 60) {
            this.second = 0;
            ++this.minute;
            if (this.minute >= 60) {
                this.minute = 0;
                ++this.hour;
                if (this.hour >= 24) {
                    this.hour = 0;
                }
            }
        }
        return this;
    }

    public Time previousSecond() {
        --this.second;
        if (this.second < 0) {
            this.second = 59;
            --this.minute;
            if (this.minute < 0) {
                this.minute = 59;
                --this.hour;
                if (this.hour < 0) {
                    this.hour = 23;
                }
            }
        }
        return this;
    }

}
