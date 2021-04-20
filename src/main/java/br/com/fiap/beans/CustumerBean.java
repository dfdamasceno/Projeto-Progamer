package br.com.fiap.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.CustumerDAO;
import br.com.fiap.model.Custumer;

@Named
@RequestScoped
public class CustumerBean {

	private Custumer custumer;

	public void save() {
		new CustumerDAO().save(this.custumer);
		//this.custumer = new Custumer();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Custumer cadastrado com sucesso"));
	}

	public List<Custumer> getCustumers() {
		return new CustumerDAO().getAll();
	}

	public void executar() {
		System.out.println("acionando o bean");
	}

	public Custumer getCustumer() {
		return custumer;
	}

	public void Custumer(Custumer custumer) {
		this.custumer = custumer;
	}

}
