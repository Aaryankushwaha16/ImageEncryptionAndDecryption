import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;     //for FlowLayout
import java.awt.Font;          //for font
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream; 

public class ImageEncryptionAndDecryption{

    public static void operate(int key){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file =fileChooser.getSelectedFile();
        //file InputOutputStream

        try {
            FileInputStream fis = new FileInputStream(file);
            byte data[] = new byte[fis.available()];    //creating array of file conatained size
            fis.read(data);
            int i=0;
            for (byte b : data) {
                System.out.println(b);
                data[i] = (byte)(b^key); //XOR
                i++;
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"Done");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setTitle("ImageEncryptionAndDecryption");
        window.setSize(500,500);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Roboto",Font.BOLD,25);
        
        //creating button
        JButton button = new JButton();
        button.setText("Select Image");
        button.setFont(font);

        
        
        //crating textfield
        JTextField textField = new JTextField(10);
        textField.setFont(font);

        //clicking on button
        //this is a interface and we can not make any object of interface so then we will 
        // make the object of child class of interface.
        button.addActionListener(e->{
            System.out.println("button click");
            String text = textField.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
        });

        window.setLayout(new FlowLayout());
        window.add(button);
        window.add(textField);
        window.setVisible(true);
    }
}