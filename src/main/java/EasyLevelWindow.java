import javax.swing.*;

public class EasyLevelWindow extends JFrame {

    public EasyLevelWindow(){
        setTitle("Zmeyka");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(EasyLevel.SIZE + 30,EasyLevel.SIZE + 60);
        setLocation(500, 150);
        add(new EasyLevel());
        setResizable(false);
        setVisible(true);
    }

}