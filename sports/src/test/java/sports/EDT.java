package sports;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.opi.sports.contracts.EstablecimientoDeportivoRequest;
import org.opi.sports.pojo.EstablecimientoDeportivoPOJO;;

/**
 * 
 * @author Mauricio
 *
 */
public class EDT {
 
 private static EstablecimientoDeportivoRequest establecimientoRequest;
 private static EstablecimientoDeportivoPOJO establecimiento;
 
 @BeforeClass
 public static void setUpBeforeClass() throws Exception {
	 establecimientoRequest = new EstablecimientoDeportivoRequest();
	 establecimiento = new EstablecimientoDeportivoPOJO();
 }

 @Test
 public void testCategoriaRequest() {
  assertNotNull(establecimientoRequest);
 }

 @Test
 public void testGetEstablecimiento() {
	 establecimientoRequest.setEstablecimientoDeportivo(establecimiento);
  assertSame(establecimientoRequest.getEstablecimientoDeportivo(), establecimiento);
 }

 @Test
 public void testSetEstablecimiento() {
	 establecimientoRequest.setEstablecimientoDeportivo(establecimiento);
  assertSame(establecimientoRequest.getEstablecimientoDeportivo(), establecimiento);
 }

}