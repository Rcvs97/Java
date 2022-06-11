import java.util.Date;

public class appointment {

  final private byte Id_Size;
  final private byte Length_Description;
  final private String START;
  private String appID;
  private Date appDate;
  private String description;

  {
    Id_Size = 10;
    Length_Description = 50;
    START = "Start";
  }

  appointment() {
    Date now = new Date();
    appID = START;
    appDate = now;
    description = START;
  }

  appointment(String id) {
    Date now = new Date();
    updateappID(id);
    appDate = now;
    description = START;
  }

  appointment(String id, Date date) {
    updateappID(id);
    updateDate(date);
    description = START;
  }

  appointment(String id, Date date, String description) {
    updateappID(id);
    updateDate(date);
    updateDescription(description);
  }

  public void updateappID(String id) {
    if (id == null) {
      throw new IllegalArgumentException("appointment ID cannot be empty.");
    } else if (id.length() > Id_Size) {
      throw new IllegalArgumentException("appointment ID cannot be bigger then " + Id_Size);
    } else {
      this.appID = id;
    }
  }

  public String getappID() { return appID; }

  public void updateDate(Date date) {
    if (date == null) {
      throw new IllegalArgumentException("appointment date cannot be empty.");
    } else if (date.before(new Date())) {
      throw new IllegalArgumentException(
          "Appointment must be futute or present.");
    } else {
      this.appDate = date;
    }
  }

  public Date getappDate() { return appDate; }

  public void updateDescription(String description) {
    if (description == null) {
      throw new IllegalArgumentException(
          "appointment description cannot be empty.");
    } else if (description.length() > Length_Description) {
      throw new IllegalArgumentException(
          "appointment description cannot be more then " +
          Length_Description);
    } else {
      this.description = description;
    }
  }

  public String getDescription() { return description; }
}
