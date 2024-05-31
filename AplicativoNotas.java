package aplicativoNotas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class AplicativoNotas {
    private JFrame frmAplicativoDeNota;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            AplicativoNotas window = new AplicativoNotas();
            window.frmAplicativoDeNota.setVisible(true);
        });
    }

    public AplicativoNotas() {
        initialize();
        
    }

    private void initialize() {
        frmAplicativoDeNota = new JFrame();
        frmAplicativoDeNota.setTitle("Aplicativo de Notas");
        frmAplicativoDeNota.setBounds(100, 100, 450, 300);
        frmAplicativoDeNota.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmAplicativoDeNota.getContentPane().setLayout(null);

        JButton btnNewButton = new JButton("SALVAR");
        btnNewButton.setBackground(SystemColor.inactiveCaption);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.setBounds(0, 238, 434, 23);
        frmAplicativoDeNota.getContentPane().add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 424, 239);
        frmAplicativoDeNota.getContentPane().add(lblNewLabel);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 11, 414, 222);
        frmAplicativoDeNota.getContentPane().add(textArea);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int resultado = fileChooser.showSaveDialog(frmAplicativoDeNota);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    try {
                        String texto = ""; // Adicione o texto que deseja salvar
                        String caminhoArquivo = fileChooser.getSelectedFile().getAbsolutePath();
                        salvarTexto(texto, caminhoArquivo);
                        JOptionPane.showMessageDialog(frmAplicativoDeNota, "Arquivo salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frmAplicativoDeNota, "Erro ao salvar o arquivo!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    private void salvarTexto(String texto, String caminhoArquivo) {
        // Implemente a lógica para salvar o texto no arquivo
    }
}
