package cli;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarEstoque {
    public List<Product> listProduct = new ArrayList<>();

    public static void main(String[] args) {
        GerenciarEstoque ge =new GerenciarEstoque();
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        do{
            opc = construirMenu(ge, sc);
        }while(opc!=9);
    }

    private static int construirMenu(GerenciarEstoque ge, Scanner sc) {
        int opc;
        System.out.println("          MENU           ");
        System.out.println("1. Cadastrar novo produto");
        System.out.println("2. Repor produto");
        System.out.println("3. Retirar produto");
        System.out.println("4. Pesquisar produto especifico");
        System.out.println("5. Listar todos os produtos");
        System.out.println("6. Patrimonio Liquido");
        System.out.println("9. Sair");
        System.out.println("Digite sua opção: ");
        opc = Integer.parseInt(sc.nextLine());
        switch (opc) {
            case 1 -> ge.execRegisterProduct(sc);
            case 2 -> ge.execSpareProduct(sc);
            case 3 -> ge.execReduceProduct(sc);
            case 4 -> ge.execShowProduct(sc);
            case 5 -> ge.execShowAllProducts();
            case 6 -> ge.execShowAllProductsTotalPrice();
            case 9 -> System.out.println("FIM");
            default -> System.out.println("Opção inválida");
        }
        return opc;
    }

    public void execRegisterProduct(Scanner sc){
        Product produto = new Product();
        System.out.println("Digite o código do produto: ");
        int code = Integer.parseInt(sc.nextLine());

        if(!codeExist(code)){
            produto.setCode(code);
        }else{
            System.out.println("Código já cadastrado");
            return;
        }

        System.out.println("Digite o nome do produto: ");
        produto.setNome(sc.nextLine());
        System.out.println("Digite a descrição do produto: ");
        produto.setDescricao(sc.nextLine());
        System.out.println("Digite a quantidade do produto: ");
        produto.setQuantidade(Double.parseDouble(sc.nextLine()));
        System.out.println("Digite o preço unitário do produto: ");
        produto.setPreco(Double.parseDouble(sc.nextLine()));

        listProduct.add(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void execSpareProduct(Scanner sc){

        Product produto = getProduct(sc);

        if(produto != null){
            System.out.println("Digite a quantidade adicional: ");
            boolean ok = produto.addProduto(Double.parseDouble(sc.nextLine()));
            if(ok){
                System.out.println("Quantidade adicionada com sucesso!");
            }else{
                System.out.println("Quantidade não pode ser menor ou igual a ZERO!");
            }
        }else{
            System.out.println("Produto não cadastrado");
        }
    }

    public void execReduceProduct(Scanner sc){

        Product produto = getProduct(sc);

        if(produto != null){
            System.out.println("Digite a quantidade da retirada: ");
            boolean ok = produto.reduce(Double.parseDouble(sc.nextLine()));
            if(ok){
                System.out.println("Quantidade retirada com sucesso!");
            }else{
                System.out.println("Quantidade não é suficiente para retirar!");
            }
        }else{
            System.out.println("Produto não cadastrado");
        }
    }

    public void execShowProduct(Scanner sc){

        Product produto = getProduct(sc);

        if(produto != null){
            System.out.println(produto.toString());
        }
    }

    public void execShowAllProducts(){
        for(Product p : listProduct){
            System.out.println(p.toString());
        }
    }

    public void execShowAllProductsTotalPrice(){
        double total = 0;
        for(Product p : listProduct){
            System.out.println(p.total());
            total += (p.getPreco() * p.getQuantidade());
        }
        System.out.println("O valor total em estoque é: " + total);
    }

    private Product getProduct(Scanner sc) {
        System.out.println("Digite o código do produto: ");
        int proc = Integer.parseInt(sc.nextLine());
        Product produto = null;

        for(Product p : listProduct){
            if(p.getCode() == proc){
                produto = p;
                break;
            }
        }
        return produto;
    }

    private boolean codeExist(Integer code) {
        for (Product p : listProduct) {
            if(p.getCode() == code){
                return true;
            }
        }
        return false;
    }
}