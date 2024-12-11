package sistema.bancario.main;

import sistema.bancario.view.ClienteView;

public class Main {
    public static void main(String[] args) {
        ClienteView clienteView = new ClienteView(); 
        clienteView.exibirMenu(); 
    }
}
