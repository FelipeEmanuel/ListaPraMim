package entidades;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import comparators.ComparadorNome;

public class ListaDeCompras implements Comparable<ListaDeCompras> {
	
	private String descricao;
	private String localDeCompra;
	private double valorCompra;
	private HashSet<Compra> compras;
	private Date data;
	private long  hora;

	public ListaDeCompras(String descricao) {
		setDescricao(descricao);
		compras = new HashSet<Compra>();
		data = new Date();
		hora = System.currentTimeMillis();
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

	public Date getData() {
		return data;
	}
	
	public String  dataString() {
		String date = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(getData());
		return date;
	}

	
	public String getLocalDeCompra() {
		return localDeCompra;
	}

	public void setLocalDeCompra(String localDeCompra) {
		this.localDeCompra = localDeCompra;
	}

	
	public double getValorCompra() {
		return valorCompra;
	}

	
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}

	
	
	public long getHora() {
		return hora;
	}

	@Override
	public int compareTo(ListaDeCompras l) {
		return this.getDescricao().compareTo(l.getDescricao());
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
		for (Compra c: compras) {
			if(c.getItem().getId() == id)
				return c.toString();
		}
		throw new IllegalArgumentException("Erro na pesquisa de compra: compra nao encontrada na lista.");
	}
	
	public void addQuantidade(int id, int quantidade) {
		for (Compra c: compras) {
			if(c.getItem().getId() == id)
				c.adicionaQuantidade(quantidade);
		}
	}
	
	public void diminuiQuantidade(int id, int quantidade) {
		for (Compra c: compras) {
			if(c.getItem().getId() == id) {
				c.diminuiQuantidade(quantidade);
				if(c.getQuantidade()<=0)
					compras.remove(c);
				break;
			}
		}
	}
	
	public void finalizarListaDeCompras(String localDaCompra, double valorFinal) {
		setLocalDeCompra(localDaCompra);
		setValorCompra(valorFinal);
	}
	
	public String getItemLista(int posicao) {
		ArrayList<Item> itens = listaItens();
		if(posicao >= itens.size())
			return "";
		int q = 0;
		for(Compra c: compras) {
			if(c.getItem().equals(itens.get(posicao))) {
				q = c.getQuantidade();
				return  q + " " + itens.get(posicao).toStringCompra();
			}
		}
		return "";
	}
	
	public ArrayList<Item> listaItens() {
		
		ArrayList<Item> itens = new ArrayList<Item>(),itens2 = new ArrayList<Item>();
		
		for(Compra c : compras) {
			if(c.getItem().getCategoria().equals("higiene pessoal")) {
				itens2.add(c.getItem());
			}
		}
		itens2.sort(new ComparadorNome());
		for(Item i : itens2) {
			itens.add(i);
		}		
		itens2.clear();
		
		for(Compra c : compras) {
			if(c.getItem().getCategoria().equals("limpeza")) {
				itens2.add(c.getItem());
			}
		}
		itens2.sort(new ComparadorNome());
		for(Item i : itens2) {
			itens.add(i);
		}
		itens2.clear();
		
		for(Compra c : compras) {
			if(c.getItem().getCategoria().equals("alimento industrializado")) {
				itens2.add(c.getItem());
			}
		}
		itens2.sort(new ComparadorNome());
		for(Item i : itens2) {
			itens.add(i);
		}
		itens2.clear();
		
		for(Compra c : compras) {
			if(c.getItem().getCategoria().equals("alimento nao industrializado")) {
				itens2.add(c.getItem());
			}
		}
		
		itens2.sort(new ComparadorNome());
		for(Item i : itens2) {
			itens.add(i);
		}
		itens2.clear();
		
		return itens;
	}
	
	public void deletaCompraDeLista(int id) {
		for(Compra c : compras) {
			if(c.getItem().getId() == id) {
				compras.remove(c);
				break;
			}
		}
	}

}
