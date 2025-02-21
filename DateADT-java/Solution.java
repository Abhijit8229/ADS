class DateADT {
    private long year;
    private long month;
    private long day;
    private long hours;
    private long minutes;
    private long seconds;
    private long milliseconds;

    public DateADT(long year, long month, long day) {

        this.year = year;
        this.month = month;
        this.day = day;
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
        this.milliseconds = 0;
        if (!this.checkDate() || !this.checktime()) {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    public DateADT(long year, long month, long day, long hours, long minutes, long seconds) {

        this.year = year;
        this.month = month;
        this.day = day;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.milliseconds = 0;
        if (!this.checkDate() || !this.checktime()) {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    public DateADT(String dateStr) {
        String[] date = dateStr.split(" ");
        String[] dateArr = date[0].split("-");
        this.year = Long.parseLong(dateArr[0]);
        this.month = Long.parseLong(dateArr[1]);
        this.day = Long.parseLong(dateArr[2]);
        if (date.length > 1) {
            String[] timeArr = date[1].split(":");
            this.hours = Long.parseLong(timeArr[0]);
            this.minutes = Long.parseLong(timeArr[1]);
            this.seconds = Long.parseLong(timeArr[2]);
            this.milliseconds = 0;
        }
        if (!this.checkDate() || !this.checktime()) {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    private boolean checkDate() {
        if (year < 0 || month < 0 || month > 11 || day < 1 || day > 31) {
            return false;
        }
        if (month == 1) {
            if (year % 4 == 0) {
                if (day > 29) {
                    return false;
                }
            } else {
                if (day > 28) {
                    return false;
                }
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30) {
                return false;
            }
        }
        return true;
    }

    public boolean checktime() {
        if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59 || seconds < 0 || seconds > 60) {
            return false;
        }
        return true;
    }

    // getters
    public long getYear() {
        return year;
    }

    public long getMonth() {
        return month;
    }

    public long getDay() {
        return day;
    }

    public long getHours() {
        return hours;
    }

    public long getMinutes() {
        return minutes;
    }

    public long getSeconds() {
        return seconds;
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    public long getTime() {

        long totalDays = (year * 365 + month * 30 + day);
        return (totalDays * 24 * 3600000) + (hours * 3600000) + (minutes * 60000) + (seconds * 1000) + milliseconds;
    }

    // setters
    public void setHours(long hours) {
        this.hours = hours;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    public void setSeconds(long seconds) {
        this.seconds = seconds;
    }

    public void setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public void setMonth(long month) {
        this.month = month;
    }

    public void setDay(long day) {
        this.day = day;
    }

    public void setTime(long ms) {

        long totalDays = ms / 86400000;
        ms = ms % 86400000;

        this.year = (int) (totalDays / 365);
        int remainingDays = (int) (totalDays % 365);
        this.month = remainingDays / 30;
        this.day = remainingDays % 30;

        this.hours = ms / 3600000;
        ms = ms % 3600000;

        this.minutes = ms / 60000;
        ms = ms % 60000;

        this.seconds = ms / 1000;
        this.milliseconds = ms % 1000;
    }

    public boolean before(DateADT date) {

        long day = date.getDay();
        long month = date.getMonth();
        long Year = date.getYear();
        long hrs = date.getHours();
        long min = date.getMinutes();
        long seconds = date.getSeconds();
        if (this.year < Year) {
            return true;
        } else if (this.year == Year) {
            if (this.month < month) {
                return true;
            } else if (this.month == month) {
                if (this.day < day) {
                    return true;
                } else if (this.day == day) {
                    if (this.hours < hrs) {
                        return true;
                    } else if (this.hours == hrs) {
                        if (this.minutes < min) {
                            return true;
                        } else if (this.minutes == min) {
                            if (this.seconds < seconds) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean after(DateADT date) {
        long day = date.getDay();
        long month = date.getMonth();
        long year = date.getYear();
        long hrs = date.getHours();
        long min = date.getMinutes();
        long seconds = date.getSeconds();
        if (this.year > year) {
            return true;
        } else if (this.year == year) {
            if (this.month > month) {
                return true;
            } else if (this.month == month) {
                if (this.day > day) {
                    return true;
                } else if (this.day == day) {
                    if (this.hours > hrs) {
                        return true;
                    } else if (this.hours == hrs) {
                        if (this.minutes > min) {
                            return true;
                        } else if (this.minutes == min) {
                            if (this.seconds > seconds) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        return String.format("%04d-%02d-%02d %02d:%02d:%02d", year, month, day, hours, minutes, seconds);

    }

}
