import java.sql.SQLOutput;
import java.util.Scanner;

public class ProvaLp {
    public static void main(String[] args) {
        String[] nomeCompleto = new String[5], nome = new String[5], sobrenome = new String[5], situacaoIMC = new String[5];
        double[] imc = new double[5], peso = new double[5];
        int[] idade = new int[5], altura = new int[5];

        int menu, i=-1;
        Scanner leitor = new Scanner(System.in);

        System.out.println("-----OPÇÕES DE ESCOLHA-----\n");
        System.out.println(
                "0-Sair do Programa\n1-Cadastro De Pessoas\n2-Linha de Pessoas Cadastradas\n3-Análise da média dos dados\n4-Valores do IMC\n5-Valores das idades\n6-Dados das pessoas\n7-Sair");
        System.out.println("Escolha a funcionalidade: ");
        System.out.println("-->");
        menu = leitor.nextInt();
        if (menu == 0) {
            System.out.println("Programa encerrado!");
        } else {
            while (menu > 0 && menu < 7) {
                switch (menu) {
                    case 1:
                        for (i = 0; i < 5; i++) {
                            System.out.println("digite a idade do usuário: ");
                            idade[i] = leitor.nextInt();
                            if(idade[i]<=16){
                                System.out.println("idade não permitida (apenas usuários acima de 16 anos):");
                                System.out.println("digite uma nova idade: ");
                                idade[i] = leitor.nextInt();
                            }
                            System.out.println("Digite o nome do usuário: ");
                            nome[i] = leitor.nextLine();
                            nome[i] = leitor.nextLine();
                            System.out.println("Digite o sobrenome do usuário: ");
                            sobrenome[i] = leitor.nextLine();
                            nomeCompleto[i] = nome[i] + " " + sobrenome[i];
                            System.out.println("Digite o peso do usuário(use vírgula!): ");
                            peso[i] = leitor.nextDouble();
                            System.out.println("digite a altura do usuário em cm: ");
                            altura[i] = leitor.nextInt();
                            imc[i] = peso[i] / (altura[i] * altura[i]);


                        }
                        break;
                    case 2:
                        if(i==-1){
                            System.out.println("Não há pessoas cadastradas!");
                        }
                        else {
                            for (i = 0; i < 5; i++) {
                                System.out.printf("Usuário %d:\n", i);
                                System.out.printf("Nome: %s \n", nomeCompleto[i]);
                                System.out.printf("Peso: %f\n", peso[i]);
                                System.out.printf("Altura: %i\n", altura[i]);
                                System.out.printf("Idade: %d\n", idade[i]);

                            }
                        }
                        break;
                    case 3:
                        if(i==-1){
                            System.out.println("Não há pessoas cadastradas!");
                        }
                        else {
                            double somaIdade = 0, somaPeso = 0, somaAltura = 0, somaIMC = 0;
                            for (i = 0; i < 5; i++) {
                                somaIdade = somaIdade + idade[i];
                                somaPeso = somaPeso + peso[i];
                                somaAltura = somaAltura + altura[i];
                                somaIMC = somaIMC + imc[i];
                            }
                            System.out.printf("Média das idades: %f\n", somaIdade/5);
                            System.out.printf("Média dos pesos: %f\n", somaPeso/5);
                            System.out.printf("Média das alturas: %f\n", somaAltura/5);
                            System.out.printf("Média dos IMCs: %f\n", somaIMC/5);
                        }
                        break;
                    case 4:
                        if(i==-1){
                            System.out.println("Não há pessoas cadastradas!");
                        }
                        else {
                            for (i = 0; i < 5; i++) {
                                System.out.printf("Nome: %s\n", nomeCompleto[i]);
                                System.out.printf("IMC: %f\n", imc[i]);
                                System.out.print("Situação do IMC: ");
                                if(imc[i]<18.5){
                                    situacaoIMC[i] = "abaixo do peso!";
                                    System.out.println(situacaoIMC[i]+"\n");
                                }
                                else if(imc[i]>=18.6 && imc[i]<25.0){
                                    situacaoIMC[i] = "peso ideal, parabéns!";
                                    System.out.println(situacaoIMC[i]+"\n");
                                }
                                else if(imc[i]>=25.0 && imc[i]<30.0){
                                    situacaoIMC[i] = "levemente acima do peso!";
                                    System.out.println(situacaoIMC[i]+"\n");
                                }
                                else if(imc[i]>=30.0 && imc[i]<35.0){
                                    situacaoIMC[i] = "obesidade grau 1";
                                    System.out.println(situacaoIMC[i]+"\n");
                                }
                                else if(imc[i]>=35.0 && imc[i]<40.0){
                                    situacaoIMC[i] = "obesidade grau 2 (severa)";
                                    System.out.println(situacaoIMC[i]+"\n");
                                }
                                else{
                                    situacaoIMC[i] = "obesidade grau 3 (mórbida)!";
                                    System.out.println(situacaoIMC[i]+"\n");
                                }
                            }
                        }
                        break;
                    case 5:
                        if(i==-1){
                            System.out.println("Não há pessoas cadastradas!");
                        }
                        else {
                            int maiorIdade = 0, menorIdade = 200, indiceMaior=0, indiceMenor=0;
                            for (i = 0; i < 5; i++) {
                                if(idade[i]<menorIdade){
                                    menorIdade = idade[i];
                                    indiceMenor = i;
                                }
                                if(idade[i]>maiorIdade){
                                    maiorIdade = idade[i];
                                    indiceMaior = i;
                                }
                                System.out.printf("Nome: %s\n", nomeCompleto[i]);
                                System.out.printf("Idade: %d\n\n", idade[i]);
                            }
                            System.out.printf("Pessoa mais velha: %s\n", nomeCompleto[indiceMaior]);
                            System.out.printf("Idade da pessoa mais velha: %d\n\n", idade[indiceMaior]);
                            System.out.printf("Pessoa mais nova: %s\n", nomeCompleto[indiceMenor]);
                            System.out.printf("Idade da pessoa mais nova: %d\n", idade[indiceMenor]);
                        }
                        break;

                    case 6:
                        if(i==-1){
                            System.out.println("Não há pessoas cadastradas!");
                        }
                        else {
                            String pesquisaNome = "";
                            System.out.println("Digite o sobrenome: \n");
                            pesquisaNome = leitor.nextLine();
                            for (i = 0; i < 5; i++) {
                                if(sobrenome[i].equalsIgnoreCase(pesquisaNome)){
                                    System.out.printf("Nome completo: %s\n", nomeCompleto[i]);
                                    System.out.printf("Idade: %i\n", idade[i]);
                                    System.out.printf("Peso: %f\n", peso[i]);
                                    System.out.printf("Altura: %f\n", altura[i]);
                                    System.out.printf("IMC: %f\n", imc[i]);
                                    if(imc[i]<18.5){
                                        System.out.println("Classificação IMC: abaixo do peso");
                                    }
                                    else if(imc[i]>=18.6 && imc[i]<25.0){
                                        System.out.println("Classificação IMC: peso ideal");
                                    }
                                    else if(imc[i]>=25.0 && imc[i]<30.0){
                                        System.out.println("Classificação IMC: levemente acima do peso");
                                    }
                                    else if(imc[i]>=30.0 && imc[i]<35.0){
                                        System.out.println("Classificação IMC: obesidade grau 1");
                                    }
                                    else if(imc[i]>=35.0 && imc[i]<40.0){
                                        System.out.println("Classificação IMC: obesidade grau 2");
                                    }
                                    else{
                                        System.out.println("Classificação IMC: obesidade grau 3");
                                    }
                                }
                            }
                        }

                        break;
                    case 7:
                        System.out.println("Programa finalizado!");
                        break;
                }
                System.out.println("-----OPÇÕES DE ESCOLHA-----\n");
                System.out.println(
                        "0-Sair do Programa\n1-Cadastro De Pessoas\n2-Linha de Pessoas Cadastradas\n3-Análise da média dos dados\n4-Valores do IMC\n5-Valores das idades\n6-Dados das pessoas\n7-Sair");
                System.out.println("Escolha a funcionalidade: ");
                System.out.println("-->");
                menu = leitor.nextInt();
            }
            System.out.println("Programa finalizado!");
        }
    }
}