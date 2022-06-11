import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class appointmentTest {

  private String id, description;
  private String LONGID, DescriptionLong;
  private Date date, doneDate;

  @SuppressWarnings("deprecation")
  @BeforeEach
  void functionality() {
    id = "0123456789";
    description = "This will have a required description.";
    date = new Date(2021, Calendar.JULY, 29);
    LONGID = "000111222333444555666777888";
    DescriptionLong =
    		"This description is too long for the requirements so this will not work.";
    doneDate = new Date(0);
  }

  @Test
  void testUpdateappID() {
    appointment apoint = new appointment();
    assertThrows(IllegalArgumentException.class,
                 () -> apoint.updateappID(null));
    assertThrows(IllegalArgumentException.class,
                 () -> apoint.updateappID(LONGID));
    apoint.updateappID(id);
    assertEquals(id, apoint.getappID());
  }

  @Test
  void testGetappID() {
    appointment apoint = new appointment(id);
    assertNotNull(apoint.getappID());
    assertEquals(apoint.getappID().length(), 10);
    assertEquals(id, apoint.getappID());
  }

  @Test
  void testUpdateDate() {
    appointment apoint = new appointment();
    assertThrows(IllegalArgumentException.class, () -> apoint.updateDate(null));
    assertThrows(IllegalArgumentException.class,
                 () -> apoint.updateDate(doneDate));
    apoint.updateDate(date);
    assertEquals(date, apoint.getappDate());
  }

  @Test
  void testGetappDate() {
    appointment apoint = new appointment(id, date);
    assertNotNull(apoint.getappDate());
    assertEquals(date, apoint.getappDate());
  }

  @Test
  void testUpdateDescription() {
    appointment apoint = new appointment();
    assertThrows(IllegalArgumentException.class,
                 () -> apoint.updateDescription(null));
    assertThrows(IllegalArgumentException.class,
                 () -> apoint.updateDescription(DescriptionLong));
    apoint.updateDescription(description);
    assertEquals(description, apoint.getDescription());
  }

  @Test
  void testGetDescription() {
    appointment apoint = new appointment(id, date, description);
    assertNotNull(apoint.getDescription());
    assertTrue(apoint.getDescription().length() <= 50);
    assertEquals(description, apoint.getDescription());
  }
}
