//Rishabh Patel
//Simple Java Calculator

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaCalculator {
    JTextField output;
    String value1=" ";
    String value2="";
    String valuetemp="";
    String optemp="";
    JavaCalculator(){
        int w=300;
        int h=200;
        int bw=50;
        int bh=30;
        JFrame frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(0,0);
        frame.setLayout(null);
        output=new JTextField(20);
        output.setEditable(false);
        output.setBounds(130,20,150,30);
        output.setHorizontalAlignment(JTextField.RIGHT);
        JButton[] buttons=new JButton[20];
        for(int i=0;i<10;i++){
            buttons[i]=new JButton(""+i+"");
        }
        buttons[10]=new JButton("+");
        buttons[11]=new JButton("-");
        buttons[12]=new JButton("*");
        buttons[13]=new JButton("/");
        buttons[14]=new JButton("=");
        buttons[15]=new JButton(".");
        buttons[16]=new JButton("C");
        buttons[17]=new JButton("^2");
        buttons[18]=new JButton("√");
        buttons[19]=new JButton("⌫");

        buttons[16].setBounds((w/2-(3*bw/2)-5)-bw-5,h-bh,bw,bh);
        buttons[17].setBounds((w/2-(3*bw/2)-5)-bw-5,h-2*bh-5,bw,bh);
        buttons[18].setBounds((w/2-(3*bw/2)-5)-bw-5,h-3*bh-10,bw,bh);
        buttons[19].setBounds((w/2-(3*bw/2)-5)-bw-5,h-4*bh-15,bw,bh);

        //Column 1
        buttons[0].setBounds(w/2-(3*bw/2)-5,h-bh,bw,bh);
        buttons[1].setBounds(w/2-(3*bw/2)-5,h-2*bh-5,bw,bh);
        buttons[4].setBounds(w/2-(3*bw/2)-5,h-3*bh-10,bw,bh);
        buttons[7].setBounds(w/2-(3*bw/2)-5,h-4*bh-15,bw,bh);

        //Column 2
        buttons[15].setBounds(w/2-bw/2,h-bh,bw,bh);
        buttons[2].setBounds(w/2-bw/2,h-2*bh-5,bw,bh);
        buttons[5].setBounds(w/2-bw/2,h-3*bh-10,bw,bh);
        buttons[8].setBounds(w/2-bw/2,h-4*bh-15,bw,bh);

        //Column 3
        buttons[14].setBounds(w/2+(bw/2)+5,h-1*bh-0,bw,bh);
        buttons[3].setBounds(w/2+(bw/2)+5,h-2*bh-5,bw,bh);
        buttons[6].setBounds(w/2+(bw/2)+5,h-3*bh-10,bw,bh);
        buttons[9].setBounds(w/2+(bw/2)+5,h-4*bh-15,bw,bh);

        //Column 4
        buttons[10].setBounds(w/2+(3*bw/2)+10,h-1*bh-0,bw,bh);
        buttons[11].setBounds(w/2+(3*bw/2)+10,h-2*bh-5,bw,bh);
        buttons[12].setBounds(w/2+(3*bw/2)+10,h-3*bh-10,bw,bh);
        buttons[13].setBounds(w/2+(3*bw/2)+10,h-4*bh-15,bw,bh);

        for(int i=0;i<buttons.length;i++) {
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    action(e);
                }
            });
            frame.getContentPane().add(buttons[i]);
        }
        frame.getContentPane().add(output);
        //frame.pack();
        frame.setSize(w+10,h+50);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        new JavaCalculator();
    }

    public void action(ActionEvent e){
        String input=e.getActionCommand();
        if((input.charAt(0) >= '0' && input.charAt(0) <= '9') || input.charAt(0)=='.'){
            if(value1!=""){
                if(value1==" "){
                    value1=input;
                }
                else {
                    value1 += input;
                }
                output.setText(value1);
            }
            else{
                value2+=input;
                output.setText(value2);
            }
            return;
        }
        if(input.charAt(0)=='+' || input.charAt(0)=='-' || input.charAt(0)=='*' || input.charAt(0)=='/'){
            valuetemp=value1;
            value1="";
            output.setText(""+input.charAt(0));
            optemp=""+input.charAt(0);
            return;
        }
        if(input.charAt(0)=='C'){
            value1="0";
            value2="";
            valuetemp="";
            optemp="";
            output.setText(value1);
            return;
        }
        if(input.charAt(0)=='^'){
            float z=Float.parseFloat(value1);
            z=(float)Math.pow((double)z,2);
            String zstring=Float.toString(z);
            output.setText(zstring);
            value1=zstring;
            value2="";
            valuetemp="";
            optemp="";
            return;
        }
        if(input.charAt(0)=='√'){
            float z=Float.parseFloat(value1);
            z=(float)Math.sqrt((double)z);
            String zstring=Float.toString(z);
            output.setText(zstring);
            value1=zstring;
            value2="";
            valuetemp="";
            optemp="";
            return;
        }
        if(input.charAt(0)=='⌫'){
            if(output.getText().equals(value1)){
                if(!value1.equals(" ")){
                    value1=value1.substring(0,value1.length()-1);
                    output.setText(value1);
                }
            }
            else if(output.getText().equals(value2)){
                value2=value2.substring(0,value1.length()-1);
                output.setText(value2);
            }
            return;
        }
        if(input.charAt(0)=='=' && valuetemp!=""){
            if(optemp==""){
                output.setText("");
            }
            float x=Float.parseFloat(valuetemp);
            float y=Float.parseFloat(value2);
            float z=0;
            if(optemp.charAt(0)=='+'){
                z=x+y;
            }
            if(optemp.charAt(0)=='-'){
                z=x-y;
            }
            if(optemp.charAt(0)=='*'){
                z=x*y;
            }
            if(optemp.charAt(0)=='/'){
                z=x/y;
            }
            String zstring=Float.toString(z);
            output.setText(zstring);
            value1=zstring;
            value2="";
            valuetemp="";
            optemp="";
            return;
        }
    }
}
