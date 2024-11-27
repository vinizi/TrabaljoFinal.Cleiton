import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora_de_IMC {
    private JPanel panelMain;
    private JTextField txtPeso;
    private JTextField txtAltura;
    private JButton btnCalcular;
    private JLabel lblAltura;
    private JLabel lblPeso;
    private JLabel lblTitulo;
    private JTextField txtResultado;
    private Double IMC = 0.0;
    private String peso = "";
    private String altura = "";


    private Calculadora_de_IMC(){
        btnCalcular.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            peso = txtPeso.getText();
                            altura = txtAltura.getText();
                            IMC = Double.valueOf(peso)/(Double.valueOf(altura)*Double.valueOf(altura));
                            if(IMC < 18.5){
                                txtResultado.setText("Seu IMC é de "+IMC+" e é considerado baixo");
                            }else if(IMC>=18.5 && IMC <24.9) {
                                txtResultado.setText("Seu IMC é de "+IMC+" e é considerado normal");
                            }else if(IMC>=25 && IMC <29.9) {
                                txtResultado.setText("Seu IMC é de "+IMC+" e é considerado sobrepeso");
                            }else if(IMC>=30 && IMC <34.9) {
                                txtResultado.setText("Seu IMC é de "+IMC+" e é considerado Obseidade grau I");
                            }else if(IMC>=35 && IMC <39.9) {
                                txtResultado.setText("Seu IMC é de "+IMC+" e é considerado Obseidade grau II");
                            }else{
                                txtResultado.setText("Seu IMC é de "+IMC+" e é considerado Obseidade grau III");
                            }
                        } catch (NumberFormatException ex){
                            txtResultado.setText("Por favor, insira um número válido para o peso e/ou altura");
                        }

                    }
                }
        );


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de IMC");
        frame.setContentPane(new Calculadora_de_IMC().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700 );
        frame.setVisible(true);
    }
}
