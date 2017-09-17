package ggui;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Vector;

import core.base.CoreBaseClassFactory;
import core.base.CoreCallback;
import core.context.CoreContext;
import core.interfaces.ICoreObject;
import core.interfaces.IExecutable;
import core.service.CoreServiceContainer;

public class GuiButton extends Button implements ICoreObject, MouseListener
{
	public static final String CLICKED = "clicked";
	public static final String PRESSED = "pressed";
	public static final String RELEASED = "released";
	public static final String ENTERED = "entered";
	public static final String EXITED = "exited";

	private static final long serialVersionUID = 1L;
	private String _name;
	protected static int nameIndex = 0;
	protected String namePrefix = "button";
	public CoreServiceContainer sc = CoreServiceContainer.getInstance();
	public CoreContext context = CoreContext.getInstance();
	public HashMap<String, Vector<IExecutable>> callbacks = new HashMap<String, Vector<IExecutable>>();

	public GuiButton(String label)
	{
		this._name = this.generateName();
		CoreBaseClassFactory.construct(this);
		this.context = CoreContext.getInstance();
		System.out.println(this._name);
		this.setLabel(label);
		this.setPreferredSize(new Dimension(150, 50));
		this.addMouseListener(this);
	}

	private String generateName()
	{
		return (String) (this.namePrefix + nameIndex++);
	}

	@Override
	public String name()
	{
		return this._name;
	}

	@Override
	public Object execute(HashMap<String, Object> params)
	{
		String expression = (String) params.get("callable.name");
		if (this.expressionBuilder(".add.callback").equals(expression))
			CoreBaseClassFactory.serviceAddCallback(this, params);
		if (this.expressionBuilder(".add.callbacks").equals(expression))
			CoreBaseClassFactory.serviceAddCallbacks(this, params);
		return null;
	}

	private String expressionBuilder(String slug)
	{
		return (String) this.name() + slug;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		this.createCallBack(CLICKED).send();
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		this.createCallBack(PRESSED).send();
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		this.createCallBack(RELEASED).send();
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		this.createCallBack(ENTERED).send();

	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		this.createCallBack(EXITED).send();

	}

	@Override
	public CoreCallback createCallBack(String group) 
	{
		return CoreBaseClassFactory.createCallBack( group,this.callbacks);
	}


	@Override
	public void log(Object message)
	{
		CoreBaseClassFactory.log(this, message);
	}

	@Override
	public void log(String message)
	{
		CoreBaseClassFactory.log(this, message);
	}

}
