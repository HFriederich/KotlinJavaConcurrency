import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.assertEquals;
import de.horst.java.Utility;

class UtilityTest {
	
	@Test
    fun addTest() {
		assertEquals(4,Utility.add(2,2))
	}
	
}