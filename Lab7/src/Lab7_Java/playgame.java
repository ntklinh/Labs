package Lab7_Java;

import sun.plugin2.main.client.MessagePassingExecutionContext;
import javax.lang.model.element.QualifiedNameable;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;
import javax.swing.border.Border;
import javax.swing.text.html.Option;

class War extends JFrame {
    private String title;
    private JLabel jlbFistPlayer = new JLabel("Fist player");
    private JLabel jlbSecondPlayer = new JLabel("Second player");
    private JLabel  jlbShowCardFist = new JLabel();
    private JLabel jlbShowCardSecond = new JLabel();
    private JButton jbtDistributeCards = new JButton("Distribute the cards");
    private JButton jbtStartPlaying = new JButton("Start playing");
    private JLabel jlbResult = new JLabel();
    private Queue<Integer> cardFistPlayer = new LinkedList<Integer>();
    private Queue<Integer> cardSecondPlayer = new LinkedList<Integer>();
    private JButton jbtRestart = new JButton("Restart");
    private boolean boo = true;
    private boolean isX(int x){
        boolean b;
        if(!(cardFistPlayer.isEmpty() && cardSecondPlayer.isEmpty())){
            Queue<Integer> queue = new LinkedList<>(cardFistPlayer);
            Integer i = queue.poll();
            while (i != null && x!= i.intValue()){
                i = queue.poll();
            }
            if(i != null){
                b = false;
            }
            else {
                queue = new LinkedList<>(cardSecondPlayer);;
                i = queue.poll();
                while (i != null && x!= i.intValue()){
                    i = queue.poll();
                }
                if(i != null){
                    b = false;
                }
                else {
                    b = true;
                }
            }
        }
        else {
            b = true;
        }
        return b;
    }
    private String converQueueToString(Queue<Integer> queue){
        Queue queue1 = new LinkedList<Integer>(queue);
        String str = "";
        while (!queue1.isEmpty()){
            str += queue1.poll().toString() + " ";
        }
        return str;
    }

    public War(String title){
        this.title = title;
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Border border = LineBorder.createGrayLineBorder();
        setLayout(new GridLayout(6,1));
        JPanel[] jnl = new JPanel[5];
        for(int i = 0; i < jnl.length; i ++){
            jnl[i] = new JPanel();
            add(jnl[i]);
        }
        jnl[0].setLayout(new GridLayout(1,2));
        jnl[0].add(jlbFistPlayer);
        jlbShowCardFist.setBorder(border);
        jnl[0].add(jlbShowCardFist);

        jnl[1].setLayout(new GridLayout(1,2));
        jnl[1].add(jlbSecondPlayer);
        jlbShowCardSecond.setBorder(border);
        jnl[1].add(jlbShowCardSecond);

        jnl[2].setLayout(new GridLayout(1,2));
        jnl[2].add(jbtDistributeCards);
        jbtDistributeCards.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(boo){
                    cardFistPlayer = new LinkedList<Integer>();
                    cardSecondPlayer = new LinkedList<Integer>();
                    jlbResult.setText("");
                    Random r = new Random();
                    int x;
                    for(int i = 0; i < 10; i ++){
                        do{
                            x = r.nextInt(10);
                        }while (!isX(x));
                        if(i % 2 == 0){
                            cardFistPlayer.offer(new Integer(x));
                        }
                        else {
                            cardSecondPlayer.offer(new Integer(x));
                        }
                    }
                    jlbShowCardFist.setText(converQueueToString(cardFistPlayer));
                    jlbShowCardSecond.setText(converQueueToString(cardSecondPlayer));
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        jnl[2].add(jbtStartPlaying);
        jbtStartPlaying.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(boo){
                    jlbResult.setText("");
                    jbtDistributeCards.setEnabled(false);
                    boo = false;
                    try{
                        Integer i_1;
                        Integer i_2;
                        int d = 0;
                        i_1 = cardFistPlayer.poll();
                        i_2 = cardSecondPlayer.poll();
                        while (d <= 106 && (!cardFistPlayer.isEmpty() && !cardSecondPlayer.isEmpty())){
                            if (i_1 < i_2) {
                                cardSecondPlayer.add(i_2);
                                cardSecondPlayer.add(i_1);
                            } else {
                                cardFistPlayer.add(i_1);
                                cardFistPlayer.add(i_2);
                            }
                            d++;
                            i_1 = cardFistPlayer.poll();
                            i_2 = cardSecondPlayer.poll();
                        }
                        if(cardFistPlayer.isEmpty() && !cardSecondPlayer.isEmpty()){
                            jlbResult.setText("Second: " + (new Integer(d)).toString());
                        }
                        else if(cardSecondPlayer.isEmpty() && !cardFistPlayer.isEmpty()){
                            jlbResult.setText("First: " + (new Integer(d)).toString());
                        }
                        else if (d > 106){
                            jlbResult.setText("botva");
                        }
                        else{
                            throw new Exception("Error");
                        }
                    }
                    catch (Exception e1){
                        JOptionPane.showMessageDialog(null,e1,"Notification!",1);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        jnl[3].setLayout(new GridLayout(1,1));
        jlbResult.setBorder(border);
        jnl[3].add(jlbResult);

        jnl[4].setLayout(new FlowLayout());
        jnl[4].add(jbtRestart);
        jbtRestart.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jbtDistributeCards.setEnabled(true);
                jlbShowCardSecond.setText("");
                jlbShowCardFist.setText("");
                boo = true;
                jlbResult.setText("");
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        setSize(500,300);
    }
}

public class playgame {
    public static void main(String[] args) {
        War war = new War("Игра Пьяницу");
        war.setVisible(true);
    }
}

