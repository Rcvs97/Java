import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class appointmentservice {
  final private List<appointment> appList = new ArrayList<>();

  private String newNewID() {
    return UUID.randomUUID().toString().substring(
        0, Math.min(toString().length(), 10));
  }

  public void newappointment() {
    appointment apoint = new appointment(newNewID());
    appList.add(apoint);
  }

  public void newappointment(Date date) {
    appointment apoint = new appointment(newNewID(), date);
    appList.add(apoint);
  }

  public void newappointment(Date date, String description) {
    appointment apoint = new appointment(newNewID(), date, description);
    appList.add(apoint);
  }

  public void deleteappointment(String id) throws Exception {
    appList.remove(searchForappointment(id));
  }

  protected List<appointment> getappList() { return appList; }

  private appointment searchForappointment(String id) throws Exception {
    int index = 0;
    while (index < appList.size()) {
      if (id.equals(appList.get(index).getappID())) {
        return appList.get(index);
      }
      index++;
    }
    throw new Exception("The appointment is not made!");
  }
}
