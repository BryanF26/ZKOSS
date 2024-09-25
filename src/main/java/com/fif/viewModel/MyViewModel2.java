package com.fif.viewModel;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

public class MyViewModel2 {

	private int count;
	private String name;

	@Init
	public void init() {
		count = 100;
		name = "Bryan";
	}

	@Command
	@NotifyChange("count")
	public void cmd() {
		++count;
	}

	@Command
	@NotifyChange("name")
	public void change() {
		name = "ganti";
	}

	public int getCount() {
		return count;
	}

	public String getName() {
		return name;
	}
}
