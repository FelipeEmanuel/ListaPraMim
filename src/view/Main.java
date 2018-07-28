package view;

import java.io.File;
import java.util.ArrayList;

import controllers.ItemController;
import easyaccept.EasyAccept;

public class Main {

	public static void main(String[] args) throws Exception {
		
		ArrayList<String> testes = new ArrayList<>();
		testes.add("user_case" + File.separator + "use_case1.txt");
		testes.add("user_case" + File.separator + "use_case1_exception.txt");
		testes.add("user_case" + File.separator + "use_case2.txt");
		testes.add("user_case" + File.separator + "use_case2_exception.txt");
		testes.add("user_case" + File.separator + "use_case3.txt");
		testes.add("user_case" + File.separator + "use_case3_exception.txt");
		testes.add("user_case" + File.separator + "use_case4.txt");
		testes.add("user_case" + File.separator + "use_case4_exception.txt");
		testes.add("user_case" + File.separator + "use_case5.txt");
		testes.add("user_case" + File.separator + "use_case6.txt");

		
		
		EasyAccept.executeEasyAcceptTests("view.Facade", testes);
}
	
}