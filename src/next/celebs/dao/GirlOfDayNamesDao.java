package next.celebs.dao;

import java.util.ArrayList;
import java.util.Date;

import next.celebs.api.API;
import next.celebs.di.Context;
import next.celebs.di.Storage;


public class GirlOfDayNamesDao {

	private Storage storage;
	private API api;
	private Context ctx;

	ArrayList<String> names = new ArrayList<String>();

	public String getTodayName() {
		Date d = new Date();
		int date = d.getDate();
		System.out.println("today is the " + date);
		return names.get(date);
	}

	public void init(Context ctx) {
		this.storage = ctx.getStorage();
		this.api = ctx.getApi();
		this.ctx = ctx;
		names.add("Adriana Lima");
		names.add("Alessandra Ambrosio");
		names.add("Charlize Theron");
		names.add("Bar Refaeli");
		names.add("Eva Mendes");
		names.add("Megan Fox");
		names.add("Marisa Miller");
		names.add("Abbey Clancy");
		names.add("Kristen Bell");
		names.add("Kristen Stewart");
		names.add("Kristin Kreuk");
		names.add("Veronica Varekova");
		names.add("Jessica Simpson");
		names.add("Jessica Van Der Steen");
		names.add("Selita Ebanks");
		names.add("Keira Knightley");
		names.add("Adriana Lima");
		names.add("Megan Fox");
		names.add("Petra Nemcova");
		names.add("Molly Sims");
		names.add("Marisa Miller");
		names.add("Bar Refaeli");
		names.add("Gisele Bundchen");
		names.add("Heidi Klum");
		names.add("Halle Berry");
		names.add("Kim Kardashian");
		names.add("Shakira");
		names.add("Jessica Alba");
		names.add("Jessica Simpson");
		names.add("Julianne Moore");
		names.add("Adriana Lima");
		names.add("Alessandra Ambrosio");
		names.add("Charlize Theron");
		names.add("Bar Refaeli");
		names.add("Eva Mendes");
		names.add("Megan Fox");
	}

}
