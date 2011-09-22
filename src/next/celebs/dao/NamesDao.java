/*
 * Copyright 2011 Vancouver Ywebb Consulting Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package next.celebs.dao;

import java.util.ArrayList;

import next.celebs.api.API;
import next.celebs.di.Context;
import next.celebs.di.Storage;


import com.google.gwt.user.client.Random;

public class NamesDao {

	private Storage storage;
	private API api;
	private Context ctx;

	ArrayList<String> names = new ArrayList<String>();

	public ArrayList<String> getNames() {
		return names;
	}

	public String getRandomName() {
		int i = Math.abs(Random.nextInt(names.size() - 1));
		String n = names.get(i);
		if (!n.startsWith("<div")) {
			return n;
		} else {
			return getRandomName();
		}
	}

	public void init(Context ctx) {
		this.storage = ctx.getStorage();
		this.api = ctx.getApi();
		this.ctx = ctx;
		names.add("<div class='yAZ'>A</div>");
		names.add("Adriana Lima");
		names.add("Alessandra Ambrosio");
		names.add("Ali Landry");
		names.add("Ali Larter");
		names.add("Alicia Keys");
		names.add("Alicia Silverstone");
		names.add("Alyson Hannigan");
		names.add("Alyssa Milano");
		names.add("Amy Smart");
		names.add("Angelina Jolie");
		names.add("Anna Kournikova");
		names.add("Anna Nicole Smith");
		names.add("AnnaLynne McCord");
		names.add("Anne Hathaway");
		names.add("Ashanti");
		names.add("Ashley Judd");
		names.add("Ashley Scott");
		names.add("Ashley Tisdale");
		names.add("Autumn Reeser");
		names.add("Avril Lavigne");

		names.add("<div class='yAZ'>B</div>");
		names.add("Bar Refaeli");
		names.add("Bettie Page");
		names.add("Beyonce");
		names.add("Bonnie-Jill Laflin");
		names.add("Bridget Moynahan");
		names.add("Britney Spears");
		names.add("Brooke Burke");

		names.add("<div class='yAZ'>C</div>");
		names.add("Cameron Diaz");
		names.add("Carmen Electra");
		names.add("Carrie Underwood");
		names.add("Cassie");
		names.add("Catherine Bell");
		names.add("Catherine Zeta-Jones");
		names.add("Charlize Theron");
		names.add("Christina Aguilera");
		names.add("Christina Milian");
		names.add("Christina Ricci");
		names.add("Ciara");
		names.add("Cindy Crawford");
		names.add("Claire Forlani");
		names.add("Claudia Schiffer");

		names.add("<div class='yAZ'>D</div>");
		names.add("Danneel Harris");
		names.add("Demi Moore");
		names.add("Denise Richards");
		names.add("Dianna Agron");
		names.add("Diora Baird");
		names.add("Drea de Matteo");
		names.add("Drew Barrymore");

		names.add("<div class='yAZ'>E</div>");
		names.add("Elisabeth Shue");
		names.add("Elisha Cuthbert");
		names.add("Eliza Dushku");
		names.add("Elizabeth Banks");
		names.add("Elizabeth Hurley");
		names.add("Elvira");
		names.add("Emmanuelle Vaugier");
		names.add("Emmy Rossum");
		names.add("Erica Durance");
		names.add("Estella Warren");
		names.add("Eva Longoria");
		names.add("Eva Mendes");
		names.add("Evangeline Lilly");

		names.add("<div class='yAZ'>F</div>");
		names.add("Faith Hill");
		names.add("Farrah Fawcett");
		names.add("Fergie");
		names.add("Fiona Apple");

		names.add("<div class='yAZ'>G</div>");
		names.add("Gabrielle Union");
		names.add("Gena Lee Nolin");
		names.add("Gisele Bundchen");
		names.add("Gwen Stefani");
		names.add("Gwyneth Paltrow");

		names.add("<div class='yAZ'>H</div>");
		names.add("Halle Berry");
		names.add("Hannah Montana");
		names.add("Hayden Panettiere");
		names.add("Heather Graham");
		names.add("Heather Locklear");
		names.add("Heidi Klum");
		names.add("Hilary Duff");
		names.add("Hilary Swank");

		names.add("<div class='yAZ'>J</div>");
		names.add("Jada Pinkett-Smith");
		names.add("Jaime Pressly");
		names.add("Janet Jackson");
		names.add("Jayne Mansfield");
		names.add("Jenna Dewan");
		names.add("Jennifer Aniston");
		names.add("Jennifer Connelly");
		names.add("Jennifer Garner");
		names.add("Jennifer Lopez");
		names.add("Jenny McCarthy");
		names.add("Jeri Ryan");
		names.add("Jessica Alba");
		names.add("Jessica Biel");
		names.add("Jessica Simpson");
		names.add("Jessica Van Der Steen");
		names.add("JoJo");
		names.add("Joanna Levesque");
		names.add("Jordana Brewster");
		names.add("Julia Roberts");
		names.add("Julianne Moore");

		names.add("<div class='yAZ'>K</div>");
		names.add("Kate Beckinsale");
		names.add("Kate Bosworth");
		names.add("Kate Middleton");
		names.add("Kate Moss");
		names.add("Kate Winslet");
		names.add("Katharine McPhee");
		names.add("Katherine Heigl");
		names.add("Katie Holmes");
		names.add("Katy Perry");
		names.add("Keira Knightley");
		names.add("Kelly Brook");
		names.add("Kelly Carlson");
		names.add("Kelly Clarkson");
		names.add("Kesha");
		names.add("Kim Basinger");
		names.add("Kim Kardashian");
		names.add("Kim Smith");
		names.add("Krista Allen");
		names.add("Kristen Bell");
		names.add("Kristen Stewart");
		names.add("Kristin Kreuk");
		names.add("Kylie Minogue");

		names.add("<div class='yAZ'>L</div>");
		names.add("Lady GaGa");
		names.add("Laetitia Casta");
		names.add("Leeann Tweeden");
		names.add("Leila Arcieri");
		names.add("Leona Lewis");
		names.add("Lindsay Lohan");
		names.add("Lucy Liu");

		names.add("<div class='yAZ'>M</div>");
		names.add("Madonna");
		names.add("Majandra Delfino");
		names.add("Malin Akerman");
		names.add("Mandy Moore");
		names.add("Maria Sharapova");
		names.add("Mariah Carey");
		names.add("Marisa Miller");
		names.add("Marilyn Monroe");
		names.add("Megan Fox");
		names.add("Mia Kirshner");
		names.add("Michelle Pfeiffer");
		names.add("Michelle Rodriguez");
		names.add("Mila Kunis");
		names.add("Miley Cyrus");
		names.add("Milla Jovovich");
		names.add("Mischa Barton");
		names.add("Monica Bellucci");
		names.add("Moon Bloodgood");

		names.add("<div class='yAZ'>N</div>");
		names.add("Naomi Campbell");
		names.add("Natalie Imbruglia");
		names.add("Natalie Portman");
		names.add("Natalie Wood");
		names.add("Natasha Bedingfield");
		names.add("Natassia Malthe");
		names.add("Nathalie Kelley");
		names.add("Nelly Furtado");
		names.add("Nicole Kidman");
		names.add("Nicole Scherzinger");
		names.add("Nicolette Sheridan");
		names.add("Nikki Cox");

		names.add("<div class='yAZ'>O</div>");
		names.add("Olivia Wilde");

		names.add("<div class='yAZ'>P</div>");
		names.add("Pamela Anderson");
		names.add("Paris Hilton");
		names.add("Paulina Rubio");
		names.add("Penelope Cruz");
		names.add("Pink");

		names.add("<div class='yAZ'>R</div>");
		names.add("Rachel Bilson");
		names.add("Rachel McAdams");
		names.add("Rebecca Romijn");
		names.add("Reese Witherspoon");
		names.add("Renee Zellweger");
		names.add("Rihanna");
		names.add("Rosario Dawson");
		names.add("Rose McGowan");
		names.add("Roselyn Sanchez");

		names.add("<div class='yAZ'>S</div>");
		names.add("Salma Hayek");
		names.add("Sandra Bullock");
		names.add("Sarah Brightman");
		names.add("Scarlett Johansson");
		names.add("Selena");
		names.add("Shakira");
		names.add("Shania Twain");
		names.add("Shanna Moakler");
		names.add("Shannon Elizabeth");
		names.add("Sharon Stone");
		names.add("Sherilyn Fenn");
		names.add("Cheryl Cole");
		names.add("Sienna Miller");
		names.add("Sofia Vergara");
		names.add("Sophia Bush");
		names.add("Sophia Loren");
		names.add("Stacy Keibler");

		names.add("<div class='yAZ'>T</div>");
		names.add("Tara Reid");
		names.add("Taylor Swift");
		names.add("Teri Hatcher");
		names.add("Toni Braxton");
		names.add("Tyra Banks");

		names.add("<div class='yAZ'>U</div>");
		names.add("Uma Thurman");

		names.add("<div class='yAZ'>V</div>");
		names.add("Vanessa Hudgens");
		names.add("Vanessa Marcil");
		names.add("Vanessa Minnillo");
		names.add("Vanessa Williams");
		names.add("Veronica Varekova");
		names.add("Victoria Beckham");
		names.add("Victoria Silvstedt");
		names.add("Virginie Ledoyen");

		names.add("<div class='yAZ'>Z</div>");
		names.add("Zhang Ziyi");
		names.add("Zoe Saldana");
	}

}
