package com.terremoto.alarme;

import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class AlarmeTest {
	
	@Test
	public void terremotoForte(){
		Exercito exercito = mock(Exercito.class);
		SAMU samu = mock(SAMU.class);
		
		Alarme alarme = new Alarme();
		alarme.setExercito(exercito);
		alarme.setSamu(samu);
		
		alarme.tremorDetectado(8, true);
		
		verify(exercito).suporteTragedia();
		verify(samu).alertaDePossiveisFeridos();
		}
	
	@Test
	public void maremotoForte(){
		GuardaCosteira guardaCosteira = mock(GuardaCosteira.class);
		SAMU samu = mock(SAMU.class);
		
		Alarme alarme = new Alarme();
		alarme.setGuardaCosteira(guardaCosteira);
		alarme.setSamu(samu);
		
		alarme.tremorDetectado(8, false);
		
		verify(guardaCosteira).alertaTsunami();
		verify(samu).alertaDePossiveisFeridos();
	}
	
	@Test
	public void queimada(){
		CorpoBombeiros corpoBombeiros = mock(CorpoBombeiros.class);
		SAMU samu = mock(SAMU.class);
		
		Alarme alarme = new Alarme();
		alarme.setCorpoBombeiros(corpoBombeiros);
		alarme.setSamu(samu);
		
		alarme.queimadaDetectadda();
		
		InOrder inOrder = inOrder(samu, corpoBombeiros);
		inOrder.verify(samu).alertaDePossiveisFeridos();
		inOrder.verify(corpoBombeiros).alertaIncendio();
	}
}
