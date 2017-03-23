package com.rpgcampaigner.woin.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


/**
 * @author bebopjmm
 * @since 11/16/16
 */
@RunWith(MockitoJUnitRunner.class)
public class ModifierUT {

	@Test
	public void notifyOfChangeCallsSubscriber() {
		ModifierListener mockedListener = mock(ModifierListener.class);
		Modifier modifier = new Modifier();
		modifier.getSubscribers().add(mockedListener);
		modifier.setValue(5);
		verify(mockedListener).onModifierChange(5);

		modifier.getSubscribers().remove(mockedListener);
		modifier.setValue(2);
		verify(mockedListener, atMost(1)).onModifierChange(anyInt());
	}
}
