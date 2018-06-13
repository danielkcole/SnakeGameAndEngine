package com.dkc.engine;

import com.dkc.controller.Controller;
import com.dkc.model.Model;
import com.dkc.view.View;

public abstract class State {
	protected Model currentModel;
	protected View currentView;
	protected Controller currentController;
	
	public Model getModel() { return currentModel; }
	public View getView() { return currentView; }
	public Controller getController() { return currentController; }	
	public void setModel( Model m ) { currentModel = m; }
	public void setState( View v ) { currentView = v; }
	public void setController(Controller c) { currentController = c; }	
}
