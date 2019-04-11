package gui.components;

import java.lang.*;
import java.awt.*;

public class MyColor {
	private Color bgColor;
	private Color buttonColor;
	private Color secondaryButtonColor;
	private Color primaryHoverColor;
	private Color secondaryHoverColor;
	private Color textColor;
	private Color navBarColor;
	private Color titleBarColor;
	private Color editButtonColor;
	private Color deleteButtonColor;
	private Color tBackgroundColor;

	public MyColor() {
		bgColor = new Color(255, 255, 255);
		buttonColor = new Color(112, 111, 211);
		primaryHoverColor = new Color(71, 71, 135);
		secondaryHoverColor = new Color(179, 57, 57);
		textColor = new Color(116, 116, 116);
		secondaryButtonColor = new Color(255, 82, 82);
		navBarColor = new Color(44, 58, 71);
		titleBarColor = new Color(24, 44, 97);
		editButtonColor = new Color(0, 184, 148);
		deleteButtonColor = new Color(214, 48, 49);

		tBackgroundColor = new Color(112, 111, 211, 80);

	}

	public Color getBgColor() {
		return this.bgColor;
	}

	public Color getButtonColor() {
		return this.buttonColor;
	}

	public Color getPrimaryHoverColor() {
		return this.primaryHoverColor;
	}

	public Color getTextColor() {
		return this.textColor;
	}

	public Color getsecondaryButtonColor() {
		return this.secondaryButtonColor;
	}

	public Color getsecondaryHoverColor() {
		return this.secondaryHoverColor;
	}

	public Color getNavbarColor() {
		return this.navBarColor;
	}

	public Color gettitleBarColor() {
		return this.titleBarColor;
	}

	public Color getEditButtonColor() {
		return this.editButtonColor;
	}

	public Color getDelteButtonColor() {
		return this.deleteButtonColor;
	}

	public Color gettBackgroundColor() {
		return this.tBackgroundColor;
	}
}