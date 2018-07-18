package entidades;

import java.util.Calendar;
import java.util.HashSet;

public class ListaDeCompras {
	
	private String descricao;
	private String localDeCompra;
	private HashSet<Compra> compras;
	private Calendar data;

	public ListaDeCompras(String descricao) {
		setDescricao(descricao);
		compras = new HashSet<Compra>();
		data = Calendar.getInstance();
	}

	public void addItem(int quantidade, Item item) {
		compras.add(new Compra(quantidade, item));
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public HashSet<Compra> getCompras() {
		return compras;
	}

	public void setCompras(HashSet<Compra> compras) {
		this.compras = compras;
	}

	public Calendar getData() {
		return data;
	}

	public String getLocalDeCompra() {
		return localDeCompra;
	}

	public void setLocalDeCompra(String localDeCompra) {
		this.localDeCompra = localDeCompra;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaDeCompras other = (ListaDeCompras) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		String retorno = "";
		for(Compra c : compras) {
			retorno += "\n" + c.getQuantidade() + c.getItem();
		}
		return descricao  + retorno;
	}
	
	public String pesquisaCompraEmLista(int id) {
		
	}
	
}
