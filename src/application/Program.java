package application;

import entities.Adress;
import entities.Department;
import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String dep = sc.next();
        System.out.print("Dia do pagamento: ");
        int day = sc.nextInt();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Telefone: ");
        String phone = sc.next();

        Adress adress = new Adress(email, phone);
        Department department = new Department(dep, day, adress);

        System.out.print("Quantos funcionários tem o departamento? ");
        int quantity = sc.nextInt();

        for (int i = 0; i < quantity; i++){
            System.out.println("Dados do funcionário " + (i +1) + ":");
            System.out.print("Nome: ");
            sc.nextLine();
            String employeeName = sc.nextLine();
            System.out.print("Salário: ");
            double employeeSalary = sc.nextDouble();

            Employee employee = new Employee(employeeName, employeeSalary);
            department.addEmployee(employee);
        }

        showReport(department);
    }

    public static void showReport(Department dept) {
        StringBuilder sb = new StringBuilder();
        sb.append("FOLHA DE PAGAMENTO: \n");
        sb.append("Departamento Vendas = R$");
        sb.append(String.format("%.2f%n", dept.payroll()));
        sb.append("Pagamento realizado no dia ");
        sb.append(dept.getPayDay()).append("\n");
        sb.append("Funcionários: \n");
        for (Employee dep : dept.getEmployees()) {
            sb.append(dep.getName()).append("\n");
        }
        sb.append("Para dúvidas favor entrar em contato: ");
        sb.append(dept.getAdress().getEmail());

        System.out.println(sb);
    }
}