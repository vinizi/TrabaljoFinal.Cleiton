import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cadastro_de_Contatos {
    private JPanel panelMain;
    private JButton btnRemover;
    private JButton btnConfirmar;
    private JTextField txtNome;
    private JTextField txtTel;
    private JTextField txtEmail;
    private JList listPesoas;
    private JLabel lblEmail;
    private JLabel lblTelefone;
    private JLabel lblNome;
    private JLabel lblTitulo;
    private String nome = "";
    private String telefone = "";
    private String email = "";
    private DefaultListModel<String> listaModelo;

    public Cadastro_de_Contatos(){
        listaModelo = new DefaultListModel<>();
        listPesoas.setModel(listaModelo);
        listPesoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        btnConfirmar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nome = txtNome.getText().trim();
                        telefone = txtTel.getText().trim();
                        email = txtEmail.getText().trim();
                        if(nome.isEmpty() || telefone.isEmpty() || email.isEmpty() ){
                            JOptionPane.showMessageDialog(panelMain, "Erro, parece que você não preencheu todos os campos");
                        }
                        else{
                            String contato = "Nome: "+nome+" | Telefone: "+telefone+" | Email: "+email;
                            txtNome.setText("");
                            txtTel.setText("");
                            txtEmail.setText("");
                            listaModelo.addElement(contato);
                        }
                    }
                }
        );
        btnRemover.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int cont_selec = listPesoas.getSelectedIndex();
                        if(cont_selec != -1){
                            listaModelo.remove(cont_selec);
                        }
                    }
                }
        );
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Contatos");
        frame.setContentPane(new Cadastro_de_Contatos().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setVisible(true);

    }
}
