package ro.agitman.page;

import org.apache.click.control.*;
import org.apache.click.extras.control.DateField;
import org.apache.click.extras.control.NumberField;

/**
 * Created by AlexandruG on 11/3/2014.
 */
public class AddPage extends BorderPage {

	private Form form = new Form("form");
	public String title = "Adauga";

	public AddPage() {
		addControl(form);
		form.setButtonAlign("right");
		form.setColumns(2);
		form.setLabelAlign("right");

		buildGeneralFieldSet();
		buildAddressFieldSet();
		buildPriceFieldSet();
		buildPeriodFieldSet();
		
		ActionButton button = new ActionButton("button");
		button.setListener(this, "onButtonClick"); 
		
		form.add(button);
		

	}
	
	public boolean onButtonClick() {
        
		return true;
    }

	private void buildPeriodFieldSet() {
		FieldSet price = new FieldSet("periodFs", "");
		price.setColumns(2);
		form.add(price);

		DateField din = new DateField("din");
		din.setSize(8);
		DateField pana = new DateField("pana");
		pana.setSize(8);
		Checkbox imediat = new Checkbox("imediat");
		Checkbox nedeterminat = new Checkbox("nedeterminat");

		price.add(din);
		price.add(imediat);
		price.add(pana);
		price.add(nedeterminat);
	}

	private void buildPriceFieldSet() {
		FieldSet price = new FieldSet("priceFs", "");
		price.setColumns(2);
		form.add(price);

		NumberField pret = new NumberField("pret", "Pret", 3);
		pret.setRequired(true);

		NumberField garantie = new NumberField("garantie", "Garantie", 3);
		Checkbox neg = new Checkbox("neg", "neg.");

		Select moneda = new Select("moneda", "");
		moneda.add(new Option("EUR"));
		moneda.add(new Option("RON"));

		price.add(pret);
		price.add(moneda);
		price.add(garantie);
		price.add(neg);
	}

	private void buildAddressFieldSet() {
		FieldSet address = new FieldSet("addrFs", "");
		address.setColumns(4);
		form.add(address);

		TextField titlu = new TextField("strada");
		titlu.setRequired(true);
		titlu.setStyle("width", "100%");

		TextField nr = new TextField("nr", "Nr.", 2);
		nr.setRequired(true);

		TextField bloc = new TextField("bl", "Bl.", 2);
		TextField scara = new TextField("sc", "Sc.", 2);
		TextField et = new TextField("et", "Et.", 2);
		TextField ap = new TextField("ap", "Ap.", 2);

		RadioGroup forma = new RadioGroup("forma", "");
		forma.setVerticalLayout(false);
		forma.add(new Radio("Chirie"));
		forma.add(new Radio("Gazda"));
		forma.add(new Radio("Coleg(a) camera"));

		address.add(titlu, 3);
		address.add(nr);
		address.add(bloc);
		address.add(scara);
		address.add(et);
		address.add(ap);
		address.add(forma, 4);
	}

	private void buildGeneralFieldSet() {
		FieldSet newFs = new FieldSet("newFs", "");
		form.add(newFs);

		TextField titlu = new TextField("titlu");
		titlu.setRequired(true);
		titlu.setStyle("width", "100%");

		Select oras = new Select("oras");
		oras.setRequired(true);
		oras.add(new Option("Iasi"));
		oras.add(new Option("Cluj"));
		oras.add(new Option("Bucuresti"));

		Select tip = new Select("tip");
		tip.setRequired(true);
		tip.add("Apartament");
		tip.add("Garsoniera");
		tip.add("Casa");
		tip.add("Camera in apartament");
		tip.add("Camera in Casa");

		newFs.add(titlu, 2);
		newFs.add(oras);
		newFs.add(tip);
	}

}
