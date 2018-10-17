import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Decrypt extends JFrame {
    Container cp;
    private JTextArea jtaR = new JTextArea("", 30, 15);
    private JTextArea jtaL = new JTextArea("", 30, 15);
    private JScrollPane jspR = new JScrollPane(jtaR);
    private JScrollPane jspL = new JScrollPane(jtaL);
    private JPanel jpnC = new JPanel(new GridLayout(9, 1, 5, 5));
    private JPanel jpnR = new JPanel(new GridLayout(1, 1, 5, 5));
    private JPanel jpnL = new JPanel(new GridLayout(1, 1, 5, 5));
    private JLabel jlb = new JLabel("Method");
    private String methodStr[] = {"DES", "AES", "XOR", "Caesar"};
    private JComboBox jcb = new JComboBox<String>(methodStr);
    private JLabel jlbpw = new JLabel("PassWord");
    private JTextField jtfkey = new JTextField();
    private JRadioButton jrbEncypt = new JRadioButton("Encypt");
    private JRadioButton jrbDecypt = new JRadioButton("Decypt");
    private JButton jbtRN = new JButton("RUN");
    private JButton jbtCL = new JButton("Close");
    private ButtonGroup buttonGroup = new ButtonGroup();

    MainFrame frm5;

    public Decrypt(MainFrame frm6) {
        frm5 = frm6;
        ex1();
    }

    private void ex1() {
        this.setBounds(100, 100, 560, 400);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frm5.setVisible(true);
            }
        });
        cp = this.getContentPane();
        cp.add(jpnL, BorderLayout.WEST);
        cp.add(jpnC, BorderLayout.CENTER);
        cp.add(jpnR, BorderLayout.EAST);
        jpnL.add(jspL);
        jpnR.add(jspR);
        jpnC.add(jlb);
        jpnC.add(jcb);
        jpnC.add(jlbpw);
        jpnC.add(jtfkey);
        jpnC.add(jrbEncypt);
        jpnC.add(jrbDecypt);
        jpnC.add(jbtRN);
        jpnC.add(jbtCL);
        buttonGroup.add(jrbEncypt);
        buttonGroup.add(jrbDecypt);

        jbtRN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jrbEncypt.isSelected()){
                    int dataLength = jtaL.getText().length();
                    if (dataLength>0) {
                        switch (jcb.getSelectedIndex()) {
                            case 0:
                                JOptionPane.showMessageDialog(Decrypt.this, "Sorry" + jcb.getSelectedItem() + "not implement yet!");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(Decrypt.this, "Sorry" + jcb.getSelectedItem() + "not implement yet!");
                                break;
                            case 2:
                                char data[] = jtaL.getText().toCharArray();
                                int key = Integer.parseInt(jtfkey.getText());
                                try {
                                    for (int i = 0; i < data.length; i++) {
                                        data[i] = (char) (data[i] + key);
                                    }
                                    jtaR.setText(new String(data));
                                } catch (NumberFormatException exp) {
                                    JOptionPane.showMessageDialog(Decrypt.this, "key is not Number");
                                } catch (Exception exp1) {
                                    JOptionPane.showMessageDialog(Decrypt.this, "Error" + exp1.toString());
                                }
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(Decrypt.this, "Sorry" + jcb.getSelectedItem() + "not implement yet!");
                                break;
                        }
                    }
                }else if (jrbDecypt.isSelected()) {
                    int dataLength = jtaR.getText().length();
                    if (dataLength > 0) {
                        switch (jcb.getSelectedIndex()) {
                            case 0:
                                JOptionPane.showMessageDialog(Decrypt.this, "Sorry" + jcb.getSelectedItem() + "not implement yet!");
                                break;
                            case 1:
                                JOptionPane.showMessageDialog(Decrypt.this, "Sorry" + jcb.getSelectedItem() + "not implement yet!");
                                break;
                            case 2:
                                char data[] = jtaR.getText().toCharArray();
                                int key = Integer.parseInt(jtfkey.getText());
                                try {
                                    for (int i = 0; i < data.length; i++) {
                                        data[i] = (char) (data[i] - key);
                                    }
                                    jtaL.setText(new String(data));
                                } catch (NumberFormatException exp) {
                                    JOptionPane.showMessageDialog(Decrypt.this, "key is not Number");
                                } catch (Exception exp1) {
                                    JOptionPane.showMessageDialog(Decrypt.this, "Error" + exp1.toString());
                                }
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(Decrypt.this, "Sorry" + jcb.getSelectedItem() + "not implement yet!");
                                break;
                        }
                    }
                }
            }
        });
        jbtCL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame frm2 = new MainFrame();
                frm2.setVisible(true);
                Decrypt.this.dispose();
            }
        });
    }
}