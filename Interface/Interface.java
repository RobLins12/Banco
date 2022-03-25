package Interface;
import java.util.Scanner;

import Logica.Banco;

public class Interface{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int op;
        Banco CC = new Banco();
        System.out.println("Bem-vindo ao sistema do banco CC");
        do{
            System.out.println("Digite a operação desejada");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Depositar na conta");
            System.out.println("3 - Consultar saldo da conta");
            System.out.println("4 - Sacar da conta");
            System.out.println("5 - Lançamento");
            System.out.println("6 - Transferir valores entre contas"); 
            System.out.println("7 - Render poupança");
            System.out.println("8 - Cadastrar/modificar usuario");
            System.out.println("9 - Ver dados do usuario");
            System.out.println("0 - Sair");
            op = s.nextInt();
            while(op < 0 || op > 9){
                System.out.println("^^");
                System.out.println("Erro: solicite uma operação válida");  
                op = s.nextInt();
            }
            if (op == 1){
                System.out.println("Qual o tipo da Conta?");
                System.out.println("1 - Conta Corrente");
                System.out.println("2 - Conta Poupanca");
                System.out.println("3 - Conta Imposto");
                int tipoConta = s.nextInt();
                var numero = 0;
                switch (tipoConta) {
                    case 1: numero = CC.criarConta(); break;
                    case 2: numero = CC.criarPoupanca(); break;    
                    case 3: numero = CC.criarContaImposto(); break;    
                }
                System.out.println("O número da conta criada é "+ numero);
            } else if (op == 2){
                System.out.println("Qual o numero da Conta?");
                int numero = s.nextInt();
                System.out.println("O saldo atual é " + CC.consultaSaldo(numero));
                System.out.println("Qual a quantia a ser depositada?");
                double depos = s.nextDouble();
                CC.depositar(numero, depos);
            } else if (op == 3){
                System.out.println("Qual o numero da Conta?");
                int numero = s.nextInt();
                double valor = CC.consultaSaldo(numero);
                System.out.println("O saldo da conta é "+ valor);
            }else if (op == 4){
                System.out.println("Qual o numero da Conta?");
                int numero = s.nextInt();
                System.out.println("Qual a quantia a ser sacada?");
                double saque = s.nextDouble();
                CC.sacarConta(numero, saque);
            } else if(op == 5){

            } else if (op == 6){
                System.out.println("Qual o numero da Conta origem?");
                int numeroOri = s.nextInt();
                System.out.println("Qual o numero da Conta destino?");
                int numeroDest = s.nextInt();
                System.out.println("Qual a quantia a ser transferida?");
                double valor = s.nextDouble();
                CC.transferir(numeroOri, numeroDest, valor);
            } else if (op == 7){
                System.out.println("Qual o numero da Poupanca?");
                int numeroOri = s.nextInt();
                boolean b = CC.renderPoupanca(numeroOri);
                if (b){
                    System.out.println("Redimento realizado");
                } else {
                    System.out.println("Não disponível para seu tipo de conta");
                }
            } else if (op == 8){
                System.out.println("Você está na parte de cadastro/modificação de usuario");
                System.out.println("Essa parte é muito importante para a fidelidade em nosso banco");
                System.out.println("Informe os dados solicitados");
                System.out.println("Qual o número da conta?");
                int num = s.nextInt();
                System.out.println("Qual é seu nome completo?");
                String nome = s.nextLine();
                s.nextLine();
                System.out.println("Qual seu numero de identidade?");
                int id = s.nextInt();
                System.out.println("Qual o nome de Usuario");
                String usuario = s.next();
                System.out.println("Qual a senha");
                String senha = s.next();
                boolean b = CC.cadastrarUsuario(num, nome, id, usuario, senha);
                if (b) {
                    System.out.println("Usuario cadastrado com sucesso");
                } else {
                    System.out.println("Cadastro invalido");
                }
            } else if (op == 9){
                System.out.println("Digite o numero da conta");
                int numero = s.nextInt();
                CC.exibirdados(numero);

            }
            
        }while (op != 0);
    }
}
