/**
 * 
 */
package com.company.minicap;

import java.awt.*;


 
public interface ScreenSubject {
	public void registerObserver(AndroidScreenObserver o);

	public void removeObserver(AndroidScreenObserver o);

	public void notifyObservers(Image image);

}
