import java.util.Scanner;

public class ListaTarefas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo a lista de tarefas U-NOTION!.\nQual máximo de tarefas que deseja? (Limite de até 20 Tarefas)");
        int maximoTarefas;
        do {
            maximoTarefas = sc.nextInt();
            if (maximoTarefas > 20 || maximoTarefas <= 0) {
                System.out.println("Valor inválido! Digite um número entre 1 e 20.");
            }
        } while (maximoTarefas > 20 || maximoTarefas <= 0);
        sc.nextLine(); // limpar o buffer que nextInt deixa
        String[][] tarefas = new String[maximoTarefas][4]; // 4 detalhes da tarefa
        int totalTarefas = 0;
        System.out.println("Bem vindo a lista de tarefas U-NOTION! ");
        while (true) {
            escolha();

            int resp = sc.nextInt();

            switch (resp) {
                case 1:
                    listarTarefas(totalTarefas, tarefas);
                    continue;

                case 2:
                    totalTarefas = addItens(totalTarefas, maximoTarefas, tarefas);

                    continue;
                case 3:
                    totalTarefas = RemoverItem(totalTarefas, tarefas);
                    continue;

                case 4:
                    if (totalTarefas == 0) {
                        System.out.println("Lista sem tarefas para colocar como concluída!\n--------------------------");
                    } else {
                        MarcarConlusao(totalTarefas, tarefas);
                    }
                    continue;


                case 5:
                    if (totalTarefas == 0) {
                        System.out.println("Lista sem tarefas para ver alterar!\n--------------------------");
                    } else {
                        AlterarDados(totalTarefas, tarefas, sc);
                    }
                    continue;


                case 6:
                    if (totalTarefas == 0) {
                        System.out.println("Lista sem tarefas para ver estatísticas!\n--------------------------");
                    } else {
                        Estatisticas(totalTarefas, tarefas);
                    }
                    continue;


                case 7:
                    System.out.println("Programa finalizado");
                    break;

            }
            break;
        }
    }


// ----- Modúlos -------------------------------------------------------

    public static void escolha() {
        System.out.println("Digite o que gostaria: \n" +
                "\n1-Visualizar a lista.\n" +
                "2-Adicionar itens a lista de tarefas.\n" +
                "3-Remover um item da lista.\n" +
                "4-Marcar uma tarefa como concluida. \n5-Alterar dados.\n" +
                "6-Estatísticas.\n7-Sair.");
    }

    public static void listarTarefas(int totalTarefas, String[][] tarefas) {
        Scanner ler = new Scanner(System.in);
        int opcao = 0;
        if (totalTarefas == 0) {
            System.out.println("Nenhuma tarefa adicionada ainda!!\n -------------------------");
        } else {
            System.out.println("Informe que forma de listagem deseja  \n " +
                    "1 - Todas as tarefas \n 2 - Pendentes \n 3 - Concluídas \n");
            do {
                opcao = ler.nextInt();
            } while (opcao <= 0 || opcao >= 4);
            switch (opcao) {
                case 1:
                    System.out.println("Tarefas cadastradas por você: ");
                    for (int i = 0; i < totalTarefas; i++) {
                        if (tarefas[i][0].isEmpty()) {
                            tarefas[i][0] = "Sem título";
                        }
                        if (tarefas[i][1].isEmpty()) {
                            tarefas[i][1] = "Sem Descrição";
                        }

                        System.out.print("|| Tarefa " + (i + 1) + " = " + tarefas[i][0] + " || ");
                        System.out.print(" Descrição: " + tarefas[i][1] + " || ");
                        System.out.print(" Status: " + tarefas[i][2] + " || ");
                        System.out.print(" Prioridade: " + tarefas[i][3] + " || \n");
                    }
                    break;

                case 2:
                    System.out.println("Tarefas para concluir: ");
                    boolean achouPendente = false;
                    for (int i = 0; i < totalTarefas; i++) {
                        if (tarefas[i][2].equalsIgnoreCase("Não concluído")) {
                            System.out.println("|| Tarefa " + (i + 1) + "= " + tarefas[i][0] + " || Descrição: " + tarefas[i][1] + " || Prioridade: " + tarefas[i][3]);
                            achouPendente = true;
                        }
                    }
                    if (!achouPendente) {
                        System.out.println("Nenhuma tarefa pendente!");
                    }
                    break;

                case 3:
                    System.out.println("Tarefas já finalizadas: ");
                    for (int i = 0; i < totalTarefas; i++) {
                        if (tarefas[i][2].equalsIgnoreCase("Concluído")) {
                            System.out.println("|| Tarefa " + (i + 1) + "= " + tarefas[i][0] + " || Descrição: " + tarefas[i][1] + " || Prioridade: " + tarefas[i][3]);
                        }
                    }
                    break;
            }
        }
    }

    public static int addItens(int totalTarefas, int maximoTarefas, String tarefas[][]) {
        Scanner ler = new Scanner(System.in);
        int prioridade = 0, opcao = 0;
        String prioridadeFormatada = " ", nome = " ", descricao = " ", status = " ";

        if (totalTarefas >= maximoTarefas) {
            System.out.println("Limite da Lista Atingido!! Remova ou conclua alguma atividade ");
        } else {

            System.out.println("Dê um título para a  tarefa que deseja adicionar: ");
            nome = ler.nextLine();
            System.out.println("Dê uma descrição breve dessa tarefa: ");
            descricao = ler.nextLine();
            System.out.println("Dê uma status dessa tarefa, 1 - Concluído ou 2 - Não concluído");

            do {
                opcao = ler.nextInt();
                ler.nextLine();
                if (opcao == 1) {
                    status = "Concluído";
                } else if (opcao == 2) {
                    status = "Não concluído";
                } else {
                    System.out.println("Opção inválida. Digite 1 ou 2:");
                }
            } while (opcao != 1 && opcao != 2);

            System.out.println("Dê uma prioridade, escolha um número:\n1-Baixa\n2-Média\n3-Alta ");

            do {
                prioridade = ler.nextInt();
                ler.nextLine();
                if (prioridade == 1) {
                    prioridadeFormatada = "Baixa";
                } else if (prioridade == 2) {
                    prioridadeFormatada = "Média";
                } else if (prioridade == 3) {
                    prioridadeFormatada = "Alta";
                } else {
                    System.out.println("Número inválido. Digite 1, 2 ou 3:");
                }
            } while (prioridade < 1 || prioridade > 3);

            System.out.println("Tarefa adicionada com êxito!\n ");
            tarefas[totalTarefas][0] = nome;
            tarefas[totalTarefas][1] = descricao;
            tarefas[totalTarefas][2] = status;
            tarefas[totalTarefas][3] = prioridadeFormatada;
            totalTarefas++;


        }
        return totalTarefas;
    }


    public static int RemoverItem(int totalTarefas, String[][] tarefas) {
        Scanner ler = new Scanner(System.in);

        if (totalTarefas == 0) {
            System.out.println("Nenhuma tarefa para remover.\n-------------------------");
            return totalTarefas;
        }

        System.out.println("Tarefas disponíveis:");
        for (int i = 0; i < totalTarefas; i++) {
            System.out.println((i + 1) + " - " + tarefas[i][0]);
        }

        System.out.print("Digite o número da tarefa que deseja remover: ");
        int escolhaRemove = ler.nextInt();

        if (escolhaRemove < 1 || escolhaRemove > totalTarefas) {
            System.out.println("Opção inválida.");
            return totalTarefas;
        }

        // Remover deslocando todas as tarefas para cima a partir da escolhida
        for (int i = escolhaRemove - 1; i < totalTarefas - 1; i++) {
            tarefas[i] = tarefas[i + 1];
        }

        // Limpa a última posição agora desnecessária
        tarefas[totalTarefas - 1] = new String[4];

        System.out.println("Tarefa removida com sucesso.");
        return totalTarefas - 1;
    }


    public static int MarcarConlusao(int totalTarefas, String tarefas[][]) {
        Scanner ler = new Scanner(System.in);
        if (totalTarefas == 0) {
            System.out.println("Lista zerada\n------------------");

        }
        System.out.println("Tarefas para possível conclusão: ");
        for (int i = 0; i < totalTarefas; i++) {
            if (tarefas[i][2].equalsIgnoreCase("Não concluído")) {
                System.out.println((i + 1) + "-" + tarefas[i][0]);
            }
        }
        System.out.println("Digite o numero da tarefa que quer concluir: ");
        int escolhaTarefaConcluida = ler.nextInt();
        if (escolhaTarefaConcluida < 1 || escolhaTarefaConcluida > totalTarefas) {
            System.out.println("Número inválido");
            return totalTarefas;
        }

        tarefas[escolhaTarefaConcluida - 1][2] = "Concluído"; //aqui preciso tirar 1 do indice porque meus indices começam em 0 mas meu array começa em 1
        System.out.println("Tarefa concluída!");
        return totalTarefas;
    }


    public static int AlterarDados(int x, String lista[][], Scanner sc) {
        String novoTitulo;

        for (int i = 0; i < x; i++) {
            System.out.print("Tarefa " + (i + 1) + " = " + lista[i][0] + "\n");
        }

        System.out.println("Deseja alterar que tarefa? Digite o número correspondente: ");
        int escolhaTarefa = sc.nextInt();
        sc.nextLine();

        if (escolhaTarefa < 1 || escolhaTarefa > x) {
            System.out.println("Número inválido.");
            return 0;
        }

        System.out.println("Deseja alterar que dado?\n 1-Descrição \n 2-Status \n 3-Prioridade\n 4-Título");
        int opcao = sc.nextInt();
        sc.nextLine();

        if (opcao < 1 || opcao > 4) {
            System.out.println("Número inválido");
            return 0;
        }

        if (opcao == 1) {
            System.out.println("Digite a descrição nova: ");
            String descNova = sc.nextLine();
            lista[escolhaTarefa - 1][1] = descNova;
        } else if (opcao == 2) {
            System.out.println("Dê uma status dessa tarefa, 1 - Concluído ou 2 - Não concluído");
            opcao = sc.nextInt();
            sc.nextLine();

            String status = " ";
            if (opcao < 1 || opcao > 2) {
                System.out.println("Digite apenas ou 1 ou 2: ");
                return 0;
            }

            if (opcao == 1) {
                status = "Concluído";

            } else {
                status = "Não concluído";
            }
            lista[escolhaTarefa - 1][2] = status;

        } else if (opcao == 3) {
            System.out.println("Dê uma prioridade nova , escolha um número:\n1-Baixa\n2-Média\n3-Alta ");
            int prioridade = sc.nextInt();
            sc.nextLine();
            String prioridadeFormatada = " ";

            if (prioridade == 1) {

                prioridadeFormatada = "Baixa";

            } else if (prioridade == 2) {

                prioridadeFormatada = "Média";

            } else if (prioridade == 3) {

                prioridadeFormatada = "Alta";
            } else {
                System.out.println("Número inválido");
                return 0;
            }

            lista[escolhaTarefa - 1][3] = prioridadeFormatada;
        }

        if (opcao == 4) {
            System.out.println("Dê um novo título a tarefa");
            novoTitulo = sc.nextLine();
            lista[escolhaTarefa - 1][0] = novoTitulo;
        }

        System.out.println("Lista atualizada!\n");
        for (int i = 0; i < x; i++) {
            System.out.print(" Tarefa " + (i + 1) + " = " + lista[i][0] + " || ");
            System.out.print(" Descrição: " + lista[i][1] + " || ");
            System.out.print(" Status: " + lista[i][2] + " || ");
            System.out.print(" Prioridade: " + lista[i][3] + " || \n");
        }
        return opcao;
    }

    public static void Estatisticas(int totalTarefas, String tarefas[][]) {
        int contConcluidas = 0, contNConcluidas = 0;
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("================================");
        System.out.println("           Estatística          ");
        System.out.println("================================");

        for (int i = 0; i < totalTarefas; i++) {
            if (tarefas[i][2].equalsIgnoreCase("Não concluído")) {
                contNConcluidas++;
            }
        }
        for (int i = 0; i < totalTarefas; i++) {
            if (tarefas[i][2].equalsIgnoreCase("Concluído")) {
                contConcluidas++;
            }
        }
        double percentual = ((contConcluidas * 100) / totalTarefas);
        System.out.println("Total de Tarefas = " + totalTarefas);
        System.out.println("Tarefas Concluidas = " + contConcluidas);
        System.out.println("Tarefas Não concluidas = " + contNConcluidas);
        System.out.println("Percentual Concluído = " + percentual + "%");
        System.out.println("================================");
    }
}
