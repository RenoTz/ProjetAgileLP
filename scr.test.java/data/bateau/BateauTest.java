package data.bateau;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import data.composants.Case;
import enumeration.EnumTypeBateau;

@RunWith(MockitoJUnitRunner.class)
public class BateauTest {
	
	
	
	@Mock
	private Bateau bateau;
	@Mock
	private Case casePlateau;
	
	@Test
	public void isCoule(){
		// Arrange
//		when(this.casePlateau.isCaseTouche()).thenReturn(true);
		bateau = new SousMarin();
		// Act
		boolean retour = bateau.isCoule();
		
		// Assert
//		assertTrue(retour);
		
	}

}
