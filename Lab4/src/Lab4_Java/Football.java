package Lab4_Java;

import javafx.scene.text.Font;
import javax.swing .*;
import java.awt .*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class football1 extends JFrame {
    private String title = "Football match team AC Milan vs Real Madrid";
    private JLabel jlbCompetitionRule = new JLabel("Competition rule: " +
            "If a team leads 2 goals then that team wins.");
    private JButton jbtACMilan = new JButton("AC Milan");
    private JButton jbtReadMadrid = new JButton("Read Madrid");
    private JButton jbtRestart = new JButton("Restart football");
    private JLabel jlbScore_ACMilan = new JLabel("0");
    private JLabel jlbScore_ReadMadrid = new JLabel("0");
    private JLabel jlbLastScored = new JLabel("N/A");
    private Label lbWinner = new Label("DRAW");
    private boolean enabled = true;

    private boolean announcementResult() {
        Integer i_ACMilan = new Integer(jlbScore_ACMilan.getText());
        Integer i_RealMadrid = new Integer(jlbScore_ReadMadrid.getText());
        if (Math.abs(i_ACMilan - i_RealMadrid) >= 2) {
            jbtReadMadrid.setEnabled(false);
            jbtACMilan.setEnabled(false);
            if (i_ACMilan > i_RealMadrid) {
                JOptionPane.showMessageDialog(null, "Team AC Milan won.",
                        "Notification!", 1);
                lbWinner.setText("AC Milan");
                return false;
            } else if (i_RealMadrid > i_ACMilan) {
                JOptionPane.showMessageDialog(null, "Team Real Madrid won.",
                        "Notification!", 1);
                lbWinner.setText("Real Madrid");
                return false;
            }
        }
        return true;
    }

    public football1() {
        setTitle(title);
        setLayout(new GridLayout(6, 1));
        JPanel[] pnl = new JPanel[6];
        for (int i = 0; i < pnl.length; i++) {
            pnl[i] = new JPanel();
            add(pnl[i]);
        }
        pnl[0].add(jlbCompetitionRule);
        pnl[1].setLayout(new GridLayout(1, 2));
        pnl[1].add(jbtACMilan);
        jbtACMilan.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                if (enabled) {
                    Integer i = new Integer(jlbScore_ACMilan.getText());
                    i++;
                    jlbScore_ACMilan.setText(i.toString());
                    jlbLastScored.setText("AC Milan");
                    enabled = announcementResult();
                }
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });
        pnl[1].add(jbtReadMadrid);
        jbtReadMadrid.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (enabled) {
                    Integer i = new Integer(jlbScore_ReadMadrid.getText());
                    i++;
                    jlbScore_ReadMadrid.setText(i.toString());
                    jlbLastScored.setText("Real Madrid");
                    enabled = announcementResult();
                }
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });
        pnl[2].setLayout(new GridLayout(1, 4));
        pnl[2].add(new JLabel("AC Milan :"));
        pnl[2].add(jlbScore_ACMilan);
        pnl[2].add(new JLabel("Read Madrid :"));
        pnl[2].add(jlbScore_ReadMadrid);
        pnl[3].setLayout(new GridLayout(1, 2));
        pnl[3].add(new JLabel("Last scored : "));
        pnl[3].add(jlbLastScored);
        pnl[4].setLayout(new GridLayout(1, 2));
        pnl[4].add(new Label("Winner : "));
        pnl[4].add(lbWinner);
        pnl[5].add(jbtRestart);
        jbtRestart.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jbtACMilan.setEnabled(true);
                jbtReadMadrid.setEnabled(true);
                jlbScore_ReadMadrid.setText("0");
                jlbScore_ACMilan.setText("0");
                jlbLastScored.setText("N/A");
                lbWinner.setText("DRAW");
                enabled = true;
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
        });
        setSize(500, 300);
    }
}

public class Football {
    public static void main(String[] args) {
        new football1().setVisible(true);
    }
}

