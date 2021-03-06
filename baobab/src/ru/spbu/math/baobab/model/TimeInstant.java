package ru.spbu.math.baobab.model;

import com.google.common.base.Objects;

/**
 * Time instant is a moment of a day, with minute precision. It repeats every day. E.g. 9:30 is a time instant.
 * 
 * @author dbarashev
 */
public class TimeInstant {
  private final int myHour;
  private final int myMinute;

  public TimeInstant(int hour, int minute) {
    assert hour >= 0 && hour <= 23 : "invalid hour value=" + hour;
    assert minute >= 0 && minute <= 59 : "invalid minute value=" + minute;
    myHour = hour;
    myMinute = minute;
  }

  public int getHour() {
    return myHour;
  }

  public int getMinute() {
    return myMinute;
  }

  public int getDayMinute() {
    return myHour * 60 + myMinute;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(myHour, myMinute);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof TimeInstant == false) {
      return false;
    }

    TimeInstant other = (TimeInstant) obj;
    return Objects.equal(myHour, other.myHour) && Objects.equal(myMinute, other.myMinute);
  }

  /**
   * Create TimeInstant using only minutes
   * 
   * @param minutes
   * @author aoool
   */
  public TimeInstant(int minutes) {
    assert minutes >= 0 && minutes < 1440 : "invalid minutes value=" + minutes;
    myHour = minutes / 60;
    myMinute = minutes - (myHour * 60);
  }
}
