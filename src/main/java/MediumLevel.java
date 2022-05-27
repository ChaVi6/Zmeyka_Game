import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


public class MediumLevel extends JPanel implements ActionListener{
    public static final int SIZE = 320;
    private final int DOT_SIZE = 16;
    private final int MAX_DOTS = 400;
    private Image dot;
    private Image food;
    private Image stone1;
    private Image stone2;
    private Image stone3;
    private int foodX;
    private int foodY;
    private int stone1X;
    private int stone1Y;
    private int stone2X;
    private int stone2Y;
    private int stone3X;
    private int stone3Y;
    private final int[] x = new int[MAX_DOTS];
    private final int[] y = new int[MAX_DOTS];
    private int dots;
    private Timer timer;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;

    public MediumLevel(){
        setBackground(Color.black);
        loadImages();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);

    }

    public void initGame(){
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 48 - i*DOT_SIZE;
            y[i] = 160;
        }
        timer = new Timer(250,this);
        timer.start();
        createFood();
        createBlocks();
    }

    //createApple, createBlock и createBonus не совпали!
    public void createFood() {
        foodX = new Random().nextInt(21) * DOT_SIZE;
        foodY = new Random().nextInt(21) * DOT_SIZE;
    }

    public void createBlocks() {
        stone1X = new Random().nextInt(21) * DOT_SIZE;
        stone1Y = new Random().nextInt(21) * DOT_SIZE;
        stone2X = new Random().nextInt(21) * DOT_SIZE;
        stone2Y = new Random().nextInt(21) * DOT_SIZE;
        stone3X = new Random().nextInt(21) * DOT_SIZE;
        stone3Y = new Random().nextInt(21) * DOT_SIZE;
    }

    public void loadImages() {
        ImageIcon iif = new ImageIcon("food.png");
        food = iif.getImage();
        ImageIcon iid = new ImageIcon("dot.png");
        dot = iid.getImage();
        ImageIcon iis1 = new ImageIcon("block.png");
        stone1 = iis1.getImage();
        ImageIcon iis2 = new ImageIcon("block.png");
        stone2 = iis2.getImage();
        ImageIcon iis3 = new ImageIcon("block.png");
        stone3 = iis3.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(inGame) {
            g.drawImage(food, foodX, foodY, this);

            g.drawImage(stone1, stone1X, stone1Y, this);

            g.drawImage(stone2, stone2X, stone2Y, this);

            g.drawImage(stone3, stone3X, stone3Y, this);


            for (int i = 0; i < dots; i++) {
                if (x[0] == foodX && y[0] == foodY) {
                    for (int j = 0; j < dots; j++) {
                        g.drawImage(dot, x[j], y[j], this);
                    }
                }
                if (y[0] < 0) {
                    y[0] = SIZE;
                }
                if (y[0] > SIZE) {
                    y[0] = 0;
                }
                if (x[0] < 0) {
                    x[0] = SIZE;
                }
                if (x[0] > SIZE) {
                    x[0] = 0;
                }
                g.drawImage(dot, x[i], y[i], this);
            }


        } else {

            if (dots == MAX_DOTS - 3) {
                JLabel str;
                str = new JLabel("You Win! :)");
                str.setSize(100, 20);
                str.setLocation(132, 100);
                str.setForeground(Color.white);

                JButton restart = new JButton("Restart");
                restart.setSize(100, 20);
                restart.setLocation(115, 165);
                restart.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        MediumLevelWindow mlw = new MediumLevelWindow();
                    }
                });

                JButton menu = new JButton("Main Menu");
                menu.setSize(100, 20);
                menu.setLocation(115, 215);
                menu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        StarterWindow sw = new StarterWindow();
                    }
                });
                add(restart);
                add(menu);
                add(str);

            } else {
                JLabel str;
                str = new JLabel("Game Over :(");
                str.setSize(100, 20);
                str.setLocation(128, 100);
                str.setForeground(Color.white);

                JButton restart = new JButton("Restart");
                restart.setSize(100, 20);
                restart.setLocation(115, 165);
                restart.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        MediumLevelWindow mlw = new MediumLevelWindow();
                    }
                });

                JButton menu = new JButton("Main Menu");
                menu.setSize(100, 20);
                menu.setLocation(115, 215);
                menu.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        StarterWindow sw = new StarterWindow();
                    }
                });
                add(restart);
                add(menu);
                add(str);
            }
        }
    }

    public void move(){
        for (int i = dots - 1; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        //x[0] - голова

        if(left){
            x[0] -= DOT_SIZE;
        }
        if(right){
            x[0] += DOT_SIZE;
        } if(up){
            y[0] -= DOT_SIZE;
        } if(down){
            y[0] += DOT_SIZE;
        }
    }

    public void checkFood() {
        if (x[0] == foodX && y[0] == foodY){
            dots++;
            if (dots == 8 || dots == 13 || dots == 18) {
                timer.setDelay(timer.getDelay() - 40);
            }
            if (dots == MAX_DOTS - 3) {
                inGame = false;
            }
            createFood();
        }
    }


    public void checkBorders(){

        if (x[0] == stone1X && y[0] == stone1Y) {
            inGame = false;
        }
        if (x[0] == stone2X && y[0] == stone2Y) {
            inGame = false;
        }
        if (x[0] == stone3X && y[0] == stone3Y) {
            inGame = false;
        }
        for (int i = dots; i >0 ; i--) {
            if (i > 4 && x[0] == x[i] && y[0] == y[i]) {
                inGame = false;
            }
        }

        if(x[0]>SIZE){
            inGame = false;
        }
        if(x[0]<0){
            inGame = false;
        }
        if(y[0]>SIZE){
            inGame = false;
        }
        if(y[0]<0){
            inGame = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){
            checkFood();
            checkBorders();
            move();
        }
        repaint();
    }

    class FieldKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_LEFT && !right){
                left = true;
                up = false;
                down = false;
            }
            if(key == KeyEvent.VK_RIGHT && !left){
                right = true;
                up = false;
                down = false;
            }

            if(key == KeyEvent.VK_UP && !down){
                right = false;
                up = true;
                left = false;
            }
            if(key == KeyEvent.VK_DOWN && !up){
                right = false;
                down = true;
                left = false;
            }
        }
    }


}