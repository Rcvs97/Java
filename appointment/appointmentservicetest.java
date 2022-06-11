import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class appointmentservicetest {
  private String id, description, DescriptionLong;
  private Date date, doneDate;
  
  @SuppressWarnings("deprecation")
  @BeforeEach
  void functionality() {
    id = "0123456789";
    description = "This will have a required description.";
    date = new Date(2021, Calendar.JULY, 29);
    DescriptionLong =
        "This description is too long for the requirements so this will not work.";
    doneDate = new Date(0);
  }

  @Test
  void testnewappointment() {
    appointmentservice service = new appointmentservice();

    service.newappointment();
    assertNotNull(service.getappList().get(0).getappID());
    assertNotNull(service.getappList().get(0).getappDate());
    assertNotNull(service.getappList().get(0).getDescription());

    service.newappointment(date);
    assertNotNull(service.getappList().get(1).getappID());
    assertEquals(date,
                 service.getappList().get(1).getappDate());
    assertNotNull(service.getappList().get(1).getDescription());

    service.newappointment(date, description);
    assertNotNull(service.getappList().get(2).getappID());
    assertEquals(date,
                 service.getappList().get(2).getappDate());
    assertEquals(description,
                 service.getappList().get(2).getDescription());

    assertNotEquals(service.getappList().get(0).getappID(),
                    service.getappList().get(1).getappID());
    assertNotEquals(service.getappList().get(0).getappID(),
                    service.getappList().get(2).getappID());
    assertNotEquals(service.getappList().get(1).getappID(),
                    service.getappList().get(2).getappID());

    assertThrows(IllegalArgumentException.class,
                 () -> service.newappointment(doneDate));
    assertThrows(IllegalArgumentException.class,
                 () -> service.newappointment(date, DescriptionLong));
  }

  @Test
  void deleteappointment() throws Exception {
    appointmentservice service = new appointmentservice();

    service.newappointment();
    service.newappointment();
    service.newappointment();

    String ID1 = service.getappList().get(0).getappID();
    String ID2 = service.getappList().get(1).getappID();
    String ID3 = service.getappList().get(2).getappID();

    assertNotEquals(ID1, ID2);
    assertNotEquals(ID1, ID3);
    assertNotEquals(ID2, ID3);
    assertNotEquals(id, ID1);
    assertNotEquals(id, ID2);
    assertNotEquals(id, ID3);

    assertThrows(Exception.class, () -> service.deleteappointment(id));

    service.deleteappointment(ID1);
    assertThrows(Exception.class, () -> service.deleteappointment(ID1));
    assertNotEquals(ID1,
                    service.getappList().get(0).getappID());
  }
}