package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantos contribuintes voce vai digitar? ");
		int n = sc.nextInt();

		System.out.println();

		List<TaxPayer> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			System.out.println("Digite os dados do " + (i + 1) + "ª contribuinte:");
			System.out.print("Renda anual com salário: ");
			double salAno = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double salSer = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double salCap = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			double gasMed = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double gasEdu = sc.nextDouble();

			TaxPayer taxpayer = new TaxPayer(salAno, salSer, salCap, gasMed, gasEdu);

			list.add(taxpayer);

			System.out.println();

		}
		for (int i = 0; i < list.size(); i++) {
			TaxPayer e = list.get(i);
			System.out.println();
			System.out.println("Resumo do " + (i + 1) + "º contribuinte:");
			System.out.printf("Imposto bruto total: %.2f%n", e.grossTax());
			System.out.printf("Abatimento: %.2f%n", e.taxRebate());
			System.out.printf("Imposto devido: %.2f%n", e.netTax());
			System.out.println();
		}

		sc.close();
	}

}
