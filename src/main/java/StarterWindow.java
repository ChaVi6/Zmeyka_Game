import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class StarterWindow extends JFrame {

    public StarterWindow() {
        ImageIcon iib = new ImageIcon("image.png");
        Image image = iib.getImage();
        setTitle("Zmeyka");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 750);
        setLocation(500, 150);
        setContentPane(new JLabel(new ImageIcon(image)));
        setVisible(true);
        setResizable(false);
        Container container = this.getContentPane();

        JButton start = new JButton("Start");
        start.setSize(300, 50);
        start.setLocation(70, 300);
        container.add(start);

        JButton rules = new JButton("Information");
        rules.setSize(300, 50);
        rules.setLocation(70, 400);
        container.add(rules);
        rules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                AboutLevels rules = new AboutLevels();
            }
        });
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start.setVisible(false);
                rules.setVisible(false);
                JButton easy = new JButton("Easy");
                easy.setSize(300, 50);
                easy.setLocation(70, 300);
                container.add(easy);
                easy.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        EasyLevelWindow elw = new EasyLevelWindow();
                    }
                });

                JButton medium = new JButton("Medium");
                medium.setSize(300, 50);
                medium.setLocation(70, 380);
                container.add(medium);
                medium.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        MediumLevelWindow mlw = new MediumLevelWindow();
                    }
                });

                JButton hard = new JButton("Hard");
                hard.setSize(300, 50);
                hard.setLocation(70, 4400);
                container.add(hard);
                hard.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        HardLevelWindow hlw = new HardLevelWindow();
                    }
                });

                JButton insane = new JButton("Insane");
                insane.setSize(300, 50);
                insane.setLocation(70, 520);
                container.add(insane);
                insane.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        InsaneLevelWindow ilw = new InsaneLevelWindow();
                    }
                });

                JButton back = new JButton("Back");
                back.setSize(100, 50);
                back.setLocation(870, 650);
                container.add(back);
                back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        StarterWindow sw = new StarterWindow();
                    }
                });
            }
        });

    }
}