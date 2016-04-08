package com.terremoto.alarme;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class AlarmeTest {
	
	@Test
	public void terremotoForte(){
		Exercito exercito = mock(Exercito.class);
		
		Alarme alarme = new Alarme();
		alarme.setExercito(exercito);
		
		alarme.tremorDetectado(8, true);
		
		verify(exercito).suporteTragedia();
	}
	
	@Test
	public void maremotoForte(){
		GuardaCosteira guardaCosteira = mock(GuardaCosteira.class);
		
		Alarme alarme = new Alarme();
		alarme.setGuardaCosteira(guardaCosteira);
		
		alarme.tremorDetectado(8, false);
		
		verify(guardaCosteira).alertaTsunami();
	}
	
	@Test
	public void queimada(){
		CorpoBombeiros corpoBombeiros = mock(CorpoBombeiros.class);
		
		Alarme alarme = new Alarme();
		alarme.setCorpoBombeiros(corpoBombeiros);
		
		alarme.queimadaDetectadda();
		
		verify(corpoBombeiros).alertaIncendio();
	}
}
