package aplicativoNotas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class AplicativoNotas1 extends JFrame implements ActionListener {
    private static final long serialVersionUID = -2117381263467984350L;
    private JTextArea areaTexto;
    private JButton botaoSalvar;

    public AplicativoNotas1() {
        setTitle("Aplicativo de Notas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        areaTexto = new JTextArea();
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(this);
        add(botaoSalvar, BorderLayout.SOUTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoSalvar) {
            JFileChooser fileChooser = new JFileChooser();
            int resultado = fileChooser.showSaveDialog(this);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                try {
                    String texto = areaTexto.getText();
                    String caminhoArquivo = fileChooser.getSelectedFile().getAbsolutePath();
                    salvarTexto(texto, caminhoArquivo);
                    JOptionPane.showMessageDialog(this, "Arquivo salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AplicativoNotas1());
    }

    public static void salvarTexto(String texto, String caminhoArquivo) throws Exception {
        java.io.FileWriter writer = new java.io.FileWriter(caminhoArquivo);
        writer.write(texto);
        writer.close();
    }
}
