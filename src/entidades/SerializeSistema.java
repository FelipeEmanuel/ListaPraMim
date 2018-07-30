package entidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SerializeSistema {

		public static void salvarItens(HashMap<Integer, Item> itens) {

			try {

				FileOutputStream fos = new FileOutputStream("data/itens.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(itens);

				oos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		
		public static HashMap<Integer, Item> carregaItens() {

			try {

				File arquivo = new File("data/itens.dat");
				if (!arquivo.exists())
					arquivo.createNewFile();

				FileInputStream fis = new FileInputStream(arquivo);
				ObjectInputStream ois = new ObjectInputStream(fis);

				@SuppressWarnings("unchecked")
				HashMap<Integer, Item> itens = (HashMap<Integer, Item>) ois.readObject();

				ois.close();
				return itens;

			} catch (IOException e) {
				return null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			return null;

		}
		
		public static void salvarListas(HashMap<String, ListaDeCompras> listas) {

			try {

				FileOutputStream fos = new FileOutputStream("data/listas.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(listas);

				oos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		
		public static HashMap<String, ListaDeCompras> carregaListas() {

			try {

				File arquivo = new File("data/listas.dat");
				if (!arquivo.exists()) 
					arquivo.createNewFile();
				
				FileInputStream fis = new FileInputStream(arquivo);
				ObjectInputStream ois = new ObjectInputStream(fis);

				@SuppressWarnings("unchecked")
				HashMap<String, ListaDeCompras> listas = (HashMap<String, ListaDeCompras>) ois.readObject();

				ois.close();
				return listas;

			} catch (IOException e) {
				return null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			return null;

		}
	
}
