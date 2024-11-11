package meuBichinho;
import java.util.Scanner;

    // definindo a classe bichinhoVirtual e seus atributos
	public class bichinhoVirtual {
		    private String nome;
		    private String classe;
		    private String familia;
		    private int idade;
		    private boolean vivo;
		    private int caloria;
		    private int forca;

		    // Construtor do bichinho
		    public bichinhoVirtual(String nome, String classe, String familia) {
		        this.nome = nome;
		        this.classe = classe;
		        this.familia = familia;
		        this.idade = 0;
		        this.vivo = true;
		        this.caloria = 10;
		        this.forca = 10;
		    }

		    // Método para exibir o estado atual do bichinho
		    public void exibirEstado() {
		        System.out.println("O animal se chama " + nome + " \uD83D\uDE04, é da classe " + classe + ", da família " + familia + ".");
		        System.out.println("Força: " + forca + ", Calorias: " + caloria + ", Idade: " + idade);
		        System.out.println("Estado: " + (vivo ? "Vivo" : "Morto"));
		    }

		    // Método para a ação de comer
		    public void comer() {
		        if (!vivo) {
		            System.out.println("O animal está morto e não pode comer.");
		        } else if (caloria >= 100) {
		            System.out.println("O animal está cheio e não pode comer mais.");
		        } else {
		            caloria += 10;
		            forca -= 2;
		            System.out.println("O animal comeu. Força: " + forca + ", Calorias: " + caloria);
		        }
		    }

		    // Método para a ação de correr
		    public void correr() {
		        if (!vivo) {
		            System.out.println("O animal está morto e não pode correr.");
		        } else if (caloria <= 0) {
		            System.out.println("O animal está exausto e não pode correr.");
		        } else {
		            forca -= 5;
		            caloria -= 5;
		            System.out.println("O animal está correndo! Força: " + forca + ", Calorias: " + caloria);
		        }
		    }

		    // Método para a ação de dormir
		    public void dormir() {
		        if (!vivo) {
		            System.out.println("O animal está morto e não pode dormir.");
		        } else {
		            forca += 10;
		            caloria -= 2;
		            System.out.println("O animal está dormindo! Força: " + forca + ", Calorias: " + caloria);
		        }
		    }

		    // Método para a ação de morrer
		    public void morrer() {
		        vivo = false;
		        forca = 0;
		        System.out.println("O animal morreu!\uD83D\uDE1E");
		    }

		    public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);

		        // Criação do bichinho virtual com dados fornecidos pelo usuário
		        System.out.println("\u001B[35mCrie seu novo animal\uD83E\uDD29\u001B[0m");
		        System.out.print("Insira o nome: ");
		        String nome = scanner.nextLine();
		        System.out.print("Insira a classe: ");
		        String classe = scanner.nextLine();
		        System.out.print("Insira a família: ");
		        String familia = scanner.nextLine();

		        bichinhoVirtual bichinho = new bichinhoVirtual(nome, classe, familia);
		        bichinho.exibirEstado();

		        // Loop para as ações do bichinho até ele morrer
		        while (bichinho.vivo) {
		            System.out.println("O que o " + nome + " vai fazer agora?\u001B[0m");
		            System.out.println("1 - Comer");
		            System.out.println("2 - Correr");
		            System.out.println("3 - Dormir");
		            System.out.println("4 - Morrer");
		            System.out.print("Escolha uma opção: \u001B[0m");
		            int opcao = scanner.nextInt();

		            switch (opcao) {
		                case 1 -> bichinho.comer();
		                case 2 -> bichinho.correr();
		                case 3 -> bichinho.dormir();
		                case 4 -> bichinho.morrer();
		                default -> System.out.println("Opção inválida\u001B[0m");
		            }

		            if (bichinho.vivo) {
		                bichinho.exibirEstado();
		            } else {
		                System.out.println("\u001B[35mGAME OVER!\u2620️\u001B[0m");
		            }
		        }

		        scanner.close();
		    }
		}