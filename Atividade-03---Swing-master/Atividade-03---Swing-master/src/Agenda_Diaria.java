import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Agenda_Diaria {
    private JPanel panelMain;
    private JTable tableCompromissos;
    private JTextField txtCompromisso;
    private JLabel lblNome;
    private JSpinner spinnerHora;
    private JSpinner spinnerData;
    private JButton btnAdd;
    private JButton btnRemover;
    private JTextField txtDesc;
    private JLabel lblDesc;
    private JLabel lblData;
    private JLabel lblHora;
    private JLabel lblTitulo;
    private DefaultTableModel tabelaModelo;
    private String nome_comp = "";
    private String desc = "";

    public Agenda_Diaria(){
        //Configurando a tabela com suas respectivas colunas
        tabelaModelo = new DefaultTableModel(new String[]{"Data/Hora", "Compromisso", "Descrição"}, 0);
        tableCompromissos.setModel(tabelaModelo);
        //Configurando o Spinner data
        spinnerData.setModel(new SpinnerDateModel());
        JSpinner.DateEditor editorData = new JSpinner.DateEditor(spinnerData, "dd/MM/yyyy");
        spinnerData.setEditor(editorData);
        //Configurando o Spinner Hora
        spinnerHora.setModel(new SpinnerDateModel());
        JSpinner.DateEditor editorTempo = new JSpinner.DateEditor(spinnerHora, "HH:mm");
        spinnerHora.setEditor(editorTempo);
        btnAdd.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                            nome_comp = txtCompromisso.getText();
                            Date data = (Date) spinnerData.getValue();
                            Date hora = (Date) spinnerHora.getValue();
                            desc = txtDesc.getText();
                            if(nome_comp.isEmpty() || data.equals("0") || hora.equals("0")){
                                JOptionPane.showMessageDialog(panelMain,"Preencha todos os campos obrigatórios");
                            }else{
                                if(desc.isEmpty()){
                                    desc = "Sem descrição";
                                }
                                SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
                                SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
                                String data_hora = formatoData.format(data) + " " + formatoHora.format(hora);
                                tabelaModelo.addRow(new Object[]{data_hora, nome_comp, desc});
                            }

                    }
                }
        );

        btnRemover.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int linha_selec = tableCompromissos.getSelectedRow();
                        if(linha_selec != -1){
                            tabelaModelo.removeRow(linha_selec);
                        }else{
                            JOptionPane.showMessageDialog(panelMain, "Selecione um compromisso para remover");
                        }
                    }
                }
        );
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Agenda Diária");
        frame.setContentPane(new Agenda_Diaria().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
