import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calc_FB implements ActionListener{

    JFrame jframe;
    JTextField textfield;
    JButton[] numbers = new JButton[10];

    //operative buttons like +,- and all
    JButton add = new JButton("+");
    JButton sub = new JButton("-");
    JButton mult = new JButton("*");
    JButton div = new JButton("/");
    JButton equal = new JButton("=");
    JButton dot = new JButton(".");
    JButton neg = new JButton("±");
    JButton sqrt = new JButton("√");
    JButton sqr = new JButton("x²");
    JButton oneUpon = new JButton("1/x");
    JButton clr = new JButton("CE");
    JButton del = new JButton("<=");
    JButton darkMode = new JButton("Dark Mode");
    JButton[]functions = {add,sub,mult,div,equal,dot,neg,sqrt,sqr,oneUpon,clr,del,darkMode};

    JPanel jpanel;    

    // different fonts and darkmode colors settings
    Font fbFont = new Font("Book Antiqua", Font.BOLD, 22);
    Font fbFontDark = new Font("Book Antiqua", Font.BOLD, 15);
    Color fbBGColor = Color.lightGray;
    Color fbFGColor = Color.DARK_GRAY;
    Color fbCalColor = Color.white;
    Color darkfbBGColor = Color.DARK_GRAY;
    Color darkfbFGColor = Color.LIGHT_GRAY;
    Color darkfbColor = Color.BLACK;

    double num1=0, num2=0, finale=0;
    char operator;

    //Calc Constructor
    Calc_FB(){
        jframe = new JFrame("Calculator FB");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(330, 510);
        jframe.setLayout(null);
        jframe.setBackground(fbCalColor);
        jframe.setForeground(fbCalColor);

        textfield = new JTextField();
        // textfield settings
        textfield.setBounds(10,10,295,50);
        textfield.setFont(fbFont);
        textfield.setBackground(fbBGColor);
        textfield.setForeground(fbFGColor);
        textfield.setEditable(false);
        
        //all buttons setting bounds and colors
        for(int i=0; i<functions.length; i++) {
            functions[i].addActionListener(this);
            functions[i].setFont(fbFont);
            functions[i].setBackground(fbBGColor);
            functions[i].setForeground(fbFGColor);
            functions[i].setFocusable(true);
            jframe.add(functions[i]);
        }
        for(int i=0; i<numbers.length; i++) {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(fbFont);
            numbers[i].setBackground(fbBGColor);
            numbers[i].setForeground(fbFGColor);
            numbers[i].setFocusable(true);
            jframe.add(numbers[i]);
        }
        
        del.setBounds(10, 110, 140, 50);
        clr.setBounds(160, 110, 140, 50);

        oneUpon.setBounds(10,170,65,50);
        sqr.setBounds(85,170,65,50);
        sqrt.setBounds(160,170,65,50);
        div.setBounds(235,170,65,50);

        numbers[7].setBounds(10,230,65,50);
        numbers[8].setBounds(85,230,65,50);
        numbers[9].setBounds(160,230,65,50);
        mult.setBounds(235,230,65,50);

        numbers[4].setBounds(10,290,65,50);
        numbers[5].setBounds(85,290,65,50);
        numbers[6].setBounds(160,290,65,50);
        sub.setBounds(235,290,65,50);

        numbers[1].setBounds(10,350,65,50);
        numbers[2].setBounds(85,350,65,50);
        numbers[3].setBounds(160,350,65,50);
        add.setBounds(235,350,65,50);

        neg.setBounds(10,410,65,50);
        numbers[0].setBounds(85,410,65,50);
        dot.setBounds(160,410,65,50);
        equal.setBounds(235,410,65,50);

        darkMode.setBounds(160,70, 140,30);
        darkMode.setFont(fbFontDark);

        jpanel = new JPanel();

        jframe.add(textfield);
        jpanel.setBounds(0, 0, 330,510);
        jpanel.setBackground(fbCalColor);
        jframe.add(jpanel);
        // jframe.addKeyListener();
        jframe.setResizable(false);
        jframe.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        Calc_FB calculator = new Calc_FB();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        for(int i=0; i<10; i++) {
            if(e.getSource() == numbers[i]) {

                if(i==0 && textfield.getText().length()==1 && textfield.getText().charAt(0) == '0') {
                    continue;
                }
                
                if(textfield.getText().length()!=0 && num1!=0) {
                    textfield.setText(String.valueOf(i));
                    num1=0;
                    continue;
                }

                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource()==dot && !textfield.getText().contains(".")) {
            textfield.setText(textfield.getText().concat("."));
        }

        if(e.getSource()==add) {
            num1 = Double.parseDouble(textfield.getText());
            operator='+';
            textfield.setText("");
        }

        if(e.getSource()==sub) {
            num1 = Double.parseDouble(textfield.getText());
            operator='-';
            textfield.setText("");
        }

        if(e.getSource()==mult) {
            num1 = Double.parseDouble(textfield.getText());
            operator='*';
            textfield.setText("");
        }

        if(e.getSource()==div) {
            num1 = Double.parseDouble(textfield.getText());
            operator='/';
            textfield.setText("");
        }

        if(e.getSource()==equal) {
            num2 = Double.parseDouble(textfield.getText());
            
            switch(operator) {
                case '+' :
                finale = num1+num2;
                break;

                case '-' :
                finale = num1-num2;
                break;

                case '*' :
                finale = num1*num2;
                break;

                case '/' :
                finale = num1/num2;
                break;
            }

            textfield.setText(String.valueOf(finale));
            num1 = finale;
        }

        if(e.getSource()==oneUpon) {
            num1 = 1/Double.parseDouble(textfield.getText());
            textfield.setText(String.valueOf(num1));
        }

        if(e.getSource()==sqr) {
            num1 = Math.pow(Double.parseDouble(textfield.getText()),2);
            textfield.setText(String.valueOf(num1));
        }

        if(e.getSource()==sqrt) {
            num1 = Math.sqrt(Double.parseDouble(textfield.getText()));
            textfield.setText(String.valueOf(num1));
        }

        if(e.getSource()==clr) {
            textfield.setText("");
        }
        
        if(e.getSource()==del) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
        }

        if(e.getSource()==neg) {
            textfield.setText(String.valueOf(-1 * Double.parseDouble(textfield.getText())));
        }

        // darkmode setting
        if(e.getSource()==darkMode) {

            if(darkMode.getText()=="Dark Mode") {
                darkMode.setText("Light Mode");
                for(int i=0; i<functions.length; i++) {
                    functions[i].setBackground(darkfbBGColor);
                    functions[i].setForeground(darkfbFGColor);
                }
                for(int i=0; i<numbers.length; i++) {
                    numbers[i].setBackground(darkfbBGColor);
                    numbers[i].setForeground(darkfbFGColor);
                }
                textfield.setBackground(darkfbBGColor);
                textfield.setForeground(darkfbFGColor);
                jpanel.setBackground(darkfbColor);
            } 
            else
            if(darkMode.getText()=="Light Mode") {
                darkMode.setText("Dark Mode");
                for(int i=0; i<functions.length; i++) {
                    functions[i].setBackground(fbBGColor);
                    functions[i].setForeground(fbFGColor);
                }
                for(int i=0; i<numbers.length; i++) {
                    numbers[i].setBackground(fbBGColor);
                    numbers[i].setForeground(fbFGColor);
                }
                textfield.setBackground(fbBGColor);
                textfield.setForeground(fbFGColor);
                jpanel.setBackground(fbCalColor);
            }
        }

    }


}

